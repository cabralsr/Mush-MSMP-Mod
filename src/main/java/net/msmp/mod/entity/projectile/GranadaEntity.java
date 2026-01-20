package net.msmp.mod.entity.projectile;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.msmp.mod.entity.ModEntityTypes;
import net.msmp.mod.item.ModItems;

public class GranadaEntity extends ThrowableItemProjectile {

    private int fuseTimer = 60; // 3 segundos

    public GranadaEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public GranadaEntity(Level level, LivingEntity shooter) {
        super(ModEntityTypes.GRANADA_PROJECTILE.get(), shooter, level);
    }

    public GranadaEntity(Level level, double x, double y, double z) {
        super(ModEntityTypes.GRANADA_PROJECTILE.get(), x, y, z, level);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.GRANADA.get();
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level().isClientSide) {
            this.fuseTimer--;

            if (this.fuseTimer <= 0) {
                this.explode();
                this.discard();
            }
        } else {
            this.level().addParticle(ParticleTypes.SMOKE, this.getX(), this.getY() + 0.5D, this.getZ(), 0.0D, 0.0D, 0.0D);
        }
    }

    @Override
    protected void onHit(HitResult result) {

        if (!this.level().isClientSide) {
            this.level().playSound(null, this.getX(), this.getY(), this.getZ(),
                    SoundEvents.METAL_HIT, SoundSource.NEUTRAL, 1.0F, 1.2F);

            this.setDeltaMovement(0, 0, 0);
        }
    }

    private void explode() {
        // Cria a explosão.
        // TNT = Quebra blocos. NONE = Só dá dano.
        this.level().explode(this, this.getX(), this.getY(), this.getZ(),
                3.0F, Level.ExplosionInteraction.TNT);
    }
}