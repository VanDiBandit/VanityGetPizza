package com.VanityGetPizza.VanityGetPizza.models;



import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long id;

    private String crust;
    private String [] toppings;
    private String status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Customer_Id", nullable = false)
    private Customer customer;

    public Pizza() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String[] getToppings() {
        return toppings;
    }

    public void setToppings(String[] toppings) {
        this.toppings = toppings;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", crust='" + crust + '\'' +
                ", toppings=" + Arrays.toString(toppings) +
                ", status='" + status + '\'' +
                '}';
    }
}
