package BazyDanychProjekt.BD2;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import com.mysql.jdbc.log.Log;


/**
 * @author Wiktor Jezierski
 */
public class DataBaseController {

	private final String persistenceName = "BD2";

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String[] args) {
		DataBaseController db = new DataBaseController();
		// db.remove(wyp);

		// List<WypozyczeniaEntity> lista =
		// db.findAll(WypozyczeniaEntity.class);
		// JOptionPane.showMessageDialog(null, lista.get(1).toString());

//		List<WypozyczeniaEntity> lista = db.findByNamedQuery(WypozyczeniaEntity.class, "test2", 17);
//		JOptionPane.showMessageDialog(null, lista.get(0).toString());

		// WypozyczeniaEntity wyp1 =
		// db.findByPrimaryKey(WypozyczeniaEntity.class, 17);
		// JOptionPane.showMessageDialog(null, wyp1.toString());
		
		List<WypozyczeniaEntity> list =  db.findAll(WypozyczeniaEntity.class);
		JOptionPane.showMessageDialog(null, list.get(0).toString());
		
		List<KlienciEntity> lista = db.executeNamedQueryForLike(KlienciEntity.class, "znajdzPoNazwisku", "P");
		JOptionPane.showMessageDialog(null, lista.size());
		db.closeConnection(); 
	}

	/**
	 * standard constructor
	 */
	public DataBaseController() {
		if (entityManagerFactory == null || entityManager == null) {
			Map<String, String> properties = new HashMap<String, String>();
			properties.put("javax.persistence.jdbc.user", "stuntman_wiktor");
			properties.put("javax.persistence.jdbc.password", "baza1234");			
			entityManagerFactory = Persistence.createEntityManagerFactory(persistenceName, properties);
			entityManager = entityManagerFactory.createEntityManager();			
		}
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
	 * Close actually connection and open new with new parameters
	 * */
	public void reconnect(String username, String password){
		Map<String, String> properties = new HashMap<String, String>();
		properties.put("javax.persistence.jdbc.user", username);
		properties.put("javax.persistence.jdbc.password", password);			
		entityManagerFactory = Persistence.createEntityManagerFactory(persistenceName, properties);
		entityManager = entityManagerFactory.createEntityManager();	
	}

	/**
	 * Open transaction for JPA entityManager
	 */
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}

	/**
	 * Close transaction for JPA entityManager
	 */
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	/**
	 * Save object into Data Base, function is template
	 */
	public <T> boolean saveToDataBase(T param) throws Exception {
	/*	try {*/
			beginTransaction();
			entityManager.persist(param);
			commitTransaction();

			return true;
	/*	} catch (Exception e) {
			e.printStackTrace();
			return false;
		}*/
	}
	
	/**
	 * Save object into Data Base, function is template
	 * Must to use function beginTransaction() before and commitTransaction() after this function
	 * function to using in loop
	 */
	public <T> boolean saveMoreToDataBase(T param) {
		try {
			entityManager.persist(param);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
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
	 * Execute NamedQuery with char % before and after value in Like
	 * */
	public <T> List<T> executeNamedQueryForLike(Class<T> type, String queryName, String... value) {
		try {
			String x = "%"; 
			
			beginTransaction();
			Query query = entityManager.createNamedQuery(queryName);
			for (int i = 0; i < value.length; i++) {
				query.setParameter(i + 1, x+value[i]+x);
			}
			List<T> result = (List<T>) query.getResultList();
			commitTransaction();

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * 
	 * */
	public <T> List<T> executeNamedQuery(Class<T> type, String queryName, String... value) {
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
	
	/**
	 * 
	 * */
	public <T> List<T> executeNamedQuery(Class<T> type, String queryName, int... value) {
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
	
	/**
	 * was not tested
	 * */
	public <T> List<T> executeNamedQuery(Class<T> type, String queryName, Date... value) {
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

}
