package net.msmp.mod.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.msmp.mod.entity.custom.RastejadorEntity;
import net.msmp.mod.entity.custom.RastejadorModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RastejadorRenderer extends GeoEntityRenderer<RastejadorEntity> {
    public RastejadorRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RastejadorModel());
        this.shadowRadius = 0.5f;
    }
}
