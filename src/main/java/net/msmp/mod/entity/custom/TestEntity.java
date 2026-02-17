package net.msmp.mod.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.game.ClientboundStopSoundPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.msmp.mod.effects.ModEffects;
import net.msmp.mod.ModSounds;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public class TestEntity extends Monster implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public TestEntity(EntityType<? extends Monster> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        this.goalSelector.addGoal(0, new FloatGoal(this));

        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));

        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));

        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));

        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));


        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));

        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true)); // Prioridade 2: Procura e ataca o jogador mais próximo
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 50.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.ATTACK_DAMAGE, 15.0D)
                .add(Attributes.ARMOR, 7D)
                .add(Attributes.ATTACK_SPEED, 1.5D)
                .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar registrar) {
        registrar.add(new AnimationController<>(this, "movementController", 10, this::movementPredicate));
    }

    private <E extends GeoEntity> PlayState movementPredicate(AnimationState<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(RawAnimation.begin().thenLoop("walk"));
        } else {
            event.getController().setAnimation(RawAnimation.begin().thenLoop("idle"));
        }

        if (this.swingTime > 0) {
            event.getController().setAnimation(RawAnimation.begin().thenPlay("attack"));
        }

        return PlayState.CONTINUE;
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        boolean attackSuccessful = super.doHurtTarget(target);

        if (attackSuccessful && target instanceof LivingEntity) {
            if (!this.level().isClientSide()) {
                LivingEntity livingTarget = (LivingEntity) target;

                livingTarget.addEffect(new MobEffectInstance(
                        ModEffects.BLEEDING.get(),
                        100,
                        2,
                        false,
                        false,
                        false
                ));

                livingTarget.addEffect(new MobEffectInstance(
                        MobEffects.POISON,
                        100,
                        0,
                        false,
                        true,
                        true
                ));
            }
        }

        return attackSuccessful;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.CLICKER_AMBIENT.get();
    }

    @Override
    public void die(DamageSource cause) {
        super.die(cause);

        if (!this.level().isClientSide()) {

            net.minecraft.resources.ResourceLocation soundId = net.msmp.mod.ModSounds.CLICKER_AMBIENT.getId();

            for (net.minecraft.world.entity.player.Player player : this.level().players()) {

                if (player instanceof ServerPlayer serverPlayer && player.distanceToSqr(this) < 1024.0D) {

                    serverPlayer.connection.send(new ClientboundStopSoundPacket(soundId, SoundSource.HOSTILE));
                }
            }
        }
    }


    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.ZOMBIE_STEP, 0.15F, 1.0F);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
