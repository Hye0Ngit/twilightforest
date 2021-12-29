// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;
import java.util.Random;
import net.minecraft.world.gen.structure.StructurePieceBlockSelector;

public class StructureTFTowerWoods extends StructurePieceBlockSelector
{
    public void func_75062_a(final Random par1Random, final int x, final int y, final int z, final boolean isWall) {
        if (!isWall) {
            this.field_75066_a = 0;
            this.field_75065_b = 0;
        }
        else {
            this.field_75066_a = TFBlocks.towerWood.field_71990_ca;
            final float randFloat = par1Random.nextFloat();
            if (randFloat < 0.1f) {
                this.field_75065_b = 2;
            }
            else if (randFloat < 0.2f) {
                this.field_75065_b = 3;
            }
            else if (randFloat < 0.225f) {
                this.field_75065_b = 4;
            }
            else {
                this.field_75065_b = 0;
            }
        }
    }
}
