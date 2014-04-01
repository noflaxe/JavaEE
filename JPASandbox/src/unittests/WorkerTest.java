package unittests;

import models.Worker;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Nazar_Sheremeta
 * Date: 6/21/13
 * Time: 6:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class WorkerTest {

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Worker.class).verify();
    }
}
