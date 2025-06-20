package dev.girnghuber.enums;

public enum Rotation {
    DEG_0(0),
    DEG_90(90),
    DEG_180(180),
    DEG_270(270);

    private final int degrees;
    Rotation(int deg) { this.degrees = deg; }
    public int getDegrees() { return degrees; }

    public Rotation rotateClockwise() {
        // Returns the next rotation in order: 0 -> 90 -> 180 -> 270 -> 0
        return values()[(this.ordinal() + 1) % 4];
    }
    public Rotation rotateCounterClockwise() {
        // Returns 0 <- 90 <- 180 <- 270 <- 0
        return values()[(this.ordinal() + 3) % 4];
    }
}
