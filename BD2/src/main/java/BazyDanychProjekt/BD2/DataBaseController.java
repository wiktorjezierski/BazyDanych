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

		// List<WypozyczeniaEntity> lista =
		// db.findAll(WypozyczeniaEntity.class);
		// JOptionPane.showMessageDialog(null, lista.get(1).toString());

		List<WypozyczeniaEntity> lista = db.findByNamedQuery(WypozyczeniaEntity.class, "test2", 17);
		JOptionPane.showMessageDialog(null, lista.get(0).toString());

		// WypozyczeniaEntity wyp1 =
		// db.findByPrimaryKey(WypozyczeniaEntity.class, 17);
		// JOptionPane.showMessageDialog(null, wyp1.toString());
		db.closeConnection();
	}

	/**
	 * standard constructor
	 */
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
	 */
	public void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory(persistenceName);
		entityManager = entityManagerFactory.createEntityManager();
	}

	/**
	 * Close connection with database
	 */
	public void closeConnection() {
		entityManager.close();
		entityManagerFactory.close();
	}

	/**
	 * Open transaction for JPA entityManager
	 */
	private void commitTransaction() {
		entityManager.getTransaction().commit();
	}

	/**
	 * Close transaction for JPA entityManager
	 */
	private void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	/**
	 * Save object into Data Base, function is template
	 */
	public <T> boolean saveToDataBase(T param) {
		try {
			beginTransaction();
			entityManager.persist(param);
			commitTransaction();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Function search all rows in Table
	 * 
	 * @param <T>
	 */
	public <T> List<T> findAll(Class<T> type) {
		try {
			beginTransaction();
			Query query = entityManager.createQuery("from " + type.getSimpleName());
			List<T> result = (List<T>) query.getResultList();
			commitTransaction();

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Second param is int for class which id is type of int
	 * 
	 * @param <T>
	 */
	public <T> T findByPrimaryKey(Class<T> type, int primaryKey) {
		try {
			beginTransaction();
			T ob = (T) entityManager.find(type, primaryKey);
			commitTransaction();

			return ob;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Second param is String for class which id is type of String
	 * 
	 * @param <T>
	 */
	public <T> T findByPrimaryKey(Class<T> type, String primaryKey) {
		try {
			beginTransaction();
			T ob = (T) entityManager.find(type, primaryKey);
			commitTransaction();

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
			beginTransaction();
			entityManager.remove(obj);
			commitTransaction();

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Function execute query SQL Language PAY ATTENTION for * in SELECT,
	 * remember to make cast
	 */
	public List<?> executeQuery(String sql) {
		try {
			beginTransaction();
			Query query = entityManager.createQuery(sql);
			List<?> result = (List<?>) query.getResultList();
			commitTransaction();

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public <T> List<T> findByNamedQuery(Class<T> type, String queryName, String... value) {
		try {
			beginTransaction();
			Query query = entityManager.createNamedQuery(queryName);
			for (int i = 0; i < value.length; i++) {
				query.setParameter(i + 1, value[i]);
			}
			List<T> result = (List<T>) query.getResultList();
			commitTransaction();

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	public <T> List<T> findByNamedQuery(Class<T> type, String queryName, int... value) {
		try {
			beginTransaction();
			Query query = entityManager.createNamedQuery(queryName);
			for (int i = 0; i < value.length; i++) {
				query.setParameter(i + 1, value[i]);
			}
			List<T> result = (List<T>) query.getResultList();
			commitTransaction();

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
