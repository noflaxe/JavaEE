package unittests;

import models.Item;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/21/13
 * Time: 5:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class ItemTest {


    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Item.class).verify();
    }
}
