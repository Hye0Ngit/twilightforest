// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.stronghold;

import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import java.util.Random;
import net.minecraft.world.gen.feature.structure.StructurePiece;

public class KnightStones extends StructurePiece.BlockSelector
{
    public void func_75062_a(final Random random, final int x, final int y, final int z, final boolean edge) {
        if (!edge) {
            this.field_151562_a = Blocks.field_150350_a.func_176223_P();
        }
        else {
            final float f = random.nextFloat();
            if (f < 0.2f) {
                this.field_151562_a = ((Block)TFBlocks.underbrick_cracked.get()).func_176223_P();
            }
            else if (f < 0.5f) {
                this.field_151562_a = ((Block)TFBlocks.underbrick_mossy.get()).func_176223_P();
            }
            else {
                this.field_151562_a = ((Block)TFBlocks.underbrick.get()).func_176223_P();
            }
        }
    }
}
