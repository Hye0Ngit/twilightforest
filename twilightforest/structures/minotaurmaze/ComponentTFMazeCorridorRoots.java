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
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFMazeCorridorRoots extends ComponentTFMazeCorridor
{
    public ComponentTFMazeCorridorRoots() {
    }
    
    public ComponentTFMazeCorridorRoots(final TFFeature feature, final int i, final int x, final int y, final int z, final EnumFacing rotation) {
        super(feature, i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (int x = 1; x < 5; ++x) {
            for (int z = 0; z < 5; ++z) {
                final int freq = x;
                if (rand.nextInt(freq + 2) > 0) {
                    final int length = rand.nextInt(6);
                    this.func_175811_a(world, Blocks.field_150346_d.func_176223_P(), x, 6, z, sbb);
                    for (int y = 6 - length; y < 6; ++y) {
                        this.func_175811_a(world, TFBlocks.twilight_plant.func_176223_P().func_177226_a((IProperty)BlockTFPlant.VARIANT, (Comparable)PlantVariant.ROOT_STRAND), x, y, z, sbb);
                    }
                    if (rand.nextInt(freq + 1) > 1) {
                        this.func_175811_a(world, Blocks.field_150351_n.func_176223_P(), x, 1, z, sbb);
                        if (rand.nextInt(freq + 1) > 1) {
                            this.func_175811_a(world, Blocks.field_150351_n.func_176223_P(), x, 2, z, sbb);
                        }
                    }
                }
            }
        }
        return true;
    }
}
