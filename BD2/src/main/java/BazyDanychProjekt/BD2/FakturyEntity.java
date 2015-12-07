package BazyDanychProjekt.BD2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the Faktury database table.
 * 
 */
@Entity
@Table(name = "Faktury")
@NamedQueries({
	@NamedQuery(name = "FakturyEntity.findAll", query = "SELECT f FROM FakturyEntity f")
})
public class FakturyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_FAKTURY")
	private int idFaktury;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_WYST")
	private Date dataWyst;

	private float kwota;

	// bi-directional many-to-one association to PracownicyEntity
	@ManyToOne(cascade = CascadeType.PERSIST, optional = false, fetch=FetchType.LAZY)
	@JoinColumn(name = "PESEL_PRAC")
	private PracownicyEntity pracownicy;

	// bi-directional many-to-one association to WypozyczeniaEntity
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "faktury", fetch=FetchType.LAZY)
	private List<WypozyczeniaEntity> wypozyczenias;

	// bi-directional many-to-one association to KlienciEntity
	@ManyToOne(cascade = CascadeType.PERSIST, optional = false, fetch=FetchType.LAZY)
	@JoinColumn(name = "PESEL_KLIENTA")
	private KlienciEntity klienci;

	public FakturyEntity() {
	}

	public FakturyEntity(int idFaktury, Date dataWyst, float kwota, PracownicyEntity pracownicy,
			List<WypozyczeniaEntity> wypozyczenias, KlienciEntity klienci) {
		super();
		this.idFaktury = idFaktury;
		this.dataWyst = dataWyst;
		this.kwota = kwota;
		this.pracownicy = pracownicy;
		this.wypozyczenias = wypozyczenias;
		this.klienci = klienci;
	}

	public int getIdFaktury() {
		return this.idFaktury;
	}

	public void setIdFaktury(int idFaktury) {
		this.idFaktury = idFaktury;
	}

	public Date getDataWyst() {
		return this.dataWyst;
	}

	public void setDataWyst(Date dataWyst) {
		this.dataWyst = dataWyst;
	}

	public float getKwota() {
		return this.kwota;
	}

	public void setKwota(float kwota) {
		this.kwota = kwota;
	}

	public PracownicyEntity getPracownicy() {
		return this.pracownicy;
	}

	public void setPracownicy(PracownicyEntity pracownicy) {
		this.pracownicy = pracownicy;
	}

	public List<WypozyczeniaEntity> getWypozyczenias() {
		return this.wypozyczenias;
	}

	public void setWypozyczenias(List<WypozyczeniaEntity> wypozyczenias) {
		this.wypozyczenias = wypozyczenias;
	}

	public WypozyczeniaEntity addWypozyczenia(WypozyczeniaEntity wypozyczenia) {
		getWypozyczenias().add(wypozyczenia);
		wypozyczenia.setFaktury(this);

		return wypozyczenia;
	}

	public WypozyczeniaEntity removeWypozyczenia(WypozyczeniaEntity wypozyczenia) {
		getWypozyczenias().remove(wypozyczenia);
		wypozyczenia.setFaktury(null);

		return wypozyczenia;
	}

	public KlienciEntity getKlienci() {
		return this.klienci;
	}

	public void setKlienci(KlienciEntity klienci) {
		this.klienci = klienci;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Faktury: dataWyst=" + dataWyst + ", kwota=" + kwota + ", pracownicy="
				+ pracownicy.getNazwisko() + ", klient=" + klienci.getImie() +" " + klienci.getNazwisko() + "]";
	}

}