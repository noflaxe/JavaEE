package converters;

import daointerfaces.EntryDAOInterface;
import innerStrings.ProgramStrings;
import models.Entry;

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
 * Date: 7/12/13
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */

@FacesConverter("EntryConverter")
public class EntryConverter implements Converter {


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        long id = Long.parseLong(s);
        try {
            Context c = new InitialContext();
            String jndi = ProgramStrings.getProgramString("JNDIEntryDAO");
            EntryDAOInterface<Entry> dao =(EntryDAOInterface<Entry>) c.lookup(jndi);
            Entry result = dao.find(id);
            return result;
        } catch (NamingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Entry i = (Entry) o;
        return String.valueOf(i.getEntryId());
    }
}
