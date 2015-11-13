package BazyDanychProjekt.BD2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Faktury database table.
 * 
 */
@Entity
@Table(name="Faktury")
@NamedQuery(name="FakturyEntity.findAll", query="SELECT f FROM FakturyEntity f")
public class FakturyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_FAKTURY")
	private String idFaktury;

	@Temporal(TemporalType.DATE)
	@Column(name="DATA_WYST")
	private Date dataWyst;

	private float kwota;

	@Column(name="PESEL_KLIENTA")
	private String peselKlienta;

	//bi-directional many-to-one association to PracownicyEntity
	@ManyToOne
	@JoinColumn(name="PESEL_PRAC")
	private PracownicyEntity pracownicy;

	public FakturyEntity() {
	}

	public String getIdFaktury() {
		return this.idFaktury;
	}

	public void setIdFaktury(String idFaktury) {
		this.idFaktury = idFaktury;
	}

	public Date getDataWyst() {
		return this.dataWyst;
	}

	public void setDataWyst(Date dataWyst) {
		this.dataWyst = dataWyst;
	}

	public float getKwota() {
		return this.kwota;
	}

	public void setKwota(float kwota) {
		this.kwota = kwota;
	}

	public String getPeselKlienta() {
		return this.peselKlienta;
	}

	public void setPeselKlienta(String peselKlienta) {
		this.peselKlienta = peselKlienta;
	}

	public PracownicyEntity getPracownicy() {
		return this.pracownicy;
	}

	public void setPracownicy(PracownicyEntity pracownicy) {
		this.pracownicy = pracownicy;
	}

}