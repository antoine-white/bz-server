package fr.blancoziar.bzbank.services;

import fr.blancoziar.bzbank.Entities.BankUser;
import fr.blancoziar.bzbank.repositiories.BankUserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private BankUserRepository userRepository;
    
    public Optional<BankUser> findById(Integer id){
        return userRepository.findById(id);
    }
    
    public Optional<BankUser> findByName(String name){
        return userRepository.findAll().stream().filter(e -> e.getLogin().equals(name)).findFirst();
    }
}
