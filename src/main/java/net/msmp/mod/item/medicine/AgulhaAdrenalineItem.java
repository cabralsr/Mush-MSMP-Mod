package net.msmp.mod.item.medicine;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.msmp.mod.item.ModItems;

public class AgulhaAdrenalineItem extends Item {

    public AgulhaAdrenalineItem(Properties properties) {
        super(properties);
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.BOW;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 20;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide()) {

            entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 1));
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 1));
            entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 300, 1));

            entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1200, 0));
            entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 1200, 0));
        }

        if (entity instanceof Player player && !player.getAbilities().instabuild) {
            stack.shrink(1);
        }

        if (stack.isEmpty()) {
            return new ItemStack(ModItems.AMPOLA_VAZIA.get());
        } else {

            if (entity instanceof Player player && !player.getAbilities().instabuild) {
                ItemStack ampolaVazia = new ItemStack(ModItems.AMPOLA_VAZIA.get());

                if (!player.getInventory().add(ampolaVazia)) {
                    player.drop(ampolaVazia, false);
                }
            }

            return stack;
        }
    }
}
