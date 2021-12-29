// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.darktower;

import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePiece;

public class TowerwoodProcessor extends StructurePiece.BlockSelector
{
    public void m_7889_(final Random random, final int x, final int y, final int z, final boolean isWall) {
        if (!isWall) {
            this.f_73553_ = Blocks.f_50016_.m_49966_();
        }
        else {
            final float randFloat = random.nextFloat();
            if (randFloat < 0.1f) {
                this.f_73553_ = ((Block)TFBlocks.CRACKED_TOWERWOOD.get()).m_49966_();
            }
            else if (randFloat < 0.2f) {
                this.f_73553_ = ((Block)TFBlocks.MOSSY_TOWERWOOD.get()).m_49966_();
            }
            else if (randFloat < 0.225f) {
                this.f_73553_ = ((Block)TFBlocks.INFESTED_TOWERWOOD.get()).m_49966_();
            }
            else {
                this.f_73553_ = ((Block)TFBlocks.TOWERWOOD.get()).m_49966_();
            }
        }
    }
}
