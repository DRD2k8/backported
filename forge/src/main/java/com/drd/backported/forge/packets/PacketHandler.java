package com.drd.backported.forge.packets;

import com.drd.backported.Backported;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class PacketHandler {
    public static SimpleChannel INSTANCE;

    public static void init() {
        INSTANCE = NetworkRegistry.ChannelBuilder
                .named(ResourceLocation.fromNamespaceAndPath(Backported.MOD_ID, "send_stab_attack_to_server"))
                .networkProtocolVersion(() -> "1")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE.messageBuilder(PlayerStabPacket.class, 0, NetworkDirection.PLAY_TO_SERVER)
                .encoder(PlayerStabPacket::encode)
                .decoder(PlayerStabPacket::new)
                .consumerMainThread(PlayerStabPacket::handle)
                .add();
    }

    public static void sendToServer(Object msg) {
        INSTANCE.send(PacketDistributor.SERVER.noArg(), msg);
    }
}
