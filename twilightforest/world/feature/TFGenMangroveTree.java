// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import java.util.Iterator;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.BlockLeaves;
import twilightforest.enums.LeavesVariant;
import twilightforest.block.BlockTFLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.WoodVariant;
import twilightforest.block.BlockTFLog;
import twilightforest.block.TFBlocks;
import com.google.common.collect.Lists;
import java.util.List;

public class TFGenMangroveTree extends TFTreeGenerator
{
    private boolean checkForWater;
    private List<LeafBlob> leaves;
    
    public TFGenMangroveTree() {
        this(false);
    }
    
    public TFGenMangroveTree(final boolean notify) {
        super(notify);
        this.leaves = Lists.newArrayList();
        this.checkForWater = !notify;
        this.treeState = TFBlocks.twilight_log.func_176223_P().func_177226_a((IProperty)BlockTFLog.VARIANT, (Comparable)WoodVariant.MANGROVE);
        this.branchState = this.treeState.func_177226_a((IProperty)BlockTFLog.field_176299_a, (Comparable)BlockLog.EnumAxis.NONE);
        this.leafState = TFBlocks.twilight_leaves.func_176223_P().func_177226_a((IProperty)BlockTFLeaves.VARIANT, (Comparable)LeavesVariant.MANGROVE).func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false);
        this.rootState = TFBlocks.root.func_176223_P();
    }
    
    protected void func_175903_a(final World worldIn, final BlockPos pos, final IBlockState state) {
        if (this.func_150523_a(worldIn.func_180495_p(pos).func_177230_c())) {
            super.func_175903_a(worldIn, pos, state);
        }
    }
    
    public boolean func_180709_b(final World world, final Random random, final BlockPos pos) {
        if (pos.func_177956_o() >= 109 || (this.checkForWater && world.func_180495_p(pos.func_177977_b()).func_177230_c() != Blocks.field_150355_j)) {
            return false;
        }
        this.leaves.clear();
        this.buildBranch(world, random, pos, 5, 6 + random.nextInt(3), 0.0, 0.0, true);
        final int numBranches = random.nextInt(3);
        double offset = random.nextDouble();
        for (int b = 0; b < numBranches; ++b) {
            this.buildBranch(world, random, pos, 7 + b, 6 + random.nextInt(2), 0.3 * b + offset, 0.25, false);
        }
        for (final LeafBlob blob : this.leaves) {
            this.makeLeafBlob(world, blob.pos, blob.size);
        }
        final int numRoots = 3 + random.nextInt(2);
        offset = random.nextDouble();
        for (int i = 0; i < numRoots; ++i) {
            final double rTilt = 0.75 + random.nextDouble() * 0.1;
            this.buildRoot(world, pos, 5, 12.0, 0.4 * i + offset, rTilt);
        }
        this.addFirefly(world, pos, 5 + random.nextInt(5), random.nextDouble());
        return true;
    }
    
    private void makeLeafBlob(final World world, final BlockPos pos, final int size) {
        TFGenerator.makeLeafCircle(this, world, pos.func_177977_b(), size - 1, this.leafState, false);
        TFGenerator.makeLeafCircle(this, world, pos, size, this.leafState, false);
        TFGenerator.makeLeafCircle(this, world, pos.func_177984_a(), size - 2, this.leafState, false);
    }
    
    private void buildBranch(final World world, final Random random, final BlockPos pos, final int height, final double length, final double angle, final double tilt, final boolean trunk) {
        final BlockPos src = pos.func_177981_b(height);
        final BlockPos dest = TFGenerator.translate(src, length, angle, tilt);
        final int bSize = 2 + random.nextInt(3);
        if (world.func_175697_a(dest, bSize + 1)) {
            TFGenerator.drawBresehnam(this, world, src, dest, trunk ? this.treeState : this.branchState);
            if (bSize > 2) {
                this.func_175903_a(world, dest.func_177974_f(), this.branchState);
                this.func_175903_a(world, dest.func_177976_e(), this.branchState);
                this.func_175903_a(world, dest.func_177968_d(), this.branchState);
                this.func_175903_a(world, dest.func_177978_c(), this.branchState);
            }
            this.leaves.add(new LeafBlob(dest, bSize));
        }
    }
    
    private void buildRoot(final World world, final BlockPos pos, final int height, final double length, final double angle, final double tilt) {
        final BlockPos src = pos.func_177981_b(height);
        final BlockPos dest = TFGenerator.translate(src, length, angle, tilt);
        if (world.func_175697_a(dest, 1)) {
            final BlockPos[] lineArray = TFGenerator.getBresehnamArrays(src, dest);
            boolean stillAboveGround = true;
            for (final BlockPos coord : lineArray) {
                if (stillAboveGround && TFGenerator.hasAirAround(world, coord)) {
                    this.func_175903_a(world, coord, this.branchState);
                    this.func_175903_a(world, coord.func_177977_b(), this.branchState);
                }
                else {
                    this.placeRootBlock(world, coord, this.rootState);
                    this.placeRootBlock(world, coord.func_177977_b(), this.rootState);
                    stillAboveGround = false;
                }
            }
        }
    }
    
    private class LeafBlob
    {
        BlockPos pos;
        int size;
        
        public LeafBlob(final BlockPos pos, final int size) {
            this.pos = pos;
            this.size = size;
        }
    }
}
