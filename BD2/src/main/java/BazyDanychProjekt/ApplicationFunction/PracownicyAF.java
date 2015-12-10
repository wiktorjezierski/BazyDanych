package BazyDanychProjekt.ApplicationFunction;

import java.util.List;

import BazyDanychProjekt.BD2.DataBaseController;
import BazyDanychProjekt.BD2.PracownicyEntity;
import BazyDanychProjekt.BD2.PracownicyEntityView;

/**
 * @author Wiktor Jezierski
 * */
public class PracownicyAF {
	
	DataBaseController mController;

	public PracownicyAF() {
		super();
		mController = new DataBaseController();
	}
	
	public List<PracownicyEntity> findAllEmployees(){
		return mController.findAll(PracownicyEntity.class);
	}

}
