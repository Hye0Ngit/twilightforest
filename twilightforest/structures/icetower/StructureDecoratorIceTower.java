// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import twilightforest.structures.StructureTFStrongholdStones;
import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import twilightforest.structures.StructureTFDecorator;

public class StructureDecoratorIceTower extends StructureTFDecorator
{
    public StructureDecoratorIceTower() {
        this.blockID = TFBlocks.auroraBrick.field_71990_ca;
        this.blockMeta = 0;
        this.accentID = Block.field_71988_x.field_71990_ca;
        this.accentMeta = 2;
        this.fenceID = Block.field_72031_aZ.field_71990_ca;
        this.stairID = Block.field_72074_bW.field_71990_ca;
        this.pillarID = Block.field_71951_J.field_71990_ca;
        this.pillarMeta = 2;
        this.platformID = Block.field_72092_bO.field_71990_ca;
        this.platformMeta = 2;
        this.floorID = Block.field_71988_x.field_71990_ca;
        this.floorMeta = 2;
        this.randomBlocks = new StructureTFStrongholdStones();
    }
}
