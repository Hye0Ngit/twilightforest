// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import twilightforest.block.TFBlocks;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureTFAuroraBricks extends StructureComponent.BlockSelector
{
    public void func_75062_a(final Random par1Random, final int x, final int y, final int z, final boolean wall) {
        if (!wall) {
            this.field_151562_a = Blocks.field_150350_a;
            this.field_75065_b = 0;
        }
        else {
            this.field_151562_a = TFBlocks.auroraBlock;
            this.field_75065_b = Math.abs(x + z) % 16;
        }
    }
}
