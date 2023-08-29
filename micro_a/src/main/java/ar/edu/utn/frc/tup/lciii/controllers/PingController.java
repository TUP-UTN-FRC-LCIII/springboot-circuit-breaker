package ar.edu.utn.frc.tup.lciii.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping("/ping")
    public String pong() {
        return "pong from micro a";
    }
}
