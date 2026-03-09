package net.msmp.mod.item.food;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.msmp.mod.item.ModItems;
import net.msmp.mod.thirst.PlayerThirstProvider;

public class BebidaCaixaItem extends Item {

    public BebidaCaixaItem(Properties properties) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 20;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide()) {

        }

        if (entity instanceof Player player && !player.getAbilities().instabuild) {
            stack.shrink(1);
        }

        if (entity instanceof ServerPlayer serverPlayer) {

            CriteriaTriggers.CONSUME_ITEM.trigger(serverPlayer, stack);

            serverPlayer.getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(thirst -> {

                thirst.addThirst(4);

                net.msmp.mod.network.ModMessages.sendToPlayer(new net.msmp.mod.networking.packet.ThirstDataSyncS2CPacket(thirst.getThirst()), serverPlayer);
            });
        }

        if (stack.isEmpty()) {
            return new ItemStack(ModItems.GARRAFA_VIDRO.get());
        } else {

            if (entity instanceof Player player && !player.getAbilities().instabuild) {


            }

            return stack;
        }
    }
}
