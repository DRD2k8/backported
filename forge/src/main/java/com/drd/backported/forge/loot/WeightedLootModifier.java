package com.drd.backported.forge.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;

import java.util.List;

public class WeightedLootModifier extends LootModifier {
    public static final Codec<WeightedLootModifier> CODEC = RecordCodecBuilder.create(inst ->
            codecStart(inst).and(
                    WeightedEntry.CODEC.listOf().fieldOf("entries").forGetter(m -> m.entries)
            ).apply(inst, WeightedLootModifier::new)
    );

    private final List<WeightedEntry> entries;

    public WeightedLootModifier(LootItemCondition[] conditions, List<WeightedEntry> entries) {
        super(conditions);
        this.entries = entries;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {

        int totalWeight = entries.stream().mapToInt(WeightedEntry::weight).sum();
        int roll = context.getRandom().nextInt(totalWeight);

        for (WeightedEntry entry : entries) {
            roll -= entry.weight();
            if (roll < 0) {
                generatedLoot.add(new ItemStack(entry.item(), entry.count()));
                break;
            }
        }

        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
