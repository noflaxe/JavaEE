package daointerfaces;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 7/9/13
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
import models.Worker;
import models.WorkingPlace;

import javax.ejb.Local;
import java.util.List;

@Local
public interface WorkerDAOInterface<T> extends EntityInterface<T> {

    public List<Worker> getByWorkingPlace(WorkingPlace w);
}
