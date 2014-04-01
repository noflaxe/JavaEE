package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/17/13
 * Time: 2:59 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="Client")
@NamedQueries({
@NamedQuery(name="Client.getByNameSurname", query="FROM Client WHERE nameClient=:name AND surnameClient=:surname") ,
@NamedQuery(name="Client.getByNameSurnameAdress", query="FROM Client WHERE nameClient=:name AND surnameClient=:surname AND address=:address"),

})
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
    @SequenceGenerator(name="SEQ_GEN", sequenceName="ID_SEQ", allocationSize=1)
    @Column(name="Client_id")
    private long clientId;
    @Column(name="Name_Client")
    private String nameClient;
    @Column(name="Surname_client")
    private String surnameClient;
    @Column(name="Address")
    private String address;
    @OneToMany(mappedBy="client")
    private List<Entry> entries;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Entry> getEntries() {
        return entries;
    }

    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }


    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getSurnameClient() {
        return surnameClient;
    }

    public void setSurnameClient(String surnameClient) {
        this.surnameClient = surnameClient;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (address != null ? !address.equals(client.address) : client.address != null) return false;
        if (nameClient != null ? !nameClient.equals(client.nameClient) : client.nameClient != null) return false;
        if (surnameClient != null ? !surnameClient.equals(client.surnameClient) : client.surnameClient != null)
            return false;

        return true;
    }

    @Override
    public final int hashCode() {
        int result = nameClient != null ? nameClient.hashCode() : 0;
        result = 31 * result + (surnameClient != null ? surnameClient.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
