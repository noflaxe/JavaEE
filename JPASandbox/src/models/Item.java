package models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/17/13
 * Time: 3:17 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name="Item")
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
    @SequenceGenerator(name="SEQ_GEN", sequenceName="ID_SEQ", allocationSize=1)
    @Column(name="Item_id")
    private long ItemId;
    @Column(name="difficulty")
    private Integer difficulty;
    @Column(name="spot_number")
    private Integer spotNumber;
    @ManyToOne
    @JoinColumn(name="ItemType_Id")
    private ItemType itemType;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="Entry_Id")
    private Entry entry;

    public long getItemId() {
        return ItemId;
    }

    public Item() {
    }

    public Item(Integer difficulty, ItemType itemType, Integer spotNumber, Entry entry) {
        this.difficulty = difficulty;
        this.itemType = itemType;
        this.spotNumber = spotNumber;
        this.entry = entry;
    }

    public void setItemId(long itemId) {
        ItemId = itemId;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    public Integer getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(Integer spotNumber) {
        if(spotNumber < 0){
            spotNumber = 0;
        }
        this.spotNumber = spotNumber;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        if(difficulty < 0){
            difficulty = 0;

        }
        if(difficulty > 10){
            difficulty = 10;
        }
        this.difficulty = difficulty;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        Item item = (Item) o;

        if (entry != null ? !entry.equals(item.entry) : item.entry != null) return false;
        if (itemType != null ? !itemType.equals(item.itemType) : item.itemType != null) return false;

        return true;
    }

    @Override
    public final int hashCode() {
        int result = itemType != null ? itemType.hashCode() : 0;
        result = 31 * result + (entry != null ? entry.hashCode() : 0);
        return result;
    }
}
