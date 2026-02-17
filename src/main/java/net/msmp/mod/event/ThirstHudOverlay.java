package net.msmp.mod.event;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.client.ClientThirstData;

public class ThirstHudOverlay {

    private static final ResourceLocation FILLED_THIRST = ResourceLocation.fromNamespaceAndPath(MsmpMod.MOD_ID,
            "textures/gui/thirst_filled.png");

    private static final ResourceLocation EMPTY_THIRST = ResourceLocation.fromNamespaceAndPath(MsmpMod.MOD_ID,
            "textures/gui/thirst_empty.png");

    public static final IGuiOverlay HUD_THIRST = ((gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        Minecraft minecraft = Minecraft.getInstance();
        Player player = minecraft.player;

        if(player == null || player.isCreative() || player.isSpectator()) {
            return;
        }

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        int thirst = ClientThirstData.getPlayerThirst();

        float maxHealth = Math.max(player.getMaxHealth(), player.getHealth());
        float absorption = player.getAbsorptionAmount();
        int healthRows = (int) Math.ceil((maxHealth + absorption) / 20.0f);

        int leftHeight = 39 + (healthRows * 10);

        if (player.getArmorValue() > 0) {
            leftHeight += 10;
        }

        int yPos = screenHeight - leftHeight;

        int xFixo = (screenWidth / 2) - 91;

        for(int i = 0; i < 10; i++) {
            int xPos = xFixo + (i * 8);

            RenderSystem.setShaderTexture(0, EMPTY_THIRST);
            guiGraphics.blit(EMPTY_THIRST, xPos, yPos, 0, 0, 9, 9, 9, 9);

            if(thirst > i * 2) {
                RenderSystem.setShaderTexture(0, FILLED_THIRST);
                guiGraphics.blit(FILLED_THIRST, xPos, yPos, 0, 0, 9, 9, 9, 9);
            }
        }
    });
}