// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import twilightforest.structures.StructureTFDecorator;

public class StructureTFDecoratorStronghold extends StructureTFDecorator
{
    public StructureTFDecoratorStronghold() {
        this.blockID = TFBlocks.underBrick.field_71990_ca;
        this.blockMeta = 0;
        this.accentID = TFBlocks.underBrick.field_71990_ca;
        this.accentMeta = 3;
        this.fenceID = Block.field_82515_ce.field_71990_ca;
        this.stairID = Block.field_71995_bx.field_71990_ca;
        this.pillarID = Block.field_72007_bm.field_71990_ca;
        this.pillarMeta = 1;
        this.platformID = Block.field_72079_ak.field_71990_ca;
        this.platformMeta = 13;
        this.randomBlocks = new StructureTFKnightStones();
    }
}
