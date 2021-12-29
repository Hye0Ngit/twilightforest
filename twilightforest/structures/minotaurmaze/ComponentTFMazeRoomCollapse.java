// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import twilightforest.block.TFBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;

public class ComponentTFMazeRoomCollapse extends ComponentTFMazeRoom
{
    public ComponentTFMazeRoomCollapse() {
    }
    
    public ComponentTFMazeRoomCollapse(final int i, final Random rand, final int x, final int y, final int z) {
        super(i, rand, x, y, z);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        for (int x = 1; x < 14; ++x) {
            for (int z = 1; z < 14; ++z) {
                final int dist = (int)Math.round(7.0 / Math.sqrt((7.5 - x) * (7.5 - x) + (7.5 - z) * (7.5 - z)));
                int gravel = rand.nextInt(dist);
                final int root = rand.nextInt(dist);
                if (gravel > 0) {
                    ++gravel;
                    this.func_151549_a(world, sbb, x, 1, z, x, gravel, z, Blocks.field_150351_n, Blocks.field_150350_a, false);
                    this.func_74878_a(world, sbb, x, gravel, z, x, gravel + 5, z);
                }
                else if (root > 0) {
                    this.func_151549_a(world, sbb, x, 5, z, x, 5 + root, z, Blocks.field_150346_d, Blocks.field_150350_a, true);
                    this.func_151556_a(world, sbb, x, 5 - rand.nextInt(5), z, x, 5, z, TFBlocks.plant, 14, Blocks.field_150350_a, 0, false);
                }
                else if (rand.nextInt(dist + 1) > 0) {
                    this.func_74878_a(world, sbb, x, 5, z, x, 5, z);
                }
            }
        }
        return true;
    }
}
