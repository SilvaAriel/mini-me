package com.minime.minime;

import com.minime.minime.domain.MiniURL;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


class MiniURLTest {

    @Test
    void instantiate() {
        MiniURL url = new MiniURL();

        assertThat(url).isNotNull();

    }

    // @Test
    // void unixTimeStamp() {
    //     MiniURL url = new MiniURL();
    //     long timestamp = url.getUnixTimestamp();

    //     assertThat(timestamp).isLessThanOrEqualTo(System.currentTimeMillis() / 1000);

    // }

    
    // @Test
    // void calculateExpiration() {
    //     MiniURL url = mock(MiniURL.class);
    //     long expectedUnix = 100000000L;
    //     when(url.getUnixTimestamp()).thenReturn(expectedUnix);

    //     long expiration = url.calculateExpiration();
        
    //     assertThat(expiration).isEqualTo(expectedUnix + 0L);
    // }
    
    // @Test
    // void instantiateWithValues() {
    //     MiniURL url = new MiniURL(180);

    //     assertThat(url.getClickCount()).
    // }

}
