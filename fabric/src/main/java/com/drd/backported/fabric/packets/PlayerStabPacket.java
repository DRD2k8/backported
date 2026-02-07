package com.drd.backported.fabric.packets;

import com.drd.backported.Backported;
import net.fabricmc.fabric.api.networking.v1.FabricPacket;
import net.fabricmc.fabric.api.networking.v1.PacketType;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public record PlayerStabPacket(int entityId) implements FabricPacket {
    public static final PacketType<PlayerStabPacket> TYPE = PacketType.create(new ResourceLocation(Backported.MOD_ID, "send_stab_attack_to_server"), PlayerStabPacket::new);

    public PlayerStabPacket(FriendlyByteBuf buf) {
        this(buf.readInt());
    }

    public PlayerStabPacket(int entityId) {
        this.entityId = entityId;
    }

    public void write(FriendlyByteBuf buf) {
        buf.writeInt(this.entityId());
    }

    public @Nullable Entity getEntity(Level world) {
        return world.getEntity(this.entityId);
    }

    public PacketType<?> getType() {
        return TYPE;
    }

    public int entityId() {
        return this.entityId;
    }
}
