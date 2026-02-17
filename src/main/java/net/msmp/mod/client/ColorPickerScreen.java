package net.msmp.mod.client;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractSliderButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.msmp.mod.network.ModMessages;
import net.msmp.mod.network.UpdateColorPacket;

public class ColorPickerScreen extends Screen {

    private float red = 0.0F;
    private float green = 0.0F;
    private float blue = 0.0F;

    private int currentColor = 0x000000;

    public ColorPickerScreen() {
        super(Component.literal("Personalize a Cor do seu Chat"));
    }

    @Override
    protected void init() {
        super.init();

        int centerX = this.width / 2;
        int startY = this.height / 2 - 20;

        this.addRenderableWidget(new AbstractSliderButton(centerX - 75, startY, 150, 20, Component.literal("Vermelho: 0"), 0.0D) {
            @Override
            protected void updateMessage() {
                this.setMessage(Component.literal("§cVermelho: " + (int)(this.value * 255)));
            }
            @Override
            protected void applyValue() {
                red = (float) this.value;
                updateColorPreview();
            }
        });

        this.addRenderableWidget(new AbstractSliderButton(centerX - 75, startY + 25, 150, 20, Component.literal("Verde: 0"), 0.0D) {
            @Override
            protected void updateMessage() {
                this.setMessage(Component.literal("§aVerde: " + (int)(this.value * 255)));
            }
            @Override
            protected void applyValue() {
                green = (float) this.value;
                updateColorPreview();
            }
        });

        this.addRenderableWidget(new AbstractSliderButton(centerX - 75, startY + 50, 150, 20, Component.literal("Azul: 0"), 0.0D) {
            @Override
            protected void updateMessage() {
                this.setMessage(Component.literal("§9Azul: " + (int)(this.value * 255)));
            }
            @Override
            protected void applyValue() {
                blue = (float) this.value;
                updateColorPreview();
            }
        });

        this.addRenderableWidget(Button.builder(Component.literal("§lConfirmar Cor"), button -> {
            ModMessages.sendToServer(new UpdateColorPacket(this.currentColor));
            this.minecraft.setScreen(null);
        }).bounds(centerX - 50, startY + 85, 100, 20).build());
    }

    private void updateColorPreview() {
        int r = (int) (this.red * 255);
        int g = (int) (this.green * 255);
        int b = (int) (this.blue * 255);
        this.currentColor = (r << 16) | (g << 8) | b;
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(graphics);

        int centerX = this.width / 2;
        int previewY = this.height / 2 - 80;

        graphics.drawCenteredString(this.font, this.title, centerX, 15, 0xFFFFFF);

        graphics.drawCenteredString(this.font, Component.literal("Sua Cor:"), centerX, previewY - 15, 0xAAAAAA);

        int boxSize = 40;
        graphics.fill(centerX - boxSize/2 - 2, previewY - 2, centerX + boxSize/2 + 2, previewY + boxSize + 2, 0xFF000000);
        graphics.fill(centerX - boxSize/2, previewY, centerX + boxSize/2, previewY + boxSize, 0xFF000000 | this.currentColor);

        super.render(graphics, mouseX, mouseY, partialTick);
    }

    @Override
    public void renderBackground(GuiGraphics graphics) {
        graphics.fillGradient(0, 0, this.width, this.height, -1072689136, -804253680);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}