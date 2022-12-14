package com.VanityGetPizza.VanityGetPizza.repo;

import com.VanityGetPizza.VanityGetPizza.models.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Long> {
}
