package DataBase;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by user on 2015-11-11.
 */
public class DataBaseController {

    public static void main(String[] args) {

        WypozyczeniaEntity wyp = new WypozyczeniaEntity();
        wyp.setIdEgzemplarza("7");
        wyp.setPeselKlienta("93101400538");
        wyp.setDataWyp(new Date(2015,10,15));
        wyp.setIdFaktury("100");
        wyp.setPeselPrac("93101400538");
        wyp.setPeselKlienta("941313");

        //zapis
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("select id from LogEntity");
        List<LogEntity> result = (List<LogEntity>) query.getResultList();
        entityManager.getTransaction().commit();

        JOptionPane.showMessageDialog(null, result.size());
    }
}
