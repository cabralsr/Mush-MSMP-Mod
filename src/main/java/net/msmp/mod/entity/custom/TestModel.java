package net.msmp.mod.entity.custom;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TestModel extends GeoModel<TestEntity> {
    @Override
    public ResourceLocation getModelResource(TestEntity object) {
        return ResourceLocation.fromNamespaceAndPath("msmpmod", "geo/clicker.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TestEntity object) {
        return  ResourceLocation.fromNamespaceAndPath("msmpmod", "textures/entity/clicker.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TestEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath("msmpmod", "animations/clicker.animation.json");
    }
}
