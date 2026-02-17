package net.msmp.mod.item.food;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.msmp.mod.item.ModItems;
import net.msmp.mod.network.ModMessages; // Importante: Sua rede
import net.msmp.mod.networking.packet.ThirstDataSyncS2CPacket; // Importante: Seu pacote
import net.msmp.mod.thirst.PlayerThirstProvider; // Importante: Sua capability

public class GarrafaAguaItem extends Item {

    public GarrafaAguaItem(Properties properties) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 32;
    }

    @Override
    public net.minecraft.sounds.SoundEvent getDrinkingSound() {
        return SoundEvents.GENERIC_DRINK;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(level, player, hand);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        super.finishUsingItem(stack, level, entity);

        if (entity instanceof ServerPlayer serverPlayer) {

            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);

            serverPlayer.getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(thirst -> {

                thirst.addThirst(4);

                ModMessages.sendToPlayer(new ThirstDataSyncS2CPacket(thirst.getThirst()), serverPlayer);
            });

            if (!serverPlayer.getAbilities().instabuild) {
                return new ItemStack(ModItems.GARRAFA_AGUA_VAZIA.get());
            }
        }

        return stack;
    }
}