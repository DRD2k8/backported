package com.drd.backported.mixin;

import com.drd.backported.Backported;
import net.minecraft.client.renderer.entity.WolfRenderer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Wolf;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WolfRenderer.class)
public class WolfRendererMixin {
    private static final ResourceLocation WILD_PALE_TEXTURE = new ResourceLocation("textures/entity/wolf/wolf.png");
    private static final ResourceLocation TAMED_PALE_TEXTURE = new ResourceLocation("textures/entity/wolf/wolf_tame.png");
    private static final ResourceLocation ANGRY_PALE_TEXTURE = new ResourceLocation("textures/entity/wolf/wolf_angry.png");
    private static final ResourceLocation WILD_ASHEN_TEXTURE = registerWildWolfTexture("ashen");
    private static final ResourceLocation TAMED_ASHEN_TEXTURE = registerTamedWolfTexture("ashen");
    private static final ResourceLocation ANGRY_ASHEN_TEXTURE = registerAngryWolfTexture("ashen");
    private static final ResourceLocation WILD_BLACK_TEXTURE = registerWildWolfTexture("black");
    private static final ResourceLocation TAMED_BLACK_TEXTURE = registerTamedWolfTexture("black");
    private static final ResourceLocation ANGRY_BLACK_TEXTURE = registerAngryWolfTexture("black");
    private static final ResourceLocation WILD_CHESTNUT_TEXTURE = registerWildWolfTexture("chestnut");
    private static final ResourceLocation TAMED_CHESTNUT_TEXTURE = registerTamedWolfTexture("chestnut");
    private static final ResourceLocation ANGRY_CHESTNUT_TEXTURE = registerAngryWolfTexture("chestnut");
    private static final ResourceLocation WILD_RUSTY_TEXTURE = registerWildWolfTexture("rusty");
    private static final ResourceLocation TAMED_RUSTY_TEXTURE = registerTamedWolfTexture("rusty");
    private static final ResourceLocation ANGRY_RUSTY_TEXTURE = registerAngryWolfTexture("rusty");
    private static final ResourceLocation WILD_SNOWY_TEXTURE = registerWildWolfTexture("snowy");
    private static final ResourceLocation TAMED_SNOWY_TEXTURE = registerTamedWolfTexture("snowy");
    private static final ResourceLocation ANGRY_SNOWY_TEXTURE = registerAngryWolfTexture("snowy");
    private static final ResourceLocation WILD_SPOTTED_TEXTURE = registerWildWolfTexture("spotted");
    private static final ResourceLocation TAMED_SPOTTED_TEXTURE = registerTamedWolfTexture("spotted");
    private static final ResourceLocation ANGRY_SPOTTED_TEXTURE = registerAngryWolfTexture("spotted");
    private static final ResourceLocation WILD_STRIPED_TEXTURE = registerWildWolfTexture("striped");
    private static final ResourceLocation TAMED_STRIPED_TEXTURE = registerTamedWolfTexture("striped");
    private static final ResourceLocation ANGRY_STRIPED_TEXTURE = registerAngryWolfTexture("striped");
    private static final ResourceLocation WILD_WOODS_TEXTURE = registerWildWolfTexture("woods");
    private static final ResourceLocation TAMED_WOODS_TEXTURE = registerTamedWolfTexture("woods");
    private static final ResourceLocation ANGRY_WOODS_TEXTURE = registerAngryWolfTexture("woods");

    private static ResourceLocation registerWildWolfTexture(String variant) {
        return new ResourceLocation(Backported.MOD_ID, "textures/entity/wolf/wolf_" + variant + ".png");
    }

    private static ResourceLocation registerTamedWolfTexture(String variant) {
        return new ResourceLocation(Backported.MOD_ID, "textures/entity/wolf/wolf_" + variant + "_tame.png");
    }

    private static ResourceLocation registerAngryWolfTexture(String variant) {
        return new ResourceLocation(Backported.MOD_ID, "textures/entity/wolf/wolf_" + variant + "_angry.png");
    }

    public WolfRendererMixin() {
    }

    @Inject(
            method = {"getTextureLocation(Lnet/minecraft/world/entity/animal/Wolf;)Lnet/minecraft/resources/ResourceLocation;"},
            at = {@At("HEAD")},
            cancellable = true
    )
    public void getWolfTexture(Wolf wolfEntity, CallbackInfoReturnable<ResourceLocation> cir) {
        CompoundTag compound = new CompoundTag();
        wolfEntity.addAdditionalSaveData(compound);
        if (compound.contains("Variant")) {
            int wolfVariant = compound.getInt("Variant");
            ResourceLocation customTexture = this.getCustomTextureForVariant(wolfVariant, wolfEntity);
            cir.setReturnValue(customTexture);
        }

    }

    private ResourceLocation getCustomTextureForVariant(int variant, Wolf wolfEntity) {
        ResourceLocation var10000;
        ResourceLocation texture;
        if (wolfEntity.isTame()) {
            switch (variant) {
                case 1 -> var10000 = TAMED_WOODS_TEXTURE;
                case 2 -> var10000 = TAMED_ASHEN_TEXTURE;
                case 3 -> var10000 = TAMED_BLACK_TEXTURE;
                case 4 -> var10000 = TAMED_CHESTNUT_TEXTURE;
                case 5 -> var10000 = TAMED_RUSTY_TEXTURE;
                case 6 -> var10000 = TAMED_SPOTTED_TEXTURE;
                case 7 -> var10000 = TAMED_STRIPED_TEXTURE;
                case 8 -> var10000 = TAMED_SNOWY_TEXTURE;
                default -> var10000 = TAMED_PALE_TEXTURE;
            }

            texture = var10000;
        } else if (wolfEntity.getRemainingPersistentAngerTime() > 0) {
            switch (variant) {
                case 1 -> var10000 = ANGRY_WOODS_TEXTURE;
                case 2 -> var10000 = ANGRY_ASHEN_TEXTURE;
                case 3 -> var10000 = ANGRY_BLACK_TEXTURE;
                case 4 -> var10000 = ANGRY_CHESTNUT_TEXTURE;
                case 5 -> var10000 = ANGRY_RUSTY_TEXTURE;
                case 6 -> var10000 = ANGRY_SPOTTED_TEXTURE;
                case 7 -> var10000 = ANGRY_STRIPED_TEXTURE;
                case 8 -> var10000 = ANGRY_SNOWY_TEXTURE;
                default -> var10000 = ANGRY_PALE_TEXTURE;
            }

            texture = var10000;
        } else {
            switch (variant) {
                case 1 -> var10000 = WILD_WOODS_TEXTURE;
                case 2 -> var10000 = WILD_ASHEN_TEXTURE;
                case 3 -> var10000 = WILD_BLACK_TEXTURE;
                case 4 -> var10000 = WILD_CHESTNUT_TEXTURE;
                case 5 -> var10000 = WILD_RUSTY_TEXTURE;
                case 6 -> var10000 = WILD_SPOTTED_TEXTURE;
                case 7 -> var10000 = WILD_STRIPED_TEXTURE;
                case 8 -> var10000 = WILD_SNOWY_TEXTURE;
                default -> var10000 = WILD_PALE_TEXTURE;
            }

            texture = var10000;
        }

        return texture;
    }
}
