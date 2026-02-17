package net.msmp.mod.client.model;

import net.minecraft.resources.ResourceLocation;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.item.GasMaskItem;
import net.msmp.mod.item.GasMaskOneItem;
import software.bernie.geckolib.model.GeoModel;

public class GasMaskOneModel extends GeoModel<GasMaskOneItem> {

    @Override
    public ResourceLocation getModelResource(GasMaskOneItem object) {
        return ResourceLocation.fromNamespaceAndPath(MsmpMod.MOD_ID, "geo/gas_mask_one.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GasMaskOneItem object) {
        return ResourceLocation.fromNamespaceAndPath(MsmpMod.MOD_ID, "textures/armor/gas_mask_one.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GasMaskOneItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(MsmpMod.MOD_ID, "animations/gas_mask_one.animation.json");
    }
}