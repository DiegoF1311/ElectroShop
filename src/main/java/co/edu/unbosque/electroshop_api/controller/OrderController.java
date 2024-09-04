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
import co.edu.unbosque.electroshop_api.service.PaymentService;
import co.edu.unbosque.electroshop_api.service.ProductService;
import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Handles HTTP requests related to order processing in the ElectroShop API.
 * <p>
 * This controller is responsible for processing orders submitted by customers.
 * It validates the order details, checks product availability, processes payments,
 * and returns the result of the order processing.
 * </p>
 * 
 * @see co.edu.unbosque.electroshop_api.model.InitialOrderDTO
 * @see co.edu.unbosque.electroshop_api.model.ProcessedOrderDTO
 * @see co.edu.unbosque.electroshop_api.service.OrderProductService
 * @see co.edu.unbosque.electroshop_api.service.OrderService
 * @see co.edu.unbosque.electroshop_api.service.PaymentService
 * @see co.edu.unbosque.electroshop_api.service.ProductService
 */
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
	
	@Autowired
	public PaymentService paymentService;
	
	/**
	 * Processes an order with the information provided in the request.
	 * <p>
	 * This method takes an {@link InitialOrderDTO} object from the request body,
	 * checks if there are enough products available, processes the payment,
	 * and then processes the order. If the order is successfully processed,
	 * it returns a {@link ResponseEntity} containing a {@link ProcessedOrderDTO}.
	 * If there are insufficient products, it returns a {@link ResponseEntity} 
	 * with an error message and a 400 status code.
	 * </p>
	 * 
	 * @param orderDTO the order details submitted by the customer
	 * @return a {@link ResponseEntity} containing the result of the order processing
	 */
	@Operation(summary = "Process an order", 
	            description = "Processes an order with the information provided in the request.")
	@ApiResponses(value = {
	     @ApiResponse(responseCode = "200", 
	                  description = "Order processed successfully", 
	                  content = @Content(mediaType = "application/json", 
	                  schema = @Schema(implementation = ProcessedOrderDTO.class))),
	     @ApiResponse(responseCode = "400", 
	                  description = "Error processing order: Insufficient products", 
	                  content = @Content(mediaType = "text/plain")),
	     @ApiResponse(responseCode = "500", 
	                  description = "Internal server error")
	 })
	@PostMapping("/pedidos/procesar")
	public ResponseEntity<?> processOrder(@Valid @RequestBody InitialOrderDTO orderDTO) {
		
		float totalPrice = productService.productReservation(orderDTO.getProductsId());
		if (totalPrice == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Error processing order: Insufficient products.");
		}
		boolean payment = paymentService.processPayment(totalPrice, orderDTO.getCard());
		ProcessedOrderDTO processedOrder = orderService.processOrder(orderDTO, totalPrice, payment);
		return ResponseEntity.ok(processedOrder); 
	}

}
