package com.drd.backported.item;

import com.drd.backported.Backported;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;

public class TrimmedSmithingTemplateItem extends Item {
    private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private final Component upgradeDescription;

    public TrimmedSmithingTemplateItem(Properties properties, String name) {
        super(properties);
        this.upgradeDescription = Component.translatable("trim_pattern." + Backported.MOD_ID + "." + name).withStyle(TITLE_FORMAT);
    }
}
