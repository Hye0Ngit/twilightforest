// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.minotaurmaze;

import net.minecraft.block.Block;
import twilightforest.block.TFBlocks;
import net.minecraft.world.World;
import java.util.List;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import twilightforest.structures.StructureTFComponent;

public class ComponentTFMazeUpperEntrance extends StructureTFComponent
{
    private int averageGroundLevel;
    
    public ComponentTFMazeUpperEntrance() {
        this.averageGroundLevel = -1;
    }
    
    public ComponentTFMazeUpperEntrance(final int i, final Random rand, final int x, final int y, final int z) {
        super(i);
        this.averageGroundLevel = -1;
        this.field_74885_f = rand.nextInt(4);
        this.field_74887_e = new StructureBoundingBox(x, y, z, x + 15, y + 4, z + 15);
    }
    
    public void func_74861_a(final StructureComponent structurecomponent, final List list, final Random random) {
    }
    
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        this.func_74880_a(world, sbb, rand, 0.7f, 0, 5, 0, 15, 5, 15, TFBlocks.mazestone.field_71990_ca, 0, true);
        this.func_74872_a(world, sbb, 0, 0, 0, 15, 0, 15, TFBlocks.mazestone.field_71990_ca, 6, 0, 0, false);
        this.func_74872_a(world, sbb, 0, 1, 0, 15, 1, 15, TFBlocks.mazestone.field_71990_ca, 3, 0, 0, true);
        this.func_74872_a(world, sbb, 0, 2, 0, 15, 3, 15, TFBlocks.mazestone.field_71990_ca, 1, 0, 0, true);
        this.func_74872_a(world, sbb, 0, 4, 0, 15, 4, 15, TFBlocks.mazestone.field_71990_ca, 3, 0, 0, true);
        this.func_74880_a(world, sbb, rand, 0.2f, 0, 0, 0, 15, 5, 15, Block.field_71940_F.field_71990_ca, 0, true);
        this.func_74884_a(world, sbb, 6, 1, 0, 9, 4, 0, Block.field_72031_aZ.field_71990_ca, 0, false);
        this.func_74878_a(world, sbb, 7, 1, 0, 8, 3, 0);
        this.func_74884_a(world, sbb, 6, 1, 15, 9, 4, 15, Block.field_72031_aZ.field_71990_ca, 0, false);
        this.func_74878_a(world, sbb, 7, 1, 15, 8, 3, 15);
        this.func_74884_a(world, sbb, 0, 1, 6, 0, 4, 9, Block.field_72031_aZ.field_71990_ca, 0, false);
        this.func_74878_a(world, sbb, 0, 1, 7, 0, 3, 8);
        this.func_74884_a(world, sbb, 15, 1, 6, 15, 4, 9, Block.field_72031_aZ.field_71990_ca, 0, false);
        this.func_74878_a(world, sbb, 15, 1, 7, 15, 3, 8);
        this.func_74878_a(world, sbb, 1, 1, 1, 14, 4, 14);
        this.func_74872_a(world, sbb, 5, 1, 5, 10, 1, 10, TFBlocks.mazestone.field_71990_ca, 3, 0, 0, false);
        this.func_74872_a(world, sbb, 5, 4, 5, 10, 4, 10, TFBlocks.mazestone.field_71990_ca, 3, 0, 0, false);
        this.func_74880_a(world, sbb, rand, 0.7f, 5, 2, 5, 10, 3, 10, Block.field_72002_bp.field_71990_ca, 0, false);
        this.func_74878_a(world, sbb, 6, 0, 6, 9, 4, 9);
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
