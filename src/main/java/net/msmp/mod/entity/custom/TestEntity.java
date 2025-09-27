package net.msmp.mod.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.security.cert.CertPathBuilder;

public class TestEntity extends PathfinderMob implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public TestEntity(EntityType<? extends PathfinderMob> type, Level level) {
        super(type, level);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        this.goalSelector.addGoal(0, new FloatGoal(this));

        // --- METAS DE ATAQUE (O COMPORTAMENTO DO ZUMBI) ---
        // Prioridade 2: A ação de atacar fisicamente quando já tem um alvo.
        // O 1.0D é a velocidade, e 'false' significa que ele não precisa ver o alvo para continuar atacando.
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));

        // --- METAS DE MOVIMENTO E AMBIENTE ---
        // Prioridade 7: Vaguear por aí quando não tem nada para fazer.
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        // Prioridade 8: Olhar para o jogador mais próximo que estiver a até 8 blocos.
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        // Prioridade 8: Olhar para direções aleatórias.
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));


        // --- SELEÇÃO DE ALVOS (A PARTE AGRESSIVA) ---
        // Prioridade 1: Se for atacado por qualquer coisa, vai revidar.
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));

        // Prioridade 2: Esta é a linha que o faz caçar jogadores ativamente!
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true)); // Prioridade 2: Procura e ataca o jogador mais próximo
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 100.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.5D)
                .add(Attributes.ATTACK_DAMAGE, 15.0D)
                .add(Attributes.ARMOR, 5D)
                .add(Attributes.ATTACK_SPEED, 2D)
                .add(Attributes.FOLLOW_RANGE, 32.0D);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar registrar) {
        // Controlador para movimento de fundo (andar/parado)
        registrar.add(new AnimationController<>(this, "movementController", 10, this::movementPredicate));
    }

    private <E extends GeoEntity> PlayState movementPredicate(AnimationState<E> event) {
        if (event.isMoving()) {
            // Usa thenLoop para animações que devem se repetir continuamente.
            event.getController().setAnimation(RawAnimation.begin().thenLoop("walk"));
        } else {
            // Animação padrão para quando o mob não está se movendo.
            event.getController().setAnimation(RawAnimation.begin().thenLoop("idle"));
        }

        if (this.swingTime > 0) {
            // Usa thenPlay para animações que devem tocar apenas uma vez.
            event.getController().setAnimation(RawAnimation.begin().thenPlay("attack"));
        }

        return PlayState.CONTINUE;
    }

//    @Override
//    public void tick() {
//        super.tick();
//
//        // Esta lógica define quando o mob deve correr.
//        // Se ele tiver um alvo, a variável 'sprinting' se torna verdadeira.
//        // Se ele perder o alvo, a variável volta a ser falsa.
//        this.setSprinting(this.getTarget() != null);
//    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
