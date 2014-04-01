package converters;

import daointerfaces.JobDAOInterface;
import innerStrings.ProgramStrings;
import models.Job;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created with IntelliJ IDEA.
 * User: noflaxe
 * Date: 21.07.13
 * Time: 23:39
 * To change this template use File | Settings | File Templates.
 */
@FacesConverter("PositionConverter")
public class PositionConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        long id = Long.parseLong(s);
        try {
            Context c = new InitialContext();
            String jndi = ProgramStrings.getProgramString("JNDIJobDAO");
            JobDAOInterface<Job> dao =( JobDAOInterface<Job>) c.lookup(jndi);
            Job result = dao.find(id);
            return result;
        } catch (NamingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        Job i = (Job) o;
        return String.valueOf(i.getJobId());
    }
}
