// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;
import java.util.Random;

public class StructureTFTowerWoods extends agr
{
    public void a(final Random par1Random, final int x, final int y, final int z, final boolean isWall) {
        if (!isWall) {
            this.a = 0;
            this.b = 0;
        }
        else {
            this.a = TFBlocks.towerWood.cz;
            final float randFloat = par1Random.nextFloat();
            if (randFloat < 0.1f) {
                this.b = 2;
            }
            else if (randFloat < 0.2f) {
                this.b = 3;
            }
            else if (randFloat < 0.225f) {
                this.b = 4;
            }
            else {
                this.b = 0;
            }
        }
    }
}
