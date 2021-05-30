package fr.blancoziar.bzbank.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BankUser {
    @Id
    private Integer id;
    
    private String password;
    
    private String login;
    
    @OneToOne(cascade = CascadeType.ALL,
              fetch = FetchType.LAZY)
    private Account acc;

    public BankUser(){}
    
    public BankUser(String password, String login) {
        this.password = password;
        this.login = login;
    }

    
    
    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }
      
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }   
    
}
