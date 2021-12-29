// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import twilightforest.block.TFBlocks;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureTFMazeStones extends StructureComponent.BlockSelector
{
    public void func_75062_a(final Random par1Random, final int par2, final int par3, final int par4, final boolean wall) {
        if (!wall) {
            this.field_151562_a = Blocks.field_150350_a;
            this.field_75065_b = 0;
        }
        else {
            this.field_151562_a = TFBlocks.mazestone;
            final float rf = par1Random.nextFloat();
            if (rf < 0.2f) {
                this.field_75065_b = 5;
            }
            else if (rf < 0.5f) {
                this.field_75065_b = 4;
            }
            else {
                this.field_75065_b = 1;
            }
        }
    }
}
