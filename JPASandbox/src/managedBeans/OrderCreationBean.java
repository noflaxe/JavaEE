package managedBeans;

import daointerfaces.ClientDAOInterface;
import daointerfaces.EntryDAOInterface;
import daointerfaces.ItemTypeDAOInterface;
import models.Client;
import models.Entry;
import models.Item;
import models.ItemType;
import org.primefaces.event.FlowEvent;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 7/5/13
 * Time: 2:54 PM
 * To change this template use File | Settings | File Templates.
 */

@ManagedBean(name="orderBean")
@ViewScoped
public class OrderCreationBean {
private String name;
private String surname;
private String address;
private Client client;
private ItemType itemType;
private boolean urgent;
private boolean extra ;


    @EJB
    private ItemTypeDAOInterface<ItemType> dao;
    @EJB
    private ClientDAOInterface<Client> clientDao;
    @EJB
    private ItemTypeDAOInterface<Item> itemDao;
    @EJB
    private EntryDAOInterface<Entry> entryDao;

    private boolean skip = false;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public OrderCreationBean(boolean extra, boolean urgent, ItemType itemType, Client client, String address, String surname, String name) {
        this.extra = extra;
        this.urgent = urgent;
        this.itemType = itemType;
        this.client = client;
        this.address = address;
        this.surname = surname;
        this.name = name;
    }

    public OrderCreationBean() {
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
              this.client = client;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public boolean isExtra() {
        return extra;
    }

    public void setExtra(boolean extra) {
        this.extra = extra;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ItemType> getAllItemTypes(){
        List<ItemType> returned = dao.findAll();
        return returned;
    }

    public List<Client> getByNameSurname(){
        List<Client> result =  clientDao.getByNameSurname(name,surname);

        return result;
    }

    public void createClient(){
       Client existing = clientDao.getByNameSurnameAddress(name,surname,address);
       if(existing == null)        {
      Client client = new Client();
        client.setNameClient(name);
        client.setSurnameClient(surname);
        client.setAddress(address);
        clientDao.create(client);
           return;
       }


    }

    public void submitOrder(){

        BigDecimal price =  new BigDecimal("0");
        Calendar calendar = Calendar.getInstance();
        Entry entry = new Entry(urgent,extra,"Created",price,calendar,client);
      //  entry.setClient(client);
      //  entry.setStatus("Created");
      //  entry.setHardWork(extra);
      //  entry.setUrgentWork(urgent);
      //  entry.setTime(Calendar.getInstance());
        Item item = new Item(0,itemType,0,entry);
     //   item.setDifficulty(0);
      //  item.setEntry(entry);
      //  item.setItemType(itemType);
      //  item.setSpotNumber(0);
     //   entry.setPrice(new BigDecimal("0"));
      //  entryDao.create(entry);
         itemDao.create(item);
        }




    public String onFlowProcess(FlowEvent event) {

        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
}

