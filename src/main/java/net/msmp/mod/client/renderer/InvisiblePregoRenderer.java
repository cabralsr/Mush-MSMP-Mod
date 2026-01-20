package net.msmp.mod.client.renderer;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.msmp.mod.entity.projectile.PregoEntity;

public class InvisiblePregoRenderer extends ArrowRenderer<PregoEntity> {
    public InvisiblePregoRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(PregoEntity pEntity) {
        return null;
    }

    // SOBRESCREVEMOS O RENDER PARA NÃO DESENHAR NADA
    @Override
    public void render(PregoEntity pEntity, float pEntityYaw, float pPartialTicks, com.mojang.blaze3d.vertex.PoseStack pMatrixStack, net.minecraft.client.renderer.MultiBufferSource pBuffer, int pPackedLight) {

    }
}
