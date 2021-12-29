// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import twilightforest.block.TFBlocks;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureTFTowerWoods extends StructureComponent.BlockSelector
{
    public void func_75062_a(final Random par1Random, final int x, final int y, final int z, final boolean isWall) {
        if (!isWall) {
            this.field_151562_a = Blocks.field_150350_a;
            this.field_75065_b = 0;
        }
        else {
            this.field_151562_a = TFBlocks.towerWood;
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
