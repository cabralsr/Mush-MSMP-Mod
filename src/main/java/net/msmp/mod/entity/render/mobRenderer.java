package net.msmp.mod.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.msmp.mod.entity.custom.TestEntity;
import net.msmp.mod.entity.custom.TestModel;
import net.msmp.mod.entity.custom.mobEntity;
import net.msmp.mod.entity.custom.mobModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class mobRenderer extends GeoEntityRenderer<mobEntity> {
    public mobRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new mobModel());
        this.shadowRadius = 0.5f;
    }
}
