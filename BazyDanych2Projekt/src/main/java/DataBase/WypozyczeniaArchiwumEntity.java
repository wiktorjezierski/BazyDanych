package DataBase;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by user on 2015-11-11.
 */
@Entity
@Table(name = "WypozyczeniaArchiwum", schema = "", catalog = "stuntman_proj")
public class WypozyczeniaArchiwumEntity {
    private String id;
    private String idSprzetu;
    private String idFaktury;
    private String peselKlienta;
    private String peselPrac;
    private Date dataWyp;
    private Date dataZwrotu;

    @Id
    @Column(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ID_SPRZETU")
    public String getIdSprzetu() {
        return idSprzetu;
    }

    public void setIdSprzetu(String idSprzetu) {
        this.idSprzetu = idSprzetu;
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

    @Basic
    @Column(name = "DATA_ZWROTU")
    public Date getDataZwrotu() {
        return dataZwrotu;
    }

    public void setDataZwrotu(Date dataZwrotu) {
        this.dataZwrotu = dataZwrotu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WypozyczeniaArchiwumEntity that = (WypozyczeniaArchiwumEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (idSprzetu != null ? !idSprzetu.equals(that.idSprzetu) : that.idSprzetu != null) return false;
        if (idFaktury != null ? !idFaktury.equals(that.idFaktury) : that.idFaktury != null) return false;
        if (peselKlienta != null ? !peselKlienta.equals(that.peselKlienta) : that.peselKlienta != null) return false;
        if (peselPrac != null ? !peselPrac.equals(that.peselPrac) : that.peselPrac != null) return false;
        if (dataWyp != null ? !dataWyp.equals(that.dataWyp) : that.dataWyp != null) return false;
        if (dataZwrotu != null ? !dataZwrotu.equals(that.dataZwrotu) : that.dataZwrotu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (idSprzetu != null ? idSprzetu.hashCode() : 0);
        result = 31 * result + (idFaktury != null ? idFaktury.hashCode() : 0);
        result = 31 * result + (peselKlienta != null ? peselKlienta.hashCode() : 0);
        result = 31 * result + (peselPrac != null ? peselPrac.hashCode() : 0);
        result = 31 * result + (dataWyp != null ? dataWyp.hashCode() : 0);
        result = 31 * result + (dataZwrotu != null ? dataZwrotu.hashCode() : 0);
        return result;
    }
}
