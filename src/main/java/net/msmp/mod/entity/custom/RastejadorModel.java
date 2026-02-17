package net.msmp.mod.entity.custom;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RastejadorModel extends GeoModel<RastejadorEntity> {
    @Override
    public ResourceLocation getModelResource(RastejadorEntity object) {
        return ResourceLocation.fromNamespaceAndPath("msmpmod", "geo/rastejador.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RastejadorEntity object) {
        return  ResourceLocation.fromNamespaceAndPath("msmpmod", "textures/entity/rastejador.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RastejadorEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("msmpmod", "animations/rastejador.animation.json");
    }
}
