package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/17/13
 * Time: 3:11 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="WorkingPlace")
public class WorkingPlace implements Serializable {
   @Id
   @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
   @SequenceGenerator(name="SEQ_GEN", sequenceName="ID_SEQ", allocationSize=1)
   @Column(name="WorkingPlace_id")
    private long  workingPlaceId;
    @Column(name="Address_WorkingPlace")
    private String address;
    @Column(name="WorkerCapacity_WorkingPlace")
    private int capacity;




    public long getWorkingPlaceId() {
        return workingPlaceId;
    }

    public void setWorkingPlaceId(long workingPlaceId) {
        this.workingPlaceId = workingPlaceId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkingPlace)) return false;

        WorkingPlace that = (WorkingPlace) o;

        if (address != null ? !address.equals(that.address) : that.address != null) return false;

        return true;
    }

    @Override
    public final int hashCode() {
        return address != null ? address.hashCode() : 0;
    }
}
