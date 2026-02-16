package com.drd.backported.client.renderer.color;

public class DryFoliageColor {
    private static int[] pixels = new int[65536];

    public DryFoliageColor() {
    }

    public static void init(int[] is) {
        pixels = is;
    }

    public static int get(double d, double e) {
        e *= d;
        int i = (int)((1.0 - d) * 255.0);
        int j = (int)((1.0 - e) * 255.0);
        int k = j << 8 | i;
        return k >= pixels.length ? getDryColor() : pixels[k];
    }

    public static int getDryColor() {
        return 6044721;
    }
}
