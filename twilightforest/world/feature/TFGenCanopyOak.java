// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import java.util.Iterator;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.EnumFacing;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.BlockLog;
import twilightforest.block.BlockTFLog;
import twilightforest.block.TFBlocks;
import com.google.common.collect.Lists;
import net.minecraft.util.math.BlockPos;
import java.util.List;

public class TFGenCanopyOak extends TFGenCanopyTree
{
    private List<BlockPos> leaves;
    
    public TFGenCanopyOak() {
        this(false);
    }
    
    public TFGenCanopyOak(final boolean notify) {
        super(notify);
        this.leaves = Lists.newArrayList();
        this.treeState = TFBlocks.twilight_log.func_176223_P();
        this.branchState = this.treeState.func_177226_a((IProperty)BlockTFLog.field_176299_a, (Comparable)BlockLog.EnumAxis.NONE);
        this.leafState = TFBlocks.twilight_leaves.func_176223_P().func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false);
        this.rootState = TFBlocks.root.func_176223_P();
    }
    
    @Override
    public boolean func_180709_b(final World world, final Random random, final BlockPos pos) {
        int treeHeight = this.minHeight;
        if (random.nextInt(this.chanceAddFirstFive) == 0) {
            treeHeight += random.nextInt(5);
            if (random.nextInt(this.chanceAddSecondFive) == 0) {
                treeHeight += random.nextInt(5);
            }
        }
        if (pos.func_177956_o() >= 256 - treeHeight) {
            return false;
        }
        final IBlockState state = world.func_180495_p(pos.func_177977_b());
        if (!state.func_177230_c().canSustainPlant(state, (IBlockAccess)world, pos.func_177977_b(), EnumFacing.UP, this.source)) {
            return false;
        }
        this.leaves.clear();
        this.buildTrunk(world, pos, treeHeight);
        final int numBranches = 12 + random.nextInt(9);
        float bangle = random.nextFloat();
        for (int b = 0; b < numBranches; ++b) {
            final float btilt = 0.15f + random.nextFloat() * 0.35f;
            this.buildBranch(world, pos, treeHeight - 10 + b / 2, 5.0, bangle, btilt, false, random);
            bangle += random.nextFloat() * 0.4f;
            if (bangle > 1.0f) {
                --bangle;
            }
        }
        for (final BlockPos leafPos : this.leaves) {
            this.makeLeafBlob(world, leafPos);
        }
        this.makeRoots(world, random, pos);
        this.makeRoots(world, random, pos.func_177974_f());
        this.makeRoots(world, random, pos.func_177968_d());
        this.makeRoots(world, random, pos.func_177974_f().func_177968_d());
        return true;
    }
    
    private void makeLeafBlob(final World world, final BlockPos leafPos) {
        TFGenerator.drawLeafBlob(this, world, leafPos, 2, this.leafState);
    }
    
    private void makeRoots(final World world, final Random random, final BlockPos pos) {
        if (TFGenerator.hasAirAround(world, pos.func_177977_b())) {
            this.func_175903_a(world, pos.func_177977_b(), this.treeState);
        }
        else {
            this.func_175903_a(world, pos.func_177977_b(), this.rootState);
        }
        final int numRoots = 1 + random.nextInt(2);
        final float offset = random.nextFloat();
        for (int b = 0; b < numRoots; ++b) {
            this.buildRoot(world, pos, offset, b);
        }
    }
    
    private void buildTrunk(final World world, final BlockPos pos, final int treeHeight) {
        for (int dy = 0; dy < treeHeight; ++dy) {
            this.func_175903_a(world, pos.func_177982_a(0, dy, 0), this.treeState);
            this.func_175903_a(world, pos.func_177982_a(1, dy, 0), this.treeState);
            this.func_175903_a(world, pos.func_177982_a(0, dy, 1), this.treeState);
            this.func_175903_a(world, pos.func_177982_a(1, dy, 1), this.treeState);
        }
        this.leaves.add(pos.func_177982_a(0, treeHeight, 0));
    }
    
    @Override
    void buildBranch(final World world, final BlockPos pos, final int height, final double length, final double angle, final double tilt, final boolean trunk, final Random treeRNG) {
        final BlockPos src = pos.func_177981_b(height);
        BlockPos dest = TFGenerator.translate(src, length, angle, tilt);
        final int limit = 5;
        if (dest.func_177958_n() - pos.func_177958_n() < -limit) {
            dest = new BlockPos(pos.func_177958_n() - limit, dest.func_177956_o(), dest.func_177952_p());
        }
        if (dest.func_177958_n() - pos.func_177958_n() > limit) {
            dest = new BlockPos(pos.func_177958_n() + limit, dest.func_177956_o(), dest.func_177952_p());
        }
        if (dest.func_177952_p() - pos.func_177952_p() < -limit) {
            dest = new BlockPos(dest.func_177958_n(), dest.func_177956_o(), pos.func_177952_p() - limit);
        }
        if (dest.func_177952_p() - pos.func_177952_p() > limit) {
            dest = new BlockPos(dest.func_177958_n(), dest.func_177956_o(), pos.func_177952_p() + limit);
        }
        TFGenerator.drawBresehnam(this, world, src, dest, trunk ? this.treeState : this.branchState);
        this.func_175903_a(world, dest.func_177974_f(), this.branchState);
        this.func_175903_a(world, dest.func_177976_e(), this.branchState);
        this.func_175903_a(world, dest.func_177978_c(), this.branchState);
        this.func_175903_a(world, dest.func_177968_d(), this.branchState);
        this.leaves.add(dest);
    }
}
