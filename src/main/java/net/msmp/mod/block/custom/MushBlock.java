package net.msmp.mod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class MushBlock extends Block {
    public MushBlock(Properties properties) {
        super(properties);
    }

    /**
     * Chamado sempre que uma entidade pisa no bloco.
     */
    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {

        if (entity instanceof LivingEntity) {

            if (!level.isClientSide()) {
                LivingEntity livingEntity = (LivingEntity) entity;

                livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 2000000, 1));
            }
        }

        super.stepOn(level, pos, state, entity);
    }
}
