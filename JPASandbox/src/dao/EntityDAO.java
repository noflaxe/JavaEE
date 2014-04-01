package dao;

import daointerfaces.EntityInterface;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/19/13
 * Time: 2:32 PM
 * To change this template use File | Settings | File Templates.
 */


public abstract class EntityDAO<T> implements EntityInterface<T>{


    @PersistenceContext(unitName = "NewPersistenceUnit")
    protected EntityManager em;




    public void create(T t){
        em.persist(t);
        em.flush();
    }

    public T find(long id){
        T result =  (T) em.find(this.getEntityClass(),id);
        return result;


    }

    public List<T> findAll() {
        String q = "from " +  this.getEntityClass().getSimpleName();           //TODO replace String concatenation
        Query query = em.createQuery(q);
        List result =  query.getResultList();
        return result;


    }


    public void update(T t){
        em.merge(t);
    }

    public void delete(T t){
        if(t == null){
            return;
        }
        em.remove(em.merge(t));

    }

    public T findByMap(Map<String,Object> m){
        T result =  (T) em.find(this.getEntityClass(),m);
        return result;

    }

    public abstract Class getEntityClass();



}
