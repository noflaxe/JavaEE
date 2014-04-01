package dao;

import daointerfaces.ItemTypeDAOInterface;
import models.ItemType;

import javax.ejb.Stateless;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/19/13
 * Time: 4:41 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class ItemTypeDAO extends EntityDAO<ItemType> implements ItemTypeDAOInterface<ItemType> {


    @Override
    public Class getEntityClass() {
        return ItemType.class;
    }
}
