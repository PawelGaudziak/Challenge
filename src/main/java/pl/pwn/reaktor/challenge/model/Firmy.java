package pl.pwn.reaktor.challenge.model;

import javax.persistence.*;

@Entity
@Table
public class Firmy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "nazwa_firmy")
    private String nazwaFirmy;

    private String nip;

    private String email;

    private String haslo;


    public Firmy() {
    }

    public Firmy(String nazwaFirmy, String nip, String email, String haslo) {
        this.nazwaFirmy = nazwaFirmy;
        this.nip = nip;
        this.email = email;
        this.haslo = haslo;
    }

    public Firmy(long id, String nazwaFirmy, String nip, String email, String haslo) {
        this.id = id;
        this.nazwaFirmy = nazwaFirmy;
        this.nip = nip;
        this.email = email;
        this.haslo = haslo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNazwaFirmy() {
        return nazwaFirmy;
    }

    public void setNazwaFirmy(String nazwaFirmy) {
        this.nazwaFirmy = nazwaFirmy;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    @Override
    public String toString() {
        return "Firmy{" +
                "id=" + id +
                ", nazwaFirmy='" + nazwaFirmy + '\'' +
                ", nip='" + nip + '\'' +
                ", email='" + email + '\'' +
                ", haslo='" + haslo + '\'' +
                '}';
    }
}
