package com.drd.backported.forge.packets;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class PacketHandler {
    private static final SimpleChannel INSTANCE = NetworkRegistry.ChannelBuilder.named(ResourceLocation.tryBuild("spears", "send_stab_attack_to_server")).clientAcceptedVersions((s) -> {
        return true;
    }).serverAcceptedVersions((s) -> {
        return true;
    }).networkProtocolVersion(() -> {
        return "1";
    }).simpleChannel();

    public PacketHandler() {
    }

    public static void register() {
        INSTANCE.messageBuilder(PlayerStabPacket.class, NetworkDirection.PLAY_TO_SERVER.ordinal()).encoder(PlayerStabPacket::encode).decoder(PlayerStabPacket::new).consumerMainThread(PlayerStabPacket::handle).add();
    }

    public static void sendToServer(Object msg) {
        INSTANCE.send(PacketDistributor.SERVER.noArg(), msg);
    }
}
