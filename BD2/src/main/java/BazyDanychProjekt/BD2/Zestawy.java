package BazyDanychProjekt.BD2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Zestawy database table.
 * 
 */
@Entity
@NamedQuery(name="Zestawy.findAll", query="SELECT z FROM Zestawy z")
public class Zestawy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_END")
	private Date dataEnd;

	@Column(name="ID_ZESTAWU")
	private String idZestawu;

	//bi-directional many-to-one association to SprzetEntity
	@ManyToOne
	@JoinColumn(name="ID_SPRZET")
	private SprzetEntity sprzet;

	public Zestawy() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataEnd() {
		return this.dataEnd;
	}

	public void setDataEnd(Date dataEnd) {
		this.dataEnd = dataEnd;
	}

	public String getIdZestawu() {
		return this.idZestawu;
	}

	public void setIdZestawu(String idZestawu) {
		this.idZestawu = idZestawu;
	}

	public SprzetEntity getSprzet() {
		return this.sprzet;
	}

	public void setSprzet(SprzetEntity sprzet) {
		this.sprzet = sprzet;
	}

}