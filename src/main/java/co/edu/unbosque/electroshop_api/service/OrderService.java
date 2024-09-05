package co.edu.unbosque.electroshop_api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.electroshop_api.model.Customer;
import co.edu.unbosque.electroshop_api.model.ProcessedOrderDTO;
import co.edu.unbosque.electroshop_api.model.Product;
import co.edu.unbosque.electroshop_api.model.Order;
import co.edu.unbosque.electroshop_api.model.OrderProduct;
import co.edu.unbosque.electroshop_api.model.InitialOrderDTO;
import co.edu.unbosque.electroshop_api.repository.CustomerRepository;
import co.edu.unbosque.electroshop_api.repository.OrderProductRepository;
import co.edu.unbosque.electroshop_api.repository.OrderRepository;
import co.edu.unbosque.electroshop_api.repository.ProductRepository;
import co.edu.unbosque.electroshop_api.util.DataMapper;


/**
 * Service class for managing orders and their related operations.
 * <p>
 * This service class provides methods for processing orders, creating processed order DTOs,
 * and retrieving all processed orders. It interacts with the repositories to perform CRUD
 * operations and uses {@link DataMapper} for converting between entities and DTOs.
 * </p>
 */
@Service
public class OrderService {

    /**
     * Repository for managing {@link Order} entities.
     * <p>
     * This repository provides access to the database for performing CRUD operations on
     * {@link Order} entities.
     * </p>
     */
    @Autowired
    public OrderRepository orderRepository;

    /**
     * Repository for managing {@link Product} entities.
     * <p>
     * This repository provides access to the database for performing CRUD operations on
     * {@link Product} entities.
     * </p>
     */
    @Autowired
    public ProductRepository productRepository;

    /**
     * Repository for managing {@link Customer} entities.
     * <p>
     * This repository provides access to the database for performing CRUD operations on
     * {@link Customer} entities.
     * </p>
     */
    @Autowired
    public CustomerRepository customerRepository;

    /**
     * Repository for managing {@link OrderProduct} entities.
     * <p>
     * This repository provides access to the database for performing CRUD operations on
     * {@link OrderProduct} entities.
     * </p>
     */
    @Autowired
    public OrderProductRepository orderProductRepository;

    /**
     * Utility for mapping between entities and DTOs.
     * <p>
     * This utility class is used to convert between {@link Order}, {@link OrderProduct}, and
     * DTO objects.
     * </p>
     */
    public DataMapper dataMapper = new DataMapper();

    /**
     * Processes an order based on the provided {@link InitialOrderDTO} and payment status.
     * <p>
     * This method converts the provided {@link InitialOrderDTO} into an {@link Order} entity,
     * updates the status of the order based on the payment status, and saves it to the
     * {@link OrderRepository}. It also creates {@link OrderProduct} entities for each product
     * in the order and saves them to the {@link OrderProductRepository}.
     * </p>
     * 
     * @param orderDTO the data transfer object containing the initial order details
     * @param totalPrice the total price of the order
     * @param payment boolean indicating whether the payment was successful
     * @param products complete list of products
     * @return a {@link ProcessedOrderDTO} containing the processed order details
     */
    public ProcessedOrderDTO processOrder(InitialOrderDTO orderDTO, float totalPrice, boolean payment, List<Product> products) {
        Order order = dataMapper.orderDTOToOrder(orderDTO, totalPrice);
        ProcessedOrderDTO processedOrder = createProcessedOrder(order, orderDTO.getProductsId());
        if (payment) {
            order.setStatus("Processed");
            orderRepository.save(order);
        } else {
            order.setStatus("Failed");
            orderRepository.save(order);
        }
        processedOrder.setStatus(order.getStatus());
        for (Product product : products) {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setOrder(order);
            orderProduct.setProduct(product);
            orderProduct.setQuantity(processedOrder.getProducts().get(product.getProductId()));
            orderProductRepository.save(orderProduct);
        }
        return processedOrder;
    }

    /**
     * Creates a {@link ProcessedOrderDTO} from an {@link Order} and product details.
     * <p>
     * This method initializes a {@link ProcessedOrderDTO} with details from the provided
     * {@link Order} and the associated customer and product information.
     * </p>
     * 
     * @param order the {@link Order} entity containing order details
     * @param products a map of product IDs to quantities for the order
     * @return a {@link ProcessedOrderDTO} containing the processed order details
     */
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

    /**
     * Retrieves all processed orders from the database.
     * <p>
     * This method fetches all {@link Order} entities from the database, converts them into
     * {@link ProcessedOrderDTO} objects, and returns a list of these DTOs.
     * </p>
     * 
     * @return a list of {@link ProcessedOrderDTO} objects representing all processed orders
     */
    public List<ProcessedOrderDTO> getAllOrders() {
        List<Order> orders = (List<Order>) orderRepository.findAll();
        List<ProcessedOrderDTO> processedOrdersDTO = new ArrayList<>();
        for (Order order : orders) {
            processedOrdersDTO.add(dataMapper.orderToProcessedOrderDTO(order));
        }
        return processedOrdersDTO;
    }
	
}
