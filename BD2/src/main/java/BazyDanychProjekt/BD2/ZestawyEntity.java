package BazyDanychProjekt.BD2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the Zestawy database table.
 * 
 */
@Entity
@Table(name="Zestawy")
@NamedQueries({
	@NamedQuery(name = "Zestawy.findAll", query = "SELECT z FROM ZestawyEntity z")
})
public class ZestawyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_END")
	private Date dataEnd;

//	@Column(name = "ID_ZESTAWU")
//	private String idZestawu;

	// bi-directional many-to-one association to SprzetEntity
	@ManyToOne(cascade = CascadeType.PERSIST, optional = false)
	@JoinColumn(name = "ID_SPRZET1")
	private SprzetEntity sprzet;

	public ZestawyEntity() {
	}

	public ZestawyEntity(int id, Date dataEnd, SprzetEntity sprzet) {
		super();
		this.id = id;
		this.dataEnd = dataEnd;
//		this.idZestawu = idZestawu;
		this.sprzet = sprzet;
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

//	public String getIdZestawu() {
//		return this.idZestawu;
//	}
//
//	public void setIdZestawu(String idZestawu) {
//		this.idZestawu = idZestawu;
//	}

	public SprzetEntity getSprzet() {
		return this.sprzet;
	}

	public void setSprzet(SprzetEntity sprzet) {
		this.sprzet = sprzet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Zestawy: id=" + id + ", dataEnd=" + dataEnd + ", idZestawu=" + sprzet.getId() ;
	}

}