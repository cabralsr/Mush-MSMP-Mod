package net.msmp.mod.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MerchantMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.Merchant;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.msmp.mod.item.ModItems;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class TraderBlockEntity extends BlockEntity implements GeoBlockEntity, Merchant, MenuProvider {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private MerchantOffers offers;
    private Player tradingPlayer;

    public TraderBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TRADER_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public MerchantOffers getOffers() {
        if (this.offers == null) {
            this.offers = new MerchantOffers();

            this.offers.add(new MerchantOffer(
                    new ItemStack(ModItems.SUCATAS.get(), 3),
                    ItemStack.EMPTY,
                    new ItemStack(ModItems.COMIDA_CONSERVA1.get(), 1),
                    16,
                    1,
                    0.05f
            ));

            this.offers.add(new MerchantOffer(
                    new ItemStack(ModItems.SUCATAS.get(), 3),
                    ItemStack.EMPTY,
                    new ItemStack(ModItems.COMIDA_CONSERVA2.get(), 1),
                    16,
                    1,
                    0.05f
            ));

            this.offers.add(new MerchantOffer(
                    new ItemStack(ModItems.SUCATAS.get(), 3),
                    ItemStack.EMPTY,
                    new ItemStack(ModItems.COMIDA_CONSERVA3.get(), 1),
                    16,
                    1,
                    0.05f
            ));

            this.offers.add(new MerchantOffer(
                    new ItemStack(ModItems.FITA.get(), 2),
                    ItemStack.EMPTY,
                    new ItemStack(ModItems.GARRAFA_AGUA.get(), 1),
                    16, 1, 0.05f
            ));

            this.offers.add(new MerchantOffer(
                    new ItemStack(ModItems.TRAPOS.get(), 3),
                    ItemStack.EMPTY,
                    new ItemStack(ModItems.REFRI1.get(), 1),
                    16, 1, 0.05f
            ));

            this.offers.add(new MerchantOffer(
                    new ItemStack(ModItems.TRAPOS.get(), 3),
                    ItemStack.EMPTY,
                    new ItemStack(ModItems.REFRI2.get(), 1),
                    16, 1, 0.05f
            ));

            this.offers.add(new MerchantOffer(
                    new ItemStack(ModItems.TRAPOS.get(), 3),
                    ItemStack.EMPTY,
                    new ItemStack(ModItems.REFRI3.get(), 1),
                    16, 1, 0.05f
            ));

            this.offers.add(new MerchantOffer(
                    new ItemStack(ModItems.TRAPOS.get(), 3),
                    ItemStack.EMPTY,
                    new ItemStack(ModItems.GUARAVITA.get(), 1),
                    16, 1, 0.05f
            ));

            this.offers.add(new MerchantOffer(
                    new ItemStack(ModItems.FIO_DE_COBRE.get(), 2),
                    ItemStack.EMPTY,
                    new ItemStack(ModItems.CERVEJA1.get(), 1),
                    16, 1, 0.05f
            ));

            this.offers.add(new MerchantOffer(
                    new ItemStack(ModItems.FIO_DE_COBRE.get(), 2),
                    ItemStack.EMPTY,
                    new ItemStack(ModItems.CERVEJA2.get(), 1),
                    16, 1, 0.05f
            ));

            this.offers.add(new MerchantOffer(
                    new ItemStack(ModItems.REMEDIOS.get(), 1),
                    ItemStack.EMPTY,
                    new ItemStack(ModItems.WHISKY.get(), 1),
                    16, 1, 0.05f
            ));
        }
        return this.offers;
    }

    @Override
    public void setTradingPlayer(@Nullable Player player) { this.tradingPlayer = player; }
    @Nullable
    @Override
    public Player getTradingPlayer() { return this.tradingPlayer; }
    @Override
    public void overrideOffers(MerchantOffers offers) {}
    @Override
    public void notifyTrade(MerchantOffer offer) { offer.increaseUses(); }
    @Override
    public void notifyTradeUpdated(ItemStack stack) {}
    @Override
    public int getVillagerXp() { return 0; }
    @Override
    public void overrideXp(int xp) {}
    @Override
    public boolean showProgressBar() { return false; }
    @Override
    public SoundEvent getNotifyTradeSound() { return SoundEvents.VILLAGER_YES; }
    @Override
    public boolean isClientSide() { return this.level != null && this.level.isClientSide; }
    @Override
    public boolean canRestock() { return true; }

    @Override
    public Component getDisplayName() {
        return Component.literal("Máquina de Trocas");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player player) {
        this.setTradingPlayer(player);
        return new MerchantMenu(containerId, playerInventory, this);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 0, state -> {
            return state.setAndContinue(RawAnimation.begin().thenLoop("animation.trader.idle"));
        }));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}