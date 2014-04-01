package unittests;

import models.ItemType;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/21/13
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class ItemTypeTest {
    ItemType cl1,cl2,cl3,cl4,cl5,cl6;

    @Before
    public void setUp() throws Exception {
     cl1 = new ItemType();
     cl1.setName("Shoe");
     cl1.setGentleObject(true);
     cl2 = new ItemType();
     cl2.setName("Hat");
     cl3 = new ItemType();
     cl3.setName("Scarf");
     cl4 = new ItemType();
     cl4.setName("Gloves");
     cl4.setGentleObject(true);
     cl5 = new ItemType();
     cl5.setName("Gloves");
     cl5.setGentleObject(true);
     cl6 = new ItemType();
     cl6.setName("Gloves");
     cl6.setGentleObject(true);

    }

    @Test
    public void testNotEquals(){
        boolean real = cl1.equals(cl4);
        boolean expected = false;
        assertEquals(expected,real);

    }

    @Test
    public void testEquals_Reflexivity(){
        boolean real = cl3.equals(cl3);
        boolean expected = true;
        assertEquals(expected,real);

    }

    @Test
    public void testEquals_Symmetry_True(){
        boolean real = cl4.equals(cl5) && cl5.equals(cl4);
        boolean expected = true;
        assertEquals(expected,real);

    }

    @Test
    public void testEquals_Symmetry_False(){
        boolean real = cl4.equals(cl3) || cl5.equals(cl3);
        boolean expected = false;
        assertEquals(expected,real);

    }

    @Test
    public void testEquals_Transitivity_True(){
        boolean real = cl4.equals(cl5) && cl5.equals(cl6) && cl4.equals(cl6);
        boolean expected = true;
        assertEquals(expected,real);

    }

    @Test
    public void testEquals_Transitivity_False(){
        boolean real = cl4.equals(cl2) || cl2.equals(cl1) || cl4.equals(cl1);
        boolean expected = false;
        assertEquals(expected,real);


    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(ItemType.class).verify();
    }
}
