package unittests;

import models.Client;
import models.Entry;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/21/13
 * Time: 5:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class EntryTest {
    Entry cl1,cl2,cl3,cl4,cl5,cl6;
    @Before
    public void setUp() throws Exception {
      Client c1 = new Client();
      c1.setNameClient("Bill");
      Client c2 = new Client();
      c2.setNameClient("John");
      Client c3 = new Client();
      c3.setNameClient("Steve");
      cl1 = new Entry();
      cl1.setHardWork(true);
      cl2 = new Entry();
      cl2.setClient(c1);
      cl3 = new Entry();
      cl3.setClient(c2);
      cl4 = new Entry();
      cl4.setClient(c3);
      cl5 = new Entry();
      cl5.setClient(c3);
      cl5.setPrice(new BigDecimal("300"));
      cl6 = new Entry();
      cl6.setPrice(new BigDecimal("300"));
      cl6.setHardWork(true);
      cl6.setClient(c3);
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
        EqualsVerifier.forClass(Entry.class).verify();
    }

}
