// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import net.minecraft.block.properties.IProperty;
import twilightforest.block.BlockTFAuroraBrick;
import twilightforest.block.TFBlocks;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureTFAuroraBricks extends StructureComponent.BlockSelector
{
    public void func_75062_a(final Random random, final int x, final int y, final int z, final boolean wall) {
        if (!wall) {
            this.field_151562_a = Blocks.field_150350_a.func_176223_P();
        }
        else {
            this.field_151562_a = TFBlocks.aurora_block.func_176223_P().func_177226_a((IProperty)BlockTFAuroraBrick.VARIANT, (Comparable)(Math.abs(x + z) % 16));
        }
    }
}
