package co.edu.unbosque.electroshop_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.electroshop_api.model.OrderProduct;
import co.edu.unbosque.electroshop_api.model.OrderProductDTO;
import co.edu.unbosque.electroshop_api.repository.OrderProductRepository;
import co.edu.unbosque.electroshop_api.util.DataMapper;

@Service
public class OrderProductService {
	
	@Autowired
	public OrderProductRepository orderProductRepository;
	
	public DataMapper dataMapper = new DataMapper();
	
	public void createOrderProduct(OrderProductDTO orderProduct) {
		OrderProduct op = dataMapper.orderProductDTOToOrderProduct(orderProduct);
		orderProductRepository.save(op);
	}
	
	public List<OrderProductDTO> getAllOrderProduct() {
		List<OrderProduct> orderProductList = (List<OrderProduct>) orderProductRepository.findAll();
		List<OrderProductDTO> list = new ArrayList<>();
		for (int i = 0; i < orderProductList.size(); i++) {
			list.add(dataMapper.orderProductToOrderProductDTO(orderProductList.get(i)));
		}
		return list;
	}
	
}
