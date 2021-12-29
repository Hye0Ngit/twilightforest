// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import net.minecraft.block.Block;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.World;
import java.util.Random;

public class ComponentTFMazeMushRoom extends ComponentTFMazeRoom
{
    public ComponentTFMazeMushRoom(final int i, final Random rand, final int x, final int y, final int z) {
        super(i, rand, x, y, z);
        this.field_74885_f = 0;
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        super.func_74875_a(world, rand, sbb);
        for (int x = 1; x < 14; ++x) {
            for (int z = 1; z < 14; ++z) {
                final int dist = (int)Math.round(7.0 / Math.sqrt((7.5 - x) * (7.5 - x) + (7.5 - z) * (7.5 - z)));
                if (rand.nextInt(dist + 1) > 0) {
                    this.func_74864_a(world, Block.field_71994_by.field_71990_ca, 0, x, 0, z, sbb);
                }
                if (rand.nextInt(dist) > 0) {
                    this.func_74864_a(world, rand.nextBoolean() ? Block.field_72103_ag.field_71990_ca : Block.field_72109_af.field_71990_ca, 0, x, 1, z, sbb);
                }
            }
        }
        this.makeMediumMushroom(world, sbb, 5, 2, 9, Block.field_72001_bo.field_71990_ca);
        this.makeMediumMushroom(world, sbb, 5, 3, 9, Block.field_72001_bo.field_71990_ca);
        this.makeMediumMushroom(world, sbb, 9, 2, 5, Block.field_72001_bo.field_71990_ca);
        this.makeMediumMushroom(world, sbb, 6, 3, 4, Block.field_72000_bn.field_71990_ca);
        this.makeMediumMushroom(world, sbb, 10, 1, 9, Block.field_72000_bn.field_71990_ca);
        this.func_74864_a(world, Block.field_72001_bo.field_71990_ca, 15, 1, 2, 1, sbb);
        this.func_74864_a(world, Block.field_72001_bo.field_71990_ca, 5, 1, 3, 1, sbb);
        this.func_74864_a(world, Block.field_72001_bo.field_71990_ca, 9, 2, 3, 1, sbb);
        this.func_74864_a(world, Block.field_72001_bo.field_71990_ca, 9, 1, 3, 2, sbb);
        this.func_74864_a(world, Block.field_72000_bn.field_71990_ca, 15, 14, 3, 1, sbb);
        this.func_74864_a(world, Block.field_72000_bn.field_71990_ca, 5, 14, 4, 1, sbb);
        this.func_74864_a(world, Block.field_72000_bn.field_71990_ca, 7, 13, 4, 1, sbb);
        this.func_74864_a(world, Block.field_72000_bn.field_71990_ca, 7, 14, 4, 2, sbb);
        this.func_74864_a(world, Block.field_72000_bn.field_71990_ca, 15, 1, 1, 14, sbb);
        this.func_74864_a(world, Block.field_72000_bn.field_71990_ca, 5, 1, 2, 14, sbb);
        this.func_74864_a(world, Block.field_72000_bn.field_71990_ca, 3, 2, 2, 14, sbb);
        this.func_74864_a(world, Block.field_72000_bn.field_71990_ca, 3, 1, 2, 13, sbb);
        this.func_74864_a(world, Block.field_72000_bn.field_71990_ca, 5, 14, 1, 14, sbb);
        this.func_74864_a(world, Block.field_72000_bn.field_71990_ca, 1, 13, 1, 14, sbb);
        this.func_74864_a(world, Block.field_72000_bn.field_71990_ca, 1, 14, 1, 13, sbb);
        return true;
    }
    
    private void makeMediumMushroom(final World world, final StructureBoundingBox sbb, final int mx, final int my, final int mz, final int blockID) {
        this.func_74864_a(world, blockID, 5, mx + 0, my, mz + 0, sbb);
        this.func_74864_a(world, blockID, 6, mx + 1, my, mz + 0, sbb);
        this.func_74864_a(world, blockID, 9, mx + 1, my, mz + 1, sbb);
        this.func_74864_a(world, blockID, 8, mx + 0, my, mz + 1, sbb);
        this.func_74864_a(world, blockID, 7, mx - 1, my, mz + 1, sbb);
        this.func_74864_a(world, blockID, 4, mx - 1, my, mz + 0, sbb);
        this.func_74864_a(world, blockID, 1, mx - 1, my, mz - 1, sbb);
        this.func_74864_a(world, blockID, 2, mx + 0, my, mz - 1, sbb);
        this.func_74864_a(world, blockID, 3, mx + 1, my, mz - 1, sbb);
        for (int y = 1; y < my; ++y) {
            this.func_74864_a(world, blockID, 10, mx + 0, y, mz + 0, sbb);
        }
    }
}
