package BazyDanychProjekt.BD2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the rezerwacja database table.
 * 
 */
@Entity
@Table(name = "rezerwacja")
@NamedQueries({
	@NamedQuery(name = "RezerwacjaEntity.findAll", query = "SELECT r FROM RezerwacjaEntity r")
})
public class RezerwacjaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_KONIEC")
	private Date dataKoniec;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_START")
	private Date dataStart;

	// bi-directional many-to-one association to KlienciEntity
	@ManyToOne(cascade = CascadeType.PERSIST, optional = false, fetch=FetchType.LAZY)
	@JoinColumn(name = "PESEL_KLIENTA")
	private KlienciEntity klienci;
	
	// bi-directional many-to-one association to KlienciEntity
	@ManyToOne(cascade = CascadeType.PERSIST, optional = false, fetch=FetchType.LAZY)
	@JoinColumn(name = "PESEL_PRAC")
	private PracownicyEntity pracownicy;
	
	// bi-directional many-to-one association to EgzemplarzEntity
	@ManyToOne(cascade = CascadeType.PERSIST, optional = false, fetch=FetchType.LAZY)
	@JoinColumn(name = "ID")
	private EgzemplarzEntity egzemplarz;
	

	public RezerwacjaEntity() {
	}

	public RezerwacjaEntity(int id, Date dataKoniec, Date dataStart, KlienciEntity klienci, PracownicyEntity pracownicy,
			EgzemplarzEntity egzemplarz) {
		super();
		this.id = id;
		this.dataKoniec = dataKoniec;
		this.dataStart = dataStart;
		this.klienci = klienci;
		this.pracownicy = pracownicy;
		this.egzemplarz = egzemplarz;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataKoniec() {
		return this.dataKoniec;
	}

	public void setDataKoniec(Date dataKoniec) {
		this.dataKoniec = dataKoniec;
	}

	public Date getDataStart() {
		return this.dataStart;
	}

	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}

	public KlienciEntity getKlienci() {
		return klienci;
	}

	public void setKlienci(KlienciEntity klienci) {
		this.klienci = klienci;
	}

	public PracownicyEntity getPracownicy() {
		return pracownicy;
	}

	public void setPracownicy(PracownicyEntity pracownicy) {
		this.pracownicy = pracownicy;
	}

	public EgzemplarzEntity getEgzemplarz() {
		return egzemplarz;
	}

	public void setEgzemplarz(EgzemplarzEntity egzemplarz) {
		this.egzemplarz = egzemplarz;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Rezerwacja: id=" + id + ", dataKoniec=" + dataKoniec + ", dataStart=" + dataStart;
	}

}