package co.edu.unbosque.electroshop_api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.electroshop_api.model.Product;
import co.edu.unbosque.electroshop_api.model.ProductDTO;
import co.edu.unbosque.electroshop_api.repository.ProductRepository;
import co.edu.unbosque.electroshop_api.util.DataMapper;

/**
 * Service class for managing products within the inventory.
 * <p>
 * This service class provides methods for creating new products, reserving products by updating stock,
 * and retrieving a list of all products. It interacts with the {@link ProductRepository} to perform
 * database operations and uses {@link DataMapper} to convert between {@link ProductDTO} and {@link Product}.
 * </p>
 */
@Service
public class ProductService {

    /**
     * Repository interface for performing CRUD operations on {@link Product} entities.
     * <p>
     * This is used to interact with the database for retrieving, saving, and updating product information.
     * </p>
     */
    @Autowired
    public ProductRepository productRepository;

    /**
     * Utility class for mapping between {@link ProductDTO} and {@link Product}.
     * <p>
     * This is used to convert between data transfer objects and entity objects.
     * </p>
     */
    public DataMapper dataMapper = new DataMapper();

    /**
     * Creates a new product and saves it to the database.
     * <p>
     * This method converts a {@link ProductDTO} to a {@link Product} entity using {@link DataMapper}
     * and saves the entity to the database using {@link ProductRepository}.
     * </p>
     * 
     * @param product the {@link ProductDTO} containing the details of the product to be created
     */
    public void createProduct(ProductDTO product) {
        Product prod = dataMapper.productDTOToProduct(product);
        productRepository.save(prod);
    }

    /**
     * Reserves products by updating their stock and calculates the total price for the reservation.
     * <p>
     * This method iterates over the provided map of product IDs and quantities, checks and updates the stock
     * for each product, and calculates the total price. If any product's stock becomes negative, the method returns 0
     * indicating a failed reservation. Otherwise, it returns the total price of the reserved products.
     * </p>
     * 
     * @param list a map of product IDs to quantities to be reserved
     * @param products complete list of products
     * @return the total price of the reserved products, or 0 if reservation fails due to insufficient stock
     */
    public float productReservation(Map<Integer, Integer> list, List<Product> products) {
        float totalPrice = 0;
        for (Product product : products) {
            int actualStock = product.getStock();
            if (actualStock - list.get(product.getProductId()) < 0) {
                return 0; 
            }
            product.setStock(actualStock - list.get(product.getProductId()));
            productRepository.save(product);
            totalPrice += product.getPrice() * list.get(product.getProductId());
        }
        return totalPrice;
    }

    /**
     * Retrieves all products from the database and converts them to a list of {@link ProductDTO}.
     * <p>
     * This method fetches all {@link Product} entities from the database and converts each entity to a {@link ProductDTO}
     * using {@link DataMapper}. It returns a list of all products in DTO format.
     * </p>
     * 
     * @return a list of {@link ProductDTO} representing all products
     */
    public List<ProductDTO> getAllProducts() {
        List<Product> products = (List<Product>) productRepository.findAll();
        List<ProductDTO> productsDTO = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            productsDTO.add(dataMapper.productToProductDTO(products.get(i)));
        }
        return productsDTO;
    }
    
    /**
     * Retrieves products by their IDs from the database.
     * <p>
     * This method fetches {@link Product} entities from the database based on a list of product IDs.
     * </p>
     * 
     * @param productIds the list of product IDs to retrieve
     * @return a list of {@link Product} representing the products associated with the given IDs
     */
    public List<Product> getProductsByOrder(List<Integer> productIds) {
    	return (List<Product>) productRepository.findAllById(productIds);
    }

}
