package net.msmp.mod.lorebook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.BookViewScreen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class LoreBookItem extends Item {

    public LoreBookItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (level.isClientSide) {
            openBookScreen();
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

    @OnlyIn(Dist.CLIENT)
    private void openBookScreen() {
        ItemStack book = new ItemStack(Items.WRITTEN_BOOK);

        CompoundTag nbt = new CompoundTag();

        nbt.putString("title", "Guia do MSMP"); // Título interno
        nbt.putString("author", "Equipe MSMP"); // Autor

        ListTag pages = new ListTag();

        pages.add(StringTag.valueOf("{\"text\":\"Bem-vindo ao Mod MSMP!\\n\\nEste livro contem os segredos antigos da nossa civilizacao.\\n\\nClique na seta para virar a pagina.\"}"));

        pages.add(StringTag.valueOf("{\"text\":\"Capitulo 1: O Fungo Vinho\\n\\nEste fungo raro pode ser encontrado em cavernas e tem propriedades alucinogenas...\"}"));

        pages.add(StringTag.valueOf("{\"text\":\"PERIGO!\\n\\nNao toque na agua escura.\",\"color\":\"red\",\"bold\":true}"));

        nbt.put("pages", pages);
        book.setTag(nbt);

        Minecraft.getInstance().setScreen(new BookViewScreen(new BookViewScreen.WrittenBookAccess(book)));
    }
}
