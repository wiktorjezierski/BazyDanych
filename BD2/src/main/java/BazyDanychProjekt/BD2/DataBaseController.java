package BazyDanychProjekt.BD2;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 * @author Wiktor Jezierski
 */
public class DataBaseController {
	
	private final String persistenceName = "BD2";
	
	public static void main(String[] args) {
		WypozyczeniaEntity wyp = new WypozyczeniaEntity();
		wyp.setIdEgzemplarza("7");
		wyp.setPeselKlienta("93101400538");
		wyp.setDataWyp(new Date(2015, 10, 10));
		wyp.setIdFaktury("100");
		wyp.setPeselPrac("00000000");
		wyp.setPeselKlienta("000010");

		// zapis
		// EntityManagerFactory entityManagerFactory =
		// Persistence.createEntityManagerFactory("BD2");
		// EntityManager entityManager =
		// entityManagerFactory.createEntityManager();
		// entityManager.getTransaction().begin();
		// entityManager.persist(wyp);
		// entityManager.getTransaction().commit();
		// entityManager.close();
		// entityManagerFactory.close();

		DataBaseController db = new DataBaseController();
		// db.saveToDataBase(wyp);
		List<WypozyczeniaEntity> lista = (List<WypozyczeniaEntity>)db.findAll(WypozyczeniaEntity.class);
		JOptionPane.showMessageDialog(null, lista.get(1).toString());
//		WypozyczeniaEntity wyp1 = (WypozyczeniaEntity) db.findByPrimaryKey(WypozyczeniaEntity.class, 1);
//		JOptionPane.showMessageDialog(null, wyp1.toString());
	}

	/**
	 * Save object into Data Base, function is template
	 */
	public <T> boolean saveToDataBase(T param) {
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceName);
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			
			entityManager.persist(param);
			
			entityManager.getTransaction().commit();
			entityManager.close();
			entityManagerFactory.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 * */
	public List<?> findAll(Class type) {
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceName);
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();

			Object ob = type.newInstance();
			Query query = entityManager.createQuery("from " + ob.getClass().getSimpleName());
			List<?> result = (List<?>) query.getResultList();
			
			entityManager.getTransaction().commit();
			entityManager.close();
			entityManagerFactory.close();
			return result;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Second param is int for class which id is type of int
	 */
	public Object findByPrimaryKey(Class type, int primaryKey) {
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceName);
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();

			Object ob = type.newInstance();
			ob = entityManager.find(type, primaryKey);

			entityManager.getTransaction().commit();
			entityManager.close();
			entityManagerFactory.close();
			return ob;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Second param is String for class which id is type of String
	 */
	public Object findByPrimaryKey(Class type, String primaryKey) {
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceName);
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();

			Object ob = type.newInstance();
			ob = entityManager.find(type, primaryKey);

			entityManager.getTransaction().commit();
			entityManager.close();
			entityManagerFactory.close();
			return ob;
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Function remove record from database
	 * make tests!!!
	 * */
	public <T> boolean remove(T obj){
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceName);
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			
			entityManager.remove(obj);
			
			entityManager.getTransaction().commit();
			entityManager.close();
			entityManagerFactory.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}			
		return true;
		
	}
	
}
