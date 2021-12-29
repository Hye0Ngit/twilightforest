// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.icetower;

import net.minecraft.state.Property;
import twilightforest.block.AuroraBrickBlock;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import java.util.Random;
import net.minecraft.world.gen.feature.structure.StructurePiece;

public class IceTowerProcessor extends StructurePiece.BlockSelector
{
    public void func_75062_a(final Random random, final int x, final int y, final int z, final boolean wall) {
        if (!wall) {
            this.field_151562_a = Blocks.field_150350_a.func_176223_P();
        }
        else {
            this.field_151562_a = (BlockState)((Block)TFBlocks.aurora_block.get()).func_176223_P().func_206870_a((Property)AuroraBrickBlock.VARIANT, (Comparable)(Math.abs(x + z) % 16));
        }
    }
}
