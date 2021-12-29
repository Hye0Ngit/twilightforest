// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.lichtower;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Blocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFFeature;

public class ComponentTFTowerRoofGableForwards extends ComponentTFTowerRoof
{
    public ComponentTFTowerRoofGableForwards() {
    }
    
    public ComponentTFTowerRoofGableForwards(final TFFeature feature, final int i, final ComponentTFTowerWing wing) {
        super(feature, i, wing);
        this.func_186164_a(wing.func_186165_e());
        this.size = wing.size + 2;
        this.height = this.size;
        this.makeAttachedOverhangBB(wing);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random rand, final StructureBoundingBox sbb) {
        final IBlockState birchSlab = Blocks.field_150376_bx.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.BIRCH);
        final IBlockState birchPlanks = Blocks.field_150344_f.func_176223_P().func_177226_a((IProperty)BlockPlanks.field_176383_a, (Comparable)BlockPlanks.EnumType.BIRCH);
        final int slopeChange = this.slopeChangeForSize(this.size);
        for (int y = 0; y <= this.height; ++y) {
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
            for (int x = 0; x <= this.size - 2; ++x) {
                for (int z = min; z <= max; ++z) {
                    if (z == min || z == max) {
                        this.func_175811_a(world, birchPlanks, x, y, z, sbb);
                    }
                    else if (x < this.size - 2) {
                        this.func_175811_a(world, birchPlanks, x, y, z, sbb);
                    }
                }
            }
        }
        final int top = this.size + 1 - slopeChange;
        final int zMid = this.size / 2;
        this.func_175811_a(world, birchSlab.func_177226_a((IProperty)BlockSlab.field_176554_a, (Comparable)BlockSlab.EnumBlockHalf.TOP), this.size - 1, top - 1, zMid, sbb);
        this.func_175811_a(world, birchSlab, 0, top, zMid, sbb);
        this.func_175811_a(world, birchSlab, this.size - 3, top, zMid, sbb);
        this.func_175811_a(world, birchPlanks, this.size - 2, top, zMid, sbb);
        this.func_175811_a(world, birchPlanks, this.size - 1, top, zMid, sbb);
        this.func_175811_a(world, birchPlanks, this.size - 1, top + 1, zMid, sbb);
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
