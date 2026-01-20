package net.msmp.mod.event;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.client.ClientThirstData;

public class ThirstHudOverlay {

    private static final ResourceLocation FILLED_THIRST = ResourceLocation.fromNamespaceAndPath(MsmpMod.MOD_ID,
            "textures/gui/thirst_filled.png");

    private static final ResourceLocation EMPTY_THIRST = ResourceLocation.fromNamespaceAndPath(MsmpMod.MOD_ID,
            "textures/gui/thirst_empty.png");

    public static final IGuiOverlay HUD_THIRST = ((gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        int xCentro = screenWidth / 2;
        int yBase = screenHeight;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        int thirst = ClientThirstData.getPlayerThirst();

        if(Minecraft.getInstance().player == null ||
                Minecraft.getInstance().player.isCreative() ||
                Minecraft.getInstance().player.isSpectator()) {
            return;
        }


        int xFixo = xCentro - 91 - 15;


        int yInicial = yBase - 12;

        for(int i = 0; i < 10; i++) {

            int xPos = xFixo;

            int yPos = yInicial - (i * 8);

            RenderSystem.setShaderTexture(0, EMPTY_THIRST);
            guiGraphics.blit(EMPTY_THIRST, xPos, yPos, 0, 0, 9, 9, 9, 9);

            // 2. Desenha o Cheio
            if(thirst > i * 2) {
                RenderSystem.setShaderTexture(0, FILLED_THIRST);
                guiGraphics.blit(FILLED_THIRST, xPos, yPos, 0, 0, 9, 9, 9, 9);
            }
        }
    });
}