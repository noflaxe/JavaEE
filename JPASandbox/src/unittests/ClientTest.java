package unittests;


import models.Client;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ClientTest {

    Client cl1,cl2,cl3,cl4,cl5,cl6;

    @Before
   public void setUp() throws Exception{
     cl1 = new Client();
     cl1.setNameClient("Tom");
     cl1.setSurnameClient("Brave");
     cl1.setAddress("stalingrada ave 33");
      cl2 = new Client();
     cl2.setNameClient("Barbara");
     cl2.setSurnameClient("Brave");
     cl2.setAddress("stalingrada ave 33");
      cl3 = new Client();
     cl3.setNameClient("Barbara");
     cl3.setSurnameClient("Smite");
     cl3.setAddress("stalingrada ave 34");
      cl4 = new Client();
     cl4.setNameClient("Barbara");
     cl4.setSurnameClient("Smite");
     cl4.setAddress("stalingrada ave 35");
      cl5 = new Client();
     cl5.setNameClient("Barbara");
     cl5.setSurnameClient("Smite");
     cl5.setAddress("stalingrada ave 35");
      cl6 = new Client();
     cl6.setNameClient("Barbara");
     cl6.setSurnameClient("Smite");
     cl6.setAddress("stalingrada ave 35");
 }

    @Test
    public void testNotEquals(){
        boolean real = cl1.equals(cl4);
        boolean expected = false;
        assertEquals(expected,real);

    }
   @Test
    public void testNotEquals_SameSurname() {
        boolean real = cl1.equals(cl2);
        boolean expected = false;
        assertEquals(expected,real);
    }
   @Test
    public void testNotEquals_SameName() {
        boolean real = cl2.equals(cl3);
        boolean expected = false;
        assertEquals(expected,real);
    }

    @Test
    public void testNotEquals_SameNameSurname() {
        boolean real = cl3.equals(cl4);
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
        EqualsVerifier.forClass(Client.class).verify();
    }
}


