package net.msmp.mod.client.model;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.item.PlushieItem;
import software.bernie.geckolib.model.GeoModel;

public class PlushieItemModel extends GeoModel<PlushieItem> {

    @Override
    public ResourceLocation getModelResource(PlushieItem animatable) {
        String name = ForgeRegistries.ITEMS.getKey(animatable).getPath();
        return ResourceLocation.fromNamespaceAndPath(MsmpMod.MOD_ID, "geo/" + name + ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PlushieItem animatable) {
        String name = ForgeRegistries.ITEMS.getKey(animatable).getPath();
        return ResourceLocation.fromNamespaceAndPath(MsmpMod.MOD_ID, "textures/block/" + name + ".png");
    }

    @Override
    public ResourceLocation getAnimationResource(PlushieItem animatable) {
        String name = ForgeRegistries.ITEMS.getKey(animatable).getPath();
        return ResourceLocation.fromNamespaceAndPath(MsmpMod.MOD_ID, "animations/" + name + ".animation.json");
    }
}