package net.legendarydev.legendarymod.block;

import net.legendarydev.legendarymod.LegendaryMod;
import net.legendarydev.legendarymod.item.ModItems;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(LegendaryMod.MOD_ID);

    public static final DeferredBlock<Block> TITANIUM_BLOCK = registerBlock("titanium_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .sound(SoundType.NETHERITE_BLOCK)
                    .strength(3f)
                    .requiresCorrectToolForDrops()
            ));



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> supplier){
        DeferredBlock<T> value = BLOCKS.register(name, supplier);
        registerBlockItem(value);
        return value;
    }

    private static<T extends Block> void registerBlockItem(DeferredBlock<T> deferredBlock){
        ModItems.ITEMS.registerSimpleBlockItem(deferredBlock);
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
