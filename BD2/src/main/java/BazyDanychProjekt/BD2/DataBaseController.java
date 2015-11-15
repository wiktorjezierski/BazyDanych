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

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public static void main(String[] args) {
		WypozyczeniaEntity wyp = new WypozyczeniaEntity();
		wyp.setId(18);
		wyp.setIdEgzemplarza("7");
		wyp.setPeselKlienta("93101400538");
		wyp.setDataWyp(new Date(2015, 10, 10));
		wyp.setIdFaktury("100");
		wyp.setPeselPrac("00000000");
		wyp.setPeselKlienta("000011");

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
		// db.remove(wyp);

		// List<WypozyczeniaEntity> lista = (List<WypozyczeniaEntity>)
		// db.findAll(WypozyczeniaEntity.class);
		// JOptionPane.showMessageDialog(null, lista.get(1).toString());

		WypozyczeniaEntity wyp1 = (WypozyczeniaEntity) db.findByPrimaryKey(WypozyczeniaEntity.class, 18);
		// JOptionPane.showMessageDialog(null, wyp1.toString());
		db.closeConnection();
	}

	/**
	 * standard constructor
	 * */
	public DataBaseController() {
		entityManagerFactory = Persistence.createEntityManagerFactory(persistenceName);
		entityManager = entityManagerFactory.createEntityManager();
	}

	/**
	 * 
	 * */
	@Override
	protected void finalize() throws Exception {
		entityManager.close();
		entityManagerFactory.close();
	}

	/**
	 * Open connection with database
	 * */
	public void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory(persistenceName);
		entityManager = entityManagerFactory.createEntityManager();
	}

	/**
	 * Close connection with database
	 * */
	public void closeConnection() {
		entityManager.close();
		entityManagerFactory.close();
	}

	/**
	 * Save object into Data Base, function is template
	 */
	public <T> boolean saveToDataBase(T param) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(param);
			entityManager.getTransaction().commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Function search all rows in Table
	 * */
	public List<?> findAll(Class type) {
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery("from " + type.getSimpleName());
			List<?> result = (List<?>) query.getResultList();
			entityManager.getTransaction().commit();

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Second param is int for class which id is type of int
	 */
	public Object findByPrimaryKey(Class type, int primaryKey) {
		try {
			entityManager.getTransaction().begin();
			Object ob = entityManager.find(type, primaryKey);
			entityManager.getTransaction().commit();

			return ob;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Second param is String for class which id is type of String
	 */
	public Object findByPrimaryKey(Class type, String primaryKey) {
		try {
			entityManager.getTransaction().begin();
			Object ob = entityManager.find(type, primaryKey);
			entityManager.getTransaction().commit();

			return ob;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Function remove record from database make tests!!!
	 */
	public <T> boolean remove(T obj) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(obj);
			entityManager.getTransaction().commit();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Function execute query SQL Languager
	 * PAY ATTENTION for * in SELECT
	 * */
	public List<?> executeQuery(String sql) {
		try {
			entityManager.getTransaction().begin();
			Query query = entityManager.createQuery(sql);
			List<?> result = (List<?>) query.getResultList();
			entityManager.getTransaction().commit();

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
