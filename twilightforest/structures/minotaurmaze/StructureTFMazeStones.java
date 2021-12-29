// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.properties.IProperty;
import twilightforest.enums.MazestoneVariant;
import twilightforest.block.BlockTFMazestone;
import twilightforest.block.TFBlocks;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureTFMazeStones extends StructureComponent.BlockSelector
{
    public void func_75062_a(final Random random, final int x, final int y, final int z, final boolean wall) {
        if (!wall) {
            this.field_151562_a = Blocks.field_150350_a.func_176223_P();
        }
        else {
            this.field_151562_a = TFBlocks.maze_stone.func_176223_P();
            final float rf = random.nextFloat();
            if (rf < 0.2f) {
                this.field_151562_a = this.field_151562_a.func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.MOSSY);
            }
            else if (rf < 0.5f) {
                this.field_151562_a = this.field_151562_a.func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.CRACKED);
            }
            else {
                this.field_151562_a = this.field_151562_a.func_177226_a((IProperty)BlockTFMazestone.VARIANT, (Comparable)MazestoneVariant.BRICK);
            }
        }
    }
}
