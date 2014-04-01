package daointerfaces;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 7/9/13
 * Time: 4:59 PM
 * To change this template use File | Settings | File Templates.
 */

import models.Client;
import models.Entry;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface EntryDAOInterface<T> extends EntityInterface<T> {
   public List<Entry> findAll(int start,int end);
   public long count();
   public long count(Client c);
}
