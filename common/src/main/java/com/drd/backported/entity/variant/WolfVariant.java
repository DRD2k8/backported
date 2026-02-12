package com.drd.backported.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum WolfVariant {
    PALE_WOLF(0),
    WOODS_WOLF(1),
    ASHEN_WOLF(2),
    BLACK_WOLF(3),
    CHESTNUT_WOLF(4),
    RUSTY_WOLF(5),
    SPOTTED_WOLF(6),
    STRIPED_WOLF(7),
    SNOWY_WOLF(8);

    private static final WolfVariant[] BY_ID = (WolfVariant[]) Arrays.stream(values()).sorted(Comparator.comparingInt(WolfVariant::getId)).toArray((x$0) -> {
        return new WolfVariant[x$0];
    });
    private final int id;

    private WolfVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static WolfVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
