// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.registration;

import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import twilightforest.block.FireflyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.util.random.SimpleWeightedRandomList;
import twilightforest.world.components.feature.trees.treeplacers.TrunkSideDecorator;
import twilightforest.world.components.feature.trees.treeplacers.TreeRootsDecorator;

public final class TreeDecorators
{
    public static final TreeRootsDecorator LIVING_ROOTS;
    public static final TrunkSideDecorator FIREFLY;
    
    static {
        LIVING_ROOTS = new TreeRootsDecorator(3, 1, 5, (BlockStateProvider)new WeightedStateProvider(new SimpleWeightedRandomList.Builder().m_146271_((Object)BlockConstants.ROOTS, 6).m_146271_((Object)((Block)TFBlocks.LIVEROOT_BLOCK.get()).m_49966_(), 1).m_146270_()));
        FIREFLY = new TrunkSideDecorator(1, 1.0f, (BlockStateProvider)new SimpleStateProvider((BlockState)((Block)TFBlocks.FIREFLY.get()).m_49966_().m_61124_((Property)FireflyBlock.FACING, (Comparable)Direction.NORTH)));
    }
}
