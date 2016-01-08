package BazyDanychProjekt.ApplicationFunction;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import BazyDanychProjekt.BD2.DataBaseController;
import BazyDanychProjekt.BD2.ProducentEntity;
import BazyDanychProjekt.BD2.SprzetEntity;
import interfejs.WybierzProducentaDialog;

public class SprzetAF {

	DataBaseController mController;
	private ArrayList<SprzetEntity> mSprzetList;
	
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
		mSprzetList = new ArrayList<>(mController.findAll(SprzetEntity.class));
		return mSprzetList;
	}

	public ArrayList<SprzetEntity> getSprzetList() {
		return mSprzetList;
	}

	public void setSprzetList(ArrayList<SprzetEntity> mSprzetList) {
		this.mSprzetList = mSprzetList;
	}
	
	public void deletePosition(int position){
		mSprzetList.remove(position);
	}
	
	public void addPosition(int position, SprzetEntity sprzet){
		mSprzetList.add(position, sprzet);
	}
	
}
