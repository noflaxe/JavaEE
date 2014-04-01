package daointerfaces;

import javax.ejb.Local;

/**
 * Created with IntelliJ IDEA.
 * User: noflaxe
 * Date: 20.07.13
 * Time: 12:50
 * To change this template use File | Settings | File Templates.
 */

@Local
public interface RoleDAOInterface<T> extends EntityInterface<T> {

    public T findByLogin(String login);
}
