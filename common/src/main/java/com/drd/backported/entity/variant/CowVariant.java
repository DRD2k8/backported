package com.drd.backported.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum CowVariant {
    TEMPERATE_COW(0),
    COLD_COW(1),
    WARM_COW(2);

    private static final CowVariant[] BY_ID = (CowVariant[]) Arrays.stream(values()).sorted(Comparator.comparingInt(CowVariant::getId)).toArray((x$0) -> {
        return new CowVariant[x$0];
    });
    private final int id;

    private CowVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static CowVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
