package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/17/13
 * Time: 3:14 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="ItemType")
public class ItemType implements Serializable {
     @Id
     @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_GEN")
     @SequenceGenerator(name="SEQ_GEN", sequenceName="ID_SEQ", allocationSize=1)
     @Column(name="ItemType_ID")
    private long itemTypeId;
     @Column(name="Name_ItemType")
    private String name;
    @Column(name="GentleObject_ItemType")
    private boolean gentleObject;
    @OneToMany(mappedBy="itemType")
    private List<Item> itemList;

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public long getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(long itemTypeId) {
        this.itemTypeId = itemTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGentleObject() {
        return gentleObject;
    }

    public void setGentleObject(boolean gentleObject) {
        this.gentleObject = gentleObject;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemType)) return false;

        ItemType itemType = (ItemType) o;

        if (gentleObject != itemType.gentleObject) return false;
        if (name != null ? !name.equals(itemType.name) : itemType.name != null) return false;

        return true;
    }

    @Override
    public final int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (gentleObject ? 1 : 0);
        return result;
    }
}
