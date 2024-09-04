package co.edu.unbosque.electroshop_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * @author SEBASTIAN ANDRES QUINTANA, DIEGO ALEJANDRO FORERO, MIGUEL ANGEL RUIZ y ANA CAROLINA QUIROGA 
 * @date 3 de septiembre del 2024
 * @version 1.0.0
 * The entry point for the ElectroShop API application.
 * <p>
 * This class contains the main method which is used to run the Spring Boot application. It is marked with
 * {@link SpringBootApplication} to enable auto-configuration, component scanning, and configuration support.
 * </p>
 * <p>
 * By calling {@link SpringApplication#run(Class, String...)} in the main method, the Spring Boot application context
 * is initialized and the application starts running.
 * </p>
 * <p>
 * The ElectroShop API application is responsible for managing orders, products, and customer information for the
 * ElectroShop company.
 * </p>
 * 
 * @see co.edu.unbosque.electroshop_api.config
 * @see co.edu.unbosque.electroshop_api.controller
 * @see co.edu.unbosque.electroshop_api.model
 * @see co.edu.unbosque.electroshop_api.repository
 * @see co.edu.unbosque.electroshop_api.service
 * @see co.edu.unbosque.electroshop_api.util
 */
@SpringBootApplication
public class ElectroshopApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectroshopApiApplication.class, args);
	}

}
