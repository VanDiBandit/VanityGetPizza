package com.VanityGetPizza.VanityGetPizza.services;


import com.VanityGetPizza.VanityGetPizza.models.Pizza;
import com.VanityGetPizza.VanityGetPizza.repo.CustomerRepo;
import com.VanityGetPizza.VanityGetPizza.repo.PizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PizzaServices {

@Autowired
    private PizzaRepo pizzaRepo;
@Autowired
private CustomerRepo customerRepo;

public void createPizza(Long customerId, Pizza pizza){
    customerRepo.findById(customerId).map(customer ->{
        pizza.setCustomer(customer);
        return pizzaRepo.save(pizza);
    });
}

public ResponseEntity<?> getPizzaById(Long pizzaId){
    Pizza pizza = pizzaRepo.findById(pizzaId).orElse(null);
    return new ResponseEntity<>(pizza, HttpStatus.OK);
}
public Iterable<Pizza> getAllPizza() {

    return pizzaRepo.findAll();
}
public void updatePizza(Long customerId, Pizza pizza){
    customerRepo.findById(customerId).map(customer -> {
        pizza.setCustomer(customer);
        return pizzaRepo.save(pizza);
    });
}
public void deletePizza(Long pizzaId){

    pizzaRepo.deleteById(pizzaId);
}
}
