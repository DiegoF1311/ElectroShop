package co.edu.unbosque.electroshop_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.electroshop_api.model.ProcessedOrderDTO;
import co.edu.unbosque.electroshop_api.model.InitialOrderDTO;
import co.edu.unbosque.electroshop_api.service.OrderProductService;
import co.edu.unbosque.electroshop_api.service.OrderService;
import co.edu.unbosque.electroshop_api.service.ProductService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(name = "/api")
@Transactional
@CrossOrigin(origins = {"*"})
public class OrderController {
	
	@Autowired
	public ProductService productService;
	
	@Autowired 
	public OrderService orderService;
	
	@Autowired
	public OrderProductService orderProductService;
	
	
	@PostMapping("/pedidos/procesar")
	public ResponseEntity<?> processOrder(@Valid @RequestBody InitialOrderDTO orderDTO) {
		
		float totalPrice = productService.productReservation(orderDTO.getProductsId());
		if (totalPrice == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error processing order: Insufficient products.");
		}
		ProcessedOrderDTO processedOrder = orderService.processOrder(orderDTO, totalPrice);
		return ResponseEntity.ok(processedOrder); 
	}

}
