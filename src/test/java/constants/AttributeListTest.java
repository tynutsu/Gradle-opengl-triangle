package constants;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static constants.AttributeList.POSITIONS;
import static org.junit.Assert.assertTrue;

/**
 * Created by tynut on 12/09/2016.
 */
@RunWith(JUnit4.class)
public class AttributeListTest {

    @Test
    public void testAttributes() {
        assertTrue(POSITIONS == 0);
    }
}
