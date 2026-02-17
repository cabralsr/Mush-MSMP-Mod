package net.msmp.mod.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.msmp.mod.entity.custom.TestEntity;
import net.msmp.mod.entity.custom.TestModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TesteRenderer extends GeoEntityRenderer<TestEntity> {
    public TesteRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TestModel());
        this.shadowRadius = 0.5f;
    }
}
