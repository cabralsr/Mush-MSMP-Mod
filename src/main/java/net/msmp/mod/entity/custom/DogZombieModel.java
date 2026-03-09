package net.msmp.mod.entity.custom;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DogZombieModel extends GeoModel<DogZombieEntity> {
    @Override
    public ResourceLocation getModelResource(DogZombieEntity object) {
        return ResourceLocation.fromNamespaceAndPath("msmpmod", "geo/dog_mush.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DogZombieEntity object) {
        return  ResourceLocation.fromNamespaceAndPath("msmpmod", "textures/entity/dog_mush.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DogZombieEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("msmpmod", "animations/dog_mush.animation.json");
    }
}
