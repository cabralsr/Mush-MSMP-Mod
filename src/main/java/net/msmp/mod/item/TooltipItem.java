package net.msmp.mod.item;


import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class TooltipItem extends Item {

    public TooltipItem(Properties properties) {
        super(properties);
    }

    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        String tooltipKey = stack.getDescriptionId() + ".tooltip";
        tooltip.add(Component.translatable(tooltipKey));
    }
}
