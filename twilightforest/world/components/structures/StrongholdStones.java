// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.components.structures;

import net.minecraft.world.level.block.Blocks;
import java.util.Random;
import net.minecraft.world.level.levelgen.structure.StructurePiece;

public class StrongholdStones extends StructurePiece.BlockSelector
{
    public void m_7889_(final Random random, final int x, final int y, final int z, final boolean wall) {
        if (!wall) {
            this.f_73553_ = Blocks.f_50016_.m_49966_();
        }
        else {
            final float f = random.nextFloat();
            if (f < 0.2f) {
                this.f_73553_ = Blocks.f_50224_.m_49966_();
            }
            else if (f < 0.5f) {
                this.f_73553_ = Blocks.f_50223_.m_49966_();
            }
            else if (f < 0.55f) {
                this.f_73553_ = Blocks.f_50176_.m_49966_();
            }
            else {
                this.f_73553_ = Blocks.f_50222_.m_49966_();
            }
        }
    }
}
