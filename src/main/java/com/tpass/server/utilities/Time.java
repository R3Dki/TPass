package com.tpass.server.utilities;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.sql.Timestamp;

@Component
@RequiredArgsConstructor
public class Time {
    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    public static Timestamp addSecondsToCurrentTimestamp(Long seconds) {
        return new Timestamp(System.currentTimeMillis() + (seconds * 1000));
    }

    public static Timestamp addSecondsToTimestamp(Timestamp t, long seconds) {
        return Timestamp.from(t.toInstant().plusSeconds(seconds));
    }
}
