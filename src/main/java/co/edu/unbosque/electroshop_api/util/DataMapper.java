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

/**
 * Utility class for mapping between data transfer objects (DTOs) and entity objects.
 * <p>
 * This class provides methods to convert between different types of DTOs and entities, as well as utilities for handling dates.
 * </p>
 */
public class DataMapper {

    /**
     * Tax rate for value-added tax (IVA).
     * <p>
     * This constant is used to calculate the total price with tax.
     * </p>
     */
    private final double IVA = 0.19;

    /**
     * Constructs a new DataMapper instance.
     * <p>
     * The constructor is used to initialize the DataMapper.
     * </p>
     */
    public DataMapper() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Converts a {@link CustomerDTO} to a {@link Customer} entity.
     * <p>
     * This method maps the properties of the {@link CustomerDTO} to a new {@link Customer} entity.
     * </p>
     * 
     * @param customerDTO the {@link CustomerDTO} to be converted
     * @return a {@link Customer} entity with the data from the DTO
     */
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

    /**
     * Converts a {@link Customer} entity to a {@link CustomerDTO}.
     * <p>
     * This method maps the properties of the {@link Customer} entity to a new {@link CustomerDTO}.
     * </p>
     * 
     * @param customer the {@link Customer} entity to be converted
     * @return a {@link CustomerDTO} with the data from the entity
     */
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

    /**
     * Converts a {@link ProductDTO} to a {@link Product} entity.
     * <p>
     * This method maps the properties of the {@link ProductDTO} to a new {@link Product} entity.
     * </p>
     * 
     * @param prodDTO the {@link ProductDTO} to be converted
     * @return a {@link Product} entity with the data from the DTO
     */
    public Product productDTOToProduct(ProductDTO prodDTO) {
        Product prod = new Product();
        prod.setName(prodDTO.getName());
        prod.setCategory(prodDTO.getCategory());
        prod.setPrice(prodDTO.getPrice());
        prod.setStock(prodDTO.getStock());
        return prod;
    }

    /**
     * Converts a {@link Product} entity to a {@link ProductDTO}.
     * <p>
     * This method maps the properties of the {@link Product} entity to a new {@link ProductDTO}.
     * </p>
     * 
     * @param prod the {@link Product} entity to be converted
     * @return a {@link ProductDTO} with the data from the entity
     */
    public ProductDTO productToProductDTO(Product prod) {
        ProductDTO prodDTO = new ProductDTO();
        prodDTO.setName(prod.getName());
        prodDTO.setCategory(prod.getCategory());
        prodDTO.setPrice(prod.getPrice());
        prodDTO.setStock(prod.getStock());
        return prodDTO;
    }

    /**
     * Converts an {@link OrderProductDTO} to an {@link OrderProduct} entity.
     * <p>
     * This method maps the properties of the {@link OrderProductDTO} to a new {@link OrderProduct} entity,
     * including setting the composite primary key {@link OrderProductId}.
     * </p>
     * 
     * @param opDTO the {@link OrderProductDTO} to be converted
     * @return an {@link OrderProduct} entity with the data from the DTO
     */
    public OrderProduct orderProductDTOToOrderProduct(OrderProductDTO opDTO) {
        OrderProduct op = new OrderProduct();
        OrderProductId orderProductId = new OrderProductId(opDTO.getOrderId(), opDTO.getProductId());
        op.setId(orderProductId);
        op.setQuantity(opDTO.getQuantity());
        return op;
    }

    /**
     * Converts an {@link OrderProduct} entity to an {@link OrderProductDTO}.
     * <p>
     * This method maps the properties of the {@link OrderProduct} entity to a new {@link OrderProductDTO}.
     * </p>
     * 
     * @param op the {@link OrderProduct} entity to be converted
     * @return an {@link OrderProductDTO} with the data from the entity
     */
    public OrderProductDTO orderProductToOrderProductDTO(OrderProduct op) {
        OrderProductDTO opDTO = new OrderProductDTO();
        opDTO.setOrderId(op.getId().getOrderId());
        opDTO.setProductId(op.getId().getProductId());
        opDTO.setQuantity(op.getQuantity());
        return opDTO;
    }

    /**
     * Converts an {@link InitialOrderDTO} to an {@link Order} entity.
     * <p>
     * This method maps the properties of the {@link InitialOrderDTO} to a new {@link Order} entity,
     * calculates the total price with IVA, and sets the current date as the order date.
     * </p>
     * 
     * @param orderDTO the {@link InitialOrderDTO} containing order details
     * @param totalPrice the total price of the order before tax
     * @return an {@link Order} entity with the data from the DTO and calculated fields
     */
    public Order orderDTOToOrder(InitialOrderDTO orderDTO, float totalPrice) {
        Order order = new Order();
        Customer aux = new Customer();
        aux.setCustomerId(orderDTO.getCustomerId());
        order.setCustomer(aux);
        order.setPaymentMethod(orderDTO.getPaymentMethod());
        order.setTotalPrice(totalPrice);
        order.setPriceWithIVA((float) (totalPrice + (totalPrice * IVA)));
        try {
            order.setDate(getCurrentDate());
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return order;
    }

    /**
     * Converts an {@link Order} entity to a {@link ProcessedOrderDTO}.
     * <p>
     * This method maps the properties of the {@link Order} entity to a new {@link ProcessedOrderDTO}.
     * </p>
     * 
     * @param order the {@link Order} entity to be converted
     * @return a {@link ProcessedOrderDTO} with the data from the entity
     */
    public ProcessedOrderDTO orderToProcessedOrderDTO(Order order) {
        ProcessedOrderDTO orderDTO = new ProcessedOrderDTO();
        orderDTO.setPaymentMethod(order.getPaymentMethod());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setDate(order.getDate());
        orderDTO.setTotalPrice(order.getTotalPrice());
        orderDTO.setPriceWithIVA(order.getPriceWithIVA());
        return orderDTO;
    }

    /**
     * Retrieves the current date formatted as {@code dd/MM/yyyy}.
     * <p>
     * This utility method returns the current date in the format used for storing dates in the system.
     * </p>
     * 
     * @return the current date as a {@link Date} object
     * @throws ParseException if the date format is invalid
     */
    public static Date getCurrentDate() throws ParseException {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = currentDate.format(formatter);
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(formattedDate);
    }
}