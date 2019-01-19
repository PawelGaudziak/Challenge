package pl.pwn.reaktor.challenge.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class Firmy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    @NotBlank
    @Column (name = "nazwa_firmy")
    private String nazwaFirmy;
//    @NotBlank
    private String nip;
//    @NotBlank
    private String email;
//    @NotBlank
    private String haslo;
//    @NotBlank
    private String role;


    public Firmy() {
        this.role = "user";
    }

    public Firmy(String nazwaFirmy, String nip, String email, String haslo, String role) {
        this.nazwaFirmy = nazwaFirmy;
        this.nip = nip;
        this.email = email;
        this.haslo = haslo;
        this.role = "user";
    }

    public Firmy(long id, String nazwaFirmy, String nip, String email, String haslo,
                 String role) {
        this.id = id;
        this.nazwaFirmy = nazwaFirmy;
        this.nip = nip;
        this.email = email;
        this.haslo = haslo;
        this.role = "user";

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
                ", role='" + role + '\'' +
                '}';
    }
}
