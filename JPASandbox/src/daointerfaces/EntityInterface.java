package daointerfaces;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 7/9/13
 * Time: 4:54 PM
 * To change this template use File | Settings | File Templates.
 */


public interface EntityInterface<T> {
    public void create(T t);
    public T find(long id);
    public List<T> findAll();
    public void update(T t);
    public void delete(T t);
    public T findByMap(Map<String,Object> m);
    public abstract Class getEntityClass();

}
