package daointerfaces;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 7/9/13
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 */

import models.Client;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ClientDAOInterface<T> extends EntityInterface<T> {
    public List<T> getByNameSurname(String name,String surname);
    public Client getByNameSurnameAddress(String name,String surname,String address);

}
