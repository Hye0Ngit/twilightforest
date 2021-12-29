// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFMazeDeadEndShrooms extends ComponentTFMazeDeadEndRoots
{
    public ComponentTFMazeDeadEndShrooms() {
    }
    
    public ComponentTFMazeDeadEndShrooms(final int i, final int x, final int y, final int z, final int rotation) {
        super(i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (int x = 1; x < 5; ++x) {
            for (int z = 0; z < 5; ++z) {
                if (rand.nextInt(z + 2) > 0) {
                    this.func_151550_a(world, (Block)Blocks.field_150391_bh, 0, x, 0, z, sbb);
                }
                if (rand.nextInt(z + 2) > 0) {
                    this.func_151550_a(world, (Block)(rand.nextBoolean() ? Blocks.field_150337_Q : Blocks.field_150338_P), 0, x, 1, z, sbb);
                }
            }
        }
        Block mushType = rand.nextBoolean() ? Blocks.field_150419_aX : Blocks.field_150420_aW;
        int mushY = rand.nextInt(4) + 1;
        int mushZ = rand.nextInt(3) + 1;
        this.func_151550_a(world, mushType, 15, 1, mushY - 1, mushZ, sbb);
        this.func_151556_a(world, sbb, 1, 1, mushZ, 1, mushY, mushZ, mushType, 10, Blocks.field_150350_a, 0, false);
        this.func_151556_a(world, sbb, 1, mushY, mushZ - 1, 2, mushY, mushZ + 1, mushType, 14, Blocks.field_150350_a, 0, false);
        mushType = ((mushType == Blocks.field_150420_aW) ? Blocks.field_150419_aX : Blocks.field_150420_aW);
        mushY = rand.nextInt(4) + 1;
        mushZ = rand.nextInt(3) + 1;
        this.func_151556_a(world, sbb, 4, 1, mushZ, 4, mushY, mushZ, mushType, 10, Blocks.field_150350_a, 0, false);
        this.func_151556_a(world, sbb, 3, mushY, mushZ - 1, 4, mushY, mushZ + 1, mushType, 14, Blocks.field_150350_a, 0, false);
        mushType = (rand.nextBoolean() ? Blocks.field_150419_aX : Blocks.field_150420_aW);
        mushY = rand.nextInt(4) + 1;
        final int mushX = rand.nextInt(3) + 2;
        this.func_151556_a(world, sbb, mushX, 1, 4, mushX, mushY, 4, mushType, 10, Blocks.field_150350_a, 0, false);
        this.func_151556_a(world, sbb, mushX - 1, mushY, 3, mushX + 1, mushY, 4, mushType, 14, Blocks.field_150350_a, 0, false);
        return true;
    }
}
