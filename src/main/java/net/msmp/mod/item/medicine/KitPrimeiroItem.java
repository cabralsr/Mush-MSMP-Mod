package net.msmp.mod.item.medicine;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;

import java.util.ArrayList;
import java.util.List;

public class KitPrimeiroItem extends Item {

    public KitPrimeiroItem(Properties properties) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }
    @Override
    public int getUseDuration(ItemStack stack) {
        return 60;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide()) {


            entity.setHealth(entity.getMaxHealth());

            List<MobEffect> effectsToRemove = new ArrayList<>();

            for (MobEffectInstance instance : entity.getActiveEffects()) {
                if (instance.getEffect().getCategory() == MobEffectCategory.HARMFUL) {
                    effectsToRemove.add(instance.getEffect());
                }
            }

            for (MobEffect effect : effectsToRemove) {
                entity.removeEffect(effect);
            }
        }

        if (entity instanceof Player && !((Player) entity).getAbilities().instabuild) {
            stack.shrink(1);
        }

        return stack;
    }
}