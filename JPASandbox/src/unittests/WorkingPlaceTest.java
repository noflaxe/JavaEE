package unittests;

import models.WorkingPlace;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/21/13
 * Time: 4:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class WorkingPlaceTest {
    WorkingPlace cl1,cl2,cl3,cl4,cl5,cl6;

    @Before
    public void setUp() throws Exception {
        cl1 = new WorkingPlace();
        cl1.setAddress("Kiev");
        cl2 = new WorkingPlace();
        cl2.setAddress("London");
        cl3 = new WorkingPlace();
        cl3.setAddress("Libiya");
        cl4 = new WorkingPlace();
        cl4.setAddress("Lisabon");
        cl5 = new WorkingPlace();
        cl5.setAddress("Lisabon");
        cl5.setCapacity(5);
        cl6 = new WorkingPlace();
        cl6.setAddress("Lisabon");
        cl6.setCapacity(10);
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
        EqualsVerifier.forClass(WorkingPlace.class).verify();
    }
}
