package BazyDanychProjekt.ApplicationFunction;

import BazyDanychProjekt.BD2.DataBaseController;
import BazyDanychProjekt.BD2.KlienciEntity;

public class KlienciAF {

	DataBaseController mController;

	public KlienciAF() {
		mController = new DataBaseController();
	}
	
	public boolean dodaj(String pesel, String imie, String nazwisko, String nrDowodu, String telefon, String uwagi) {
		KlienciEntity klient = new KlienciEntity(pesel, 0, imie, nazwisko, nrDowodu, telefon, uwagi, );
	}
}
