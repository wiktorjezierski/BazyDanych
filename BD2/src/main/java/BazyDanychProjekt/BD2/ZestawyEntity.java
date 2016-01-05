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
	
	@Column(name = "CENA")
	private int cena;
	
	// bi-directional many-to-one association to SprzetEntity
	@ManyToOne(cascade = CascadeType.PERSIST, optional = false, fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_SPRZET1")
	private SprzetEntity sprzet1;
	
	// bi-directional many-to-one association to SprzetEntity
	@ManyToOne(cascade = CascadeType.PERSIST, optional = false, fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_SPRZET2")
	private SprzetEntity sprzet2;


	public ZestawyEntity() {
	}

	public ZestawyEntity(Date dataEnd, int cena, SprzetEntity sprzet1, SprzetEntity sprzet2) {
		super();
		this.dataEnd = dataEnd;
		this.cena = cena;
		this.sprzet1 = sprzet1;
		this.sprzet2 = sprzet2;
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

	public SprzetEntity getSprzet1() {
		return this.sprzet1;
	}
	
	public SprzetEntity getSprzet2() {
		return sprzet2;
	}


	public void setSprzet(SprzetEntity sprzet) {
		this.sprzet1 = sprzet;
	}

	
	public int getCena() {
		return cena;
	}
	
	public String getNazwaSprzet1() {
		return getSprzet1().getNazwa();
	}
	
	public String getNazwaSprzet2() {
		return getSprzet2().getNazwa();
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Zestawy: id=" + id + ", dataEnd=" + dataEnd + ", idZestawu=" + sprzet1.getId() ;
	}


}