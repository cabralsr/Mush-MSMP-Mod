package net.msmp.mod.entity.render;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.msmp.mod.entity.custom.DogZombieEntity;
import net.msmp.mod.entity.custom.DogZombieModel;
import net.msmp.mod.entity.custom.RastejadorEntity;
import net.msmp.mod.entity.custom.RastejadorModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DogZombieRenderer extends GeoEntityRenderer<DogZombieEntity> {
    public DogZombieRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DogZombieModel());
        this.shadowRadius = 0.5f;
    }
}
