// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import net.minecraft.state.Property;
import net.minecraft.util.Direction;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import twilightforest.structures.TFStructureDecorator;

public class IceTowerDecorator extends TFStructureDecorator
{
    public IceTowerDecorator() {
        this.blockState = ((Block)TFBlocks.aurora_block.get()).func_176223_P();
        this.accentState = Blocks.field_196666_p.func_176223_P();
        this.fenceState = Blocks.field_180407_aO.func_176223_P();
        this.stairState = Blocks.field_150487_bG.func_176223_P();
        this.pillarState = (BlockState)((RotatedPillarBlock)TFBlocks.aurora_pillar.get()).func_176223_P().func_206870_a((Property)RotatedPillarBlock.field_176298_M, (Comparable)Direction.Axis.Y);
        this.platformState = Blocks.field_196627_bs.func_176223_P();
        this.floorState = Blocks.field_196666_p.func_176223_P();
        this.randomBlocks = new IceTowerProcessor();
    }
}
