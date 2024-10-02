package cursoSpringBoot.controllers;

import cursoSpringBoot.domain.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity <List<Customer>> getCustomers() {
        return ResponseEntity.ok(customers);
    }

    @RequestMapping(value ="/{username}" , method = RequestMethod.GET)
    //@GetMapping("/{username}")
    public ResponseEntity <?> getCustomer(@PathVariable String username){
        for (Customer c:customers){
            if (c.getUsername().equals(username)){
                return ResponseEntity.ok(c);
            }

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con username: "+username);
    }

    @RequestMapping(method = RequestMethod.POST)
    //@PostMapping
    public ResponseEntity <?> postCliente(@RequestBody Customer customer){
        customers.add(customer);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("El Cliente fue creado exitosamente: "+customer.getUsername());
    }

    @RequestMapping(method = RequestMethod.PUT)
    // @PutMapping
    public ResponseEntity<?> putCliente (@RequestBody Customer customer){

        for (Customer c: customers){
            if (c.getID() == customer.getID()){
                c.setName(customer.getName());
                c.setUsername(customer.getUsername());
                c.setPassword(customer.getPassword());
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
    @RequestMapping(value ="/{id}" , method = RequestMethod.DELETE)
    // @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCliente (@PathVariable int id){
        for (Customer c: customers){
            if (c.getID() == id){
                customers.remove(c);
                return ResponseEntity.noContent().build();
            }
        }
        return  ResponseEntity.notFound().build();
    }

    @RequestMapping(method = RequestMethod.PATCH)
    //@PatchMapping
    public ResponseEntity<?>  patchCliente(@RequestBody Customer customer){
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
                return ResponseEntity.ok("Cliente modificado satisfactoriamente: "+customer.getID());
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente no encontrado con el ID: "+customer.getID());
    }

}
