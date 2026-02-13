package com.drd.backported.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum PigVariant {
    TEMPERATE_PIG(0),
    COLD_PIG(1),
    WARM_PIG(2);

    private static final PigVariant[] BY_ID = (PigVariant[]) Arrays.stream(values()).sorted(Comparator.comparingInt(PigVariant::getId)).toArray((x$0) -> {
        return new PigVariant[x$0];
    });
    private final int id;

    private PigVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static PigVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
