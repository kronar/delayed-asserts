package com.github.kronar;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.MultipleFailureException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 */
public class DelayedAssertRule extends TestWatcher {

    private static final Logger LOGGER = Logger.getLogger(DelayedAssertRule.class.getName());

    private List<DelayedAssertResult> delayed = new ArrayList<DelayedAssertResult>();

    public void addDelayedAssert(DelayedAssert da) {
        if (da == null) {
            throw new IllegalArgumentException("Null is not permitted");
        }
        delayed.add(da.doAssertion());
    }


    private void fireDelayedAsserts() {
        List<Throwable> failures = new ArrayList<>();
        List<String> errorMsgs = new ArrayList<String>();
        for (DelayedAssertResult dar : delayed) {
            if (!dar.isSuccess()) {
                failures.add(dar.getError());
                errorMsgs.add(dar.getMesssage());
            } else {
                LOGGER.info("Delayed assert succeed");
            }
        }

        if (!failures.isEmpty()) {
            MultipleFailureException multipleFailureException = new MultipleFailureException(failures);
            throw new IllegalStateException("Delayed asserts failed :"+errorMsgs, multipleFailureException);
        }

    }

    @Override
    protected void succeeded(Description description) {
        fireDelayedAsserts();
    }

    @Override
    protected void failed(Throwable e, Description description) {
        fireDelayedAsserts();
    }
}
