package co.edu.unbosque.electroshop_api.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.electroshop_api.model.OrderProduct;
import co.edu.unbosque.electroshop_api.model.OrderProductId;

public interface OrderProductRepository extends CrudRepository<OrderProduct, OrderProductId> {

}
