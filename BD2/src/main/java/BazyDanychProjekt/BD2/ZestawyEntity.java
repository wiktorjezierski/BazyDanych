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
	
	@Column(name = "ID_SPRZET2")
	private int idSprzet2;

	// bi-directional many-to-one association to SprzetEntity
	@ManyToOne(cascade = CascadeType.PERSIST, optional = false, fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_SPRZET1")
	private SprzetEntity sprzet;

	public ZestawyEntity() {
	}

	public ZestawyEntity(int id, Date dataEnd, int id2, SprzetEntity sprzet) {
		super();
		this.id = id;
		this.dataEnd = dataEnd;
		this.idSprzet2 = id2;
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

	public SprzetEntity getSprzet() {
		return this.sprzet;
	}

	public void setSprzet(SprzetEntity sprzet) {
		this.sprzet = sprzet;
	}

	public int getIdSprzet2() {
		return idSprzet2;
	}

	public void setIdSprzet2(int idSprzet2) {
		this.idSprzet2 = idSprzet2;
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