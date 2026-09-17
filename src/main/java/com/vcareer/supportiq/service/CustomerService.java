package com.vcareer.supportiq.service;

import com.vcareer.supportiq.entity.Customer;
import com.vcareer.supportiq.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import com.vcareer.supportiq.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Customer not found with id: " + id
                        )
                );
    }
}