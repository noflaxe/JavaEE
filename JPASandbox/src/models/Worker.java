package models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/17/13
 * Time: 3:24 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="Worker")
@NamedQueries({
@NamedQuery(name="Worker.getByWorkingPlace",query="FROM Worker where workingPlace=:w")
})
public class Worker implements Serializable {
     @Id
     @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
     @SequenceGenerator(name="SEQ_GEN", sequenceName="ID_SEQ", allocationSize=1)
     @Column(name="Worker_id")
     private long workerId;
     @Column(name="Name_Worker")
     private String name;
     @Column(name="Surname")
     private String surname;
    @Column(name="Address")
    private String address;
     @ManyToOne
     @JoinColumn(name = "Job_id")
     private Job job;
     @ManyToOne
     @JoinColumn(name = "WorkingPlace_id")
      private WorkingPlace workingPlace;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ROLE_ID")
     private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public long getWorkerId() {
        return workerId;
    }

    public void setWorkerId(long workerId) {
        this.workerId = workerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public WorkingPlace getWorkingPlace() {
        return workingPlace;
    }

    public void setWorkingPlace(WorkingPlace workingPlace) {
        this.workingPlace = workingPlace;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;

        Worker worker = (Worker) o;

        if (address != null ? !address.equals(worker.address) : worker.address != null) return false;
        if (name != null ? !name.equals(worker.name) : worker.name != null) return false;
        if (surname != null ? !surname.equals(worker.surname) : worker.surname != null) return false;

        return true;
    }

    @Override
    public final int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
