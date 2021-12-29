// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.properties.IProperty;
import twilightforest.enums.PlantVariant;
import twilightforest.block.BlockTFPlant;
import twilightforest.block.TFBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;
import twilightforest.TFFeature;

public class ComponentTFMazeRoomCollapse extends ComponentTFMazeRoom
{
    public ComponentTFMazeRoomCollapse() {
    }
    
    public ComponentTFMazeRoomCollapse(final TFFeature feature, final int i, final Random rand, final int x, final int y, final int z) {
        super(feature, i, rand, x, y, z);
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
                    this.func_175804_a(world, sbb, x, 1, z, x, gravel, z, Blocks.field_150351_n.func_176223_P(), ComponentTFMazeRoomCollapse.AIR, false);
                    this.func_74878_a(world, sbb, x, gravel, z, x, gravel + 5, z);
                }
                else if (root > 0) {
                    this.func_175804_a(world, sbb, x, 5, z, x, 5 + root, z, Blocks.field_150346_d.func_176223_P(), ComponentTFMazeRoomCollapse.AIR, true);
                    this.func_175804_a(world, sbb, x, 5 - rand.nextInt(5), z, x, 5, z, TFBlocks.twilight_plant.func_176223_P().func_177226_a((IProperty)BlockTFPlant.VARIANT, (Comparable)PlantVariant.ROOT_STRAND), ComponentTFMazeRoomCollapse.AIR, false);
                }
                else if (rand.nextInt(dist + 1) > 0) {
                    this.func_74878_a(world, sbb, x, 5, z, x, 5, z);
                }
            }
        }
        return true;
    }
}
