package BazyDanychProjekt.BD2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Sprzet database table.
 * 
 */
@Entity
@Table(name="Sprzet")
@NamedQuery(name="SprzetEntity.findAll", query="SELECT s FROM SprzetEntity s")
public class SprzetEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_ZAKUPU")
	private Date dataZakupu;

	@Column(name="ID_PRODUCENT")
	private String idProducent;

	private int ilosc;

	private String kategoria;

	private String marka;

	private String nazwa;

	public SprzetEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDataZakupu() {
		return this.dataZakupu;
	}

	public void setDataZakupu(Date dataZakupu) {
		this.dataZakupu = dataZakupu;
	}

	public String getIdProducent() {
		return this.idProducent;
	}

	public void setIdProducent(String idProducent) {
		this.idProducent = idProducent;
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

}