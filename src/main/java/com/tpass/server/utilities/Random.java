package com.tpass.server.utilities;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
@RequiredArgsConstructor
public class Random {
    private static final SecureRandom rng = new SecureRandom();

    public static Integer generateVariableLengthCode(int length) {
        return (10 ^ length) + rng.nextInt((10 ^ (length + 1)) - (10 ^ length) + 1);
    }

    public static Integer generateAuthCode() {
        return 99999 + rng.nextInt((1000000 - 100000));
    }
}