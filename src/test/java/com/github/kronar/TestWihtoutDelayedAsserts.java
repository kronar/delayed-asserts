package com.github.kronar;

import org.junit.Assert;
import org.junit.Test;

import java.util.logging.Logger;

/**
 */
public class TestWihtoutDelayedAsserts {

    private static final Logger LOGGER = Logger.getLogger(TestWihtoutDelayedAsserts.class.getName());
    @Test
    public void testA(){
        Assert.assertTrue(false);
        LOGGER.info("You're here");
        Assert.assertFalse("You'll never rich this point",false);

    }
}
