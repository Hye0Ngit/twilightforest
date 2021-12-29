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
        this.f = rand.nextInt(4);
        this.e = new aee(x, y, z, x + 6 - 1, y + 14, z + 6 - 1);
    }
    
    public void a(final agq structurecomponent, final List list, final Random random) {
    }
    
    public boolean a(final zv world, final Random rand, final aee sbb) {
        if (this.averageGroundLevel < 0) {
            this.averageGroundLevel = this.getAverageGroundLevel(world, sbb);
            if (this.averageGroundLevel < 0) {
                return true;
            }
            this.e.a(0, this.averageGroundLevel - this.e.e + 12 - 1, 0);
        }
        this.a(world, sbb, 0, -10, 0, 5, 30, 5, TFBlocks.mazestone.cz, 1, 0, 0, true);
        this.a(world, sbb, 1, -10, 1, 4, 30, 4);
        return true;
    }
    
    protected int getAverageGroundLevel(final zv par1World, final aee par2StructureBoundingBox) {
        int var3 = 0;
        int var4 = 0;
        for (int var5 = this.e.c; var5 <= this.e.f; ++var5) {
            for (int var6 = this.e.a; var6 <= this.e.d; ++var6) {
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
