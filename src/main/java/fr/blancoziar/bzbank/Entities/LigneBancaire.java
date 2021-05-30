package fr.blancoziar.bzbank.Entities;



import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class LigneBancaire {

    @Id
    private Integer id;

    private String user_;

    private BigDecimal montant;

    private String libelle;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user_;
    }

    public void setUser(String user) {
        this.user_ = user;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}