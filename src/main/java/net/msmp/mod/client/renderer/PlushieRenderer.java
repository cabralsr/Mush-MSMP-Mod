package net.msmp.mod.client.renderer;

import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.msmp.mod.block.entity.custom.PlushieBlockEntity;
import net.msmp.mod.client.model.PlushieModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class PlushieRenderer extends GeoBlockRenderer<PlushieBlockEntity> {
    public PlushieRenderer(BlockEntityRendererProvider.Context context) {
        super(new PlushieModel());
    }
}