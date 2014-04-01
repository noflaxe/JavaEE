package managedBeans;

import daointerfaces.RoleDAOInterface;
import models.Role;
import models.Worker;
import utility.UtilityMethods;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: noflaxe
 * Date: 20.07.13
 * Time: 18:18
 * To change this template use File | Settings | File Templates.
 */

@ManagedBean(name = "profile")
@ViewScoped
public class ProfileEditorBean {
  private String firstPwEntry;
  private String secondPwEntry;
  private String newPw;
    @EJB
  private RoleDAOInterface<Role> dao;

    public ProfileEditorBean() {
    }

    public String getFirstPwEntry() {
        return firstPwEntry;
    }

    public void setFirstPwEntry(String firstPwEntry) {
        this.firstPwEntry = firstPwEntry;
    }

    public String getSecondPwEntry() {
        return secondPwEntry;
    }

    public void setSecondPwEntry(String secondPwEntry) {
        this.secondPwEntry = secondPwEntry;
    }

    public String getNewPw() {
        return newPw;
    }

    public void setNewPw(String newPw) {
        this.newPw = newPw;
    }

    public void changePassword(Worker worker) throws NoSuchAlgorithmException {
        System.out.println("I AM CHANGING");
       String oldMD5Password = worker.getRole().getPassword();
       if(firstPwEntry.equals(secondPwEntry) == false){
           UtilityMethods.facesMessage("Passwords are not matching each other");
                                 return;
       }

       if(oldMD5Password.equals((firstPwEntry)) == false)    {
            UtilityMethods.facesMessage("Password is wrong");
                             return;
       }

        Role role = worker.getRole();
        role.setPassword(newPw);
        dao.update(role);


    }

}
