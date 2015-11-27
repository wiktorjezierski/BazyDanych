package BazyDanychProjekt.BD2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the Serwis database table.
 * 
 */
@Entity
@Table(name = "Serwis")
@NamedQueries({
	@NamedQuery(name = "SerwisEntity.findAll", query = "SELECT s FROM SerwisEntity s")
})
public class SerwisEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String adres;

	private String nazwa;

	private String telefon;

	// bi-directional many-to-one association to EgzemplarzEntity
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "serwi")
	private List<EgzemplarzEntity> egzemplarzs;

	// bi-directional many-to-one association to Serwisowanie
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "serwi")
	private List<SerwisowanieEntity> serwisowanies;

	public SerwisEntity() {
	}

	public SerwisEntity(int id, String adres, String nazwa, String telefon, List<EgzemplarzEntity> egzemplarzs,
			List<SerwisowanieEntity> serwisowanies) {
		super();
		this.id = id;
		this.adres = adres;
		this.nazwa = nazwa;
		this.telefon = telefon;
		this.egzemplarzs = egzemplarzs;
		this.serwisowanies = serwisowanies;
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

	public List<SerwisowanieEntity> getSerwisowanies() {
		return this.serwisowanies;
	}

	public void setSerwisowanies(List<SerwisowanieEntity> serwisowanies) {
		this.serwisowanies = serwisowanies;
	}

	public SerwisowanieEntity addSerwisowany(SerwisowanieEntity serwisowany) {
		getSerwisowanies().add(serwisowany);
		serwisowany.setSerwi(this);

		return serwisowany;
	}

	public SerwisowanieEntity removeSerwisowany(SerwisowanieEntity serwisowany) {
		getSerwisowanies().remove(serwisowany);
		serwisowany.setSerwi(null);

		return serwisowany;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Serwis: id=" + id + ", adres=" + adres + ", nazwa=" + nazwa + ", telefon=" + telefon;
	}

}