package models;


import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;


/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/17/13
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="Entry")
@NamedQueries({
@NamedQuery(name="Entry.findByStatus",query = "FROM Entry WHERE status =:status")   ,
@NamedQuery(name="Entry.findAllLazy",query="FROM Entry")    ,
@NamedQuery(name="Entry.count",query="SELECT count(*) from Entry") ,
@NamedQuery(name="Entry.countClient",query="SELECT COUNT(*) from Entry where client.clientId =:clientId")
})
public class Entry implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
    @SequenceGenerator(name="SEQ_GEN", sequenceName="ID_SEQ", allocationSize=1)
    @Column(name="Entry_id")
    private long entryId;
    @Column(name="urgent_work")
    private boolean urgentWork;
    @Column(name="hard_work")
    private boolean hardWork;
    @Column(name="Status")
    private String status;
    @Column(name="Price")
    private BigDecimal price;
    @Temporal(value=TemporalType.DATE)
    @Column(name="Time")
    private Calendar Time;
    @ManyToOne
    @JoinColumn(name = "Worker_id")
    private Worker worker;
    @ManyToOne
    @JoinColumn(name = "Client_id")
    private Client client;
    @OneToOne(mappedBy = "entry")
    private Item item;

    public Item getItem() {
        return item;
    }

    public Entry() {
    }


    public Entry(boolean urgentWork, boolean hardWork, String status, BigDecimal price, Calendar time, Client client) {
        this.urgentWork = urgentWork;
        this.hardWork = hardWork;
        this.status = status;
        this.price = price;
        Time = time;
        this.client = client;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public long getEntryId() {
        return entryId;
    }

    public void setEntryId(long entryId) {
        this.entryId = entryId;
    }

    public boolean isUrgentWork() {
        return urgentWork;
    }

    public void setUrgentWork(boolean urgentWork) {
        this.urgentWork = urgentWork;
    }

    public boolean isHardWork() {
        return hardWork;
    }

    public void setHardWork(boolean hardWork) {
        this.hardWork = hardWork;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Calendar getTime() {
        return Time;
    }

    public void setTime(Calendar time) {
        Time = time;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;

        Entry entry = (Entry) o;

        if (client != null ? !client.equals(entry.client) : entry.client != null) return false;
        if (worker != null ? !worker.equals(entry.worker) : entry.worker != null) return false;

        return true;
    }

    @Override
    public final int hashCode() {
        int result = worker != null ? worker.hashCode() : 0;
        result = 31 * result + (client != null ? client.hashCode() : 0);
        return result;
    }
}
