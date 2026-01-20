package net.msmp.mod.item.food;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFood {
    public static final FoodProperties FUNGO_VINHO = new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200, 0), 0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 20000, 3), 0.1f)
            .build();

    public static final FoodProperties AGUA_PROPERTIES = new FoodProperties.Builder()
            .nutrition(0)
            .saturationMod(5)
            .alwaysEat()
            .build();

    public static final FoodProperties COMIDA_CONSERVA = new FoodProperties.Builder()
            .nutrition(4)
            .saturationMod(4)
            .alwaysEat()
            .build();

    public static final FoodProperties REFRIGERANTE = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(3)
            .alwaysEat()
            .build();

    public static final FoodProperties WHISKY = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(1)
            .alwaysEat()
            .build();

    public static final FoodProperties CERVEJA = new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(1)
            .alwaysEat()
            .build();

    public static final FoodProperties FRASCO = new FoodProperties.Builder()
            .nutrition(0)
            .saturationMod(0f)
            .alwaysEat()
            .build();

}
