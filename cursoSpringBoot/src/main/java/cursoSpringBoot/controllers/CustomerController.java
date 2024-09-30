package cursoSpringBoot.controllers;

import cursoSpringBoot.domain.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {
    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123,"Carlos Cuesta","carcues","contra1234"),
            new Customer(456,"Mario Hernandez","mherna","mariher456"),
            new Customer(789,"Laura Acuña","lauac","acu321"),
            new Customer(234,"Marcelo Perez","perlom","perlo3444")
    ));

    @GetMapping("/clientes")
    public List<Customer> getCustomers() {
        return customers;
    }
    @GetMapping("/clientes/{username}")
    public Customer getCustomer(@PathVariable String username){
        for (Customer c:customers){
            if (c.getUsername().equals(username)){
                return c;
            }

        }
        return null;
    }
}
