package BazyDanychProjekt.BD2;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Log database table.
 * 
 */
@Entity
@Table(name="Log")
@NamedQuery(name="LogEntity.findAll", query="SELECT l FROM LogEntity l")
public class LogEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;

	@Temporal(TemporalType.DATE)
	private Date data;

	@Column(name="ID_KROTKI")
	private int idKrotki;

	@Column(name="RODZAJ_OPER")
	private String rodzajOper;

	private String tabela;

	public LogEntity() {
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

	public int getIdKrotki() {
		return this.idKrotki;
	}

	public void setIdKrotki(int idKrotki) {
		this.idKrotki = idKrotki;
	}

	public String getRodzajOper() {
		return this.rodzajOper;
	}

	public void setRodzajOper(String rodzajOper) {
		this.rodzajOper = rodzajOper;
	}

	public String getTabela() {
		return this.tabela;
	}

	public void setTabela(String tabela) {
		this.tabela = tabela;
	}

}