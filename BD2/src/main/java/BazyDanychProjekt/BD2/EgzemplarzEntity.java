package BazyDanychProjekt.BD2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


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

	@Column(name="ID_SERWIS")
	private String idSerwis;

	@Column(name="ID_SPRZET")
	private String idSprzet;

	private byte wycofany;

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

	public String getIdSerwis() {
		return this.idSerwis;
	}

	public void setIdSerwis(String idSerwis) {
		this.idSerwis = idSerwis;
	}

	public String getIdSprzet() {
		return this.idSprzet;
	}

	public void setIdSprzet(String idSprzet) {
		this.idSprzet = idSprzet;
	}

	public byte getWycofany() {
		return this.wycofany;
	}

	public void setWycofany(byte wycofany) {
		this.wycofany = wycofany;
	}

}