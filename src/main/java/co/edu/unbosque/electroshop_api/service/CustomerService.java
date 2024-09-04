package co.edu.unbosque.electroshop_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.electroshop_api.model.Customer;
import co.edu.unbosque.electroshop_api.model.CustomerDTO;
import co.edu.unbosque.electroshop_api.repository.CustomerRepository;
import co.edu.unbosque.electroshop_api.util.DataMapper;

/**
 * Service class for handling operations related to {@link Customer}.
 * <p>
 * This class provides methods to create a new customer and to retrieve all customers.
 * It uses {@link CustomerRepository} for data access and {@link DataMapper} for converting between 
 * {@link Customer} entities and {@link CustomerDTO} objects.
 * </p>
 */
@Service
public class CustomerService {
	
	 /**
     * Repository for managing {@link Customer} entities.
     * <p>
     * This repository provides access to the database for performing CRUD operations on {@link Customer} entities.
     * </p>
     */
    @Autowired
    public CustomerRepository customerRepository;

    /**
     * Utility for mapping between {@link CustomerDTO} and {@link Customer} objects.
     * <p>
     * This utility class is used to convert between data transfer objects (DTOs) and entity objects.
     * </p>
     */
    public DataMapper dataMapper = new DataMapper();

    /**
     * Creates a new {@link Customer} based on the provided {@link CustomerDTO}.
     * <p>
     * This method converts the provided {@link CustomerDTO} into a {@link Customer} entity and saves it
     * to the database using the {@link CustomerRepository}.
     * </p>
     * 
     * @param customerDTO the data transfer object containing customer information
     */
    public void createCustomer(CustomerDTO customerDTO) {
        Customer c = dataMapper.customerDTOToCustomer(customerDTO);
        customerRepository.save(c);
    }

    /**
     * Retrieves all {@link Customer} entities from the database.
     * <p>
     * This method fetches all {@link Customer} entities from the database, converts them into
     * {@link CustomerDTO} objects, and returns a list of these DTOs.
     * </p>
     * 
     * @return a list of {@link CustomerDTO} objects representing all customers
     */
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = (List<Customer>) customerRepository.findAll();
        List<CustomerDTO> customersDTO = new ArrayList<>();
        for (int i = 0; i < customers.size(); i++) {
            customersDTO.add(dataMapper.customerToCustomerDTO(customers.get(i)));
        }
        return customersDTO;
    }
	
}
