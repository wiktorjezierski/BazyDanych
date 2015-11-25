package BazyDanychProjekt.BD2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Serwisowanie database table.
 * 
 */
@Entity
@NamedQuery(name="Serwisowanie.findAll", query="SELECT s FROM Serwisowanie s")
public class Serwisowanie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date data;

	private int koszt;

	//bi-directional many-to-one association to EgzemplarzEntity
	@ManyToOne
	@JoinColumn(name="id_Egzemplarz")
	private EgzemplarzEntity egzemplarz;

	//bi-directional many-to-one association to SerwisEntity
	@ManyToOne
	@JoinColumn(name="id_Serwis")
	private SerwisEntity serwi;

	public Serwisowanie() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getKoszt() {
		return this.koszt;
	}

	public void setKoszt(int koszt) {
		this.koszt = koszt;
	}

	public EgzemplarzEntity getEgzemplarz() {
		return this.egzemplarz;
	}

	public void setEgzemplarz(EgzemplarzEntity egzemplarz) {
		this.egzemplarz = egzemplarz;
	}

	public SerwisEntity getSerwi() {
		return this.serwi;
	}

	public void setSerwi(SerwisEntity serwi) {
		this.serwi = serwi;
	}

}