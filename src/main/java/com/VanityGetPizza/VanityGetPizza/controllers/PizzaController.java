package com.VanityGetPizza.VanityGetPizza.controllers;

import com.VanityGetPizza.VanityGetPizza.models.Pizza;
import com.VanityGetPizza.VanityGetPizza.repo.PizzaRepo;
import com.VanityGetPizza.VanityGetPizza.services.PizzaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class PizzaController {

    @Autowired
    PizzaServices pizzaServices;

    @Autowired
    PizzaRepo pizzaRepo;


    @PostMapping("/pizza/{customerId}/pizza")
    public void createPizza(@PathVariable(value = "customerId") Long customerId, @Validated @RequestBody Pizza pizza){
        pizzaServices.createPizza(customerId, pizza);
    }

    @GetMapping("/pizza/{id}")
    public ResponseEntity<?> getPizzaById(@PathVariable Long id){

        return pizzaServices.getPizzaById(id);
    }

    @GetMapping("/pizza")
    public Iterable<Pizza> getAllPizza() {

        return pizzaServices.getAllPizza();
    }

    @PutMapping("/pizza/{customerId}/pizza")
    public void updatePizzaById(@PathVariable Long customerId, @Validated @RequestBody Pizza pizza){
        pizzaServices.updatePizza(customerId,pizza);
    }

    @DeleteMapping("/pizza/{id}")
    public void deletePizzaById(@PathVariable Long id){

        pizzaServices.deletePizza(id);
    }
}
