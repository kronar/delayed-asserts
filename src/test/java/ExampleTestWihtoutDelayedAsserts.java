import org.junit.Assert;
import org.junit.Test;

/**
 */
public class ExampleTestWihtoutDelayedAsserts {

    @Test
    public void testA(){
        Assert.assertTrue(false);
        Assert.assertFalse("You'll never rich this point",false);
    }
}
