package me.serumdev.particles.utils;

public class RGB {

    private final float red;
    private final float green;
    private final float blue;

    public RGB(float red, float green, float blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public float getRed() {
        return red;
    }

    public float getGreen() {
        return green;
    }

    public float getBlue() {
        return blue;
    }

    public float getColor(float value) {
        if (value <= 0.0F)
            value = -1.0F;
        return value / 255.0F;
    }
}
