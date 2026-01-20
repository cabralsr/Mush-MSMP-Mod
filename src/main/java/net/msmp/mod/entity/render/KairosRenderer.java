package net.msmp.mod.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.msmp.mod.entity.custom.KairosEntity;
import net.msmp.mod.entity.custom.KairosModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class KairosRenderer extends GeoEntityRenderer<KairosEntity> {
    public KairosRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new KairosModel());
        this.shadowRadius = 0.5f;
    }
}
