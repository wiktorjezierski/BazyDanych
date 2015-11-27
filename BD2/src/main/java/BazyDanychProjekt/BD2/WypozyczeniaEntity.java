package BazyDanychProjekt.BD2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the Wypozyczenia database table.
 * 
 */
@Entity
@Table(name = "Wypozyczenia")
@NamedQuery(name = "WypozyczeniaEntity.findAll", query = "SELECT w FROM WypozyczeniaEntity w")
public class WypozyczeniaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_WYP")
	private Date dataWyp;

	// bi-directional many-to-one association to PracownicyEntity
	@ManyToOne(cascade = CascadeType.PERSIST, optional = false)
	@JoinColumn(name = "PESEL_PRAC")
	private PracownicyEntity pracownicy;

	// bi-directional many-to-one association to FakturyEntity
	@ManyToOne(cascade = CascadeType.PERSIST, optional = false)
	@JoinColumn(name = "ID_FAKTURY")
	private FakturyEntity faktury;

	// bi-directional many-to-one association to KlienciEntity
	@ManyToOne(cascade = CascadeType.PERSIST, optional = false)
	@JoinColumn(name = "PESEL_KLIENTA")
	private KlienciEntity klienci;

	// bi-directional many-to-one association to EgzemplarzEntity
	@ManyToOne(cascade = CascadeType.PERSIST, optional = false)
	@JoinColumn(name = "ID_EGZEMPLARZA")
	private EgzemplarzEntity egzemplarz;

	public WypozyczeniaEntity() {
	}

	public WypozyczeniaEntity(int id, Date dataWyp, PracownicyEntity pracownicy, FakturyEntity faktury,
			KlienciEntity klienci, EgzemplarzEntity egzemplarz) {
		super();
		this.id = id;
		this.dataWyp = dataWyp;
		this.pracownicy = pracownicy;
		this.faktury = faktury;
		this.klienci = klienci;
		this.egzemplarz = egzemplarz;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataWyp() {
		return this.dataWyp;
	}

	public void setDataWyp(Date dataWyp) {
		this.dataWyp = dataWyp;
	}

	public PracownicyEntity getPracownicy() {
		return this.pracownicy;
	}

	public void setPracownicy(PracownicyEntity pracownicy) {
		this.pracownicy = pracownicy;
	}

	public FakturyEntity getFaktury() {
		return this.faktury;
	}

	public void setFaktury(FakturyEntity faktury) {
		this.faktury = faktury;
	}

	public KlienciEntity getKlienci() {
		return this.klienci;
	}

	public void setKlienci(KlienciEntity klienci) {
		this.klienci = klienci;
	}

	public EgzemplarzEntity getEgzemplarz() {
		return this.egzemplarz;
	}

	public void setEgzemplarz(EgzemplarzEntity egzemplarz) {
		this.egzemplarz = egzemplarz;
	}

	@Override
	public String toString() {
		return "WypozyczeniaEntity [dataWyp=" + dataWyp + ", faktury=" + pracownicy.getImie() + "SPRZET= "
				+ egzemplarz.getSprzet().getIlosc() + "]";
	}

}