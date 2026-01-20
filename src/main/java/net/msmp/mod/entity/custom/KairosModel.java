package net.msmp.mod.entity.custom;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class KairosModel extends GeoModel<KairosEntity> {
    @Override
    public ResourceLocation getModelResource(KairosEntity object) {
        return ResourceLocation.fromNamespaceAndPath("msmpmod", "geo/kairos.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KairosEntity object) {
        return  ResourceLocation.fromNamespaceAndPath("msmpmod", "textures/entity/kairos.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KairosEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("msmpmod", "animations/kairos.animation.json");
    }
}
