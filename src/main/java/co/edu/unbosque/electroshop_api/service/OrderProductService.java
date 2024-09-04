package co.edu.unbosque.electroshop_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.electroshop_api.model.OrderProduct;
import co.edu.unbosque.electroshop_api.model.OrderProductDTO;
import co.edu.unbosque.electroshop_api.repository.OrderProductRepository;
import co.edu.unbosque.electroshop_api.util.DataMapper;

/**
 * Service class for managing {@link OrderProduct} entities.
 * <p>
 * This service class provides methods for creating and retrieving {@link OrderProduct} entities.
 * It interacts with the {@link OrderProductRepository} to perform CRUD operations and uses {@link DataMapper}
 * to convert between {@link OrderProductDTO} and {@link OrderProduct} objects.
 * </p>
 */
@Service
public class OrderProductService {

    /**
     * Repository for managing {@link OrderProduct} entities.
     * <p>
     * This repository provides access to the database for performing CRUD operations on {@link OrderProduct} entities.
     * </p>
     */
    @Autowired
    public OrderProductRepository orderProductRepository;

    /**
     * Utility for mapping between {@link OrderProductDTO} and {@link OrderProduct} objects.
     * <p>
     * This utility class is used to convert between data transfer objects (DTOs) and entity objects.
     * </p>
     */
    public DataMapper dataMapper = new DataMapper();

    /**
     * Creates a new {@link OrderProduct} based on the provided {@link OrderProductDTO}.
     * <p>
     * This method converts the provided {@link OrderProductDTO} into an {@link OrderProduct} entity and saves it
     * to the database using the {@link OrderProductRepository}.
     * </p>
     * 
     * @param orderProduct the data transfer object containing order-product association information
     */
    public void createOrderProduct(OrderProductDTO orderProduct) {
        OrderProduct op = dataMapper.orderProductDTOToOrderProduct(orderProduct);
        orderProductRepository.save(op);
    }

    /**
     * Retrieves all {@link OrderProduct} entities from the database.
     * <p>
     * This method fetches all {@link OrderProduct} entities from the database, converts them into
     * {@link OrderProductDTO} objects, and returns a list of these DTOs.
     * </p>
     * 
     * @return a list of {@link OrderProductDTO} objects representing all order-product associations
     */
    public List<OrderProductDTO> getAllOrderProduct() {
        List<OrderProduct> orderProductList = (List<OrderProduct>) orderProductRepository.findAll();
        List<OrderProductDTO> list = new ArrayList<>();
        for (int i = 0; i < orderProductList.size(); i++) {
            list.add(dataMapper.orderProductToOrderProductDTO(orderProductList.get(i)));
        }
        return list;
    }

}