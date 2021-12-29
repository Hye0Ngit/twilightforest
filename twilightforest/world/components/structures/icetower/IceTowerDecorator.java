// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.icetower;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import twilightforest.world.components.structures.TFStructureDecorator;

public class IceTowerDecorator extends TFStructureDecorator
{
    public IceTowerDecorator() {
        this.blockState = ((Block)TFBlocks.AURORA_BLOCK.get()).m_49966_();
        this.accentState = Blocks.f_50742_.m_49966_();
        this.fenceState = Blocks.f_50132_.m_49966_();
        this.stairState = Blocks.f_50270_.m_49966_();
        this.pillarState = (BlockState)((RotatedPillarBlock)TFBlocks.AURORA_PILLAR.get()).m_49966_().m_61124_((Property)RotatedPillarBlock.f_55923_, (Comparable)Direction.Axis.Y);
        this.platformState = Blocks.f_50400_.m_49966_();
        this.floorState = Blocks.f_50742_.m_49966_();
        this.randomBlocks = new IceTowerProcessor();
    }
}
