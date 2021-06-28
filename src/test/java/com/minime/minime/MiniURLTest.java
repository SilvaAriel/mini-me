package com.minime.minime;

import com.minime.minime.domain.MiniURL;
import com.minime.minime.domain.UnixEpochExpiration;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;


class MiniURLTest {

    @Test
    void instantiateWithAttributes() {
        MiniURL url;
        try {
            url = new MiniURL(new URL("http://www.google.com.br"), new UnixEpochExpiration(10L));
            assertThat(url.getExpiration()).isNotNull();
            assertThat(url.getUrl()).isNotNull();
            assertThat(url.getClickCount()).isNotNull();
        } catch (MalformedURLException e) {}
    }

}
