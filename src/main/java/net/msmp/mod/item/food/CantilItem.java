package net.msmp.mod.item.food;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.msmp.mod.item.ModItems;
import net.msmp.mod.thirst.PlayerThirstProvider;

public class CantilItem extends Item {

    private final boolean isInfectado;

    public CantilItem(Properties properties, boolean isInfectado) {
        super(properties);
        this.isInfectado = isInfectado;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        return ItemUtils.startUsingInstantly(level, player, hand);
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
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        super.finishUsingItem(stack, level, entity);

        if (entity instanceof ServerPlayer serverPlayer) {
            serverPlayer.getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(thirst -> {

                if (isInfectado) {
                    thirst.addThirst(2);

                    serverPlayer.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0));
                } else {
                    thirst.addThirst(10);
                }

                net.msmp.mod.networking.ModMessages.sendToPlayer(new net.msmp.mod.networking.packet.ThirstDataSyncS2CPacket(thirst.getThirst()), serverPlayer);
            });

            int danoAtual = stack.getDamageValue();
            int novoDano = danoAtual + 1;

            if (novoDano >= stack.getMaxDamage()) {
                return new ItemStack(ModItems.CANTIL_VAZIO.get());
            } else {
                stack.setDamageValue(novoDano);
                return stack;
            }
        }
        return stack;
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        return stack.isDamaged();
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return Math.round(13.0F - (float)stack.getDamageValue() * 13.0F / (float)this.getMaxDamage(stack));
    }

    @Override
    public int getBarColor(ItemStack stack) {
        return 0x33ebff;
    }
}