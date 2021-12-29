// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import net.minecraft.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import twilightforest.structures.TFStructureDecorator;

public class StructureDecoratorDarkTower extends TFStructureDecorator
{
    public StructureDecoratorDarkTower() {
        this.blockState = ((Block)TFBlocks.tower_wood.get()).func_176223_P();
        this.accentState = ((Block)TFBlocks.tower_wood_encased.get()).func_176223_P();
        this.fenceState = Blocks.field_180407_aO.func_176223_P();
        this.stairState = Blocks.field_150485_bF.func_176223_P();
        this.pillarState = ((Block)TFBlocks.tower_wood_encased.get()).func_176223_P();
        this.platformState = ((Block)TFBlocks.tower_wood_encased.get()).func_176223_P();
        this.randomBlocks = new TowerwoodProcessor();
    }
}
