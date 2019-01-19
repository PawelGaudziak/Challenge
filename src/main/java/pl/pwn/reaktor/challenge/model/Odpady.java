package pl.pwn.reaktor.challenge.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Odpady {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "data_KPO")
    private LocalDate dataKpo;

    @Column (name = "kod_odpadu")
    private String kodOdpadu;

    private double masa;

    private String nip;

    public Odpady() {
    }

    public Odpady(long id, LocalDate dataKpo, String kodOdpadu, double masa, String nip) {
        this.id = id;
        this.dataKpo = dataKpo;
        this.kodOdpadu = kodOdpadu;
        this.masa = masa;
        this.nip = nip;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDataKpo() {
        return dataKpo;
    }

    public void setDataKpo(LocalDate dataKpo) {
        this.dataKpo = dataKpo;
    }

    public String getKodOdpadu() {
        return kodOdpadu;
    }

    public void setKodOdpadu(String kodOdpadu) {
        this.kodOdpadu = kodOdpadu;
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @Override
    public String toString() {
        return "Odpady{" +
                "id=" + id +
                ", dataKpo=" + dataKpo +
                ", kodOdpadu='" + kodOdpadu + '\'' +
                ", masa=" + masa +
                ", nip='" + nip + '\'' +
                '}';
    }
}
