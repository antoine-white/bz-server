package fr.blancoziar.bzbank.web;

import fr.blancoziar.bzbank.Entities.AuthToken;
import fr.blancoziar.bzbank.Entities.BankUser;
import fr.blancoziar.bzbank.Utils;
import fr.blancoziar.bzbank.repositiories.AccountRepository;
import fr.blancoziar.bzbank.repositiories.AuthTokenRepository;
import fr.blancoziar.bzbank.repositiories.BankUserRepository;
import fr.blancoziar.bzbank.services.AuthService;
import fr.blancoziar.bzbank.services.UserService;

import java.util.Optional;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// TODO : think  about rate limiting

@RestController
@CrossOrigin
public class UserController {
       
    @Autowired
    UserService userService;
    
    @Autowired
    AuthService authService;
    
    @Autowired
    AuthTokenRepository authTokenRepository;
    
    @Autowired
    AccountRepository accountRepository;
    
    @Autowired
    BankUserRepository bankUserRepository;
    
    private static final int LENGTH_TOKEN = 100;

    @GetMapping("/connect")
    public ResponseEntity connect(@RequestParam String name, @RequestParam String password) {
        Optional<BankUser> u = userService.findById(1);
        if(u.isPresent()){
            BankUser user = u.get();
            if(user.getPassword().equals(password))  {
                String token = Utils.randomString(LENGTH_TOKEN);
                AuthToken _token = new AuthToken( token, 1);
                authTokenRepository.save(_token);
                return ResponseEntity.ok(new UserInfo(token, user.getLogin()));
            }                
        } 
        // TOFIX :
        // It makes no sense to respond with a 400 HTTP error when the parameters
        // are correct but the user doesn't exist or the password is bad
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
        
    @GetMapping("/account")
    public ResponseEntity seeAccount(@RequestParam String token){
        Pair<Boolean,Integer> p = authService.isValid(token);
        if (!p.getKey())
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        BankUser u = userService.findById(p.getValue()).get();
        AccountController acc = new AccountController(u.getAcc().getAccName(), u.getAcc().getMoney().intValue());
        return ResponseEntity.ok(acc);
    }
    @GetMapping("/disconnect")
    public ResponseEntity disconnect(@RequestParam String token){
        boolean res = authService.destroy(token);
        return res?
            ResponseEntity.ok(null):
            ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
    }
}

class AccountController {
    private String name;
    private double money;

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public AccountController(String name, double money) {
        this.name = name;
        this.money = money;
    }    
}

class UserInfo {
    private final String token;
    private final String login;

    public UserInfo(String token, String login) {
            this.token = token;
            this.login = login;
    }

    public String getToken() {
            return token;
    }

    public String getlogin() {
            return login;
    }
}