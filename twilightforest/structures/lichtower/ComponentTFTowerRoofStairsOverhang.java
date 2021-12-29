// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.util.EnumFacing;
import twilightforest.TFFeature;

public class ComponentTFTowerRoofStairsOverhang extends ComponentTFTowerRoof
{
    public ComponentTFTowerRoofStairsOverhang() {
    }
    
    public ComponentTFTowerRoofStairsOverhang(final TFFeature feature, final int i, final ComponentTFTowerWing wing) {
        super(feature, i, wing);
        this.func_186164_a(EnumFacing.SOUTH);
        this.size = wing.size + 2;
        this.height = this.size / 2;
        this.field_74887_e = new StructureBoundingBox(wing.func_74874_b().field_78897_a - 1, wing.func_74874_b().field_78894_e, wing.func_74874_b().field_78896_c - 1, wing.func_74874_b().field_78893_d + 1, wing.func_74874_b().field_78894_e + this.height - 1, wing.func_74874_b().field_78892_f + 1);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final IBlockState woodenSlab = Blocks.field_150376_bx.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.BIRCH);
        final IBlockState woodenPlanks = Blocks.field_150344_f.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.BIRCH);
        final IBlockState birchStairsNorth = Blocks.field_150487_bG.func_176223_P().func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)EnumFacing.NORTH);
        final IBlockState birchStairsSouth = Blocks.field_150487_bG.func_176223_P().func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)EnumFacing.SOUTH);
        final IBlockState birchStairsEast = Blocks.field_150487_bG.func_176223_P().func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)EnumFacing.EAST);
        final IBlockState birchStairsWest = Blocks.field_150487_bG.func_176223_P().func_177226_a((IProperty)BlockStairs.field_176309_a, (Comparable)EnumFacing.WEST);
        for (int y = 0; y <= this.height; ++y) {
            final int min = y;
            for (int max = this.size - y - 1, x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == min) {
                        if (z == min || z == max) {
                            this.func_175811_a(world, woodenSlab, x, y, z, sbb);
                        }
                        else {
                            this.func_175811_a(world, birchStairsWest, x, y, z, sbb);
                        }
                    }
                    else if (x == max) {
                        if (z == min || z == max) {
                            this.func_175811_a(world, woodenSlab, x, y, z, sbb);
                        }
                        else {
                            this.func_175811_a(world, birchStairsEast, x, y, z, sbb);
                        }
                    }
                    else if (z == max) {
                        this.func_175811_a(world, birchStairsSouth, x, y, z, sbb);
                    }
                    else if (z == min) {
                        this.func_175811_a(world, birchStairsNorth, x, y, z, sbb);
                    }
                    else {
                        this.func_175811_a(world, woodenPlanks, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
}
