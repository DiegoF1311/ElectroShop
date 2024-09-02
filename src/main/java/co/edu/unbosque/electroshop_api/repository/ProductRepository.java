package co.edu.unbosque.electroshop_api.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.electroshop_api.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
}
