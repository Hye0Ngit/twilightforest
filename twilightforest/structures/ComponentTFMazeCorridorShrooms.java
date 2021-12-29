// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.block.Block;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;

public class ComponentTFMazeCorridorShrooms extends ComponentTFMazeCorridor
{
    public ComponentTFMazeCorridorShrooms(final int i, final int x, final int y, final int z, final int rotation) {
        super(i, x, y, z, rotation);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        for (int x = 1; x < 5; ++x) {
            for (int z = 0; z < 5; ++z) {
                if (rand.nextInt(2) > 0) {
                    this.func_74864_a(world, Block.field_71994_by.field_71990_ca, 0, x, 0, z, sbb);
                }
                if (rand.nextInt(2) > 0) {
                    this.func_74864_a(world, rand.nextBoolean() ? Block.field_72103_ag.field_71990_ca : Block.field_72109_af.field_71990_ca, 0, x, 1, z, sbb);
                }
            }
        }
        int mushType = rand.nextBoolean() ? Block.field_72001_bo.field_71990_ca : Block.field_72000_bn.field_71990_ca;
        int mushY = rand.nextInt(4) + 1;
        int mushZ = rand.nextInt(4) + 1;
        this.func_74864_a(world, mushType, 15, 1, mushY - 1, mushZ, sbb);
        this.func_74872_a(world, sbb, 1, 1, mushZ, 1, mushY, mushZ, mushType, 10, 0, 0, false);
        this.func_74872_a(world, sbb, 1, mushY, mushZ - 1, 2, mushY, mushZ + 1, mushType, 14, 0, 0, false);
        mushType = ((mushType == Block.field_72000_bn.field_71990_ca) ? Block.field_72001_bo.field_71990_ca : Block.field_72000_bn.field_71990_ca);
        mushY = rand.nextInt(4) + 1;
        mushZ = rand.nextInt(4) + 1;
        this.func_74872_a(world, sbb, 4, 1, mushZ, 4, mushY, mushZ, mushType, 10, 0, 0, false);
        this.func_74872_a(world, sbb, 3, mushY, mushZ - 1, 4, mushY, mushZ + 1, mushType, 14, 0, 0, false);
        return true;
    }
}
