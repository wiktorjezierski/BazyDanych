package BazyDanychProjekt.BD2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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
	private int id;

	private String adres;

	private String nazwa;

	private String telefon;

	//bi-directional many-to-one association to EgzemplarzEntity
	@OneToMany(mappedBy="serwi")
	private List<EgzemplarzEntity> egzemplarzs;

	//bi-directional many-to-one association to Serwisowanie
	@OneToMany(mappedBy="serwi")
	private List<Serwisowanie> serwisowanies;

	public SerwisEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
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

	public List<EgzemplarzEntity> getEgzemplarzs() {
		return this.egzemplarzs;
	}

	public void setEgzemplarzs(List<EgzemplarzEntity> egzemplarzs) {
		this.egzemplarzs = egzemplarzs;
	}

	public EgzemplarzEntity addEgzemplarz(EgzemplarzEntity egzemplarz) {
		getEgzemplarzs().add(egzemplarz);
		egzemplarz.setSerwi(this);

		return egzemplarz;
	}

	public EgzemplarzEntity removeEgzemplarz(EgzemplarzEntity egzemplarz) {
		getEgzemplarzs().remove(egzemplarz);
		egzemplarz.setSerwi(null);

		return egzemplarz;
	}

	public List<Serwisowanie> getSerwisowanies() {
		return this.serwisowanies;
	}

	public void setSerwisowanies(List<Serwisowanie> serwisowanies) {
		this.serwisowanies = serwisowanies;
	}

	public Serwisowanie addSerwisowany(Serwisowanie serwisowany) {
		getSerwisowanies().add(serwisowany);
		serwisowany.setSerwi(this);

		return serwisowany;
	}

	public Serwisowanie removeSerwisowany(Serwisowanie serwisowany) {
		getSerwisowanies().remove(serwisowany);
		serwisowany.setSerwi(null);

		return serwisowany;
	}

}