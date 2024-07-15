package org.example.optional;

import org.example.map.flatmap.Customer;
import org.example.map.flatmap.EkartDataBase;

import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {

        String email1 = "abc@gmail.com";
        String email2 = null;

        Optional<String> emailOptional = Optional.ofNullable(email1);
        System.out.println(emailOptional);
        System.out.println(emailOptional.get());

        Optional<String> emailOptional1 = Optional.ofNullable(email2);
        System.out.println(emailOptional1);
       //////// System.out.println(emailOptional1.get());
        if(emailOptional1.isPresent()){
            System.out.println(emailOptional.get());
        }

        System.out.println(emailOptional1.orElse("dummy@gmail.com"));
        System.out.println(emailOptional1.orElseGet(()->"dummy@gmail.com"));

        //System.out.println(emailOptional1.orElseThrow(()->new IllegalArgumentException("value must not be null")));

        List<Customer> all =  EkartDataBase.getAll();

        //find customer by email
        String emailToFind = "abc@gmail.com";
        //find the customer by email, if not present then return an empty customer object
        all.stream().filter(cust->cust.getEmail().equalsIgnoreCase(emailToFind)).findAny().orElse(new Customer());

        //find the customer by email, if not present thro an exception
        all.stream().filter(cust->cust.getEmail().equalsIgnoreCase(emailToFind)).findAny().orElseThrow(()->new RuntimeException("Customer with email "+emailToFind+" not found"));


    }
}
