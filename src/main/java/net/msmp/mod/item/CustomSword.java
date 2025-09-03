package net.msmp.mod.item;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class CustomSword extends SwordItem {
    public CustomSword(Tier pTier, int pAttackDamageModifier, double pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, (float) pAttackSpeedModifier, pProperties);
    }
}
