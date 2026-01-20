package net.msmp.mod.client.model;

import net.minecraft.resources.ResourceLocation;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.item.GasMaskItem;
import software.bernie.geckolib.model.GeoModel;

public class GasMaskModel extends GeoModel<GasMaskItem> {

    @Override
    public ResourceLocation getModelResource(GasMaskItem object) {
        return ResourceLocation.fromNamespaceAndPath(MsmpMod.MOD_ID, "geo/gas_mask.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GasMaskItem object) {
        return ResourceLocation.fromNamespaceAndPath(MsmpMod.MOD_ID, "textures/armor/gas_mask.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GasMaskItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(MsmpMod.MOD_ID, "animations/gas_mask.animation.json");
    }
}