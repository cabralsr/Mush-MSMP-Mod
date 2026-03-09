package net.msmp.mod.block.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.msmp.mod.block.custom.TraderBlock;
import net.msmp.mod.block.entity.TraderBlockEntity;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class TraderBlockRenderer extends GeoBlockRenderer<TraderBlockEntity> {
    public TraderBlockRenderer(BlockEntityRendererProvider.Context context) {
        super(new TraderBlockModel());
    }

    @Override
    public RenderType getRenderType(TraderBlockEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
        return RenderType.entityTranslucent(texture);
    }

    @Override
    public void preRender(PoseStack poseStack, TraderBlockEntity animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);

        Direction facing = animatable.getBlockState().getValue(TraderBlock.FACING);

        float rotation = 0f;

        switch (facing) {
            case NORTH: rotation = 0f; break;
            case EAST: rotation = 270f; break;
            case SOUTH: rotation = 180f; break;
            case WEST: rotation = 90f; break;
        }

        poseStack.translate(0.5f, 0.0f, 0.5f);
        poseStack.mulPose(Axis.YP.rotationDegrees(rotation));
        poseStack.translate(-0.5f, 0.0f, -0.5f);
    }
}