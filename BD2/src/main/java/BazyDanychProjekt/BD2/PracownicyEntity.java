package BazyDanychProjekt.BD2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the Pracownicy database table.
 * 
 */
@Entity
@Table(name = "Pracownicy")
@NamedQueries({ 
	@NamedQuery(name = "PracownicyEntity.findAll", query = "SELECT p FROM PracownicyEntity p") 
	})
public class PracownicyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PESEL_PRAC")
	private String peselPrac;

	@Column(name = "ADRES_EMAIL")
	private String adresEmail;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_STARTU")
	private Date dataStartu;

	private String imie;

	private String nazwisko;

	private String stanowisko;

	@Temporal(TemporalType.DATE)
	private Date zwolniony;
	
	@Column(name = "ACCESS_LEVEL")
	private int accessLevel;

	// bi-directional many-to-one association to FakturyEntity
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "pracownicy", fetch=FetchType.LAZY)
	private List<FakturyEntity> fakturies;

	// bi-directional one-to-one association to LogowanieEntity
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "pracownicy", fetch=FetchType.LAZY)
	private List<LogowanieEntity> logowanie;

	// bi-directional many-to-one association to WypozyczeniaEntity
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "pracownicy", fetch=FetchType.LAZY)
	private List<WypozyczeniaEntity> wypozyczenias;
	
	// bi-directional many-to-one association to WypozyczeniaEntity
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "pracownicy", fetch=FetchType.LAZY)
	private List<RezerwacjaEntity> rezerwacjas;

	public PracownicyEntity() {
	}

	public PracownicyEntity(String peselPrac, String adresEmail, Date dataStartu, String imie, String nazwisko,
			String stanowisko, Date zwolniony, List<FakturyEntity> fakturies, List<LogowanieEntity> logowanie,
			List<WypozyczeniaEntity> wypozyczenias, List<RezerwacjaEntity> rezerwacjas) {
		super();
		this.peselPrac = peselPrac;
		this.adresEmail = adresEmail;
		this.dataStartu = dataStartu;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.stanowisko = stanowisko;
		this.zwolniony = zwolniony;
		this.fakturies = fakturies;
		this.logowanie = logowanie;
		this.wypozyczenias = wypozyczenias;
		this.rezerwacjas = rezerwacjas;
	}


	public String getPeselPrac() {
		return this.peselPrac;
	}

	public void setPeselPrac(String peselPrac) {
		this.peselPrac = peselPrac;
	}

	public String getAdresEmail() {
		return this.adresEmail;
	}

	public void setAdresEmail(String adresEmail) {
		this.adresEmail = adresEmail;
	}

	public Date getDataStartu() {
		return this.dataStartu;
	}

	public void setDataStartu(Date dataStartu) {
		this.dataStartu = dataStartu;
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

	public String getStanowisko() {
		return this.stanowisko;
	}

	public void setStanowisko(String stanowisko) {
		this.stanowisko = stanowisko;
	}

	public Date getZwolniony() {
		return this.zwolniony;
	}

	public void setZwolniony(Date zwolniony) {
		this.zwolniony = zwolniony;
	}

	public List<FakturyEntity> getFakturies() {
		return this.fakturies;
	}

	public void setFakturies(List<FakturyEntity> fakturies) {
		this.fakturies = fakturies;
	}

	public FakturyEntity addFaktury(FakturyEntity faktury) {
		getFakturies().add(faktury);
		faktury.setPracownicy(this);

		return faktury;
	}

	public FakturyEntity removeFaktury(FakturyEntity faktury) {
		getFakturies().remove(faktury);
		faktury.setPracownicy(null);

		return faktury;
	}

	public LogowanieEntity getLogowanie() {
		return this.logowanie.get(0);
	}

	public void setLogowanie(LogowanieEntity logowanie) {
		this.logowanie.add(logowanie);
	}

	public List<WypozyczeniaEntity> getWypozyczenias() {
		return this.wypozyczenias;
	}

	public void setWypozyczenias(List<WypozyczeniaEntity> wypozyczenias) {
		this.wypozyczenias = wypozyczenias;
	}

	public WypozyczeniaEntity addWypozyczenia(WypozyczeniaEntity wypozyczenia) {
		getWypozyczenias().add(wypozyczenia);
		wypozyczenia.setPracownicy(this);

		return wypozyczenia;
	}

	public WypozyczeniaEntity removeWypozyczenia(WypozyczeniaEntity wypozyczenia) {
		getWypozyczenias().remove(wypozyczenia);
		wypozyczenia.setPracownicy(null);

		return wypozyczenia;
	}
	
	public void setLogowanie(List<LogowanieEntity> logowanie) {
		this.logowanie = logowanie;
	}
	

	public List<RezerwacjaEntity> getRezerwacjas() {
		return rezerwacjas;
	}

	public void setRezerwacjas(List<RezerwacjaEntity> rezerwacjas) {
		this.rezerwacjas = rezerwacjas;
	}

	public int getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pracownicy: pesel=" + peselPrac + ", adresEmail=" + adresEmail + ", dataStartu=" + dataStartu
				+ ", imie=" + imie + ", nazwisko=" + nazwisko + ", stanowisko=" + stanowisko + ", zwolniony="
				+ zwolniony;
	}

}