// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.darktower;

import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import java.util.Random;
import net.minecraft.world.gen.feature.structure.StructurePiece;

public class TowerwoodProcessor extends StructurePiece.BlockSelector
{
    public void func_75062_a(final Random random, final int x, final int y, final int z, final boolean isWall) {
        if (!isWall) {
            this.field_151562_a = Blocks.field_150350_a.func_176223_P();
        }
        else {
            final float randFloat = random.nextFloat();
            if (randFloat < 0.1f) {
                this.field_151562_a = ((Block)TFBlocks.tower_wood_cracked.get()).func_176223_P();
            }
            else if (randFloat < 0.2f) {
                this.field_151562_a = ((Block)TFBlocks.tower_wood_mossy.get()).func_176223_P();
            }
            else if (randFloat < 0.225f) {
                this.field_151562_a = ((Block)TFBlocks.tower_wood_infested.get()).func_176223_P();
            }
            else {
                this.field_151562_a = ((Block)TFBlocks.tower_wood.get()).func_176223_P();
            }
        }
    }
}
