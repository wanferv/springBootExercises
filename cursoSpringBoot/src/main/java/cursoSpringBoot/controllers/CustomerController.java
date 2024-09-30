package cursoSpringBoot.controllers;

import cursoSpringBoot.domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CustomerController {
    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(123,"Carlos Cuesta","carcues","contra1234"),
            new Customer(456,"Mario Hernandez","mherna","mariher456"),
            new Customer(789,"Laura Acuña","lauac","acu321"),
            new Customer(234,"Marcelo Perez","perlom","perlo3444")
    ));

    @RequestMapping(method = RequestMethod.GET)
    // @GetMapping
    public List<Customer> getCustomers() {
        return customers;
    }

    @RequestMapping(value ="/{username}" , method = RequestMethod.GET)
    //@GetMapping("/{username}")
    public Customer getCustomer(@PathVariable String username){
        for (Customer c:customers){
            if (c.getUsername().equals(username)){
                return c;
            }

        }
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    //@PostMapping
    public Customer postCliente(@RequestBody Customer customer){
        customers.add(customer);
        return customer;
    }

    @RequestMapping(method = RequestMethod.PUT)
    // @PutMapping
    public Customer putCliente (@RequestBody Customer customer){

        for (Customer c: customers){
            if (c.getID() == customer.getID()){
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());
                return c;
            }
        }
        return null;
    }
    @RequestMapping(value ="/{id}" , method = RequestMethod.DELETE)
    // @DeleteMapping("/{id}")
    public Customer deleteCliente (@PathVariable int id){
        for (Customer c: customers){
            if (c.getID() == id){
                customers.remove(c);
                return c;
            }
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.PATCH)
    //@PatchMapping
    public Customer patchCliente(@RequestBody Customer customer){
        for (Customer c : customers){
            if (c.getID() == customer.getID()){
                if (customer.getName()!= null){
                    c.setName(customer.getName());

                }
                if (customer.getUsername()!=null){

                    c.setUsername(customer.getUsername());
                }
                if (customer.getPassword()!=null){
                    c.setPassword(customer.getPassword());
                }
                return c;
            }
        }
        return null;
    }

}
