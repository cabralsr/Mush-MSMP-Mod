package net.msmp.mod.client.model;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.block.entity.custom.PlushieBlockEntity;
import software.bernie.geckolib.model.GeoModel;

public class PlushieModel extends GeoModel<PlushieBlockEntity> {

    @Override
    public ResourceLocation getModelResource(PlushieBlockEntity animatable) {
        String name = ForgeRegistries.BLOCKS.getKey(animatable.getBlockState().getBlock()).getPath();
        return ResourceLocation.fromNamespaceAndPath(MsmpMod.MOD_ID, "geo/" + name + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PlushieBlockEntity animatable) {
        String name = ForgeRegistries.BLOCKS.getKey(animatable.getBlockState().getBlock()).getPath();
        return ResourceLocation.fromNamespaceAndPath(MsmpMod.MOD_ID, "textures/block/" + name + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(PlushieBlockEntity animatable) {
        String name = ForgeRegistries.BLOCKS.getKey(animatable.getBlockState().getBlock()).getPath();
        return ResourceLocation.fromNamespaceAndPath(MsmpMod.MOD_ID, "animations/" + name + ".animation.json");
    }
}