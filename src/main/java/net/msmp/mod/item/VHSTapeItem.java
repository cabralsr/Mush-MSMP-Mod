package net.msmp.mod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class VHSTapeItem extends Item {
    private final String audioId;

    public VHSTapeItem(Properties pProperties, String audioId) {
        super(pProperties);
        this.audioId = audioId;
    }

    public String getAudioId() {
        return audioId;
    }
}