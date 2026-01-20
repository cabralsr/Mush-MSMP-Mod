package net.msmp.mod.item.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

    public class AlcoolicoItem extends Item {

        public AlcoolicoItem(Properties properties) {
            super(properties);
        }

        @Override
        public UseAnim getUseAnimation(ItemStack stack) {
            return UseAnim.DRINK;
        }
        @Override
        public int getUseDuration(ItemStack stack) {
            return 30;
        }

        @Override
        public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
            if (!level.isClientSide()) {
                entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 600, 0));
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 1));
            }
            if (entity instanceof Player player && !player.getAbilities().instabuild) {
                stack.shrink(1);
            }

            return stack;
        }
    }

