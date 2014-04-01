package converters;

import daointerfaces.ClientDAOInterface;
import innerStrings.ProgramStrings;
import models.Client;

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
 * Date: 7/10/13
 * Time: 4:08 PM
 * To change this template use File | Settings | File Templates.
 */

@FacesConverter("ClientConverter")
public class ClientConverter implements Converter {


    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        long id = Long.parseLong(s);
          try {
           Context c = new InitialContext();

           String jndi = ProgramStrings.getProgramString("JNDIClientDAO");
           ClientDAOInterface<Client> dao =(ClientDAOInterface<Client>) c.lookup(jndi);
           Client result = dao.find(id);
           return result;
        } catch (NamingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
              return null;
        }

    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Client i = (Client) o;
        return String.valueOf(i.getClientId());
    }
}
