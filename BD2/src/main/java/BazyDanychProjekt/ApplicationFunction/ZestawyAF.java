package BazyDanychProjekt.ApplicationFunction;

import java.util.List;

import BazyDanychProjekt.BD2.DataBaseController;
import BazyDanychProjekt.BD2.ZestawyEntity;

public class ZestawyAF {

	DataBaseController mController;

	public ZestawyAF() {
		mController = new DataBaseController();
	}
	
/*	public String dodaj(String pesel, String imie, String nazwisko, String nrDowodu, String telefon, String uwagi) throws Exception {
		KlienciEntity klient = new KlienciEntity(pesel, 0, imie, nazwisko, nrDowodu, telefon, uwagi);
		boolean local = mController.saveToDataBase(klient);

		if (local == true) {
			return "Pomyślnie dodano do bazy danych.";
		} else {
			return "Wystąpił błąd.";
		}
	}*/
	
	public List<ZestawyEntity> findAllKits(){
		return mController.findAll(ZestawyEntity.class);
	}
}
