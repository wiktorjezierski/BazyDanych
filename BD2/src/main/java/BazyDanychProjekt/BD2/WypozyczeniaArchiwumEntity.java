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
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_WYP")
	private Date dataWyp;

	@Column(name="ID_EGZEMPLARZA")
	private String idEgzemplarza;

	@Column(name="ID_FAKTURY")
	private String idFaktury;

	@Column(name="PESEL_KLIENTA")
	private String peselKlienta;

	@Column(name="PESEL_PRAC")
	private String peselPrac;

	public WypozyczeniaArchiwumEntity() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataWyp() {
		return this.dataWyp;
	}

	public void setDataWyp(Date dataWyp) {
		this.dataWyp = dataWyp;
	}

	public String getIdEgzemplarza() {
		return this.idEgzemplarza;
	}

	public void setIdEgzemplarza(String idEgzemplarza) {
		this.idEgzemplarza = idEgzemplarza;
	}

	public String getIdFaktury() {
		return this.idFaktury;
	}

	public void setIdFaktury(String idFaktury) {
		this.idFaktury = idFaktury;
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