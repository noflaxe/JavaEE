package dao;

import daointerfaces.EntryDAOInterface;
import models.Client;
import models.Entry;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/19/13
 * Time: 4:34 PM
 * To change this template use File | Settings | File Templates.
 */

@Path("/getEntries")
@Stateless
public class EntryDAO extends EntityDAO<Entry> implements EntryDAOInterface<Entry> {


    public EntryDAO(){

           }

    @Override
    public Class getEntityClass() {
        return Entry.class;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getJson")
    public List<Entry> getJson(){
        return super.findAll();
    }

    public List<Entry> findByStatus(String status){
        Query query = em.createNamedQuery("Entry.findByStatus",Entry.class);
        query.setParameter("status",status);
        List result =  query.getResultList();
        return result;
    }


    public List<Entry> findAll(int start,int end){
        Query query = em.createNamedQuery("Entry.findAllLazy",Entry.class);
        query.setMaxResults(end - start);
        query.setFirstResult(start);
        return query.getResultList();
    }

    @Override
    public long count() {
        Query query = em.createNamedQuery("Entry.count");
        return (Long) query.getSingleResult();
    }

    public long count(Client c){
        Query query = em.createNamedQuery("Entry.countClient");
        query.setParameter("clientId",c.getClientId());
        long result = (Long)query.getSingleResult();
        return result;
    }
}
