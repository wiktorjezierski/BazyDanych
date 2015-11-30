package BazyDanychProjekt.ApplicationFunction;

import java.util.List;

import org.hibernate.annotations.Nationalized;

import BazyDanychProjekt.BD2.DataBaseController;
import BazyDanychProjekt.BD2.LogowanieEntity;

/**
 * @author Wiktor Jezierski
 *
 */
public class LogowanieAF {

	private DataBaseController dbController;

	/**
	 * standard constructor
	 */
	public LogowanieAF() {
		super();
		dbController = new DataBaseController();
	}

	/**
	 * Function validate data in purpose login into system
	 * check can be according to login and pesel
	 * */
	public boolean zaloguj(String name, String password) {
		try {
			LogowanieEntity pesel = dbController.findByPrimaryKey(LogowanieEntity.class, name);
			List<LogowanieEntity> login = dbController.executeNamedQuery(LogowanieEntity.class, "LogowanieEntity.findByLogin", name);

			if (pesel != null) {
				if (password.equals(pesel.getHaslo())) {
					SessionData.setPracownik(pesel.getPracownicy());
					return true;
				}
			} else if (login.size() > 0) {
				if(password.equals(login.get(0).getHaslo())){
					SessionData.setPracownik(login.get(0).getPracownicy());
					return true;
				}
			}
		} catch (Exception e) {
			return false;
		}

		return false;
	}

}
