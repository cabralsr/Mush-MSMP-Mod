package net.msmp.mod.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.msmp.mod.effects.ModEffects;

public class CustomSword extends SwordItem {
    public CustomSword(Tier pTier, int pAttackDamageModifier, double pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, (float) pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.level().isClientSide()) {

            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 2), attacker);

            target.addEffect(new MobEffectInstance(ModEffects.BLEEDING.get(), 200, 0, false, true, false), attacker);
        }
        return super.hurtEnemy(stack, target, attacker);
    }
}
