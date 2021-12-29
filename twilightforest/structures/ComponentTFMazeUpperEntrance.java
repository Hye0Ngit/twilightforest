// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.TFBlocks;
import java.util.List;
import java.util.Random;

public class ComponentTFMazeUpperEntrance extends StructureTFComponent
{
    private int averageGroundLevel;
    
    public ComponentTFMazeUpperEntrance(final int i, final Random rand, final int x, final int y, final int z) {
        super(i);
        this.averageGroundLevel = -1;
        this.f = rand.nextInt(4);
        this.e = new acg(x, y, z, x + 15, y + 4, z + 15);
    }
    
    public void a(final aes structurecomponent, final List list, final Random random) {
    }
    
    public boolean a(final xv world, final Random rand, final acg sbb) {
        this.a(world, sbb, rand, 0.7f, 0, 5, 0, 15, 5, 15, TFBlocks.mazestone.cm, 0, true);
        this.a(world, sbb, 0, 0, 0, 15, 0, 15, TFBlocks.mazestone.cm, 6, 0, 0, false);
        this.a(world, sbb, 0, 1, 0, 15, 1, 15, TFBlocks.mazestone.cm, 3, 0, 0, true);
        this.a(world, sbb, 0, 2, 0, 15, 3, 15, TFBlocks.mazestone.cm, 1, 0, 0, true);
        this.a(world, sbb, 0, 4, 0, 15, 4, 15, TFBlocks.mazestone.cm, 3, 0, 0, true);
        this.a(world, sbb, rand, 0.2f, 0, 0, 0, 15, 5, 15, amj.I.cm, 0, true);
        this.a(world, sbb, 6, 1, 0, 9, 4, 0, amj.bc.cm, 0, false);
        this.a(world, sbb, 7, 1, 0, 8, 3, 0);
        this.a(world, sbb, 6, 1, 15, 9, 4, 15, amj.bc.cm, 0, false);
        this.a(world, sbb, 7, 1, 15, 8, 3, 15);
        this.a(world, sbb, 0, 1, 6, 0, 4, 9, amj.bc.cm, 0, false);
        this.a(world, sbb, 0, 1, 7, 0, 3, 8);
        this.a(world, sbb, 15, 1, 6, 15, 4, 9, amj.bc.cm, 0, false);
        this.a(world, sbb, 15, 1, 7, 15, 3, 8);
        this.a(world, sbb, 1, 1, 1, 14, 4, 14);
        this.a(world, sbb, 5, 1, 5, 10, 1, 10, TFBlocks.mazestone.cm, 3, 0, 0, false);
        this.a(world, sbb, 5, 4, 5, 10, 4, 10, TFBlocks.mazestone.cm, 3, 0, 0, false);
        this.a(world, sbb, rand, 0.7f, 5, 2, 5, 10, 3, 10, amj.bs.cm, 0, false);
        this.a(world, sbb, 6, 0, 6, 9, 4, 9);
        return true;
    }
    
    protected int getAverageGroundLevel(final xv par1World, final acg par2StructureBoundingBox) {
        int var3 = 0;
        int var4 = 0;
        for (int var5 = this.e.c; var5 <= this.e.f; ++var5) {
            for (int var6 = this.e.a; var6 <= this.e.d; ++var6) {
                if (par2StructureBoundingBox.b(var6, 64, var5)) {
                    var3 += Math.max(par1World.i(var6, var5), par1World.v.i());
                    ++var4;
                }
            }
        }
        if (var4 == 0) {
            return -1;
        }
        return var3 / var4;
    }
}
