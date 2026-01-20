package net.msmp.mod.client.renderer;

import net.msmp.mod.client.model.PlushieItemModel;
import net.msmp.mod.item.PlushieItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class PlushieItemRenderer extends GeoItemRenderer<PlushieItem> {
    public PlushieItemRenderer() {
        super(new PlushieItemModel());
    }
}