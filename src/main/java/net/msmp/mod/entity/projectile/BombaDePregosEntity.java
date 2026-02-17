package net.msmp.mod.entity.projectile;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.msmp.mod.entity.ModEntityTypes; // Vamos criar isso já já
import net.msmp.mod.entity.projectile.PregoEntity;
import net.msmp.mod.item.ModItems; // Seu registro de itens

public class BombaDePregosEntity extends ThrowableItemProjectile {

    public BombaDePregosEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public BombaDePregosEntity(Level pLevel, LivingEntity pShooter) {
        super(ModEntityTypes.BOMBA_DE_PREGO_PROJECTILE.get(), pShooter, pLevel);
    }

    public BombaDePregosEntity(Level pLevel, double pX, double pY, double pZ) {
        super(ModEntityTypes.BOMBA_DE_PREGO_PROJECTILE.get(), pX, pY, pZ, pLevel);
    }

    @Override
    protected Item getDefaultItem() {

        return ModItems.BOMBA_DE_PREGO.get();
    }

    @Override
    protected void onHit(HitResult pResult) {
        super.onHit(pResult);

        if (!this.level().isClientSide) {
            this.level().explode(this, this.getX(), this.getY(), this.getZ(), 2.0F, Level.ExplosionInteraction.NONE);

            spawnShrapnel();

            this.discard();
        }
    }

    private void spawnShrapnel() {
        int numberOfNails = 20;

        for (int i = 0; i < numberOfNails; i++) {
            PregoEntity nail = new PregoEntity(this.level(), this.getX(), this.getY() + 0.5, this.getZ());

            nail.setBaseDamage(7.0);
            nail.pickup = AbstractArrow.Pickup.DISALLOWED;

            double angle = (2 * Math.PI / numberOfNails) * i;
            double xDir = Math.cos(angle);
            double zDir = Math.sin(angle);

            nail.shoot(xDir, 0.1, zDir, 1.5f, 5.0f);

            this.level().addFreshEntity(nail);
            if (this.level().isClientSide) {
                this.level().addParticle(ParticleTypes.CRIT,
                        this.getX(), this.getY(), this.getZ(),
                        xDir * 0.5, 0.1, zDir * 0.5);
            }
        }
    }
}