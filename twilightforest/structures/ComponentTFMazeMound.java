// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.List;
import java.util.Random;

public class ComponentTFMazeMound extends StructureTFComponent
{
    public static final int DIAMETER = 35;
    private int averageGroundLevel;
    private ComponentTFMazeUpperEntrance mazeAbove;
    
    public ComponentTFMazeMound(final int i, final Random rand, final int x, final int y, final int z) {
        super(i);
        this.averageGroundLevel = -1;
        this.f = rand.nextInt(4);
        this.e = new acg(x, y, z, x + 35, y + 8, z + 35);
    }
    
    public void a(final aes structurecomponent, final List list, final Random random) {
        super.a(structurecomponent, list, random);
        list.add(this.mazeAbove = new ComponentTFMazeUpperEntrance(3, random, this.e.a + 10, this.e.b + 1, this.e.c + 10));
        this.mazeAbove.a(this, list, random);
    }
    
    public boolean a(final xv world, final Random rand, final acg sbb) {
        if (this.averageGroundLevel < 0) {
            this.averageGroundLevel = this.getAverageGroundLevel(world, sbb);
            if (this.averageGroundLevel < 0) {
                return true;
            }
            final int offset = this.averageGroundLevel - this.e.e + 8 - 1;
            this.e.a(0, offset, 0);
            this.mazeAbove.b().a(0, offset, 0);
        }
        for (int x = 0; x < 35; ++x) {
            for (int z = 0; z < 35; ++z) {
                final int cx = x - 17;
                final int cz = z - 17;
                final int dist = (int)Math.sqrt(cx * cx + cz * cz);
                final int hheight = (int)(Math.cos(dist / 35.0 * 3.141592653589793) * 11.0);
                if ((cx > 2 || cx < -1 || cz > 2 || cz < -1) && (((cx > 2 || cx < -1) && (cz > 2 || cz < -1)) || hheight > 6)) {
                    this.a(world, amj.x.cm, 0, x, hheight, z, sbb);
                    if ((cx > 2 || cx < -1) && (cz > 2 || cz < -1)) {
                        this.b(world, amj.y.cm, 0, x, hheight - 1, z, sbb);
                    }
                    else if (hheight > 6) {
                        this.a(world, sbb, x, 6, z, x, hheight - 1, z, amj.y.cm, 0, false);
                    }
                }
            }
        }
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
