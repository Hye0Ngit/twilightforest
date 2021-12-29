// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.state.Property;
import net.minecraft.state.properties.SlabType;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import twilightforest.structures.TFStructureDecorator;

public class StrongholdDecorator extends TFStructureDecorator
{
    public StrongholdDecorator() {
        this.blockState = ((Block)TFBlocks.underbrick.get()).func_176223_P();
        this.accentState = ((Block)TFBlocks.underbrick_cracked.get()).func_176223_P();
        this.fenceState = Blocks.field_150463_bK.func_176223_P();
        this.stairState = Blocks.field_150390_bg.func_176223_P();
        this.pillarState = Blocks.field_196698_dj.func_176223_P();
        this.platformState = (BlockState)Blocks.field_222401_hJ.func_176223_P().func_206870_a((Property)SlabBlock.field_196505_a, (Comparable)SlabType.TOP);
        this.randomBlocks = new KnightStones();
    }
}
