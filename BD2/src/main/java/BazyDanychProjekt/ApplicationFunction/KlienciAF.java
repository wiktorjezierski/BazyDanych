package BazyDanychProjekt.ApplicationFunction;

import java.util.List;

import BazyDanychProjekt.BD2.DataBaseController;
import BazyDanychProjekt.BD2.KlienciEntity;
import BazyDanychProjekt.BD2.PracownicyEntity;

public class KlienciAF {

	DataBaseController mController;

	public KlienciAF() {
		mController = new DataBaseController();
	}
	
	public String dodaj(String pesel, String imie, String nazwisko, String nrDowodu, String telefon, String uwagi) throws Exception {
		KlienciEntity klient = new KlienciEntity(pesel, 0, imie, nazwisko, nrDowodu, telefon, uwagi);
		boolean local = mController.saveToDataBase(klient);

		if (local == true) {
			return "Pomyślnie dodano do bazy danych.";
		} else {
			return "Wystąpił błąd.";
		}
	}
	
	public List<KlienciEntity> findAllCustomers(){
		return mController.findAll(KlienciEntity.class);
	}
}
