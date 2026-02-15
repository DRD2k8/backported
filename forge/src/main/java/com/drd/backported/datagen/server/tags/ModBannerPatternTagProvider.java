package com.drd.backported.datagen.server.tags;

import com.drd.backported.Backported;
import com.drd.backported.init.ModBannerPatterns;
import com.drd.backported.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BannerPatternTagsProvider;
import net.minecraft.world.level.block.entity.BannerPatterns;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBannerPatternTagProvider extends BannerPatternTagsProvider {
    public ModBannerPatternTagProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(arg, lookupProvider, Backported.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.BannerPatterns.FLOW_BANNER_PATTERN)
                .add(ModBannerPatterns.FLOW.getKey());
        this.tag(ModTags.BannerPatterns.GUSTER_BANNER_PATTERN)
                .add(ModBannerPatterns.GUSTER.getKey());
        this.tag(ModTags.BannerPatterns.BORDURE_INDENTED_BANNER_PATTERN)
                .add(BannerPatterns.CURLY_BORDER);
        this.tag(ModTags.BannerPatterns.FIELD_MASONED_BANNER_PATTERN)
                .add(BannerPatterns.BRICKS);
    }
}
