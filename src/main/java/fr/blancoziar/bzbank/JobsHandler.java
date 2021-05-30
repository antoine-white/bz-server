package fr.blancoziar.bzbank;

import fr.blancoziar.bzbank.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
public final class JobsHandler {
    
    @Autowired
    AuthService service;
    
    @Scheduled(fixedDelay = 6000000)
    public void cleanAuthTokenRepo() {
        service.clean();
    }
}
