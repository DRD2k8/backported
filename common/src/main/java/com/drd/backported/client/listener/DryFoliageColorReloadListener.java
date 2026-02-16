package com.drd.backported.client.listener;

import com.drd.backported.client.renderer.color.DryFoliageColor;
import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

public class DryFoliageColorReloadListener extends SimplePreparableReloadListener<int[]> {
    @Override
    protected int[] prepare(ResourceManager manager, ProfilerFiller profiler) {
        ResourceLocation loc = new ResourceLocation("textures/colormap/foliage.png");
        Optional<Resource> opt = manager.getResource(loc);
        if (opt.isEmpty()) {
            return new int[65536];
        }

        Resource resource = opt.get();

        try (InputStream stream = resource.open()) {
            NativeImage img = NativeImage.read(stream);

            int[] pixels = new int[65536];
            for (int y = 0; y < 256; y++) {
                for (int x = 0; x < 256; x++) {
                    pixels[y * 256 + x] = img.getPixelRGBA(x, y);
                }
            }

            return pixels;

        } catch (IOException e) {
            return new int[65536];
        }
    }

    @Override
    protected void apply(int[] pixels, ResourceManager manager, ProfilerFiller profiler) {
        DryFoliageColor.init(pixels);
    }
}
