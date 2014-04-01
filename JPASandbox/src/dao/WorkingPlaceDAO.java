package dao;

import daointerfaces.WorkingPlaceDAOInterface;
import models.WorkingPlace;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/19/13
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */

@Path("/helloworld")
@Stateless
public class WorkingPlaceDAO extends EntityDAO<WorkingPlace> implements WorkingPlaceDAOInterface<WorkingPlace> {


    @Override
    public Class getEntityClass() {
        return WorkingPlace.class;
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findAll")
    public List<WorkingPlace> findAll(){
             return super.findAll();
    }
}
