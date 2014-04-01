package dao;

import daointerfaces.RoleDAOInterface;
import models.Role;

import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 * Created with IntelliJ IDEA.
 * User: noflaxe
 * Date: 20.07.13
 * Time: 12:50
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class RoleDAO extends EntityDAO<Role> implements RoleDAOInterface<Role>{
    @Override
    public Class getEntityClass() {
        return Role.class;
    }

    public Role findByLogin(String login){
        Query query = em.createNamedQuery("Role.findByAll",Role.class);
        query.setParameter("login",login);
        try{
            Role result =  (Role) query.getSingleResult();
            return result;
        } catch(javax.persistence.NoResultException e){       // Exception shows there is nothing in DB :\
            return null;
        }
    }
}
