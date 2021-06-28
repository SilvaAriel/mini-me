package com.minime.minime.domain;

import java.net.URL;

public class MiniURL{

    private URL url;
    private UnixEpochExpiration expiration;
    private long clickCount;

    
    public MiniURL(URL url, UnixEpochExpiration expiration) {
        this.url = url;
        this.expiration = expiration;
        this.clickCount = 0;
    }
    
    public URL getUrl() {
        return this.url;
    }
    
    public void setUrl(URL url) {
        this.url = url;
    }
    
    public UnixEpochExpiration getExpiration() {
        return this.expiration;
    }
    
    public void setExpiration(UnixEpochExpiration expiration) {
        this.expiration = expiration;
    }
    
    public long getClickCount() {
        return this.clickCount;
    }
    
}
