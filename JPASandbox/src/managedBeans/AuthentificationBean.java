package managedBeans;

import daointerfaces.RoleDAOInterface;
import daointerfaces.WorkerDAOInterface;
import models.Role;
import models.Worker;
import utility.UtilityMethods;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mykola_Turunov
 * Date: 7/18/13
 * Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name = "login")
@SessionScoped
public class AuthentificationBean implements Serializable {



    private String name;
    private String password;
    private Boolean isLogged = Boolean.FALSE;
    private Worker worker;
    @EJB
    private RoleDAOInterface<Role> dao;
    @EJB
    private WorkerDAOInterface<Worker> workerDao;

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password)   {
        this.password = password;
           }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthentificationBean(String password, String name) {
        this.password = password;
        this.name = name;
    }

    public AuthentificationBean(){}

    public String login() {

        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ec.getRequest();
                  System.out.println("I am logging in :(");

        try {
              //       password = UtilityMethods.md5(password);



                request.login(name, password);
                Role role = dao.findByLogin(name);
                worker = role.getWorker();
                isLogged = true;
               if(role.getRole().equals("worker")){
                       return "OrderList";
               }
            System.out.println("admin case");
                   return "admin";
        } catch (ServletException e1) {
            UtilityMethods.facesMessage("Authentification has failed");
           UtilityMethods.logSevere(e1);
            System.out.println("error case");
            return "error";
        }
    }


    public String logout() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ((HttpSession) ec.getSession(false)).invalidate();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            isLogged = false;
            worker = null;
            return "logout";

    }



     public List<Worker> getWorkingWith(){
       List<Worker> result = workerDao.getByWorkingPlace(worker.getWorkingPlace());
        result.remove(worker);
         return result;
    }


}
