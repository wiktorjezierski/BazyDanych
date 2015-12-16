package BazyDanychProjekt.BD2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the Klienci database table.
 * 
 */
@Entity
@Table(name = "Klienci")
@NamedQueries({
	@NamedQuery(name = "KlienciEntity.findAll", query = "SELECT k FROM KlienciEntity k"),
	@NamedQuery(name = "znajdzPoNazwisku", query = "SELECT k FROM KlienciEntity k WHERE k.nazwisko LIKE ?1")
})
public class KlienciEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String pesel;

	@Column(name = "ILOSC_TRANSAKCJI")
	private int iloscTransakcji;

	private String imie;

	private String nazwisko;

	@Column(name = "NR_DOWODU")
	private String nrDowodu;

	@Column(name = "NR_TELEFONU")
	private String nrTelefonu;

	private String uwagi;

	// bi-directional many-to-one association to FakturyEntity
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "klienci", fetch=FetchType.LAZY)
	private List<FakturyEntity> fakturies;

	// bi-directional many-to-one association to WypozyczeniaEntity
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "klienci", fetch=FetchType.LAZY)
	private List<WypozyczeniaEntity> wypozyczenias;
	
	// bi-directional many-to-one association to WypozyczeniaEntity
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "klienci", fetch=FetchType.LAZY)
	private List<RezerwacjaEntity> rezerwacjas;

	public KlienciEntity() {
	}

	public KlienciEntity(String pesel, int iloscTransakcji, String imie, String nazwisko, String nrDowodu,
			String nrTelefonu, String uwagi){
		
	}
	
	public KlienciEntity(String pesel, int iloscTransakcji, String imie, String nazwisko, String nrDowodu,
			String nrTelefonu, String uwagi, List<FakturyEntity> fakturies, List<WypozyczeniaEntity> wypozyczenias,
			List<RezerwacjaEntity> rezerwacjas) {
		super();
		this.pesel = pesel;
		this.iloscTransakcji = iloscTransakcji;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.nrDowodu = nrDowodu;
		this.nrTelefonu = nrTelefonu;
		this.uwagi = uwagi;
		this.fakturies = fakturies;
		this.wypozyczenias = wypozyczenias;
		this.rezerwacjas = rezerwacjas;
	}

	public String getPesel() {
		return this.pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public int getIloscTransakcji() {
		return this.iloscTransakcji;
	}

	public void setIloscTransakcji(int iloscTransakcji) {
		this.iloscTransakcji = iloscTransakcji;
	}

	public String getImie() {
		return this.imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getNrDowodu() {
		return this.nrDowodu;
	}

	public void setNrDowodu(String nrDowodu) {
		this.nrDowodu = nrDowodu;
	}

	public String getNrTelefonu() {
		return this.nrTelefonu;
	}

	public void setNrTelefonu(String nrTelefonu) {
		this.nrTelefonu = nrTelefonu;
	}

	public String getUwagi() {
		return this.uwagi;
	}

	public void setUwagi(String uwagi) {
		this.uwagi = uwagi;
	}

	public List<FakturyEntity> getFakturies() {
		return this.fakturies;
	}

	public void setFakturies(List<FakturyEntity> fakturies) {
		this.fakturies = fakturies;
	}

	public FakturyEntity addFaktury(FakturyEntity faktury) {
		getFakturies().add(faktury);
		faktury.setKlienci(this);

		return faktury;
	}

	public FakturyEntity removeFaktury(FakturyEntity faktury) {
		getFakturies().remove(faktury);
		faktury.setKlienci(null);

		return faktury;
	}

	public List<WypozyczeniaEntity> getWypozyczenias() {
		return this.wypozyczenias;
	}

	public void setWypozyczenias(List<WypozyczeniaEntity> wypozyczenias) {
		this.wypozyczenias = wypozyczenias;
	}

	public WypozyczeniaEntity addWypozyczenia(WypozyczeniaEntity wypozyczenia) {
		getWypozyczenias().add(wypozyczenia);
		wypozyczenia.setKlienci(this);

		return wypozyczenia;
	}

	public WypozyczeniaEntity removeWypozyczenia(WypozyczeniaEntity wypozyczenia) {
		getWypozyczenias().remove(wypozyczenia);
		wypozyczenia.setKlienci(null);

		return wypozyczenia;
	}
	
	public List<RezerwacjaEntity> getRezerwacjas() {
		return rezerwacjas;
	}

	public void setRezerwacjas(List<RezerwacjaEntity> rezerwacjas) {
		this.rezerwacjas = rezerwacjas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Klienci: pesel=" + pesel + ", iloscTransakcji=" + iloscTransakcji + ", imie=" + imie
				+ ", nazwisko=" + nazwisko + ", nrDowodu=" + nrDowodu + ", nrTelefonu=" + nrTelefonu + ", uwagi="
				+ uwagi  + ", wypozyczenia=" + wypozyczenias.size();
	}

}