package com.github.kronar;

/**
 */
public class DelayedAssertResult {

    private final String messsage;
    private boolean success;
    private Throwable error;

    private DelayedAssertResult(boolean success, Throwable error, String message) {
        this.success = success;
        this.error = error;
        this.messsage = message;
    }

    public static DelayedAssertResult createSucceed(String message) {
        return new DelayedAssertResult(true, null, message);
    }

    public static DelayedAssertResult createFailed(Throwable t, String message) {
        return new DelayedAssertResult(false, t, message);
    }

    public String getMesssage() {
        return messsage;
    }

    public boolean isSuccess() {
        return success;
    }

    public Throwable getError() {
        return error;
    }
}
