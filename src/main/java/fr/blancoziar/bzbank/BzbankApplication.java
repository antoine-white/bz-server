package fr.blancoziar.bzbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class BzbankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BzbankApplication.class, args);
	}
        
    
}
