package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/21/13
 * Time: 4:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class EntityManagerController {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewPersistenceUnit",new HashMap());

    public static EntityManager getEntityManager(){
         EntityManager em = emf.createEntityManager();
        return em;

    }
    private EntityManagerController(){


    }
}
