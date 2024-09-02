package co.edu.unbosque.electroshop_api.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.electroshop_api.model.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
	
}
