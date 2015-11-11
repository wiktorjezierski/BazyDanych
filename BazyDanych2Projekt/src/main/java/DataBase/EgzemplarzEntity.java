package DataBase;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by user on 2015-11-11.
 */
@Entity
@Table(name = "Egzemplarz", schema = "", catalog = "stuntman_proj")
public class EgzemplarzEntity {
    private String id;
    private Date dataZakupu;
    private String idSprzet;
    private String idSerwis;
    private Date dataOstPrzeg;
    private byte wycofany;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DATA_ZAKUPU")
    public Date getDataZakupu() {
        return dataZakupu;
    }

    public void setDataZakupu(Date dataZakupu) {
        this.dataZakupu = dataZakupu;
    }

    @Basic
    @Column(name = "ID_SPRZET")
    public String getIdSprzet() {
        return idSprzet;
    }

    public void setIdSprzet(String idSprzet) {
        this.idSprzet = idSprzet;
    }

    @Basic
    @Column(name = "ID_SERWIS")
    public String getIdSerwis() {
        return idSerwis;
    }

    public void setIdSerwis(String idSerwis) {
        this.idSerwis = idSerwis;
    }

    @Basic
    @Column(name = "DATA_OST_PRZEG")
    public Date getDataOstPrzeg() {
        return dataOstPrzeg;
    }

    public void setDataOstPrzeg(Date dataOstPrzeg) {
        this.dataOstPrzeg = dataOstPrzeg;
    }

    @Basic
    @Column(name = "WYCOFANY")
    public byte getWycofany() {
        return wycofany;
    }

    public void setWycofany(byte wycofany) {
        this.wycofany = wycofany;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EgzemplarzEntity that = (EgzemplarzEntity) o;

        if (wycofany != that.wycofany) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (dataZakupu != null ? !dataZakupu.equals(that.dataZakupu) : that.dataZakupu != null) return false;
        if (idSprzet != null ? !idSprzet.equals(that.idSprzet) : that.idSprzet != null) return false;
        if (idSerwis != null ? !idSerwis.equals(that.idSerwis) : that.idSerwis != null) return false;
        if (dataOstPrzeg != null ? !dataOstPrzeg.equals(that.dataOstPrzeg) : that.dataOstPrzeg != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dataZakupu != null ? dataZakupu.hashCode() : 0);
        result = 31 * result + (idSprzet != null ? idSprzet.hashCode() : 0);
        result = 31 * result + (idSerwis != null ? idSerwis.hashCode() : 0);
        result = 31 * result + (dataOstPrzeg != null ? dataOstPrzeg.hashCode() : 0);
        result = 31 * result + (int) wycofany;
        return result;
    }
}
