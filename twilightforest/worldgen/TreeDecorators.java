// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.worldgen;

import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.state.Property;
import net.minecraft.util.Direction;
import twilightforest.block.FireflyBlock;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.blockstateprovider.BlockStateProvider;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.gen.blockstateprovider.WeightedBlockStateProvider;
import twilightforest.worldgen.treeplacers.TrunkSideDecorator;
import twilightforest.worldgen.treeplacers.TreeRootsDecorator;

public final class TreeDecorators
{
    public static final TreeRootsDecorator LIVING_ROOTS;
    public static final TrunkSideDecorator FIREFLY;
    
    static {
        LIVING_ROOTS = new TreeRootsDecorator(3, 1, 5, (BlockStateProvider)new WeightedBlockStateProvider().func_227407_a_(BlockConstants.ROOTS, 6).func_227407_a_(((Block)TFBlocks.liveroot_block.get()).func_176223_P(), 1));
        FIREFLY = new TrunkSideDecorator(1, 1.0f, (BlockStateProvider)new SimpleBlockStateProvider((BlockState)((Block)TFBlocks.firefly.get()).func_176223_P().func_206870_a((Property)FireflyBlock.field_176387_N, (Comparable)Direction.NORTH)));
    }
}
