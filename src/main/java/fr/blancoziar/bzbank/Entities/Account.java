/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.blancoziar.bzbank.Entities;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Account {
    @Id
    private Integer id;
    
    private String accName;
    
    private BigDecimal money;

    @OneToOne
    private BankUser bUser;

    public Account(){
        
    }
    
    public Account( String accName, BigDecimal money, BankUser bUser) {
        this.accName = accName;
        this.money = money;
        this.bUser = bUser;
    }

    
    

    public BankUser getbUser() {
        return bUser;
    }

    public void setbUser(BankUser bUser) {
        this.bUser = bUser;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }    
    
    
}
