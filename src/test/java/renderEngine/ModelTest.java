package renderEngine;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertTrue;

/**
 * Created by tynut on 12/09/2016.
 */

@RunWith(JUnit4.class)
public class ModelTest {
    private Model toCheck;

    @Test
    public void testModelConstructor() {
        int expectedVao = 1;
        int expectedTotalVertices = 33;
        toCheck = new Model(expectedVao, expectedTotalVertices);

        // test constructor and getter
        int obtainedVao = toCheck.getVao();
        int obtainedTotalVertices = toCheck.getTotalVertices();

        assertTrue(expectedVao == obtainedVao);
        assertTrue(expectedTotalVertices == obtainedTotalVertices);

        // test setter
        expectedVao = 5;
        expectedVao = 66;
        toCheck.setVao(expectedVao);
        toCheck.setTotalVertices(expectedTotalVertices);

        assertTrue(expectedVao == toCheck.getVao());
        assertTrue(expectedTotalVertices == toCheck.getTotalVertices());
    }
}
