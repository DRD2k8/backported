package com.drd.backported.mixin;

import com.drd.backported.Backported;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin({ItemProperties.class})
public abstract class ItemPropertiesMixin {
    public ItemPropertiesMixin() {
    }

    @Shadow
    private static ClampedItemPropertyFunction m_174581_(ResourceLocation id, ClampedItemPropertyFunction provider) {
        return null;
    }

    static {
        m_174581_(ResourceLocation.tryBuild(Backported.MOD_ID, "in_gui"), (stack, world, entity, seed) -> {
            return stack.getEntityRepresentation() != null && stack.getFrame() == null ? 0.0F : 1.0F;
        });
    }
}
