package converters;

import daointerfaces.ItemTypeDAOInterface;
import innerStrings.ProgramStrings;
import models.ItemType;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 7/5/13
 * Time: 4:11 PM
 * To change this template use File | Settings | File Templates.
 */

@FacesConverter("ItemTypeConverter")
public class itemTypeConverter implements Converter {


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        long id = Long.parseLong(s);
            try {
            Context  c = new InitialContext();
                String jndi = ProgramStrings.getProgramString("JNDIItemTypeDAO");
            ItemTypeDAOInterface<ItemType> dao =(ItemTypeDAOInterface<ItemType>) c.lookup(jndi);
            ItemType result = dao.find(id);
            return result;
        } catch (NamingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                return null;
        }

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        ItemType i = (ItemType) o;
        return String.valueOf(i.getItemTypeId());
        //TODO: Make getAsString return name value instead of ID
    }
}
