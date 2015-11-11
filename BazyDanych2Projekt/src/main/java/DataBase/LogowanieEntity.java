package DataBase;

import javax.persistence.*;

/**
 * Created by user on 2015-11-11.
 */
@Entity
@Table(name = "LOGOWANIE", schema = "", catalog = "stuntman_proj")
public class LogowanieEntity {
    private String pesel;
    private String login;
    private String haslo;

    @Id
    @Column(name = "PESEL")
    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @Basic
    @Column(name = "LOGIN")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "HASLO")
    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogowanieEntity that = (LogowanieEntity) o;

        if (pesel != null ? !pesel.equals(that.pesel) : that.pesel != null) return false;
        if (login != null ? !login.equals(that.login) : that.login != null) return false;
        if (haslo != null ? !haslo.equals(that.haslo) : that.haslo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pesel != null ? pesel.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (haslo != null ? haslo.hashCode() : 0);
        return result;
    }
}
