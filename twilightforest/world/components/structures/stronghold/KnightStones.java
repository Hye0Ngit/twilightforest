// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures.stronghold;

import twilightforest.block.TFBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePiece;

public class KnightStones extends StructurePiece.BlockSelector
{
    public void m_7889_(final Random random, final int x, final int y, final int z, final boolean edge) {
        if (!edge) {
            this.f_73553_ = Blocks.f_50016_.m_49966_();
        }
        else {
            final float f = random.nextFloat();
            if (f < 0.2f) {
                this.f_73553_ = ((Block)TFBlocks.CRACKED_UNDERBRICK.get()).m_49966_();
            }
            else if (f < 0.5f) {
                this.f_73553_ = ((Block)TFBlocks.MOSSY_UNDERBRICK.get()).m_49966_();
            }
            else {
                this.f_73553_ = ((Block)TFBlocks.UNDERBRICK.get()).m_49966_();
            }
        }
    }
}
