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
	
	public List<PracownicyEntityView> findAllEmployees(){
		return mController.findAll(PracownicyEntityView.class);
	}

}
