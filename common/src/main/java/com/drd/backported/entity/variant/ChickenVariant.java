package com.drd.backported.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum ChickenVariant {
    TEMPERATE_CHICKEN(0),
    COLD_CHICKEN(1),
    WARM_CHICKEN(2);

    private static final ChickenVariant[] BY_ID = (ChickenVariant[]) Arrays.stream(values()).sorted(Comparator.comparingInt(ChickenVariant::getId)).toArray((x$0) -> {
        return new ChickenVariant[x$0];
    });
    private final int id;

    private ChickenVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static ChickenVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
