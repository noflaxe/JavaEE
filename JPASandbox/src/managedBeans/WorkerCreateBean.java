package managedBeans;

import daointerfaces.RoleDAOInterface;
import daointerfaces.WorkerDAOInterface;
import models.Role;
import models.Worker;
import org.primefaces.event.RowEditEvent;
import utility.UtilityMethods;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: noflaxe
 * Date: 21.07.13
 * Time: 13:29
 * To change this template use File | Settings | File Templates.
 */

@ManagedBean(name="workerEdit")
@ViewScoped
public class WorkerCreateBean {
    @EJB
    private WorkerDAOInterface<Worker> dao;
    @EJB
    private RoleDAOInterface<Role> roleDao;
    private List<Worker> workers;
    private Worker newWorker;
    private String passwordSecondTime;


    public Worker getNewWorker() {
        return newWorker;
    }

    public void setNewWorker(Worker newWorker) {
        this.newWorker = newWorker;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

      @PostConstruct
      public void init(){
      workers = dao.findAll();
      newWorker = new Worker();
      Role r = new Role();
      newWorker.setRole(r);

      }

    public String getPasswordSecondTime() {
        return passwordSecondTime;
    }

    public void setPasswordSecondTime(String passwordSecondTime) {
        this.passwordSecondTime = passwordSecondTime;
    }

    public void  createWorker() throws NoSuchAlgorithmException {
               if(workers.contains(newWorker)){
                   UtilityMethods.facesMessage("Worker already exists");
                       return;
        }
        if(newWorker.getRole().getPassword().equals(passwordSecondTime) == false){
            UtilityMethods.facesMessage("Passwords do not match");
            return;
        }
        newWorker.getRole().setRole("worker");
        dao.create(newWorker);
    }

    public void onEdit(RowEditEvent event) {
        UtilityMethods.facesMessage("Worker edited");
        dao.update((Worker) event.getObject());
    }

    public void onCancel(RowEditEvent event) {
        UtilityMethods.facesMessage("Edit cancelled");
    }

    public void delete(Worker worker){
        Role r = worker.getRole();
        dao.delete(worker);
        roleDao.delete(r);
    }


}

