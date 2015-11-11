package DataBase;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by user on 2015-11-11.
 */
@Entity
@Table(name = "Sprzet", schema = "", catalog = "stuntman_proj")
public class SprzetEntity {
    @Id
    @Column(name = "ID")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String nazwa;
    private String marka;
    private String idProducent;
    private String kategoria;
    private Date dataZakupu;
    private int ilosc;


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
    @Column(name = "MARKA")
    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    @Basic
    @Column(name = "ID_PRODUCENT")
    public String getIdProducent() {
        return idProducent;
    }

    public void setIdProducent(String idProducent) {
        this.idProducent = idProducent;
    }

    @Basic
    @Column(name = "KATEGORIA")
    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
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
    @Column(name = "ILOSC")
    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SprzetEntity that = (SprzetEntity) o;

        if (ilosc != that.ilosc) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nazwa != null ? !nazwa.equals(that.nazwa) : that.nazwa != null) return false;
        if (marka != null ? !marka.equals(that.marka) : that.marka != null) return false;
        if (idProducent != null ? !idProducent.equals(that.idProducent) : that.idProducent != null) return false;
        if (kategoria != null ? !kategoria.equals(that.kategoria) : that.kategoria != null) return false;
        if (dataZakupu != null ? !dataZakupu.equals(that.dataZakupu) : that.dataZakupu != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        result = 31 * result + (marka != null ? marka.hashCode() : 0);
        result = 31 * result + (idProducent != null ? idProducent.hashCode() : 0);
        result = 31 * result + (kategoria != null ? kategoria.hashCode() : 0);
        result = 31 * result + (dataZakupu != null ? dataZakupu.hashCode() : 0);
        result = 31 * result + ilosc;
        return result;
    }
}
