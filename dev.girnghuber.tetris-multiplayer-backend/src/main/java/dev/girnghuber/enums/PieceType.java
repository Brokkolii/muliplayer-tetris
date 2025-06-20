package dev.girnghuber.enums;

import java.util.concurrent.ThreadLocalRandom;

public enum PieceType {
    I,
    O,
    T,
    S,
    Z,
    J,
    L;

    private static final PieceType[] VALUES = values();
    private static final int SIZE = VALUES.length;

    public static PieceType getRandom() {
        return VALUES[ThreadLocalRandom.current().nextInt(SIZE)];
    }
}
