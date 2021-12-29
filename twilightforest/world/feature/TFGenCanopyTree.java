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
import twilightforest.enums.LeavesVariant;
import twilightforest.block.BlockTFLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.WoodVariant;
import twilightforest.block.BlockTFLog;
import twilightforest.block.TFBlocks;
import com.google.common.collect.Lists;
import net.minecraft.util.math.BlockPos;
import java.util.List;

public class TFGenCanopyTree extends TFTreeGenerator
{
    protected int minHeight;
    protected int chanceAddFirstFive;
    protected int chanceAddSecondFive;
    private List<BlockPos> leaves;
    
    public TFGenCanopyTree() {
        this(false);
    }
    
    public TFGenCanopyTree(final boolean notify) {
        super(notify);
        this.minHeight = 20;
        this.chanceAddFirstFive = 3;
        this.chanceAddSecondFive = 8;
        this.leaves = Lists.newArrayList();
        this.treeState = TFBlocks.twilight_log.func_176223_P().func_177226_a((IProperty)BlockTFLog.VARIANT, (Comparable)WoodVariant.CANOPY);
        this.branchState = this.treeState.func_177226_a((IProperty)BlockTFLog.field_176299_a, (Comparable)BlockLog.EnumAxis.NONE);
        this.leafState = TFBlocks.twilight_leaves.func_176223_P().func_177226_a((IProperty)BlockTFLeaves.VARIANT, (Comparable)LeavesVariant.CANOPY).func_177226_a((IProperty)BlockLeaves.field_176236_b, (Comparable)false);
        this.rootState = TFBlocks.root.func_176223_P();
    }
    
    public boolean func_180709_b(final World world, final Random random, final BlockPos pos) {
        return this.generate(world, random, pos, true);
    }
    
    public boolean generate(final World world, final Random random, final BlockPos pos, final boolean hasLeaves) {
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
        this.buildBranch(world, pos, 0, treeHeight, 0.0, 0.0, true, random);
        final int numBranches = 3 + random.nextInt(2);
        float offset = random.nextFloat();
        for (int b = 0; b < numBranches; ++b) {
            this.buildBranch(world, pos, treeHeight - 10 + b, 9.0, 0.3 * b + offset, 0.2, false, random);
        }
        if (hasLeaves) {
            for (final BlockPos leafPos : this.leaves) {
                this.makeLeafBlob(world, leafPos);
            }
        }
        if (TFGenerator.hasAirAround(world, pos.func_177977_b())) {
            this.func_175903_a(world, pos.func_177977_b(), this.treeState);
        }
        else {
            this.func_175903_a(world, pos.func_177977_b(), this.rootState);
        }
        final int numRoots = 3 + random.nextInt(2);
        offset = random.nextFloat();
        for (int b2 = 0; b2 < numRoots; ++b2) {
            this.buildRoot(world, pos, offset, b2);
        }
        return true;
    }
    
    private void makeLeafBlob(final World world, final BlockPos leafPos) {
        TFGenerator.makeLeafCircle(this, world, leafPos.func_177977_b(), 3, this.leafState, true);
        TFGenerator.makeLeafCircle(this, world, leafPos, 4, this.leafState, true);
        TFGenerator.makeLeafCircle(this, world, leafPos.func_177984_a(), 2, this.leafState, true);
    }
    
    void buildBranch(final World world, final BlockPos pos, final int height, final double length, final double angle, final double tilt, final boolean trunk, final Random treeRNG) {
        final BlockPos src = pos.func_177981_b(height);
        final BlockPos dest = TFGenerator.translate(src, length, angle, tilt);
        if (world.func_175697_a(dest, 5)) {
            TFGenerator.drawBresehnam(this, world, src, dest, trunk ? this.treeState : this.branchState);
            if (trunk) {
                this.addFirefly(world, pos, 3 + treeRNG.nextInt(7), treeRNG.nextDouble());
            }
            this.func_175903_a(world, dest.func_177974_f(), this.branchState);
            this.func_175903_a(world, dest.func_177976_e(), this.branchState);
            this.func_175903_a(world, dest.func_177968_d(), this.branchState);
            this.func_175903_a(world, dest.func_177978_c(), this.branchState);
            this.leaves.add(dest);
        }
    }
}
