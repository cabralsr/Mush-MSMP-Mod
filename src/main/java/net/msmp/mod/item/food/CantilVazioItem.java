package net.msmp.mod.item.food;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.msmp.mod.item.ModItems;

public class CantilVazioItem extends Item {

    public CantilVazioItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        // Raytrace para detectar fluidos (mesma lógica do balde)
        BlockHitResult hitResult = getPlayerPOVHitResult(level, player, ClipContext.Fluid.SOURCE_ONLY);

        if (hitResult.getType() == HitResult.Type.BLOCK) {
            BlockPos pos = hitResult.getBlockPos();

            if (level.getBlockState(pos).is(Blocks.WATER)) {
                level.playSound(player, player.getX(), player.getY(), player.getZ(),
                        SoundEvents.BOTTLE_FILL, SoundSource.NEUTRAL, 1.0F, 1.0F);

                // --- LÓGICA DE SORTE (RNG) ---
                ItemStack novoCantil;
                float chancePurificada = 0.15f; // 15% de chance de vir limpa

                if (level.getRandom().nextFloat() < chancePurificada) {
                    // Ganha Cantil Limpo
                    novoCantil = new ItemStack(ModItems.CANTIL_LIMPO.get());
                } else {
                    // Ganha Cantil Sujo
                    novoCantil = new ItemStack(ModItems.CANTIL_SUJO.get());
                }

                // Como o cantil cheio tem durabilidade, garantimos que ele vem "novo" (dano 0)
                novoCantil.setDamageValue(0);

                // Troca o item na mão
                return InteractionResultHolder.sidedSuccess(
                        ItemUtils.createFilledResult(itemStack, player, novoCantil),
                        level.isClientSide());
            }
        }

        return InteractionResultHolder.pass(itemStack);
    }
}