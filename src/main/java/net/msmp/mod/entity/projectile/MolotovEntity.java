package net.msmp.mod.entity.projectile;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.msmp.mod.entity.ModEntityTypes;
import net.msmp.mod.item.ModItems;

public class MolotovEntity extends ThrowableItemProjectile {

    public MolotovEntity(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    public MolotovEntity(Level level, LivingEntity shooter) {
        super(ModEntityTypes.MOLOTOV_PROJECTILE.get(), shooter, level);
    }

    public MolotovEntity(Level level, double x, double y, double z) {
        super(ModEntityTypes.MOLOTOV_PROJECTILE.get(), x, y, z, level);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.MOLOTOV.get();
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);

        if (!this.level().isClientSide) {
            this.level().broadcastEntityEvent(this, (byte)3);

            spawnFire(result);

            this.discard();
        }
    }

    private void spawnFire(HitResult result) {
        BlockPos centerPos;
        if (result.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockHit = (BlockHitResult) result;
            centerPos = blockHit.getBlockPos().relative(blockHit.getDirection());
        } else {
            centerPos = this.blockPosition();
        }

        int radius = 4;

        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                if (x * x + z * z <= radius * radius) {
                    BlockPos targetPos = centerPos.offset(x, 0, z);

                    if (this.level().getBlockState(targetPos).isAir() &&
                            !this.level().getBlockState(targetPos.below()).isAir()) {

                        this.level().setBlockAndUpdate(targetPos,
                                Blocks.FIRE.defaultBlockState().setValue(FireBlock.AGE, 13));
                    }
                }
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        result.getEntity().setSecondsOnFire(10);
        result.getEntity().hurt(this.damageSources().thrown(this, this.getOwner()), 2f);
    }
}
