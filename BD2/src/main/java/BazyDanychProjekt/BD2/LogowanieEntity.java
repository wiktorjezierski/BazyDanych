package BazyDanychProjekt.BD2;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the LOGOWANIE database table.
 * 
 */
@Entity
@Table(name = "LOGOWANIE")
@NamedQueries({
	@NamedQuery(name = "LogowanieEntity.findAll", query = "SELECT l FROM LogowanieEntity l")
})
public class LogowanieEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String pesel;

	private String haslo;

	private String login;

	// bi-directional one-to-one association to PracownicyEntity
	@OneToOne(cascade = CascadeType.PERSIST, optional = false)
	@JoinColumn(name = "PESEL")
	private PracownicyEntity pracownicy;

	public LogowanieEntity() {
	}

	public LogowanieEntity(String pesel, String haslo, String login, PracownicyEntity pracownicy) {
		super();
		this.pesel = pesel;
		this.haslo = haslo;
		this.login = login;
		this.pracownicy = pracownicy;
	}

	public String getPesel() {
		return this.pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getHaslo() {
		return this.haslo;
	}

	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public PracownicyEntity getPracownicy() {
		return this.pracownicy;
	}

	public void setPracownicy(PracownicyEntity pracownicy) {
		this.pracownicy = pracownicy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Logowanie: pesel=" + pesel + ", haslo=" + haslo + ", login=" + login + ", pracownicy="
				+ pracownicy.getImie() + " " + pracownicy.getAdresEmail();
	}

}