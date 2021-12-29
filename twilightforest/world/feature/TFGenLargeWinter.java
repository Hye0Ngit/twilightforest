// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.block.state.IBlockState;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraftforge.common.IPlantable;
import twilightforest.block.TFBlocks;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockOldLog;
import net.minecraft.init.Blocks;

public class TFGenLargeWinter extends TFTreeGenerator
{
    public TFGenLargeWinter() {
        this(false);
    }
    
    public TFGenLargeWinter(final boolean notify) {
        super(notify);
        this.treeState = Blocks.field_150364_r.func_176223_P().func_177226_a((IProperty)BlockOldLog.field_176301_b, (Comparable)BlockPlanks.EnumType.SPRUCE);
        this.branchState = Blocks.field_150364_r.func_176223_P().func_177226_a((IProperty)BlockOldLog.field_176301_b, (Comparable)BlockPlanks.EnumType.SPRUCE).func_177226_a((IProperty)BlockLog.field_176299_a, (Comparable)BlockLog.EnumAxis.NONE);
        this.leafState = Blocks.field_150362_t.func_176223_P().func_177226_a((IProperty)BlockOldLeaf.field_176239_P, (Comparable)BlockPlanks.EnumType.SPRUCE).func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false);
        this.rootState = TFBlocks.root.func_176223_P();
        this.source = (IPlantable)Blocks.field_150345_g;
    }
    
    public boolean func_180709_b(final World world, final Random random, final BlockPos pos) {
        int treeHeight = 35;
        if (random.nextInt(3) == 0) {
            treeHeight += random.nextInt(10);
            if (random.nextInt(8) == 0) {
                treeHeight += random.nextInt(10);
            }
        }
        if (pos.func_177956_o() >= 256 - treeHeight) {
            return false;
        }
        final IBlockState state = world.func_180495_p(pos.func_177977_b());
        if (!state.func_177230_c().canSustainPlant(state, (IBlockAccess)world, pos.func_177977_b(), EnumFacing.UP, this.source)) {
            return false;
        }
        this.buildTrunk(world, pos, treeHeight);
        this.makeLeaves(world, pos, treeHeight);
        final int numRoots = 4 + random.nextInt(3);
        final float offset = random.nextFloat();
        for (int b = 0; b < numRoots; ++b) {
            this.buildRoot(world, pos, offset, b);
        }
        return true;
    }
    
    private void makeLeaves(final World world, final BlockPos pos, final int treeHeight) {
        final int offGround = 3;
        final int leafType = 1;
        for (int dy = 0; dy < treeHeight; ++dy) {
            final int radius = this.leafRadius(treeHeight, dy, leafType);
            TFGenerator.makeLeafCircle2(this, world, pos.func_177981_b(offGround + treeHeight - dy), radius, this.leafState, false);
            this.makePineBranches(world, pos.func_177981_b(offGround + treeHeight - dy), radius);
        }
    }
    
    private void makePineBranches(final World world, final BlockPos pos, final int radius) {
        final int branchLength = (radius > 4) ? (radius - 1) : (radius - 2);
        switch (pos.func_177956_o() % 2) {
            case 0: {
                for (int i = 1; i <= branchLength; ++i) {
                    this.func_175903_a(world, pos.func_177982_a(-i, 0, 0), this.branchState.func_177226_a((IProperty)BlockOldLog.field_176299_a, (Comparable)BlockLog.EnumAxis.X));
                    this.func_175903_a(world, pos.func_177982_a(0, 0, i + 1), this.branchState.func_177226_a((IProperty)BlockOldLog.field_176299_a, (Comparable)BlockLog.EnumAxis.Z));
                    this.func_175903_a(world, pos.func_177982_a(i + 1, 0, 1), this.branchState.func_177226_a((IProperty)BlockOldLog.field_176299_a, (Comparable)BlockLog.EnumAxis.X));
                    this.func_175903_a(world, pos.func_177982_a(1, 0, -i), this.branchState.func_177226_a((IProperty)BlockOldLog.field_176299_a, (Comparable)BlockLog.EnumAxis.Z));
                }
                break;
            }
            case 1: {
                for (int i = 1; i <= branchLength; ++i) {
                    this.func_175903_a(world, pos.func_177982_a(-1, 0, 1), this.branchState.func_177226_a((IProperty)BlockOldLog.field_176299_a, (Comparable)BlockLog.EnumAxis.X));
                    this.func_175903_a(world, pos.func_177982_a(1, 0, i + 1), this.branchState.func_177226_a((IProperty)BlockOldLog.field_176299_a, (Comparable)BlockLog.EnumAxis.Z));
                    this.func_175903_a(world, pos.func_177982_a(i + 1, 0, 0), this.branchState.func_177226_a((IProperty)BlockOldLog.field_176299_a, (Comparable)BlockLog.EnumAxis.X));
                    this.func_175903_a(world, pos.func_177982_a(0, 0, -i), this.branchState.func_177226_a((IProperty)BlockOldLog.field_176299_a, (Comparable)BlockLog.EnumAxis.Z));
                }
                break;
            }
        }
    }
    
    private int leafRadius(final int treeHeight, final int dy, final int functionType) {
        switch (functionType) {
            default: {
                return (dy - 1) % 4;
            }
            case 1: {
                return (int)(4.0f * dy / treeHeight + 0.75f * dy % 3.0f);
            }
            case 99: {
                return (treeHeight - dy / 2 - 1) % 4;
            }
        }
    }
    
    private void buildTrunk(final World world, final BlockPos pos, final int treeHeight) {
        for (int dy = 0; dy < treeHeight; ++dy) {
            this.func_175903_a(world, pos.func_177982_a(0, dy, 0), this.treeState);
            this.func_175903_a(world, pos.func_177982_a(1, dy, 0), this.treeState);
            this.func_175903_a(world, pos.func_177982_a(0, dy, 1), this.treeState);
            this.func_175903_a(world, pos.func_177982_a(1, dy, 1), this.treeState);
        }
    }
}
