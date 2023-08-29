package ar.edu.utn.frc.tup.lciii.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    private Integer counter = 0;

    @GetMapping("/ping")
    public String pong() {
        return "pong from micro c";
    }

    @GetMapping("/micro")
    public String micro() {
        counter++;
        if(counter > 10 && counter < 30) {
            System.out.println("Call N° " + counter + " - Error en Micro C");
            throw new RuntimeException("Error");
        }
        System.out.println("Call N° " + counter + " - OK en Micro C");
        return "pong from micro c - counter = " + counter;
    }
}
