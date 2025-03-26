package com.techtaste.payment_ms.model;

import java.util.Random;

public class GeneratorAuthorization {
    
    private static final Random random = new Random();

    public static boolean getRandomBoolean() {
        return random.nextBoolean();
    }
}
