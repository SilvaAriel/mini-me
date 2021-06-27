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
    void correctTimeLeft() {

        long secondsToExpire = 5L;
        long expectedTimeLeft = 4L;

        UnixEpochExpiration mockExpiration = mock(UnixEpochExpiration.class);
        mockExpiration.
        // UnixEpochExpiration exp = new UnixEpochExpiration(secondsToExpire);
        when(mockExpiration.getCurrentUnixTimestamp()).thenReturn(100L);
        when(mockExpiration.calculateExpiration()).thenReturn(104L);
        long timeLeft = mockExpiration.getTimeLeft();
        
        assertThat(timeLeft).isCloseTo(expectedTimeLeft, byLessThan(1l));
        System.out.println("");

    }

    @Test
    void whenExpired_then(){

    }

}
