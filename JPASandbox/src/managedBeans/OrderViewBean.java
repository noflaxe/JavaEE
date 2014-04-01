package managedBeans;

import daointerfaces.EntryDAOInterface;
import daointerfaces.ItemDAOInterface;
import models.Client;
import models.Entry;
import models.Item;
import utility.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;


/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 7/8/13
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(name="orderView")
@ViewScoped
public class OrderViewBean implements Serializable {

    @EJB
    private transient EntryDAOInterface<Entry> e;
    @EJB
    private transient ItemDAOInterface<Item> i;
    private EntryDataModel allEntries;
    private Entry selectedEntry;
    private transient SelectItem[] options;
    private int discount;
    private int spotNumber;
    private int difficulty;

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public Entry getSelectedEntry() {
        return selectedEntry;
    }

    public void setSelectedEntry(Entry selectedEntry) {
        this.selectedEntry = selectedEntry;
        setDiscount(selectedEntry);
    }

    private void setDiscount(Entry entry){
         Client c = entry.getClient();
        long orderNumber =  e.count(c);
         if(orderNumber > 3 ){
             discount = 3;
         }
        if(orderNumber > 5){
            discount = 5;
        }
    }

    public EntryDAOInterface<Entry> getE() {

        return e;
    }

    public void setE(EntryDAOInterface<Entry> e) {
        this.e = e;
    }

    public SelectItem[] getOptions() {
        return options;
    }



    public void setOptions(SelectItem[] options) {
        this.options = options;
    }


    public OrderViewBean(SelectItem[] options, Entry selectedEntry, EntryDataModel allEntries) {
        this.options = options;
        this.selectedEntry = selectedEntry;
        this.allEntries = allEntries;
    }

    public EntryDataModel getAllEntries() {
        return allEntries;
    }

    public void setAllEntries(EntryDataModel allEntries) {
        this.allEntries = allEntries;
    }

    public OrderViewBean(){

    }


    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    private SelectItem[] createFilterOptions(String[] data)  {
        SelectItem[] options = new SelectItem[data.length + 1];

        options[0] = new SelectItem("", "Select");
        for(int i = 0; i < data.length; i++) {
            options[i + 1] = new SelectItem(data[i], data[i]);
        }

        return options;
    }
    public void update(Entry entry){
        System.out.println("It updated!!");
        entry.setStatus("Done");
        e.update(entry);
        i.update(entry.getItem());

    }

    @PostConstruct
    public void init(){
        String[] temp = new String[]{"Done","Created","Invalid"};
        options = createFilterOptions(temp);
        allEntries = new EntryDataModel(new LinkedList<Entry>());
        selectedEntry = e.findAll(1,2).get(0);
    }


    public void calculate(Entry entry){
        discount = 0;
        setDiscount(entry);

        entry.getItem().setDifficulty(difficulty);
        entry.getItem().setSpotNumber(spotNumber);
        long price = 50;
        Item item = entry.getItem();
        price = price + 10*item.getSpotNumber()*item.getDifficulty();
        if(entry.isHardWork())   {
        price = price*14/10;      }
        if(entry.isUrgentWork())  {
        price = price*15/10;
        }

        BigDecimal finalPrice = BigDecimal.valueOf(price/100.0);
        finalPrice.setScale(2, RoundingMode.HALF_UP);
      //  finalPrice.setScale(7);
        entry.setPrice(finalPrice);


             }

    public void delete(Entry entry){
        i.delete(entry.getItem());
       e.delete(entry);
    }
    }




