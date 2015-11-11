package DataBase;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by user on 2015-11-11.
 */
@Entity
@Table(name = "rezerwacja", schema = "", catalog = "stuntman_proj")
public class RezerwacjaEntity {
    private String id;
    private String peselPrac;
    private String idEgzemplarz;
    private String peselKlienta;
    private Date dataStart;
    private Date dataKoniec;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PESEL_PRAC")
    public String getPeselPrac() {
        return peselPrac;
    }

    public void setPeselPrac(String peselPrac) {
        this.peselPrac = peselPrac;
    }

    @Basic
    @Column(name = "ID_EGZEMPLARZ")
    public String getIdEgzemplarz() {
        return idEgzemplarz;
    }

    public void setIdEgzemplarz(String idEgzemplarz) {
        this.idEgzemplarz = idEgzemplarz;
    }

    @Basic
    @Column(name = "PESEL_KLIENTA")
    public String getPeselKlienta() {
        return peselKlienta;
    }

    public void setPeselKlienta(String peselKlienta) {
        this.peselKlienta = peselKlienta;
    }

    @Basic
    @Column(name = "DATA_START")
    public Date getDataStart() {
        return dataStart;
    }

    public void setDataStart(Date dataStart) {
        this.dataStart = dataStart;
    }

    @Basic
    @Column(name = "DATA_KONIEC")
    public Date getDataKoniec() {
        return dataKoniec;
    }

    public void setDataKoniec(Date dataKoniec) {
        this.dataKoniec = dataKoniec;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RezerwacjaEntity that = (RezerwacjaEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (peselPrac != null ? !peselPrac.equals(that.peselPrac) : that.peselPrac != null) return false;
        if (idEgzemplarz != null ? !idEgzemplarz.equals(that.idEgzemplarz) : that.idEgzemplarz != null) return false;
        if (peselKlienta != null ? !peselKlienta.equals(that.peselKlienta) : that.peselKlienta != null) return false;
        if (dataStart != null ? !dataStart.equals(that.dataStart) : that.dataStart != null) return false;
        if (dataKoniec != null ? !dataKoniec.equals(that.dataKoniec) : that.dataKoniec != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (peselPrac != null ? peselPrac.hashCode() : 0);
        result = 31 * result + (idEgzemplarz != null ? idEgzemplarz.hashCode() : 0);
        result = 31 * result + (peselKlienta != null ? peselKlienta.hashCode() : 0);
        result = 31 * result + (dataStart != null ? dataStart.hashCode() : 0);
        result = 31 * result + (dataKoniec != null ? dataKoniec.hashCode() : 0);
        return result;
    }
}
