package co.edu.unbosque.electroshop_api.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.electroshop_api.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String>{
	
}
