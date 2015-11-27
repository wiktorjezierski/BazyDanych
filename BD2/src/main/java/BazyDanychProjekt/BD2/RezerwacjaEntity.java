package BazyDanychProjekt.BD2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the rezerwacja database table.
 * 
 */
@Entity
@Table(name = "rezerwacja")
@NamedQuery(name = "RezerwacjaEntity.findAll", query = "SELECT r FROM RezerwacjaEntity r")
public class RezerwacjaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_KONIEC")
	private Date dataKoniec;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATA_START")
	private Date dataStart;

	@Column(name = "ID_EGZEMPLARZ")
	private String idEgzemplarz;

	@Column(name = "PESEL_KLIENTA")
	private String peselKlienta;

	@Column(name = "PESEL_PRAC")
	private String peselPrac;

	public RezerwacjaEntity() {
	}

	public RezerwacjaEntity(int id, Date dataKoniec, Date dataStart, String idEgzemplarz, String peselKlienta,
			String peselPrac) {
		super();
		this.id = id;
		this.dataKoniec = dataKoniec;
		this.dataStart = dataStart;
		this.idEgzemplarz = idEgzemplarz;
		this.peselKlienta = peselKlienta;
		this.peselPrac = peselPrac;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataKoniec() {
		return this.dataKoniec;
	}

	public void setDataKoniec(Date dataKoniec) {
		this.dataKoniec = dataKoniec;
	}

	public Date getDataStart() {
		return this.dataStart;
	}

	public void setDataStart(Date dataStart) {
		this.dataStart = dataStart;
	}

	public String getIdEgzemplarz() {
		return this.idEgzemplarz;
	}

	public void setIdEgzemplarz(String idEgzemplarz) {
		this.idEgzemplarz = idEgzemplarz;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RezerwacjaEntity [id=" + id + ", dataKoniec=" + dataKoniec + ", dataStart=" + dataStart
				+ ", idEgzemplarz=" + idEgzemplarz + ", peselKlienta=" + peselKlienta + ", peselPrac=" + peselPrac
				+ "]";
	}

}