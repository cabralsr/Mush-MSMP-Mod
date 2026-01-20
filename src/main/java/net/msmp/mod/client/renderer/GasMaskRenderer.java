package net.msmp.mod.client.renderer;

import net.msmp.mod.client.model.GasMaskModel;
import net.msmp.mod.item.GasMaskItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class GasMaskRenderer extends GeoArmorRenderer<GasMaskItem> {
    public GasMaskRenderer() {
        super(new GasMaskModel());
    }
}