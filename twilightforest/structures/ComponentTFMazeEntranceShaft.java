// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import twilightforest.block.TFBlocks;
import java.util.List;
import java.util.Random;

public class ComponentTFMazeEntranceShaft extends StructureTFComponent
{
    private int averageGroundLevel;
    
    public ComponentTFMazeEntranceShaft(final int i, final Random rand, final int x, final int y, final int z) {
        super(i);
        this.averageGroundLevel = -1;
        this.g = rand.nextInt(4);
        this.f = new age(x, y, z, x + 6 - 1, y + 14, z + 6 - 1);
    }
    
    public void a(final aiq structurecomponent, final List list, final Random random) {
    }
    
    public boolean a(final abv world, final Random rand, final age sbb) {
        if (this.averageGroundLevel < 0) {
            this.averageGroundLevel = this.getAverageGroundLevel(world, sbb);
            if (this.averageGroundLevel < 0) {
                return true;
            }
            this.f.a(0, this.averageGroundLevel - this.f.e + 12 - 1, 0);
        }
        this.a(world, sbb, 0, -10, 0, 5, 30, 5, TFBlocks.mazestone.cF, 1, 0, 0, true);
        this.a(world, sbb, 1, -10, 1, 4, 30, 4);
        System.out.println("Drawing entrance");
        final int var8 = this.a(0, 0);
        final int var9 = this.a(0);
        final int var10 = this.b(0, 0);
        System.out.println("Drawing entrance at " + var8 + ", " + var9 + ", " + var10);
        return true;
    }
    
    protected int getAverageGroundLevel(final abv par1World, final age par2StructureBoundingBox) {
        int var3 = 0;
        int var4 = 0;
        for (int var5 = this.f.c; var5 <= this.f.f; ++var5) {
            for (int var6 = this.f.a; var6 <= this.f.d; ++var6) {
                if (par2StructureBoundingBox.b(var6, 64, var5)) {
                    var3 += Math.max(par1World.i(var6, var5), par1World.t.i());
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
