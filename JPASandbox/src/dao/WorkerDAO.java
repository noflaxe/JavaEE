package dao;

import daointerfaces.WorkerDAOInterface;
import models.Worker;
import models.WorkingPlace;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/19/13
 * Time: 4:42 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class WorkerDAO extends EntityDAO<Worker> implements WorkerDAOInterface<Worker>{



    @Override
    public Class getEntityClass() {
        return Worker.class;
    }

    @Override
    public List<Worker> getByWorkingPlace(WorkingPlace w) {
        Query query = em.createNamedQuery("Worker.getByWorkingPlace",Worker.class);
        query.setParameter("w",w);
        List result =  query.getResultList();
        return result;
    }
}
