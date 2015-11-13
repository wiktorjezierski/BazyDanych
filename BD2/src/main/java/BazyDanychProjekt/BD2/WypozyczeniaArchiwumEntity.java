package BazyDanychProjekt.BD2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the WypozyczeniaArchiwum database table.
 * 
 */
@Entity
@Table(name="WypozyczeniaArchiwum")
@NamedQuery(name="WypozyczeniaArchiwumEntity.findAll", query="SELECT w FROM WypozyczeniaArchiwumEntity w")
public class WypozyczeniaArchiwumEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_WYP")
	private Date dataWyp;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_ZWROTU")
	private Date dataZwrotu;

	@Column(name="ID_FAKTURY")
	private String idFaktury;

	@Column(name="ID_SPRZETU")
	private String idSprzetu;

	@Column(name="PESEL_KLIENTA")
	private String peselKlienta;

	@Column(name="PESEL_PRAC")
	private String peselPrac;

	public WypozyczeniaArchiwumEntity() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDataWyp() {
		return this.dataWyp;
	}

	public void setDataWyp(Date dataWyp) {
		this.dataWyp = dataWyp;
	}

	public Date getDataZwrotu() {
		return this.dataZwrotu;
	}

	public void setDataZwrotu(Date dataZwrotu) {
		this.dataZwrotu = dataZwrotu;
	}

	public String getIdFaktury() {
		return this.idFaktury;
	}

	public void setIdFaktury(String idFaktury) {
		this.idFaktury = idFaktury;
	}

	public String getIdSprzetu() {
		return this.idSprzetu;
	}

	public void setIdSprzetu(String idSprzetu) {
		this.idSprzetu = idSprzetu;
	}

	public String getPeselKlienta() {
		return this.peselKlienta;
	}

	public void setPeselKlienta(String peselKlienta) {
		this.peselKlienta = peselKlienta;
	}

	public String getPeselPrac() {
		return this.peselPrac;
	}

	public void setPeselPrac(String peselPrac) {
		this.peselPrac = peselPrac;
	}

}