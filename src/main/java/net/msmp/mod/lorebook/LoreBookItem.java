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

        // A abertura de GUI (Tela) só acontece no Cliente
        if (level.isClientSide) {
            openBookScreen();
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

    // Marcamos como OnlyIn(Dist.CLIENT) para não quebrar o servidor dedicado
    @OnlyIn(Dist.CLIENT)
    private void openBookScreen() {
        // 1. Criamos uma "cópia falsa" de um Livro Escrito do Minecraft
        ItemStack book = new ItemStack(Items.WRITTEN_BOOK);

        // 2. Criamos as Tags NBT (os dados do livro)
        CompoundTag nbt = new CompoundTag();

        nbt.putString("title", "Guia do MSMP"); // Título interno
        nbt.putString("author", "Equipe MSMP"); // Autor

        // 3. Criamos as Páginas
        ListTag pages = new ListTag();

        // PÁGINA 1
        // O texto deve estar em formato JSON de Chat. Use § para cores simples ou formatação JSON.
        pages.add(StringTag.valueOf("{\"text\":\"Bem-vindo ao Mod MSMP!\\n\\nEste livro contem os segredos antigos da nossa civilizacao.\\n\\nClique na seta para virar a pagina.\"}"));

        // PÁGINA 2
        pages.add(StringTag.valueOf("{\"text\":\"Capitulo 1: O Fungo Vinho\\n\\nEste fungo raro pode ser encontrado em cavernas e tem propriedades alucinogenas...\"}"));

        // PÁGINA 3 (Exemplo com cor vermelha)
        pages.add(StringTag.valueOf("{\"text\":\"PERIGO!\\n\\nNao toque na agua escura.\",\"color\":\"red\",\"bold\":true}"));

        // Adiciona as páginas e coloca o NBT no livro falso
        nbt.put("pages", pages);
        book.setTag(nbt);

        // 4. Força o jogo a abrir a tela de leitura com nosso livro falso
        Minecraft.getInstance().setScreen(new BookViewScreen(new BookViewScreen.WrittenBookAccess(book)));
    }
}
