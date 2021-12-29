// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFFeature;

public class ComponentTFTowerRoofPointy extends ComponentTFTowerRoof
{
    public ComponentTFTowerRoofPointy() {
    }
    
    public ComponentTFTowerRoofPointy(final TFFeature feature, final int i, final ComponentTFTowerWing wing) {
        super(feature, i, wing);
        this.func_186164_a(wing.func_186165_e());
        this.size = wing.size;
        this.height = this.size;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final IBlockState birchSlab = Blocks.field_150376_bx.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.BIRCH);
        final IBlockState birchPlanks = Blocks.field_150344_f.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.BIRCH);
        for (int y = 0; y <= this.height; ++y) {
            final int slopeChange = this.slopeChangeForSize(this.size);
            int min;
            int max;
            if (y < slopeChange) {
                min = y;
                max = this.size - y - 1;
            }
            else {
                min = (y + slopeChange) / 2;
                max = this.size - (y + slopeChange) / 2 - 1;
            }
            final int mid = min + (max - min) / 2;
            for (int x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    this.func_175811_a(world, birchPlanks, x, y, z, sbb);
                    if ((x == min && (z == min || z == max)) || (x == max && (z == min || z == max))) {
                        this.func_175811_a(world, birchSlab, x, y + 1, z, sbb);
                    }
                    if ((((x == min || x == max) && z == mid && x % 2 == 0) || ((z == min || z == max) && x == mid && z % 2 == 0)) && mid != min + 1) {
                        this.func_175811_a(world, birchSlab, x, y + 1, z, sbb);
                    }
                }
            }
        }
        return true;
    }
    
    public int slopeChangeForSize(final int pSize) {
        if (this.size > 10) {
            return 3;
        }
        if (this.size > 6) {
            return 2;
        }
        return 1;
    }
}
