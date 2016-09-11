package ApplicationMain;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by tynut on 10/09/2016.
 */

@RunWith(JUnit4.class)
public class TestApplicationMain {

    @Test
    public void test() {
        Assert.assertTrue(ApplicationMain.sayHello().equals("Hello"));
    }
}


