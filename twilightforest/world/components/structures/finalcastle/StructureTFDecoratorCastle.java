// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.finalcastle;

import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import twilightforest.world.components.structures.TFStructureDecorator;

public class StructureTFDecoratorCastle extends TFStructureDecorator
{
    public StructureTFDecoratorCastle() {
        this.blockState = ((Block)TFBlocks.CASTLE_BRICK.get()).m_49966_();
        this.accentState = Blocks.f_50282_.m_49966_();
        this.roofState = ((Block)TFBlocks.CASTLE_ROOF_TILE.get()).m_49966_();
        this.pillarState = ((Block)TFBlocks.BOLD_CASTLE_BRICK_PILLAR.get()).m_49966_();
        this.fenceState = Blocks.f_50132_.m_49966_();
        this.stairState = ((StairBlock)TFBlocks.CASTLE_BRICK_STAIRS.get()).m_49966_();
        this.randomBlocks = new CastleBlockProcessor();
    }
}
