package co.edu.unbosque.electroshop_api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.electroshop_api.model.Customer;
import co.edu.unbosque.electroshop_api.model.CustomerDTO;
import co.edu.unbosque.electroshop_api.repository.CustomerRepository;
import co.edu.unbosque.electroshop_api.util.DataMapper;

@Service
public class CustomerService {
	
	@Autowired
	public CustomerRepository customerRepository;
	
	public DataMapper dataMapper = new DataMapper();
	
	public void createCustomer(CustomerDTO customerDTO) {
		Customer c = dataMapper.customerDTOToCustomer(customerDTO);
		customerRepository.save(c);
	}
	
	public List<CustomerDTO> getAllCustomers() {
		List<Customer> customers = (List<Customer>) customerRepository.findAll();
		List<CustomerDTO> customersDTO = new ArrayList<>();
		for (int i = 0; i < customers.size(); i++) {
			customersDTO.add(dataMapper.customerToCustomerDTO(customers.get(i)));
		}
		return customersDTO;
	}
	
}
