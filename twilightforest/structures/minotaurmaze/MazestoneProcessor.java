// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import java.util.Random;
import net.minecraft.world.gen.feature.structure.StructurePiece;

public class MazestoneProcessor extends StructurePiece.BlockSelector
{
    public void func_75062_a(final Random random, final int x, final int y, final int z, final boolean wall) {
        if (!wall) {
            this.field_151562_a = Blocks.field_150350_a.func_176223_P();
        }
        else {
            this.field_151562_a = ((Block)TFBlocks.maze_stone.get()).func_176223_P();
            final float rf = random.nextFloat();
            if (rf < 0.2f) {
                this.field_151562_a = ((Block)TFBlocks.maze_stone_mossy.get()).func_176223_P();
            }
            else if (rf < 0.5f) {
                this.field_151562_a = ((Block)TFBlocks.maze_stone_cracked.get()).func_176223_P();
            }
            else {
                this.field_151562_a = ((Block)TFBlocks.maze_stone_brick.get()).func_176223_P();
            }
        }
    }
}
