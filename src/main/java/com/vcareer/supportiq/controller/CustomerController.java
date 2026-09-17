package com.vcareer.supportiq.controller;

import com.vcareer.supportiq.entity.Customer;
import com.vcareer.supportiq.service.CustomerService;
import com.vcareer.supportiq.dto.CustomerRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer createCustomer(@Valid @RequestBody CustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());

        return customerService.createCustomer(customer);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
}