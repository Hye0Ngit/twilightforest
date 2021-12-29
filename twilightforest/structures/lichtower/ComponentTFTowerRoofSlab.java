// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;
import net.minecraft.init.Blocks;
import net.minecraft.block.BlockPlanks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFFeature;

public class ComponentTFTowerRoofSlab extends ComponentTFTowerRoof
{
    public ComponentTFTowerRoofSlab() {
    }
    
    public ComponentTFTowerRoofSlab(final TFFeature feature, final int i, final ComponentTFTowerWing wing) {
        super(feature, i, wing);
        this.func_186164_a(wing.func_186165_e());
        this.size = wing.size;
        this.height = this.size / 2;
        this.makeCapBB(wing);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final BlockPlanks.EnumType woodType = BlockPlanks.EnumType.BIRCH;
        return this.makePyramidCap(world, woodType, sbb);
    }
    
    protected boolean makePyramidCap(final World world, final BlockPlanks.EnumType woodType, final StructureBoundingBox sbb) {
        final IBlockState woodenSlab = Blocks.field_150376_bx.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)woodType);
        final IBlockState woodenPlanks = Blocks.field_150344_f.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)woodType);
        for (int y = 0; y <= this.height; ++y) {
            final int min = 2 * y;
            for (int max = this.size - 2 * y - 1, x = min; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == min || x == max || z == min || z == max) {
                        this.func_175811_a(world, woodenSlab, x, y, z, sbb);
                    }
                    else {
                        this.func_175811_a(world, woodenPlanks, x, y, z, sbb);
                    }
                }
            }
        }
        return true;
    }
    
    protected boolean makeConnectedCap(final World world, final BlockPlanks.EnumType woodType, final StructureBoundingBox sbb) {
        final IBlockState woodenSlab = Blocks.field_150376_bx.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)woodType);
        final IBlockState woodenPlanks = Blocks.field_150344_f.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)woodType);
        for (int y = 0; y < this.height; ++y) {
            final int min = 2 * y;
            for (int max = this.size - 2 * y - 1, x = 0; x <= max; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (x == max || z == min || z == max) {
                        this.func_175811_a(world, woodenSlab, x, y, z, sbb);
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
