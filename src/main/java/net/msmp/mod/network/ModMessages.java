package net.msmp.mod.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

import net.msmp.mod.MsmpMod;
import net.msmp.mod.networking.packet.ThirstDataSyncS2CPacket;

public class ModMessages {
    private static SimpleChannel INSTANCE;

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        SimpleChannel net = NetworkRegistry.ChannelBuilder
                .named(ResourceLocation.fromNamespaceAndPath(MsmpMod.MOD_ID, "messages"))
                .networkProtocolVersion(() -> "1.0")
                .clientAcceptedVersions(s -> true)
                .serverAcceptedVersions(s -> true)
                .simpleChannel();

        INSTANCE = net;

        net.messageBuilder(ThirstDataSyncS2CPacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(ThirstDataSyncS2CPacket::new)
                .encoder(ThirstDataSyncS2CPacket::toBytes)
                .consumerMainThread(ThirstDataSyncS2CPacket::handle)
                .add();

        net.messageBuilder(BubbleMessagePacket.class, id(), NetworkDirection.PLAY_TO_CLIENT)
                .decoder(BubbleMessagePacket::new)
                .encoder(BubbleMessagePacket::toBytes)
                .consumerMainThread(BubbleMessagePacket::handle)
                .add();
        net.messageBuilder(UpdateColorPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(UpdateColorPacket::new)
                .encoder(UpdateColorPacket::toBytes)
                .consumerMainThread(UpdateColorPacket::handle)
                .add();
            } // Fim do register()

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }

    public static <MSG> void sendToAllPlayers(MSG message) {
        INSTANCE.send(PacketDistributor.ALL.noArg(), message);
    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }
}