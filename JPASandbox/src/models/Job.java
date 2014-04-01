package models;



import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/17/13
 * Time: 3:07 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="JOB")

public class Job implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
    @SequenceGenerator(name="SEQ_GEN", sequenceName="ID_SEQ", allocationSize=1)
    @Column(name= "Job_Id")
    private long jobId;
    @Column(name= "Position_Job")
    private String position;
    @Column(name= "Salary")
    private Integer salary;

    public long getJobId() {

        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;

        Job job = (Job) o;

        if (position != null ? !position.equals(job.position) : job.position != null) return false;

        return true;
    }

    @Override
    public final int hashCode() {
        return position != null ? position.hashCode() : 0;
    }
}
