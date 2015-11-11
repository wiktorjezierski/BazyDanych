package DataBase;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by user on 2015-11-11.
 */
@Entity
@Table(name = "Faktury", schema = "", catalog = "stuntman_proj")
public class FakturyEntity {
    private String idFaktury;
    private String peselKlienta;
    private Date dataWyst;
    private float kwota;

    @Id
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
    @Column(name = "DATA_WYST")
    public Date getDataWyst() {
        return dataWyst;
    }

    public void setDataWyst(Date dataWyst) {
        this.dataWyst = dataWyst;
    }

    @Basic
    @Column(name = "KWOTA")
    public float getKwota() {
        return kwota;
    }

    public void setKwota(float kwota) {
        this.kwota = kwota;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FakturyEntity that = (FakturyEntity) o;

        if (Float.compare(that.kwota, kwota) != 0) return false;
        if (idFaktury != null ? !idFaktury.equals(that.idFaktury) : that.idFaktury != null) return false;
        if (peselKlienta != null ? !peselKlienta.equals(that.peselKlienta) : that.peselKlienta != null) return false;
        if (dataWyst != null ? !dataWyst.equals(that.dataWyst) : that.dataWyst != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFaktury != null ? idFaktury.hashCode() : 0;
        result = 31 * result + (peselKlienta != null ? peselKlienta.hashCode() : 0);
        result = 31 * result + (dataWyst != null ? dataWyst.hashCode() : 0);
        result = 31 * result + (kwota != +0.0f ? Float.floatToIntBits(kwota) : 0);
        return result;
    }
}
