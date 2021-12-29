// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.finalcastle;

import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import java.util.Random;
import net.minecraft.world.gen.feature.structure.StructurePiece;

public class CastleBlockProcessor extends StructurePiece.BlockSelector
{
    public void func_75062_a(final Random random, final int x, final int y, final int z, final boolean isWall) {
        if (!isWall) {
            this.field_151562_a = Blocks.field_150350_a.func_176223_P();
        }
        else {
            final float randFloat = random.nextFloat();
            if (randFloat < 0.1f) {
                this.field_151562_a = ((Block)TFBlocks.castle_brick_worn.get()).func_176223_P();
            }
            else if (randFloat < 0.2f) {
                this.field_151562_a = ((Block)TFBlocks.castle_brick_cracked.get()).func_176223_P();
            }
            else {
                this.field_151562_a = ((Block)TFBlocks.castle_brick.get()).func_176223_P();
            }
        }
    }
}
