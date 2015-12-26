package BazyDanychProjekt.ApplicationFunction;

import BazyDanychProjekt.BD2.DataBaseController;
import BazyDanychProjekt.BD2.ProducentEntity;
import BazyDanychProjekt.BD2.SprzetEntity;

public class SprzetAF {

	DataBaseController mController;
	
	public SprzetAF() {
		mController = new DataBaseController();
	}

	public ProducentEntity findProducent(int i){
		return mController.findByPrimaryKey(ProducentEntity.class, i);
	}
	
	public boolean dodaj(SprzetEntity sprzet){
		try {
			mController.saveToDataBase(sprzet);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
