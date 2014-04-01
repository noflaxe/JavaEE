package dao;

import daointerfaces.JobDAOInterface;
import models.Job;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/19/13
 * Time: 4:41 PM
 * To change this template use File | Settings | File Templates.
 */

@WebService
@Stateless

public class JobDAO extends EntityDAO<Job> implements JobDAOInterface<Job>{

    @WebMethod
    @Override
    public List<Job> findAll(){
      return super.findAll();
    }

    @Override
    public Class getEntityClass() {
        return Job.class;
    }
}
