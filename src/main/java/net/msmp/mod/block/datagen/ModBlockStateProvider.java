package net.msmp.mod.block.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.msmp.mod.MsmpMod;
import net.msmp.mod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MsmpMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        //PLACAS
        signBlock(((StandingSignBlock) ModBlocks.MUSH_SIGN_MNPC01.get()), ((WallSignBlock) ModBlocks.MUSH_WALL_SIGN_MNPC01.get()),
                blockTexture(Blocks.OAK_SIGN));

        signBlock(((StandingSignBlock) ModBlocks.MUSH_SIGN_MNPC02.get()), ((WallSignBlock) ModBlocks.MUSH_WALL_SIGN_MNPC02.get()),
                blockTexture(Blocks.OAK_SIGN));

        signBlock(((StandingSignBlock) ModBlocks.MUSH_SIGN_MNPC03.get()), ((WallSignBlock) ModBlocks.MUSH_WALL_SIGN_MNPC03.get()),
                blockTexture(Blocks.OAK_SIGN));

        signBlock(((StandingSignBlock) ModBlocks.MUSH_SIGN_MNPC04.get()), ((WallSignBlock) ModBlocks.MUSH_WALL_SIGN_MNPC04.get()),
                blockTexture(Blocks.OAK_SIGN));

        signBlock(((StandingSignBlock) ModBlocks.MUSH_SIGN_MNPC05.get()), ((WallSignBlock) ModBlocks.MUSH_WALL_SIGN_MNPC05.get()),
                blockTexture(Blocks.OAK_SIGN));

        signBlock(((StandingSignBlock) ModBlocks.MUSH_SIGN_MNPC06.get()), ((WallSignBlock) ModBlocks.MUSH_WALL_SIGN_MNPC05.get()),
                blockTexture(Blocks.OAK_SIGN));

        signBlock(((StandingSignBlock) ModBlocks.MUSH_SIGN_MNPC07.get()), ((WallSignBlock) ModBlocks.MUSH_WALL_SIGN_MNPC07.get()),
                blockTexture(Blocks.OAK_SIGN));

        signBlock(((StandingSignBlock) ModBlocks.MUSH_SIGN_MNPC08.get()), ((WallSignBlock) ModBlocks.MUSH_WALL_SIGN_MNPC08.get()),
                blockTexture(Blocks.OAK_SIGN));

        signBlock(((StandingSignBlock) ModBlocks.MUSH_SIGN_MNPC09.get()), ((WallSignBlock) ModBlocks.MUSH_WALL_SIGN_MNPC09.get()),
                blockTexture(Blocks.OAK_SIGN));

        signBlock(((StandingSignBlock) ModBlocks.MUSH_SIGN_MNPC10.get()), ((WallSignBlock) ModBlocks.MUSH_WALL_SIGN_MNPC10.get()),
                blockTexture(Blocks.OAK_SIGN));

    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ResourceLocation textures) {
        ModelFile sign = models().sign(name(signBlock), textures);
        hangingSignBlock(signBlock, wallSignBlock, sign);
    }

    public void hangingSignBlock(Block signBlock, Block wallSignBlock, ModelFile sign) {
        simpleBlock(signBlock, sign);
        simpleBlock(wallSignBlock, sign);
    }

    private  String name(Block block) {
        return key(block).getPath();
    }

    private ResourceLocation key(Block block){
        return ForgeRegistries.BLOCKS.getKey(block);
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(),
                new ModelFile.UncheckedModelFile(MsmpMod.MOD_ID + ":block/"
                        + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

