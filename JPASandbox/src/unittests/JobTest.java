package unittests;

import models.Job;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/21/13
 * Time: 4:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class JobTest {
    Job cl1,cl2,cl3,cl4,cl5,cl6;

    @Before
    public void setUp() throws Exception {
        cl1 = new Job();
        cl1.setPosition("Junior");
        cl2 = new Job();
        cl2.setPosition("Middle");
        cl3 = new Job();
        cl3.setPosition("Senior");
        cl4 = new Job();
        cl4.setPosition("Intern");
        cl5 = new Job();
        cl5.setPosition("Intern");
        cl5.setSalary(200);
        cl6 = new Job();
        cl6.setPosition("Intern");
        cl6.setSalary(400);

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
        EqualsVerifier.forClass(Job.class).verify();
    }
}
