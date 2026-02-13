package com.drd.backported.forge.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;

public record WeightedEntry(Item item, int count, int weight) {
    public static final Codec<WeightedEntry> CODEC = RecordCodecBuilder.create(inst ->
            inst.group(
                    ForgeRegistries.ITEMS.getCodec().fieldOf("item").forGetter(WeightedEntry::item),
                    Codec.INT.fieldOf("count").forGetter(WeightedEntry::count),
                    Codec.INT.fieldOf("weight").forGetter(WeightedEntry::weight)
            ).apply(inst, WeightedEntry::new)
    );
}
