package com.VanityGetPizza.VanityGetPizza.controllers;

import com.VanityGetPizza.VanityGetPizza.models.Customer;
import com.VanityGetPizza.VanityGetPizza.repo.CustomerRepo;
import com.VanityGetPizza.VanityGetPizza.services.CustomerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerServices customerServices;

    @PostMapping("/customer")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        return customerServices.createCustomer(customer);
    }


    @GetMapping("/customer/id")
    public ResponseEntity<?> getCustomerById(@PathVariable Long customerId) {
        customerServices.verifyCustomer(customerId);
        return customerServices.getCustomer(customerId);
    }

    @GetMapping("/customer")
    public ResponseEntity<Iterable<Customer>> getAllCustomer() {

        return customerServices.getAllCustomer();
    }

    @PutMapping("/customer/id")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId) {
        customerServices.verifyCustomer(customerId);
        customerServices.updateCustomer(customer, customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/customer/id")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
        customerServices.verifyCustomer(customerId);
        return customerServices.deleteCustomer(customerId);
    }
}


