package net.msmp.mod.block.entity;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.entity.SignText;
import net.minecraft.world.level.block.state.BlockState;

public class ModSignBlockEntity extends SignBlockEntity {
    public ModSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.MOD_SIGN.get(), pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.MOD_SIGN.get();
    }

    @Override
    public void onLoad() {
        super.onLoad();

        // Força o glow no texto da frente
        SignText front = this.getFrontText().setHasGlowingText(true);
        this.setText(front, true);

        // Força o glow no texto de trás, se quiser (opcional)
        SignText back = this.getBackText().setHasGlowingText(true);
        this.setText(back, false);

        this.setChanged();
    }
}
