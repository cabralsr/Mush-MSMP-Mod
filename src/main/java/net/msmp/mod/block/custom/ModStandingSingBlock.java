package net.msmp.mod.block.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.msmp.mod.block.entity.ModSignBlockEntity;
import net.msmp.mod.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class ModStandingSingBlock extends StandingSignBlock {
    public ModStandingSingBlock(Properties pProperties, WoodType pType) {
        super(pProperties, pType);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.translatable("tooltip.msmpmod.signs")
                .withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new ModSignBlockEntity(pPos, pState);
    }

}
