package com.minime.minime.domain;


public class UnixEpochExpiration {

    private long start;
    private long secondsToExpire;
    
    public UnixEpochExpiration(long secondsToExpire){
        this.start = getCurrentUnixTimestamp();
        this.secondsToExpire = secondsToExpire;
    }

    public long getCurrentUnixTimestamp() {
        return System.currentTimeMillis() / 1000;
    }

    public long calculateExpiration() {
        return this.start + this.secondsToExpire;
    }

    public long getTimeLeft() {
        long timeLeft = calculateExpiration() - getCurrentUnixTimestamp();
        if (timeLeft > 0) {
            return timeLeft;
        }
        return -1;
    }

    public long getStart() {
        return this.start;
    }

    public long getSecondsToExpire() {
        return this.secondsToExpire;
    }

}
