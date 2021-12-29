// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import net.minecraft.block.StairsBlock;
import net.minecraft.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import twilightforest.structures.TFStructureDecorator;

public class StructureTFDecoratorCastle extends TFStructureDecorator
{
    public StructureTFDecoratorCastle() {
        this.blockState = ((Block)TFBlocks.castle_brick.get()).func_176223_P();
        this.accentState = Blocks.field_196772_fk.func_176223_P();
        this.roofState = ((Block)TFBlocks.castle_brick_roof.get()).func_176223_P();
        this.pillarState = ((Block)TFBlocks.castle_pillar_bold.get()).func_176223_P();
        this.fenceState = Blocks.field_180407_aO.func_176223_P();
        this.stairState = ((StairsBlock)TFBlocks.castle_stairs_brick.get()).func_176223_P();
        this.randomBlocks = new CastleBlockProcessor();
    }
}
