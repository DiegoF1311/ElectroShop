package co.edu.unbosque.electroshop_api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.electroshop_api.model.Product;
import co.edu.unbosque.electroshop_api.model.ProductDTO;
import co.edu.unbosque.electroshop_api.repository.ProductRepository;
import co.edu.unbosque.electroshop_api.util.DataMapper;

@Service
public class ProductService {
	
	@Autowired
	public ProductRepository productRepository;
	
	public DataMapper dataMapper = new DataMapper();
	
	public void createProduct(ProductDTO product) {
		Product prod = dataMapper.productDTOToProduct(product);
		productRepository.save(prod);
	}
	
	public float productReservation(Map<Integer, Integer> list) {
		Set<Integer> productsIds = list.keySet();
		float totalPrice = 0;
		for (Integer id : productsIds) {
			Optional<Product> product = productRepository.findById(id);
			Product auxProduct = product.get();
			int actualStock = auxProduct.getStock();
			auxProduct.setStock(actualStock - list.get(id));
			if (auxProduct.getStock() < 0) {
				return 0; 
			}
			productRepository.save(auxProduct);
			totalPrice += auxProduct.getPrice()*list.get(id);
		}
		return totalPrice;
	}
	
	public List<ProductDTO> getAllProducts() {
		List<Product> products = (List<Product>) productRepository.findAll();
		List<ProductDTO> productsDTO = new ArrayList<>();
		for (int i = 0; i < products.size(); i++) {
			productsDTO.add(dataMapper.productToProductDTO(products.get(i)));
		}
		return productsDTO;
	}

}
