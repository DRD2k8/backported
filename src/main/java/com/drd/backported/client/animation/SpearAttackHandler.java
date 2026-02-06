package com.drd.backported.client.animation;

import com.drd.backported.Backported;
import com.drd.backported.item.SpearItem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Backported.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class SpearAttackHandler {
    @SubscribeEvent
    public static void onAttackEntity(AttackEntityEvent event) {
        Player player = event.getEntity();

        ItemStack stack = player.getMainHandItem();
        if (stack.getItem() instanceof SpearItem) {
            player.getPersistentData().putInt("spear_jab_ticks", 5);
        }
    }

    @SubscribeEvent
    public static void onLeftClickEmpty(InputEvent.InteractionKeyMappingTriggered event) {
        if (!event.isAttack()) return;

        Player player = Minecraft.getInstance().player;
        if (player == null) return;

        ItemStack stack = player.getMainHandItem();
        if (stack.getItem() instanceof SpearItem) {
            player.getPersistentData().putInt("spear_jab_ticks", 5);
        }
    }
}
