package com.VanityGetPizza.VanityGetPizza.services;

import com.VanityGetPizza.VanityGetPizza.models.Customer;
import com.VanityGetPizza.VanityGetPizza.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class CustomerServices {

    @Autowired
    private CustomerRepo customerRepo;

    public void verifyCustomer(Long customerId){Optional<Customer> customer = customerRepo.findById(customerId);
    }

    public ResponseEntity<?> getCustomer(Long CustomerId) {
        Optional<Customer> c = customerRepo.findById(CustomerId);
        return new ResponseEntity<> (c, HttpStatus.OK);
    }

    public ResponseEntity<?> createCustomer(Customer customer) {
        customer=customerRepo.save(customer);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newCustomerUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customer.getId())
                .toUri();
        responseHeaders.setLocation(newCustomerUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    public void updateCustomer(Customer customer, Long CustomerId) {

        customerRepo.save(customer);
    }

    public ResponseEntity<?> deleteCustomer(Long CustomerId) {
        customerRepo.deleteById(CustomerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    public ResponseEntity<Iterable<Customer>> getAllCustomer() {
        Iterable<Customer> allCustomer = customerRepo.findAll();
        return new ResponseEntity<>(customerRepo.findAll(), HttpStatus.OK);
    }
}
