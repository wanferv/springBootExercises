package cursoSpringBoot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorrldRestController {

    @GetMapping({"/hello","hw","hola"})
    public String helloWorld() {
        System.out.println("solictud ejecutada");
        return "Hello World!";
    }
}

