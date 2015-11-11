package DataBase;

import javax.persistence.*;

/**
 * Created by user on 2015-11-11.
 */
@Entity
@Table(name = "Producent", schema = "", catalog = "stuntman_proj")
public class ProducentEntity {
    private String id;
    private String nazwa;
    private String adres;
    private String telefon;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAZWA")
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Basic
    @Column(name = "ADRES")
    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Basic
    @Column(name = "TELEFON")
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProducentEntity that = (ProducentEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nazwa != null ? !nazwa.equals(that.nazwa) : that.nazwa != null) return false;
        if (adres != null ? !adres.equals(that.adres) : that.adres != null) return false;
        if (telefon != null ? !telefon.equals(that.telefon) : that.telefon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        result = 31 * result + (adres != null ? adres.hashCode() : 0);
        result = 31 * result + (telefon != null ? telefon.hashCode() : 0);
        return result;
    }
}
