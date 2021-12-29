// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures.hollowtree;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockLog;
import twilightforest.block.TFBlocks;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.TFFeature;

public class ComponentTFHollowTreeSmallBranch extends ComponentTFHollowTreeMedBranch
{
    public ComponentTFHollowTreeSmallBranch() {
    }
    
    protected ComponentTFHollowTreeSmallBranch(final TFFeature feature, final int i, final int sx, final int sy, final int sz, final double length, final double angle, final double tilt, final boolean leafy) {
        super(feature, i, sx, sy, sz, length, angle, tilt, leafy);
    }
    
    @Override
    public boolean func_74875_a(final World world, final Random random, final StructureBoundingBox sbb) {
        return this.addComponentParts(world, random, sbb, false);
    }
    
    @Override
    public boolean addComponentParts(final World world, final Random random, final StructureBoundingBox sbb, final boolean drawLeaves) {
        final BlockPos rSrc = this.src.func_177982_a(-this.field_74887_e.field_78897_a, -this.field_74887_e.field_78895_b, -this.field_74887_e.field_78896_c);
        final BlockPos rDest = this.dest.func_177982_a(-this.field_74887_e.field_78897_a, -this.field_74887_e.field_78895_b, -this.field_74887_e.field_78896_c);
        if (!drawLeaves) {
            final IBlockState log = TFBlocks.twilight_log.func_176223_P().func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.NONE);
            this.drawBresehnam(world, sbb, rSrc.func_177958_n(), rSrc.func_177956_o(), rSrc.func_177952_p(), rDest.func_177958_n(), rDest.func_177956_o(), rDest.func_177952_p(), log);
        }
        else {
            final int leafRad = random.nextInt(2) + 1;
            this.makeLeafBlob(world, sbb, rDest.func_177958_n(), rDest.func_177956_o(), rDest.func_177952_p(), leafRad);
        }
        return true;
    }
}
