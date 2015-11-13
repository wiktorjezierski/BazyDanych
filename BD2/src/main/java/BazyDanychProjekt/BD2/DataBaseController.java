package BazyDanychProjekt.BD2;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 * Hello world!
 *
 */
public class DataBaseController 
{
    public static void main( String[] args )
    {
    	WypozyczeniaEntity wyp = new WypozyczeniaEntity();
        wyp.setIdEgzemplarza("7");
        wyp.setPeselKlienta("93101400538");
        wyp.setDataWyp(new Date(2015,10,10));
        wyp.setIdFaktury("100");
        wyp.setPeselPrac("00000000");
        wyp.setPeselKlienta("000005");

        //zapis
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BD2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(wyp);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
