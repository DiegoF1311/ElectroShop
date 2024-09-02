package co.edu.unbosque.electroshop_api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.electroshop_api.model.Customer;
import co.edu.unbosque.electroshop_api.model.ProcessedOrderDTO;
import co.edu.unbosque.electroshop_api.model.Order;
import co.edu.unbosque.electroshop_api.model.OrderProduct;
import co.edu.unbosque.electroshop_api.model.InitialOrderDTO;
import co.edu.unbosque.electroshop_api.repository.CustomerRepository;
import co.edu.unbosque.electroshop_api.repository.OrderProductRepository;
import co.edu.unbosque.electroshop_api.repository.OrderRepository;
import co.edu.unbosque.electroshop_api.repository.ProductRepository;
import co.edu.unbosque.electroshop_api.util.DataMapper;

@Service
public class OrderService {
	
	@Autowired
	public OrderRepository orderRepository;
	
	@Autowired
	public ProductRepository productRepository;
	
	@Autowired 
	public CustomerRepository customerRepository;
	
	@Autowired
	public OrderProductRepository orderProductRepository;
	
	public DataMapper dataMapper = new DataMapper();
	
	public ProcessedOrderDTO processOrder(InitialOrderDTO orderDTO, float totalPrice) {
		Order order = dataMapper.orderDTOToOrder(orderDTO, totalPrice);
		ProcessedOrderDTO processedOrder = createProcessedOrder(order, orderDTO.getProductsId());
		if(processedOrder != null) {
			order.setStatus("Proccesed");
			orderRepository.save(order);
		} else {			
			order.setStatus("Failed");
			orderRepository.save(order);
		}
		processedOrder.setStatus(order.getStatus());
		for (Integer id : processedOrder.getProducts().keySet()) {			
			OrderProduct orderProduct = new OrderProduct();
			orderProduct.setOrder(order);
			orderProduct.setProduct(productRepository.findById(id).get());
			orderProduct.setQuantity(processedOrder.getProducts().get(id));
			orderProductRepository.save(orderProduct);
		}
		return processedOrder;
	}
	
	public ProcessedOrderDTO createProcessedOrder(Order order, Map<Integer, Integer> products) {
		ProcessedOrderDTO processedOrder = new ProcessedOrderDTO();
		String customerId = order.getCustomer().getCustomerId();
		Customer customer = customerRepository.findById(customerId).get();
		processedOrder.setCustomerName(customer.getName() + " " + customer.getLastName());
		processedOrder.setCustomerAddress(customer.getAddress());
		processedOrder.setDate(order.getDate());
		processedOrder.setTotalPrice(order.getTotalPrice());
		processedOrder.setPriceWithIVA(order.getPriceWithIVA());
		processedOrder.setPaymentMethod(order.getPaymentMethod());
		processedOrder.setProducts(products);
		return processedOrder;
		
	}
	
	public List<ProcessedOrderDTO> getAllOrders() {
		List<Order> orders = (List<Order>) orderRepository.findAll();
		List<ProcessedOrderDTO> orocessedOrdersDTO = new ArrayList<>();
		for (int i = 0; i < orders.size(); i++) {
			orocessedOrdersDTO.add(dataMapper.orderToProcessedOrderDTO(orders.get(i)));
		}
		return orocessedOrdersDTO;
	}
	
}
