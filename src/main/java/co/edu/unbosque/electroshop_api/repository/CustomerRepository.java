package co.edu.unbosque.electroshop_api.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.electroshop_api.model.Customer;

/**
 * Repository interface for {@link Customer} entities.
 * <p>
 * This interface provides CRUD (Create, Read, Update, Delete) operations for {@link Customer} entities.
 * It extends {@link CrudRepository}, which is a Spring Data interface that simplifies data access operations.
 * </p>
 * 
 * @param <Customer> the type of the entity
 * @param <String> the type of the entity's ID
 * 
 * @see co.edu.unbosque.electroshop_api
 * @see co.edu.unbosque.electroshop_api.controller
 * @see co.edu.unbosque.electroshop_api.model
 * @see co.edu.unbosque.electroshop_api.config
 * @see co.edu.unbosque.electroshop_api.repository
 */
public interface CustomerRepository extends CrudRepository<Customer, String>{
	
}
