package net.legendarydev.legendarymod.datagen;

import net.legendarydev.legendarymod.LegendaryMod;
import net.legendarydev.legendarymod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, LegendaryMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        createSimpleBlockWithItem(ModBlocks.TITANIUM_BLOCK);
    }
    private <T extends Block> void createSimpleBlockWithItem(DeferredBlock<T> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));

    }
}
