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

public class ComponentTFTowerRoofSlabForwards extends ComponentTFTowerRoofSlab
{
    public ComponentTFTowerRoofSlabForwards() {
    }
    
    public ComponentTFTowerRoofSlabForwards(final TFFeature feature, final int i, final ComponentTFTowerWing wing) {
        super(feature, i, wing);
        this.func_186164_a(wing.func_186165_e());
        this.size = wing.size + 2;
        this.height = this.size / 2;
        this.makeAttachedOverhangBB(wing);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final IBlockState birchSlab = Blocks.field_150376_bx.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.BIRCH);
        final IBlockState birchDoubleSlab = Blocks.field_150373_bw.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.BIRCH);
        for (int y = 0; y <= this.height; ++y) {
            final int min = 2 * y;
            for (int max = this.size - 2 * y - 1, x = 0; x <= max - 1; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == max - 1 || z == min || z == max) {
                        this.func_175811_a(world, birchSlab, x, y, z, sbb);
                    }
                    else {
                        this.func_175811_a(world, birchDoubleSlab, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
}
