package com.minime.minime;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.minime.minime.domain.UnixEpochExpiration;
import org.junit.jupiter.api.Test;

public class ExpirationTest {

    @Test
    void instantiate() {
        UnixEpochExpiration exp = new UnixEpochExpiration(180L);

        assertThat(exp).isNotNull();
    }

    @Test
    void instantiateWithSecondsToExpire() {
        long secondsToExpire = 180L;
        UnixEpochExpiration exp = new UnixEpochExpiration(180L);

        assertThat(exp.getSecondsToExpire()).isEqualTo(secondsToExpire);
        assertThat(exp.getStart()).isGreaterThanOrEqualTo(System.currentTimeMillis()/1000);

    }

    @Test
    void correctExpirationTime() {
        long secondsToExpire = 180L;
        UnixEpochExpiration exp = new UnixEpochExpiration(secondsToExpire);
        long expiration = exp.calculateExpiration();

        assertThat(expiration).isCloseTo((System.currentTimeMillis()/1000) + 180L, byLessThan(1l));
    }

    @Test
    void whenExpired_thenGetTimeLeftReturnMinusOne(){

        UnixEpochExpiration exp = mock(UnixEpochExpiration.class);
        when(exp.calculateExpiration()).thenReturn(1000L);
        when(exp.getCurrentUnixTimestamp()).thenReturn(1010L);
        when(exp.getTimeLeft()).thenCallRealMethod();

        assertThat(exp.getTimeLeft()).isEqualTo(-1L);

    }

}
