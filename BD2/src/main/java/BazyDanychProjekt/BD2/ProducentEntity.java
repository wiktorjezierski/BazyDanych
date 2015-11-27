package BazyDanychProjekt.BD2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Producent database table.
 * 
 */
@Entity
@Table(name="Producent")
@NamedQuery(name="ProducentEntity.findAll", query="SELECT p FROM ProducentEntity p")
public class ProducentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String adres;

	private String nazwa;

	private String telefon;

	//bi-directional many-to-one association to SprzetEntity
	@OneToMany(cascade=CascadeType.PERSIST,mappedBy="producent")
	private List<SprzetEntity> sprzets;

	public ProducentEntity() {
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

	public List<SprzetEntity> getSprzets() {
		return this.sprzets;
	}

	public void setSprzets(List<SprzetEntity> sprzets) {
		this.sprzets = sprzets;
	}

	public SprzetEntity addSprzet(SprzetEntity sprzet) {
		getSprzets().add(sprzet);
		sprzet.setProducent(this);

		return sprzet;
	}

	public SprzetEntity removeSprzet(SprzetEntity sprzet) {
		getSprzets().remove(sprzet);
		sprzet.setProducent(null);

		return sprzet;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProducentEntity [id=" + id + ", adres=" + adres + ", nazwa=" + nazwa + ", telefon=" + telefon
				+ ", sprzets=" + sprzets + "]";
	}

}