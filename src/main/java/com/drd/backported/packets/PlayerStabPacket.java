package com.drd.backported.packets;

import com.drd.backported.item.SpearItem;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class PlayerStabPacket {
    private final int playerId;

    public PlayerStabPacket(int playerId) {
        this.playerId = playerId;
    }

    public PlayerStabPacket(FriendlyByteBuf buffer) {
        this(buffer.readInt());
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeInt(this.playerId);
    }

    public void handle(Supplier<NetworkEvent.Context> context) {
        ((NetworkEvent.Context)context.get()).enqueueWork(() -> {
            ServerPlayer sp = ((NetworkEvent.Context)context.get()).getSender();
            if (sp != null && sp.getId() == this.playerId) {
                Item patt0$temp = sp.getMainHandItem().getItem();
                if (patt0$temp instanceof SpearItem) {
                    SpearItem s = (SpearItem)patt0$temp;
                    s.stab(sp, EquipmentSlot.MAINHAND);
                }

                sp.resetAttackStrengthTicker();
            }

        });
        ((NetworkEvent.Context)context.get()).setPacketHandled(true);
    }
}
