import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

/**
 */
public class ExampleTestWithDelayedAsserts {


    @Rule
    public DelayedAssertRule delayedAssertRule = new DelayedAssertRule();

    private static final class DelayedAssertTrue implements DelayedAssert {
        private final boolean actualValue;
        private final String message;

        private DelayedAssertTrue(boolean actualValue, String s) {
            this.actualValue = actualValue;
            message = s;
        }

        @Override
        public DelayedAssertResult doAssertion() {
            try {
                Assert.assertTrue(actualValue);
                return DelayedAssertResult.createSucceed("Succeed");
            } catch (Throwable e) {
                return DelayedAssertResult.createFailed(e, message);
            }
        }
    }

    @Test
    public void testB() {
        delayedAssertRule.addDelayedAssert(new DelayedAssertTrue(false, "Must be true always"));
        Assert.assertFalse("You'll never rich this point", false);
    }
}
