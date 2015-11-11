package DataBase;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by user on 2015-11-11.
 */
@Entity
@Table(name = "Pracownicy", schema = "", catalog = "stuntman_proj")
public class PracownicyEntity {
    private String peselPrac;
    private String imie;
    private String nazwisko;
    private Date dataStartu;
    private String stanowisko;
    private Date zwolniony;
    private String adresEmail;

    @Id
    @Column(name = "PESEL_PRAC")
    public String getPeselPrac() {
        return peselPrac;
    }

    public void setPeselPrac(String peselPrac) {
        this.peselPrac = peselPrac;
    }

    @Basic
    @Column(name = "IMIE")
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Basic
    @Column(name = "NAZWISKO")
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Basic
    @Column(name = "DATA_STARTU")
    public Date getDataStartu() {
        return dataStartu;
    }

    public void setDataStartu(Date dataStartu) {
        this.dataStartu = dataStartu;
    }

    @Basic
    @Column(name = "STANOWISKO")
    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    @Basic
    @Column(name = "ZWOLNIONY")
    public Date getZwolniony() {
        return zwolniony;
    }

    public void setZwolniony(Date zwolniony) {
        this.zwolniony = zwolniony;
    }

    @Basic
    @Column(name = "ADRES_EMAIL")
    public String getAdresEmail() {
        return adresEmail;
    }

    public void setAdresEmail(String adresEmail) {
        this.adresEmail = adresEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PracownicyEntity that = (PracownicyEntity) o;

        if (peselPrac != null ? !peselPrac.equals(that.peselPrac) : that.peselPrac != null) return false;
        if (imie != null ? !imie.equals(that.imie) : that.imie != null) return false;
        if (nazwisko != null ? !nazwisko.equals(that.nazwisko) : that.nazwisko != null) return false;
        if (dataStartu != null ? !dataStartu.equals(that.dataStartu) : that.dataStartu != null) return false;
        if (stanowisko != null ? !stanowisko.equals(that.stanowisko) : that.stanowisko != null) return false;
        if (zwolniony != null ? !zwolniony.equals(that.zwolniony) : that.zwolniony != null) return false;
        if (adresEmail != null ? !adresEmail.equals(that.adresEmail) : that.adresEmail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = peselPrac != null ? peselPrac.hashCode() : 0;
        result = 31 * result + (imie != null ? imie.hashCode() : 0);
        result = 31 * result + (nazwisko != null ? nazwisko.hashCode() : 0);
        result = 31 * result + (dataStartu != null ? dataStartu.hashCode() : 0);
        result = 31 * result + (stanowisko != null ? stanowisko.hashCode() : 0);
        result = 31 * result + (zwolniony != null ? zwolniony.hashCode() : 0);
        result = 31 * result + (adresEmail != null ? adresEmail.hashCode() : 0);
        return result;
    }
}
