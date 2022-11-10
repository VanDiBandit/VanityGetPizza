package com.VanityGetPizza.VanityGetPizza.repo;

import com.VanityGetPizza.VanityGetPizza.models.Pizza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepo extends CrudRepository<Pizza, Long> {

}
