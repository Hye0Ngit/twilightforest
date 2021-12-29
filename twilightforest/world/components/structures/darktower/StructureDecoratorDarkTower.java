// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.darktower;

import net.minecraft.world.level.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import twilightforest.world.components.structures.TFStructureDecorator;

public class StructureDecoratorDarkTower extends TFStructureDecorator
{
    public StructureDecoratorDarkTower() {
        this.blockState = ((Block)TFBlocks.TOWERWOOD.get()).m_49966_();
        this.accentState = ((Block)TFBlocks.ENCASED_TOWERWOOD.get()).m_49966_();
        this.fenceState = Blocks.f_50132_.m_49966_();
        this.stairState = Blocks.f_50269_.m_49966_();
        this.pillarState = ((Block)TFBlocks.ENCASED_TOWERWOOD.get()).m_49966_();
        this.platformState = ((Block)TFBlocks.ENCASED_TOWERWOOD.get()).m_49966_();
        this.randomBlocks = new TowerwoodProcessor();
    }
}
