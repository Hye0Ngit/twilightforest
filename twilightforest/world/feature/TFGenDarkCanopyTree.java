// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world.feature;

import net.minecraft.util.EnumFacing;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import twilightforest.enums.WoodVariant;
import twilightforest.block.BlockTFLog;
import twilightforest.block.TFBlocks;

public class TFGenDarkCanopyTree extends TFTreeGenerator
{
    public TFGenDarkCanopyTree() {
        this(false);
    }
    
    public TFGenDarkCanopyTree(final boolean notify) {
        super(notify);
        this.treeState = TFBlocks.twilight_log.func_176223_P().func_177226_a((IProperty)BlockTFLog.VARIANT, (Comparable)WoodVariant.DARK);
        this.branchState = this.treeState.func_177226_a((IProperty)BlockTFLog.field_176299_a, (Comparable)BlockLog.EnumAxis.NONE);
        this.leafState = TFBlocks.dark_leaves.func_176223_P();
        this.rootState = TFBlocks.root.func_176223_P();
    }
    
    public boolean func_180709_b(final World world, final Random random, BlockPos pos) {
        boolean foundDirt = false;
        for (int dy = pos.func_177956_o(); dy >= 31; --dy) {
            final Material materialUnder = world.func_180495_p(new BlockPos(pos.func_177958_n(), dy - 1, pos.func_177952_p())).func_185904_a();
            if (materialUnder == Material.field_151577_b || materialUnder == Material.field_151578_c) {
                foundDirt = true;
                pos = new BlockPos(pos.func_177958_n(), dy, pos.func_177952_p());
                break;
            }
            if (materialUnder == Material.field_151576_e) {
                break;
            }
            if (materialUnder == Material.field_151595_p) {
                break;
            }
        }
        if (!foundDirt) {
            return false;
        }
        for (final EnumFacing e : EnumFacing.field_176754_o) {
            if (world.func_180495_p(pos.func_177972_a(e)).func_185904_a() == Material.field_151575_d) {
                return false;
            }
        }
        final int treeHeight = 6 + random.nextInt(5);
        TFGenerator.drawBresehnam(this, world, pos, pos.func_177981_b(treeHeight), this.treeState);
        this.leafAround(world, pos.func_177981_b(treeHeight));
        final int numBranches = 4;
        double offset = random.nextFloat();
        for (int b = 0; b < numBranches; ++b) {
            this.buildBranch(world, pos, treeHeight - 3 - numBranches + b / 2, 10 + random.nextInt(4), 0.23 * b + offset, 0.23, random);
        }
        if (TFGenerator.hasAirAround(world, pos.func_177977_b())) {
            this.func_175903_a(world, pos.func_177977_b(), this.treeState);
        }
        else {
            this.func_175903_a(world, pos.func_177977_b(), this.rootState);
        }
        final int numRoots = 3 + random.nextInt(2);
        offset = random.nextDouble();
        for (int b2 = 0; b2 < numRoots; ++b2) {
            this.buildRoot(world, pos, offset, b2);
        }
        return true;
    }
    
    private void buildBranch(final World world, final BlockPos pos, final int height, final double length, final double angle, final double tilt, final Random random) {
        final BlockPos src = pos.func_177981_b(height);
        final BlockPos dest = TFGenerator.translate(src, length, angle, tilt);
        if (world.func_175697_a(dest, 6)) {
            TFGenerator.drawBresehnam(this, world, src, dest, this.branchState);
            this.leafAround(world, dest);
        }
    }
    
    private void leafAround(final World world, final BlockPos pos) {
        final int leafSize = 4;
        if (TFGenerator.hasAirAround(world, pos)) {
            TFGenerator.makeLeafCircle(this, world, pos.func_177977_b(), leafSize, this.leafState, false);
            TFGenerator.makeLeafCircle(this, world, pos, leafSize + 1, this.leafState, false);
            TFGenerator.makeLeafCircle(this, world, pos.func_177984_a(), leafSize, this.leafState, false);
            TFGenerator.makeLeafCircle(this, world, pos.func_177981_b(2), leafSize - 2, this.leafState, false);
        }
    }
}
