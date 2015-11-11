package DataBase;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by user on 2015-11-11.
 */
@Entity
@Table(name = "Wypozyczenia", schema = "", catalog = "stuntman_proj")
public class WypozyczeniaEntity {
    private String idEgzemplarza;
    private String idFaktury;
    private String peselKlienta;
    private String peselPrac;
    private Date dataWyp;
    private int id;

    @Basic
    @Column(name = "ID_EGZEMPLARZA")
    public String getIdEgzemplarza() {
        return idEgzemplarza;
    }

    public void setIdEgzemplarza(String idEgzemplarza) {
        this.idEgzemplarza = idEgzemplarza;
    }

    @Basic
    @Column(name = "ID_FAKTURY")
    public String getIdFaktury() {
        return idFaktury;
    }

    public void setIdFaktury(String idFaktury) {
        this.idFaktury = idFaktury;
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
    @Column(name = "PESEL_PRAC")
    public String getPeselPrac() {
        return peselPrac;
    }

    public void setPeselPrac(String peselPrac) {
        this.peselPrac = peselPrac;
    }

    @Basic
    @Column(name = "DATA_WYP")
    public Date getDataWyp() {
        return dataWyp;
    }

    public void setDataWyp(Date dataWyp) {
        this.dataWyp = dataWyp;
    }

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WypozyczeniaEntity that = (WypozyczeniaEntity) o;

        if (id != that.id) return false;
        if (idEgzemplarza != null ? !idEgzemplarza.equals(that.idEgzemplarza) : that.idEgzemplarza != null)
            return false;
        if (idFaktury != null ? !idFaktury.equals(that.idFaktury) : that.idFaktury != null) return false;
        if (peselKlienta != null ? !peselKlienta.equals(that.peselKlienta) : that.peselKlienta != null) return false;
        if (peselPrac != null ? !peselPrac.equals(that.peselPrac) : that.peselPrac != null) return false;
        if (dataWyp != null ? !dataWyp.equals(that.dataWyp) : that.dataWyp != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEgzemplarza != null ? idEgzemplarza.hashCode() : 0;
        result = 31 * result + (idFaktury != null ? idFaktury.hashCode() : 0);
        result = 31 * result + (peselKlienta != null ? peselKlienta.hashCode() : 0);
        result = 31 * result + (peselPrac != null ? peselPrac.hashCode() : 0);
        result = 31 * result + (dataWyp != null ? dataWyp.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
