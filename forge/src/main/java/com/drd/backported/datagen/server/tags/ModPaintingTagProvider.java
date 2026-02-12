package com.drd.backported.datagen.server.tags;

import com.drd.backported.Backported;
import com.drd.backported.init.ModPaintings;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModPaintingTagProvider extends PaintingVariantTagsProvider {
    public ModPaintingTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Backported.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(PaintingVariantTags.PLACEABLE)
                .add(ModPaintings.MEDITATIVE.getKey())
                .add(ModPaintings.PRAIRIE_RIDE.getKey())
                .add(ModPaintings.BAROQUE.getKey())
                .add(ModPaintings.HUMBLE.getKey())
                .add(ModPaintings.UNPACKED.getKey())
                .add(ModPaintings.BOUQUET.getKey())
                .add(ModPaintings.CAVEBIRD.getKey())
                .add(ModPaintings.COTAN.getKey())
                .add(ModPaintings.ENDBOSS.getKey())
                .add(ModPaintings.FERN.getKey())
                .add(ModPaintings.OWLEMONS.getKey())
                .add(ModPaintings.SUNFLOWERS.getKey())
                .add(ModPaintings.TIDES.getKey())
                .add(ModPaintings.BACKYARD.getKey())
                .add(ModPaintings.POND.getKey())
                .add(ModPaintings.CHANGING.getKey())
                .add(ModPaintings.FINDING.getKey())
                .add(ModPaintings.LOWMIST.getKey())
                .add(ModPaintings.PASSAGE.getKey())
                .add(ModPaintings.ORB.getKey())
                .add(ModPaintings.DENNIS.getKey());
    }
}
