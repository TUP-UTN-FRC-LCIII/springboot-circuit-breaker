package ar.edu.utn.frc.tup.lciii.clients;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MicroCRestClient {

    private static final String RESILIENCE4J_INSTANCE_NAME = "microCircuitBreaker";
    private static final String FALLBACK_METHOD = "fallback";

    String baseResourceUrl = "http://localhost:8082/micro";

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
    public ResponseEntity<String> getMicro() {
        System.out.println("Calling Micro C");
        return restTemplate.getForEntity(baseResourceUrl, String.class);
    }

    public ResponseEntity<String> fallback(Exception ex) {
        return ResponseEntity.status(503).body("Response from Circuit Breaker Fallback of Micro C");
    }
}
