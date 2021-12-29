// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import twilightforest.structures.StructureTFComponent;

public class ComponentTFMazeMound extends StructureTFComponent
{
    public static final int DIAMETER = 35;
    private int averageGroundLevel;
    private ComponentTFMazeUpperEntrance mazeAbove;
    
    public ComponentTFMazeMound() {
        this.averageGroundLevel = -1;
    }
    
    public ComponentTFMazeMound(final int i, final Random rand, final int x, final int y, final int z) {
        super(i);
        this.averageGroundLevel = -1;
        this.field_74885_f = rand.nextInt(4);
        this.field_74887_e = new StructureBoundingBox(x, y, z, x + 35, y + 8, z + 35);
    }
    
    public void func_74861_a(final StructureComponent structurecomponent, final List list, final Random random) {
        super.func_74861_a(structurecomponent, list, random);
        list.add(this.mazeAbove = new ComponentTFMazeUpperEntrance(3, random, this.field_74887_e.field_78897_a + 10, this.field_74887_e.field_78895_b + 1, this.field_74887_e.field_78896_c + 10));
        this.mazeAbove.func_74861_a(this, list, random);
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (this.averageGroundLevel < 0) {
            this.averageGroundLevel = this.getAverageGroundLevel(world, sbb);
            if (this.averageGroundLevel < 0) {
                return true;
            }
            final int offset = this.averageGroundLevel - this.field_74887_e.field_78894_e + 8 - 1;
            this.field_74887_e.func_78886_a(0, offset, 0);
            if (this.mazeAbove != null) {
                this.mazeAbove.func_74874_b().func_78886_a(0, offset, 0);
            }
        }
        for (int x = 0; x < 35; ++x) {
            for (int z = 0; z < 35; ++z) {
                final int cx = x - 17;
                final int cz = z - 17;
                final int dist = (int)Math.sqrt(cx * cx + cz * cz);
                final int hheight = (int)(Math.cos(dist / 35.0 * 3.141592653589793) * 11.0);
                if ((cx > 2 || cx < -1 || cz > 2 || cz < -1) && (((cx > 2 || cx < -1) && (cz > 2 || cz < -1)) || hheight > 6)) {
                    this.func_74864_a(world, Block.field_71980_u.field_71990_ca, 0, x, hheight, z, sbb);
                    if ((cx > 2 || cx < -1) && (cz > 2 || cz < -1)) {
                        this.func_74870_b(world, Block.field_71979_v.field_71990_ca, 0, x, hheight - 1, z, sbb);
                    }
                    else if (hheight > 6) {
                        this.func_74884_a(world, sbb, x, 6, z, x, hheight - 1, z, Block.field_71979_v.field_71990_ca, 0, false);
                    }
                }
            }
        }
        return true;
    }
    
    @Override
    protected int getAverageGroundLevel(final World par1World, final StructureBoundingBox par2StructureBoundingBox) {
        int var3 = 0;
        int var4 = 0;
        for (int var5 = this.field_74887_e.field_78896_c; var5 <= this.field_74887_e.field_78892_f; ++var5) {
            for (int var6 = this.field_74887_e.field_78897_a; var6 <= this.field_74887_e.field_78893_d; ++var6) {
                if (par2StructureBoundingBox.func_78890_b(var6, 64, var5)) {
                    var3 += Math.max(par1World.func_72825_h(var6, var5), par1World.field_73011_w.func_76557_i());
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
