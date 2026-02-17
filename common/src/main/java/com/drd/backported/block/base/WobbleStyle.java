package com.drd.backported.block.base;

public enum WobbleStyle {
    POSITIVE(7),
    NEGATIVE(10);

    public final int duration;

    WobbleStyle(int duration) {
        this.duration = duration;
    }
}
