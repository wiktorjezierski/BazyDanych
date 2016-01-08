package BazyDanychProjekt.ApplicationFunction;

import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import BazyDanychProjekt.BD2.DataBaseController;
import BazyDanychProjekt.BD2.ProducentEntity;
import BazyDanychProjekt.BD2.SprzetEntity;
import interfejs.WybierzProducentaDialog;

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
	
	public ProducentEntity wybierzProducenta(JFrame fr){
		WybierzProducentaDialog frame = new WybierzProducentaDialog(fr);
		frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
		return frame.mProducent;
	}
	
	public List<SprzetEntity> findAllDevice(){
		return mController.findAll(SprzetEntity.class);
	}
	
}
