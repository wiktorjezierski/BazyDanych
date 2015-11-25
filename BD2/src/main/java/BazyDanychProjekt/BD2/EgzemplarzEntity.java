package BazyDanychProjekt.BD2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Egzemplarz database table.
 * 
 */
@Entity
@Table(name="Egzemplarz")
@NamedQuery(name="EgzemplarzEntity.findAll", query="SELECT e FROM EgzemplarzEntity e")
public class EgzemplarzEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_OST_PRZEG")
	private Date dataOstPrzeg;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_ZAKUPU")
	private Date dataZakupu;

	private byte wycofany;

	//bi-directional many-to-one association to WypozyczeniaEntity
	@OneToMany(mappedBy="egzemplarz")
	private List<WypozyczeniaEntity> wypozyczenias;

	//bi-directional many-to-one association to Serwisowanie
	@OneToMany(mappedBy="egzemplarz")
	private List<Serwisowanie> serwisowanies;

	//bi-directional many-to-one association to SprzetEntity
	@ManyToOne
	@JoinColumn(name="ID_SPRZET")
	private SprzetEntity sprzet;

	//bi-directional many-to-one association to SerwisEntity
	@ManyToOne
	@JoinColumn(name="ID_SERWIS")
	private SerwisEntity serwi;

	public EgzemplarzEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDataOstPrzeg() {
		return this.dataOstPrzeg;
	}

	public void setDataOstPrzeg(Date dataOstPrzeg) {
		this.dataOstPrzeg = dataOstPrzeg;
	}

	public Date getDataZakupu() {
		return this.dataZakupu;
	}

	public void setDataZakupu(Date dataZakupu) {
		this.dataZakupu = dataZakupu;
	}

	public byte getWycofany() {
		return this.wycofany;
	}

	public void setWycofany(byte wycofany) {
		this.wycofany = wycofany;
	}

	public List<WypozyczeniaEntity> getWypozyczenias() {
		return this.wypozyczenias;
	}

	public void setWypozyczenias(List<WypozyczeniaEntity> wypozyczenias) {
		this.wypozyczenias = wypozyczenias;
	}

	public WypozyczeniaEntity addWypozyczenia(WypozyczeniaEntity wypozyczenia) {
		getWypozyczenias().add(wypozyczenia);
		wypozyczenia.setEgzemplarz(this);

		return wypozyczenia;
	}

	public WypozyczeniaEntity removeWypozyczenia(WypozyczeniaEntity wypozyczenia) {
		getWypozyczenias().remove(wypozyczenia);
		wypozyczenia.setEgzemplarz(null);

		return wypozyczenia;
	}

	public List<Serwisowanie> getSerwisowanies() {
		return this.serwisowanies;
	}

	public void setSerwisowanies(List<Serwisowanie> serwisowanies) {
		this.serwisowanies = serwisowanies;
	}

	public Serwisowanie addSerwisowany(Serwisowanie serwisowany) {
		getSerwisowanies().add(serwisowany);
		serwisowany.setEgzemplarz(this);

		return serwisowany;
	}

	public Serwisowanie removeSerwisowany(Serwisowanie serwisowany) {
		getSerwisowanies().remove(serwisowany);
		serwisowany.setEgzemplarz(null);

		return serwisowany;
	}

	public SprzetEntity getSprzet() {
		return this.sprzet;
	}

	public void setSprzet(SprzetEntity sprzet) {
		this.sprzet = sprzet;
	}

	public SerwisEntity getSerwi() {
		return this.serwi;
	}

	public void setSerwi(SerwisEntity serwi) {
		this.serwi = serwi;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EgzemplarzEntity [id=" + id + ", dataOstPrzeg=" + dataOstPrzeg + ", dataZakupu=" + dataZakupu
				+ ", wycofany=" + wycofany + ", wypozyczenias=" + wypozyczenias + ", serwisowanies=" + serwisowanies
				+ ", sprzet=" + sprzet + ", serwi=" + serwi + "]";
	}
	
	

}