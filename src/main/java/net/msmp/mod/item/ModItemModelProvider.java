package net.msmp.mod.item;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.msmp.mod.MsmpMod;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MsmpMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // --- CÓDIGO PARA O OVO DE SPAWN ---
        // Esta linha diz ao jogo para usar o modelo padrão de ovo de spawn para o seu item.
        withExistingParent(ModItems.CLICKER_SPAWN_EGG.getId().getPath(), "item/template_spawn_egg");

        // --- EXEMPLO PARA ITENS SIMPLES (se você tiver outros) ---
        // simpleItem(ModItems.NOME_DO_SEU_ITEM);
    }

    // Método auxiliar para itens simples (opcional, mas útil)
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                // Correção para o aviso em "item/generated"
                ResourceLocation.fromNamespaceAndPath("minecraft", "item/generated"))
                .texture("layer0",
                        // Correção para o aviso no seu item customizado
                        ResourceLocation.fromNamespaceAndPath(MsmpMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
