package dao;

import daointerfaces.ItemDAOInterface;
import models.Item;

import javax.ejb.Stateless;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/19/13
 * Time: 4:40 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class ItemDAO extends EntityDAO<Item> implements ItemDAOInterface<Item>{


    @Override
    public Class getEntityClass() {
        return Item.class;
    }
}
