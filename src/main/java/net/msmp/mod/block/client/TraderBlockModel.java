package net.msmp.mod.block.client;

import net.minecraft.resources.ResourceLocation;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.block.entity.TraderBlockEntity;
import software.bernie.geckolib.model.GeoModel;

@SuppressWarnings("removal")
public class TraderBlockModel extends GeoModel<TraderBlockEntity> {

    @Override
    public ResourceLocation getModelResource(TraderBlockEntity animatable) {
        return new ResourceLocation(MsmpMod.MOD_ID, "geo/trader_block.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TraderBlockEntity animatable) {
        return new ResourceLocation(MsmpMod.MOD_ID, "textures/block/trader_block.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TraderBlockEntity animatable) {
        return new ResourceLocation(MsmpMod.MOD_ID, "animations/trader_block.animation.json");
    }
}