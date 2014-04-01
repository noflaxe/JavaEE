package dao;

import daointerfaces.ClientDAOInterface;
import models.Client;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/19/13
 * Time: 4:33 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class ClientDAO extends EntityDAO<Client> implements ClientDAOInterface<Client> {

    public ClientDAO(){}


    @Override
    public Class getEntityClass() {
        return Client.class;
    }

    public List<Client> getByNameSurname(String nameClient,String surnameClient){
        Query query = em.createNamedQuery("Client.getByNameSurname", Client.class);
        query.setParameter("name",nameClient);
        query.setParameter("surname",surnameClient);
        List result =  query.getResultList();
        return result;

    }



      public Client getByNameSurnameAddress(String nameClient,String surnameClient,String address){
        Query query = em.createNamedQuery("Client.getByNameSurnameAdress",Client.class);
        query.setParameter("name",nameClient);
        query.setParameter("surname",surnameClient);
        query.setParameter("address",address);
          try{
        Client result =  (Client) query.getSingleResult();
              return result;
          } catch(javax.persistence.NoResultException e){       // Exception shows there is nothing in DB :\
                return null;
                     }


    }
}
