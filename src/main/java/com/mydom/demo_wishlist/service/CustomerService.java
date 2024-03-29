package com.mydom.demo_wishlist.service;

import com.mydom.demo_wishlist.exception.EntityAlreadyExistsException;
import com.mydom.demo_wishlist.exception.ResourceNotFoundException;
import com.mydom.demo_wishlist.model.Customer;
import com.mydom.demo_wishlist.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer create(Customer customer) throws EntityAlreadyExistsException {
        this.findByEmail(customer.getEmail()).orElseThrow(() -> new EntityAlreadyExistsException(""));
        return this.customerRepository.save(customer);
    }

    public Optional<Customer> findById(Long id) {
        return this.customerRepository.findById(id);
    }

    public List<Customer> getAll() {
        return new ArrayList<>(customerRepository.findAll());

    }

    public Customer update(Customer newCustomer, Long id) throws ResourceNotFoundException {
        Optional<Customer> optionalCustomer = this.findById(id);
        Customer customer = optionalCustomer.orElseThrow(() -> new ResourceNotFoundException(""));
        customer.setEmail(newCustomer.getEmail());
        customer.setName(newCustomer.getName());
        return customer;
    }

    public void delete(Long id) throws ResourceNotFoundException {
        Optional<Customer> optionalCustomer = this.findById(id);
        Customer customer = optionalCustomer.orElseThrow(() -> new ResourceNotFoundException(""));
        this.customerRepository.delete(customer);
    }

    public Optional<Customer> findByEmail(String email) {
        return this.customerRepository.findByEmail(email);
    }

}
