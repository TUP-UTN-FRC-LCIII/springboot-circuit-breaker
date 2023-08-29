package ar.edu.utn.frc.tup.lciii.scheduled;

import ar.edu.utn.frc.tup.lciii.clients.MicroBRestClient;
import ar.edu.utn.frc.tup.lciii.clients.MicroCRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class ScheduleMicroB {

    @Autowired
    private MicroBRestClient microBRestClient;

    @Autowired
    private MicroCRestClient microCRestClient;

    @Scheduled(fixedDelay = 1000)
    public void scheduleActionCallMicroB() {
        try {
            ResponseEntity<String> microResponse = microBRestClient.getMicro();
            System.out.println(microResponse.getBody());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void scheduleActionCallMicroC() {
        try {
            String microResponse = microCRestClient.getMicro().getBody();
            System.out.println(microResponse);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
