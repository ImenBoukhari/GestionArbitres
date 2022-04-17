package com.example.GestionArbitre.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Match")
public class Match {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "nom_equipe1")
        private String nom_equipe1;

        @Column(name = "nom_equipe2")
        private String nom_equipe2;

        @Column(name = "arbitre_principal")
        private String arbitre_principal;

        @Column(name = "resultat")
        private String resultat;

        @Column(name = "date")
        private Date date;

        @Column(name = "tour")
        private String tour;

        public Match() {

        }

    public Match(long id, String nom_equipe1, String nom_equipe2, String arbitre_principal, String resultat, Date date, String tour) {
        this.id = id;
        this.nom_equipe1 = nom_equipe1;
        this.nom_equipe2 = nom_equipe2;
        this.arbitre_principal = arbitre_principal;
        this.resultat = resultat;
        this.date = date;
        this.tour = tour;
    }

    public long getId() {
        return id;
    }

    public String getNom_equipe1() {
        return nom_equipe1;
    }

    public String getNom_equipe2() {
        return nom_equipe2;
    }

    public String getArbitre_principal() {
        return arbitre_principal;
    }

    public String getResultat() {
        return resultat;
    }

    public Date getDate() {
        return date;
    }

    public String getTour() {
        return tour;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom_equipe1(String nom_equipe1) {
        this.nom_equipe1 = nom_equipe1;
    }

    public void setNom_equipe2(String nom_equipe2) {
        this.nom_equipe2 = nom_equipe2;
    }

    public void setArbitre_principal(String arbitre_principal) {
        this.arbitre_principal = arbitre_principal;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTour(String tour) {
        this.tour = tour;
    }
}
