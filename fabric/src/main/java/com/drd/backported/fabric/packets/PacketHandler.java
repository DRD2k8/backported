package com.drd.backported.fabric.packets;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.networking.v1.FabricPacket;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.impl.networking.client.ClientNetworkingImpl;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ServerGamePacketListener;
import net.minecraft.resources.ResourceLocation;

import java.util.Objects;

@Environment(EnvType.CLIENT)
public final class PacketHandler {
    public static Packet<ServerGamePacketListener> createC2SPacket(ResourceLocation channelName, FriendlyByteBuf buf) {
        Objects.requireNonNull(channelName, "Channel name cannot be null");
        Objects.requireNonNull(buf, "Buf cannot be null");
        return ClientNetworkingImpl.createPlayC2SPacket(channelName, buf);
    }

    public static PacketSender getSender() throws IllegalStateException {
        if (Minecraft.getInstance().getConnection() != null) {
            return ClientNetworkingImpl.getAddon(Minecraft.getInstance().getConnection());
        } else {
            throw new IllegalStateException("Cannot get packet sender when not in game!");
        }
    }

    public static void send(ResourceLocation channelName, FriendlyByteBuf buf) throws IllegalStateException {
        if (Minecraft.getInstance().getConnection() != null) {
            Minecraft.getInstance().getConnection().send(createC2SPacket(channelName, buf));
        } else {
            throw new IllegalStateException("Cannot send packets when not in game!");
        }
    }

    public static <T extends FabricPacket> void send(T packet) {
        Objects.requireNonNull(packet, "Packet cannot be null");
        Objects.requireNonNull(packet.getType(), "Packet#getType cannot return null");
        FriendlyByteBuf buf = PacketByteBufs.create();
        packet.write(buf);
        send(packet.getType().getId(), buf);
    }

    private PacketHandler() {
    }
}
