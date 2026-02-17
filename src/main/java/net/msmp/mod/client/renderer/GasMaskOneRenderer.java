package net.msmp.mod.client.renderer;

import net.msmp.mod.client.model.GasMaskOneModel;
import net.msmp.mod.item.GasMaskOneItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class GasMaskOneRenderer extends GeoArmorRenderer<GasMaskOneItem> {
    public GasMaskOneRenderer() {
        super(new GasMaskOneModel());
    }
}