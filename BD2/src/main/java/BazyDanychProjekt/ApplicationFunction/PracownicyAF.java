package BazyDanychProjekt.ApplicationFunction;

import java.util.List;

import BazyDanychProjekt.BD2.DataBaseController;
import BazyDanychProjekt.BD2.PracownicyEntity;
/**
 * @author Wiktor Jezierski
 * */
public class PracownicyAF {
	
	private DataBaseController mController;
	private List<PracownicyEntity> employees;
	
	public List<PracownicyEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(List<PracownicyEntity> employees) {
		this.employees = employees;
	}

	public PracownicyAF() {
		super();
		mController = new DataBaseController();
	}

	public List<PracownicyEntity> findAllEmployees(){
		return mController.findAll(PracownicyEntity.class);
	}
	
	public boolean remove(int number){
		PracownicyEntity p = employees.get(number);
		employees.remove(number);
		return mController.remove(p);
	}

}
