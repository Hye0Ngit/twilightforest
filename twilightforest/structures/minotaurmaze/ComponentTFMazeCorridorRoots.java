// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFMazeCorridorRoots extends ComponentTFMazeCorridor
{
    public ComponentTFMazeCorridorRoots() {
    }
    
    public ComponentTFMazeCorridorRoots(final int i, final int x, final int y, final int z, final int rotation) {
        super(i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (int x = 1; x < 5; ++x) {
            for (int z = 0; z < 5; ++z) {
                final int freq = x;
                if (rand.nextInt(freq + 2) > 0) {
                    final int length = rand.nextInt(6);
                    this.func_74864_a(world, Block.field_71979_v.field_71990_ca, 0, x, 6, z, sbb);
                    for (int y = 6 - length; y < 6; ++y) {
                        this.func_74864_a(world, TFBlocks.plant.field_71990_ca, 14, x, y, z, sbb);
                    }
                    if (rand.nextInt(freq + 1) > 1) {
                        this.func_74864_a(world, Block.field_71940_F.field_71990_ca, 0, x, 1, z, sbb);
                        if (rand.nextInt(freq + 1) > 1) {
                            this.func_74864_a(world, Block.field_71940_F.field_71990_ca, 0, x, 2, z, sbb);
                        }
                    }
                }
            }
        }
        return true;
    }
}
