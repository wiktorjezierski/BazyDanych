package BazyDanychProjekt.BD2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the Sprzet database table.
 * 
 */
@Entity
@Table(name = "Sprzet")
@NamedQueries({
	@NamedQuery(name = "SprzetEntity.findAll", query = "SELECT s FROM SprzetEntity s")
})
public class SprzetEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_ZAKUPU")
	private Date dataZakupu;

	private int dostepnych;

	private int ilosc;

	private String kategoria;

	private String marka;

	private String nazwa;

	// bi-directional many-to-one association to EgzemplarzEntity
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "sprzet", fetch=FetchType.LAZY)
	private List<EgzemplarzEntity> egzemplarzs;

	// bi-directional many-to-one association to Zestawy
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "sprzet1", fetch=FetchType.LAZY)
	private List<ZestawyEntity> zestawies;

	// bi-directional many-to-one association to ProducentEntity
	@ManyToOne(cascade = CascadeType.PERSIST, optional = false, fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_PRODUCENT")
	private ProducentEntity producent;

	public SprzetEntity() {
	}

	public SprzetEntity(int id, Date dataZakupu, int dostepnych, int ilosc, String kategoria, String marka,
			String nazwa, List<EgzemplarzEntity> egzemplarzs, List<ZestawyEntity> zestawies,
			ProducentEntity producent) {
		super();
		this.id = id;
		this.dataZakupu = dataZakupu;
		this.dostepnych = dostepnych;
		this.ilosc = ilosc;
		this.kategoria = kategoria;
		this.marka = marka;
		this.nazwa = nazwa;
		this.egzemplarzs = egzemplarzs;
		this.zestawies = zestawies;
		this.producent = producent;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataZakupu() {
		return this.dataZakupu;
	}

	public void setDataZakupu(Date dataZakupu) {
		this.dataZakupu = dataZakupu;
	}

	public int getDostepnych() {
		return this.dostepnych;
	}

	public void setDostepnych(int dostepnych) {
		this.dostepnych = dostepnych;
	}

	public int getIlosc() {
		return this.ilosc;
	}

	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}

	public String getKategoria() {
		return this.kategoria;
	}

	public void setKategoria(String kategoria) {
		this.kategoria = kategoria;
	}

	public String getMarka() {
		return this.marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getNazwa() {
		return this.nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public List<EgzemplarzEntity> getEgzemplarzs() {
		return this.egzemplarzs;
	}

	public void setEgzemplarzs(List<EgzemplarzEntity> egzemplarzs) {
		this.egzemplarzs = egzemplarzs;
	}

	public EgzemplarzEntity addEgzemplarz(EgzemplarzEntity egzemplarz) {
		getEgzemplarzs().add(egzemplarz);
		egzemplarz.setSprzet(this);

		return egzemplarz;
	}

	public EgzemplarzEntity removeEgzemplarz(EgzemplarzEntity egzemplarz) {
		getEgzemplarzs().remove(egzemplarz);
		egzemplarz.setSprzet(null);

		return egzemplarz;
	}

	public List<ZestawyEntity> getZestawies() {
		return this.zestawies;
	}

	public void setZestawies(List<ZestawyEntity> zestawies) {
		this.zestawies = zestawies;
	}

	public ZestawyEntity addZestawy(ZestawyEntity zestawy) {
		getZestawies().add(zestawy);
		zestawy.setSprzet(this);

		return zestawy;
	}

	public ZestawyEntity removeZestawy(ZestawyEntity zestawy) {
		getZestawies().remove(zestawy);
		zestawy.setSprzet(null);

		return zestawy;
	}

	public ProducentEntity getProducent() {
		return this.producent;
	}

	public void setProducent(ProducentEntity producent) {
		this.producent = producent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sprzet: id=" + id + ", dataZakupu=" + dataZakupu + ", dostepnych=" + dostepnych + ", ilosc=" + ilosc
				+ ", kategoria=" + kategoria + ", marka=" + marka + ", nazwa=" + nazwa + " producent="
				+ producent.getNazwa();

	}

}