package io.ravi.systemdesign.ratelimiting;

public interface RateLimiter {
    boolean allow(String request);
}
