package com.minime.minime.domain;


public class UnixEpochExpiration {

    private long start;
    private long secondsToExpire;
    
    public UnixEpochExpiration(long secondsToExpire){
        this.secondsToExpire = secondsToExpire;
        this.start = getCurrentUnixTimestamp();
    }

    public long getCurrentUnixTimestamp() {
        return System.currentTimeMillis() / 1000;
    }

    public long calculateExpiration() {
        return this.start + secondsToExpire;
    }

    public long getTimeLeft() {
        return calculateExpiration() - getCurrentUnixTimestamp();
    }

    public long getStart() {
        return this.start;
    }

    public long getSecondsToExpire() {
        return this.secondsToExpire;
    }

}
