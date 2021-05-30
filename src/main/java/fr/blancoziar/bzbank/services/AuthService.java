package fr.blancoziar.bzbank.services;

import fr.blancoziar.bzbank.Entities.AuthToken;
import fr.blancoziar.bzbank.repositiories.AuthTokenRepository;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthTokenRepository authRepository;
    
    private static final int MAX_MINUTE_WITHOUT_INTERACTION = 5;
    
    private boolean dateOk(Date exp, Date lastActivity){
        Calendar now = Calendar.getInstance();
        Calendar beforeFive = Calendar.getInstance();
        beforeFive.add(Calendar.MINUTE, -MAX_MINUTE_WITHOUT_INTERACTION);
        return (exp.after(now.getTime()) && lastActivity.after(beforeFive.getTime()));
    }
    
    /**
     * side effect : update last activity of token if found
     * @param token
     * @return 
     */
    public Pair<Boolean,Integer> isValid(String token){
        List<AuthToken> l = authRepository.findAll();
        Optional<AuthToken> a = l.stream()
                .filter(e-> e.getToken().equals(token) && dateOk(e.getExpiredDate(), e.getLastActivity()))
                .findFirst();
        if(a.isPresent()){
            a.get().setLastActivity(new Date());
            return new Pair(true,a.get().getUserId());
        }
        else 
            return new Pair(false,null);
    }
    
    public boolean destroy(String token){
        List<AuthToken> l = authRepository.findAll();
        Optional<AuthToken> a = l.stream()
                .filter(e-> e.getToken().equals(token) && dateOk(e.getExpiredDate(), e.getLastActivity()))
                .findFirst();
        if(a.isPresent())
            authRepository.delete(a.get());
        return a.isPresent();
    }
    
    public void clean(){
        authRepository.findAll()
                .stream()
                .filter(e-> !dateOk(e.getExpiredDate(), e.getLastActivity()))
                .forEach(e-> authRepository.delete(e));
    }
}
