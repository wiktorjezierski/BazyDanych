package DataBase;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by user on 2015-11-11.
 */
@Entity
@Table(name = "Log", schema = "", catalog = "stuntman_proj")
public class LogEntity {
    private int id;
    private String tabela;
    private int idKrotki;
    private String rodzajOper;
    private Date data;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TABELA")
    public String getTabela() {
        return tabela;
    }

    public void setTabela(String tabela) {
        this.tabela = tabela;
    }

    @Basic
    @Column(name = "ID_KROTKI")
    public int getIdKrotki() {
        return idKrotki;
    }

    public void setIdKrotki(int idKrotki) {
        this.idKrotki = idKrotki;
    }

    @Basic
    @Column(name = "RODZAJ_OPER")
    public String getRodzajOper() {
        return rodzajOper;
    }

    public void setRodzajOper(String rodzajOper) {
        this.rodzajOper = rodzajOper;
    }

    @Basic
    @Column(name = "DATA")
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogEntity logEntity = (LogEntity) o;

        if (id != logEntity.id) return false;
        if (idKrotki != logEntity.idKrotki) return false;
        if (tabela != null ? !tabela.equals(logEntity.tabela) : logEntity.tabela != null) return false;
        if (rodzajOper != null ? !rodzajOper.equals(logEntity.rodzajOper) : logEntity.rodzajOper != null) return false;
        if (data != null ? !data.equals(logEntity.data) : logEntity.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tabela != null ? tabela.hashCode() : 0);
        result = 31 * result + idKrotki;
        result = 31 * result + (rodzajOper != null ? rodzajOper.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
