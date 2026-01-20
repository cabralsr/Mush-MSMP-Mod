package net.msmp.mod.entity.custom;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class mobModel extends GeoModel<mobEntity> {
    @Override
    public ResourceLocation getModelResource(mobEntity object) {
        return ResourceLocation.fromNamespaceAndPath("msmpmod", "geo/mobfinal.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(mobEntity object) {
        return  ResourceLocation.fromNamespaceAndPath("msmpmod", "textures/entity/mobfinal.png");
    }

    @Override
    public ResourceLocation getAnimationResource(mobEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("msmpmod", "animations/mobfinal.animation.json");
    }
}
