package co.edu.unbosque.electroshop_api.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.electroshop_api.model.OrderProduct;
import co.edu.unbosque.electroshop_api.model.OrderProductId;


/**
 * Repository interface for {@link OrderProduct} entities.
 * <p>
 * This interface provides CRUD (Create, Read, Update, Delete) operations for {@link OrderProduct} entities.
 * It extends {@link CrudRepository}, which is a Spring Data interface that simplifies data access operations.
 * </p>
 * 
 * @param <OrderProduct> the type of the entity
 * @param <OrderProductId> the type of the entity's composite key
 * 
 * @see co.edu.unbosque.electroshop_api
 * @see co.edu.unbosque.electroshop_api.controller
 * @see co.edu.unbosque.electroshop_api.model
 * @see co.edu.unbosque.electroshop_api.config
 * @see co.edu.unbosque.electroshop_api.repository
 */
public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductId> {

}
