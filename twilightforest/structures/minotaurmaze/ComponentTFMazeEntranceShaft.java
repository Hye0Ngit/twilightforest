// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.init.Blocks;
import twilightforest.block.TFBlocks;
import net.minecraft.world.World;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import twilightforest.structures.StructureTFComponent;

public class ComponentTFMazeEntranceShaft extends StructureTFComponent
{
    private int averageGroundLevel;
    
    public ComponentTFMazeEntranceShaft() {
        this.averageGroundLevel = -1;
    }
    
    public ComponentTFMazeEntranceShaft(final int i, final Random rand, final int x, final int y, final int z) {
        super(i);
        this.averageGroundLevel = -1;
        this.field_74885_f = rand.nextInt(4);
        this.field_74887_e = new StructureBoundingBox(x, y, z, x + 6 - 1, y + 14, z + 6 - 1);
    }
    
    public void func_74861_a(final StructureComponent structurecomponent, final List list, final Random random) {
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        if (this.averageGroundLevel < 0) {
            this.averageGroundLevel = this.getAverageGroundLevel(world, sbb);
            if (this.averageGroundLevel < 0) {
                return true;
            }
            this.field_74887_e.func_78886_a(0, this.averageGroundLevel - this.field_74887_e.field_78894_e + 15 - 1, 0);
        }
        this.func_151556_a(world, sbb, 0, -10, 0, 5, 30, 5, TFBlocks.mazestone, 1, Blocks.field_150350_a, 0, true);
        this.func_74878_a(world, sbb, 1, -10, 1, 4, 30, 4);
        final int var8 = this.func_74865_a(0, 0);
        final int var9 = this.func_74862_a(0);
        final int var10 = this.func_74873_b(0, 0);
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
