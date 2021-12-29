// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;
import java.util.Random;

public class StructureTFMazeStones extends air
{
    public void a(final Random par1Random, final int par2, final int par3, final int par4, final boolean wall) {
        if (!wall) {
            this.a = 0;
            this.b = 0;
        }
        else {
            this.a = TFBlocks.mazestone.cF;
            final float rf = par1Random.nextFloat();
            if (rf < 0.2f) {
                this.b = 5;
            }
            else if (rf < 0.5f) {
                this.b = 4;
            }
            else {
                this.b = 1;
            }
        }
    }
}
