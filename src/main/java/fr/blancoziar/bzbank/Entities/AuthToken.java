
package fr.blancoziar.bzbank.Entities;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class AuthToken {

    @Id
    private String token;
    private Integer userId;
    private Date expiredDate;
    private Date lastActivity;

    
    public AuthToken(){}
    
    public AuthToken(String token, Integer userId) {
        this.token = token;
        this.userId = userId;
        Calendar cal = Calendar.getInstance();
        lastActivity = cal.getTime();
        cal.add(Calendar.HOUR, 1);
        expiredDate = cal.getTime();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Date getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(Date lastActivity) {
        this.lastActivity = lastActivity;
    }

    
    
}
