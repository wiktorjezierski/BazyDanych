package BazyDanychProjekt.BD2;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Serwis database table.
 * 
 */
@Entity
@Table(name="Serwis")
@NamedQuery(name="SerwisEntity.findAll", query="SELECT s FROM SerwisEntity s")
public class SerwisEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String adres;

	private String nazwa;

	private String telefon;

	public SerwisEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdres() {
		return this.adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getTelefon() {
		return this.telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

}