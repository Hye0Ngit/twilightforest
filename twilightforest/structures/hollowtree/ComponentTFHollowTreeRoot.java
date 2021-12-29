// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.hollowtree;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import twilightforest.world.feature.TFGenerator;
import net.minecraft.util.math.BlockPos;
import twilightforest.block.TFBlocks;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import twilightforest.TFFeature;
import net.minecraft.block.state.IBlockState;
import java.util.function.Predicate;

public class ComponentTFHollowTreeRoot extends ComponentTFHollowTreeMedBranch
{
    protected int groundLevel;
    protected static final Predicate<IBlockState> isGround;
    
    public ComponentTFHollowTreeRoot() {
        this.groundLevel = -1;
    }
    
    public ComponentTFHollowTreeRoot(final TFFeature feature, final int i, final int sx, final int sy, final int sz, final double length, final double angle, final double tilt, final boolean leafy) {
        super(feature, i, sx, sy, sz, length, angle, tilt, leafy);
        this.groundLevel = -1;
        this.field_74887_e = new StructureBoundingBox((Vec3i)this.src, (Vec3i)this.dest);
    }
    
    @Override
    public boolean addComponentParts(final World world, final Random random, final StructureBoundingBox sbb, final boolean drawLeaves) {
        if (!drawLeaves) {
            if (this.groundLevel < 0) {
                this.groundLevel = this.findGroundLevel(world, sbb, 90, ComponentTFHollowTreeRoot.isGround);
                if (this.groundLevel < 0) {
                    return true;
                }
                final int dy = this.groundLevel + 5 - this.src.func_177956_o();
                this.src = this.src.func_177982_a(0, dy, 0);
                this.dest = this.dest.func_177982_a(0, dy, 0);
            }
            final BlockPos rSrc = this.src.func_177982_a(-this.field_74887_e.field_78897_a, -this.field_74887_e.field_78895_b, -this.field_74887_e.field_78896_c);
            final BlockPos rDest = this.dest.func_177982_a(-this.field_74887_e.field_78897_a, -this.field_74887_e.field_78895_b, -this.field_74887_e.field_78896_c);
            this.drawRootLine(world, sbb, rSrc.func_177958_n(), rSrc.func_177956_o(), rSrc.func_177952_p(), rDest.func_177958_n(), rDest.func_177956_o(), rDest.func_177952_p(), TFBlocks.root.func_176223_P());
            this.drawRootLine(world, sbb, rSrc.func_177958_n(), rSrc.func_177956_o() - 1, rSrc.func_177952_p(), rDest.func_177958_n(), rDest.func_177956_o() - 1, rDest.func_177952_p(), TFBlocks.root.func_176223_P());
        }
        return true;
    }
    
    protected void drawRootLine(final World world, final StructureBoundingBox sbb, final int x1, final int y1, final int z1, final int x2, final int y2, final int z2, final IBlockState blockValue) {
        final BlockPos[] bresehnamArrays;
        final BlockPos[] lineCoords = bresehnamArrays = TFGenerator.getBresehnamArrays(x1, y1, z1, x2, y2, z2);
        for (final BlockPos coords : bresehnamArrays) {
            final IBlockState block = this.func_175807_a(world, coords.func_177958_n(), coords.func_177956_o(), coords.func_177952_p(), sbb);
            if (!block.func_185915_l() || (block.func_177230_c() != Blocks.field_150350_a && block.func_185904_a() == Material.field_151577_b)) {
                final IBlockState log = TFBlocks.twilight_log.func_176223_P().func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.NONE);
                this.func_175811_a(world, log, coords.func_177958_n(), coords.func_177956_o(), coords.func_177952_p(), sbb);
            }
            else if (block.func_177230_c() == Blocks.field_150350_a || block.func_185904_a() != Material.field_151575_d) {
                this.func_175811_a(world, blockValue, coords.func_177958_n(), coords.func_177956_o(), coords.func_177952_p(), sbb);
            }
        }
    }
    
    static {
        isGround = (state -> {
            final Material material = state.func_185904_a();
            return material == Material.field_151578_c || material == Material.field_151576_e || material == Material.field_151577_b;
        });
    }
}
