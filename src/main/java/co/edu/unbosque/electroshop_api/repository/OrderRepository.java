package co.edu.unbosque.electroshop_api.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.electroshop_api.model.Order;

/**
 * Repository interface for {@link Order} entities.
 * <p>
 * This interface provides CRUD (Create, Read, Update, Delete) operations for {@link Order} entities.
 * It extends {@link CrudRepository}, which is a Spring Data interface that simplifies data access operations.
 * </p>
 * 
 * @param <Order> the type of the entity
 * @param <Integer> the type of the entity's primary key
 * 
 * @see co.edu.unbosque.electroshop_api
 * @see co.edu.unbosque.electroshop_api.controller
 * @see co.edu.unbosque.electroshop_api.model
 * @see co.edu.unbosque.electroshop_api.config
 * @see co.edu.unbosque.electroshop_api.repository
 */
public interface OrderRepository extends CrudRepository<Order, Integer> {
	
}
