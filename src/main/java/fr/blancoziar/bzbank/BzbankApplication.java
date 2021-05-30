package fr.blancoziar.bzbank;

import fr.blancoziar.bzbank.Entities.BankUser;
import fr.blancoziar.bzbank.repositiories.AccountRepository;
import fr.blancoziar.bzbank.repositiories.BankUserRepository;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
public class BzbankApplication {

        @Autowired
        BankUserRepository bankUserRepository;
        
        @Autowired
        AccountRepository accountRepository;
    
	public static void main(String[] args) {
		SpringApplication.run(BzbankApplication.class, args);
	}
        
    @EventListener(ContextRefreshedEvent.class)
    public void init(){        
        BankUser u = new BankUser("password","Dupond Martin");
        u.setId(1);
        fr.blancoziar.bzbank.Entities.Account a = new fr.blancoziar.bzbank.Entities.Account("compte courant",new BigDecimal(10),u);
        u.setAcc(a);
        a.setId(1);
        bankUserRepository.save(u);
        accountRepository.save(a);
    
    }
}
