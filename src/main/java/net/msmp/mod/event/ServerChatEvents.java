package net.msmp.mod.event;

import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.network.BubbleMessagePacket;
import net.msmp.mod.network.ModMessages;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Mod.EventBusSubscriber(modid = MsmpMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ServerChatEvents {

    public static final Map<UUID, Integer> PLAYER_COLORS = new HashMap<>();

    @SubscribeEvent
    public static void onChat(ServerChatEvent event) {
        ServerPlayer player = event.getPlayer();
        String message = event.getRawText();

        int playerColor = PLAYER_COLORS.getOrDefault(player.getUUID(), 0x000000);

        ModMessages.sendToAllPlayers(new BubbleMessagePacket(player.getUUID(), message, playerColor));

        event.setCanceled(true);
    }

    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity() instanceof net.minecraft.server.level.ServerPlayer player) {

            if (player.getPersistentData().contains("msmp_chat_color")) {
                int savedColor = player.getPersistentData().getInt("msmp_chat_color");

                PLAYER_COLORS.put(player.getUUID(), savedColor);
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        if (event.getOriginal().getPersistentData().contains("msmp_chat_color")) {
            int savedColor = event.getOriginal().getPersistentData().getInt("msmp_chat_color");

            event.getEntity().getPersistentData().putInt("msmp_chat_color", savedColor);

            PLAYER_COLORS.put(event.getEntity().getUUID(), savedColor);
        }
    }
}