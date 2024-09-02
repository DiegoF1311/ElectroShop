package co.edu.unbosque.electroshop_api.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import co.edu.unbosque.electroshop_api.model.Customer;
import co.edu.unbosque.electroshop_api.model.CustomerDTO;
import co.edu.unbosque.electroshop_api.model.Order;
import co.edu.unbosque.electroshop_api.model.InitialOrderDTO;
import co.edu.unbosque.electroshop_api.model.OrderProduct;
import co.edu.unbosque.electroshop_api.model.OrderProductDTO;
import co.edu.unbosque.electroshop_api.model.OrderProductId;
import co.edu.unbosque.electroshop_api.model.ProcessedOrderDTO;
import co.edu.unbosque.electroshop_api.model.Product;
import co.edu.unbosque.electroshop_api.model.ProductDTO;

public class DataMapper {
	
	private final double IVA = 0.19;
	
	public DataMapper() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer customerDTOToCustomer(CustomerDTO customerDTO) {
		Customer c = new Customer();
		c.setName(customerDTO.getName());
		c.setLastName(customerDTO.getLastName());
		c.setGender(customerDTO.getGender());
		c.setPhoneNumber(customerDTO.getPhoneNumber());
		c.setAddress(customerDTO.getAddress());
		c.setEmail(customerDTO.getEmail());
		return c;
	}
	
	public CustomerDTO customerToCustomerDTO(Customer customer) {
		CustomerDTO cosDTO = new CustomerDTO();
		cosDTO.setName(customer.getName());
		cosDTO.setLastName(customer.getLastName());
		cosDTO.setGender(customer.getGender());
		cosDTO.setPhoneNumber(customer.getPhoneNumber());
		cosDTO.setAddress(customer.getAddress());
		cosDTO.setEmail(customer.getEmail());
		return cosDTO;
	}
	
	public Product productDTOToProduct(ProductDTO prodDTO) {
		Product prod = new Product();
		prod.setName(prodDTO.getName());
		prod.setCategory(prodDTO.getCategory());
		prod.setPrice(prodDTO.getPrice());
		prod.setStock(prodDTO.getStock());
		return prod;
	}
	
	public ProductDTO productToProductDTO(Product prod) {
		ProductDTO prodDTO = new ProductDTO();
		prodDTO.setName(prod.getName());
		prodDTO.setCategory(prod.getCategory());
		prodDTO.setPrice(prod.getPrice());
		prodDTO.setStock(prod.getStock());
		return prodDTO;
	}
	
	public OrderProduct orderProductDTOToOrderProduct(OrderProductDTO opDTO) {
	    OrderProduct op = new OrderProduct();
	    OrderProductId orderProductId = new OrderProductId(opDTO.getOrderId(), opDTO.getProductId());
	    op.setId(orderProductId);
	    op.setQuantity(opDTO.getQuantity());
	    return op;
	}
	
	public OrderProductDTO orderProductToOrderProductDTO(OrderProduct op) {
	    OrderProductDTO opDTO = new OrderProductDTO();
	    opDTO.setOrderId(op.getId().getOrderId());
	    opDTO.setProductId(op.getId().getProductId());
	    opDTO.setQuantity(op.getQuantity());
	    return opDTO;
	}
	
	public Order orderDTOToOrder(InitialOrderDTO orderDTO, float totalPrice) {
		Order order = new Order();
		Customer aux = new Customer();
		aux.setCustomerId(orderDTO.getCustomerId());
		order.setCustomer(aux);
		order.setPaymentMethod(orderDTO.getPaymentMethod());
		order.setTotalPrice(totalPrice);
		order.setPriceWithIVA((float) (totalPrice + (totalPrice*IVA)));
		try {
			order.setDate(getCurrentDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}
	
	public ProcessedOrderDTO orderToProcessedOrderDTO(Order order) {
		ProcessedOrderDTO orderDTO = new ProcessedOrderDTO();
		orderDTO.setPaymentMethod(order.getPaymentMethod());
		orderDTO.setStatus(order.getStatus());
		orderDTO.setDate(order.getDate());
		orderDTO.setTotalPrice(order.getTotalPrice());
		orderDTO.setPriceWithIVA(order.getPriceWithIVA());
		return orderDTO;
	}
	
	public static Date getCurrentDate() throws ParseException {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(formattedDate);
    }
	
}