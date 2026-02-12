package net.msmp.mod.item;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ArmorItem;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import net.msmp.mod.client.renderer.GasMaskRenderer;
import org.jetbrains.annotations.NotNull;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class GasMaskItem extends ArmorItem implements GeoItem {

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public GasMaskItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }


    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private GasMaskRenderer renderer;

            @Override
            public @NotNull HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack,
                                                                   EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
                if (this.renderer == null) {
                    this.renderer = new GasMaskRenderer();
                }

                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, state ->
                state.setAndContinue(RawAnimation.begin().thenLoop("idle"))
        ));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }


    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (!level.isClientSide() && entity instanceof Player player) {

            ItemStack headStack = player.getItemBySlot(EquipmentSlot.HEAD);
            if (headStack.getItem() == this) {


                if (stack.getDamageValue() < stack.getMaxDamage() - 1) {

                    if (player.hasEffect(MobEffects.POISON)) {
                        player.removeEffect(MobEffects.POISON);
                    }
                    if (player.hasEffect(MobEffects.CONFUSION)) {
                        player.removeEffect(MobEffects.CONFUSION);
                    }
                    if (player.hasEffect(MobEffects.DARKNESS)) {
                        player.removeEffect(MobEffects.DARKNESS);
                    }



                    if (!player.isCreative() && player.tickCount % 500 == 0) {
                        stack.setDamageValue(stack.getDamageValue() + 1);
                    }

                } else {
                    if (player.tickCount % 1200 == 0) {
                        player.displayClientMessage(Component.literal("§cSeu filtro acabou!"), true);
                    }
                }
            }
        }
    }

    @Override
    public <T extends LivingEntity> int damageItem(ItemStack stack, int amount, T entity, java.util.function.Consumer<T> onBroken) {
        if (stack.getDamageValue() + amount >= stack.getMaxDamage()) {
            return 0;
        }
        return super.damageItem(stack, amount, entity, onBroken);
    }

    // Adiciona dica no item
    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        if (stack.getDamageValue() >= stack.getMaxDamage() - 1) {
            tooltip.add(Component.literal("§cFiltro Esgotado! Troque na Crafting Table."));
        } else {
            int porcentagem = 100 - (int)((float)stack.getDamageValue() / stack.getMaxDamage() * 100);
            tooltip.add(Component.literal("§aFiltro: " + porcentagem + "%"));
        }
        super.appendHoverText(stack, level, tooltip, flag);
    }
}