package net.msmp.mod.event;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.entity.ModEntityTypes;
import net.msmp.mod.entity.custom.TestEntity;
import net.msmp.mod.entity.render.TesteRenderer;
import net.msmp.mod.item.ModItems;
import net.msmp.mod.thirst.PlayerThirstProvider;
import net.msmp.mod.weather.RedRainManager;


@Mod.EventBusSubscriber(modid = MsmpMod.MOD_ID)

public class ModEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.SEU_MOB.get(), TestEntity.createAttributes().build());
        event.put(ModEntityTypes.KAIROS_MOB.get(), TestEntity.createAttributes().build());
        event.put(ModEntityTypes.MOBFINAL_MOB.get(), TestEntity.createAttributes().build());
    }


    @SubscribeEvent
    public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();
        Player player = event.getEntity();
        InteractionHand hand = event.getHand();
        ItemStack itemStack = player.getItemInHand(hand);

        if (itemStack.getItem() == ModItems.CANTIL_VAZIO.get()) {
            HitResult hitResult = player.pick(5.0D, 0.0F, true);

            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockPos pos = ((BlockHitResult) hitResult).getBlockPos();
                BlockState state = level.getBlockState(pos);

                if (state.is(Blocks.WATER)) {
                    level.playSound(player, player.getX(), player.getY(), player.getZ(),
                            SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);


                    ItemStack resultadoDaAgua;


                    float chancePurificada = 0.10f;

                    if (level.getRandom().nextFloat() < chancePurificada) {
                        resultadoDaAgua = new ItemStack(ModItems.CANTIL_LIMPO.get());

                        if (!level.isClientSide) {
                        }
                    } else {
                        resultadoDaAgua = new ItemStack(ModItems.CANTIL_SUJO.get());
                    }


                    if (!player.getAbilities().instabuild) {
                        player.setItemInHand(hand, ItemUtils.createFilledResult(itemStack, player, resultadoDaAgua));
                    }

                    event.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player) {
            if(!event.getObject().getCapability(PlayerThirstProvider.PLAYER_THIRST).isPresent()) {
                event.addCapability(ResourceLocation.fromNamespaceAndPath(MsmpMod.MOD_ID, "properties_thirst"), new PlayerThirstProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(oldStore -> {
                event.getEntity().getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onPlayerJoinWorld(PlayerEvent.PlayerLoggedInEvent event) {
        if(!event.getEntity().level().isClientSide()) {
            event.getEntity().getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(thirst -> {
                net.msmp.mod.networking.ModMessages.sendToPlayer(new net.msmp.mod.networking.packet.ThirstDataSyncS2CPacket(thirst.getThirst()), (ServerPlayer) event.getEntity());
            });
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.side.isServer() && event.phase == TickEvent.Phase.START) {
            ServerPlayer player = (ServerPlayer) event.player;

            if (player.isCreative() || player.isSpectator()) return;

            if(player.tickCount % 2400 == 0) {

                player.getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(thirst -> {
                    if(thirst.getThirst() > 0) {
                        thirst.subThirst(1);

                        net.msmp.mod.networking.ModMessages.sendToPlayer(new net.msmp.mod.networking.packet.ThirstDataSyncS2CPacket(thirst.getThirst()), player);
                    } else {
                        player.hurt(player.damageSources().starve(), 1.0f);
                    }
                });
            }
        }
    }

    @SubscribeEvent
    public static void onLivingTick(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        Level level = entity.level();

        if (level.isClientSide || !RedRainManager.isActive() || !level.isRaining()) {
            return;
        }

        if (entity.tickCount % 20 == 0) {
           return;
        }

        if (entity instanceof Player player) {
            ItemStack helmet = player.getItemBySlot(EquipmentSlot.HEAD);
            if (helmet.getItem() == ModItems.GAS_MASK.get()) {
                return;
            }
        }
        // -----------------------------------

        BlockPos pos = entity.blockPosition();

        if (level.isRainingAt(pos)) {
            entity.addEffect(new MobEffectInstance(MobEffects.POISON, 800, 0, false, true));
        }

    }

    @SubscribeEvent
    public static void onRegisterCommands(RegisterCommandsEvent event) {
        CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();

        dispatcher.register(Commands.literal("redrain")
                .requires(source -> source.hasPermission(2))
                .executes(context -> {
                    RedRainManager.toggle(context.getSource().getLevel());
                    return 1;
                }));
    }
}
