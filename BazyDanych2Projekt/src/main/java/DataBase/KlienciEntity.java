package DataBase;

import javax.persistence.*;

/**
 * Created by user on 2015-11-11.
 */
@Entity
@Table(name = "Klienci", schema = "", catalog = "stuntman_proj")
public class KlienciEntity {
    private String pesel;
    private String imie;
    private String nazwisko;
    private String nrDowodu;
    private String uwagi;
    private int iloscTransakcji;
    private String nrTelefonu;

    @Id
    @Column(name = "PESEL")
    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
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
    @Column(name = "NR_DOWODU")
    public String getNrDowodu() {
        return nrDowodu;
    }

    public void setNrDowodu(String nrDowodu) {
        this.nrDowodu = nrDowodu;
    }

    @Basic
    @Column(name = "UWAGI")
    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }

    @Basic
    @Column(name = "ILOSC_TRANSAKCJI")
    public int getIloscTransakcji() {
        return iloscTransakcji;
    }

    public void setIloscTransakcji(int iloscTransakcji) {
        this.iloscTransakcji = iloscTransakcji;
    }

    @Basic
    @Column(name = "NR_TELEFONU")
    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KlienciEntity that = (KlienciEntity) o;

        if (iloscTransakcji != that.iloscTransakcji) return false;
        if (pesel != null ? !pesel.equals(that.pesel) : that.pesel != null) return false;
        if (imie != null ? !imie.equals(that.imie) : that.imie != null) return false;
        if (nazwisko != null ? !nazwisko.equals(that.nazwisko) : that.nazwisko != null) return false;
        if (nrDowodu != null ? !nrDowodu.equals(that.nrDowodu) : that.nrDowodu != null) return false;
        if (uwagi != null ? !uwagi.equals(that.uwagi) : that.uwagi != null) return false;
        if (nrTelefonu != null ? !nrTelefonu.equals(that.nrTelefonu) : that.nrTelefonu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pesel != null ? pesel.hashCode() : 0;
        result = 31 * result + (imie != null ? imie.hashCode() : 0);
        result = 31 * result + (nazwisko != null ? nazwisko.hashCode() : 0);
        result = 31 * result + (nrDowodu != null ? nrDowodu.hashCode() : 0);
        result = 31 * result + (uwagi != null ? uwagi.hashCode() : 0);
        result = 31 * result + iloscTransakcji;
        result = 31 * result + (nrTelefonu != null ? nrTelefonu.hashCode() : 0);
        return result;
    }
}
