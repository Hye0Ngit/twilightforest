// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.stronghold;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.SlabType;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import twilightforest.world.components.structures.TFStructureDecorator;

public class StrongholdDecorator extends TFStructureDecorator
{
    public StrongholdDecorator() {
        this.blockState = ((Block)TFBlocks.UNDERBRICK.get()).m_49966_();
        this.accentState = ((Block)TFBlocks.CRACKED_UNDERBRICK.get()).m_49966_();
        this.fenceState = Blocks.f_50274_.m_49966_();
        this.stairState = Blocks.f_50194_.m_49966_();
        this.pillarState = Blocks.f_50223_.m_49966_();
        this.platformState = (BlockState)Blocks.f_50405_.m_49966_().m_61124_((Property)SlabBlock.f_56353_, (Comparable)SlabType.TOP);
        this.randomBlocks = new KnightStones();
    }
}
