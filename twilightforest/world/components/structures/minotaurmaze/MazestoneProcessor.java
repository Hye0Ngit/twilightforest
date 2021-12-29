// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.minotaurmaze;

import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePiece;

public class MazestoneProcessor extends StructurePiece.BlockSelector
{
    public void m_7889_(final Random random, final int x, final int y, final int z, final boolean wall) {
        if (!wall) {
            this.f_73553_ = Blocks.f_50016_.m_49966_();
        }
        else {
            this.f_73553_ = ((Block)TFBlocks.MAZESTONE.get()).m_49966_();
            final float rf = random.nextFloat();
            if (rf < 0.2f) {
                this.f_73553_ = ((Block)TFBlocks.MOSSY_MAZESTONE.get()).m_49966_();
            }
            else if (rf < 0.5f) {
                this.f_73553_ = ((Block)TFBlocks.CRACKED_MAZESTONE.get()).m_49966_();
            }
            else {
                this.f_73553_ = ((Block)TFBlocks.MAZESTONE_BRICK.get()).m_49966_();
            }
        }
    }
}
