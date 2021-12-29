// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;

public class TFGenTreeOfTime extends TFGenHollowTree
{
    public TFGenTreeOfTime(final boolean par1) {
        super(par1);
        this.treeBlock = TFBlocks.magicLog;
        this.treeMeta = 0;
        this.branchMeta = (this.treeMeta | 0xC);
        this.leafBlock = TFBlocks.magicLeaves;
        this.leafMeta = 0;
    }
    
    @Override
    public boolean func_76484_a(final World world, final Random random, final int x, final int y, final int z) {
        final int height = 8;
        final int diameter = 1;
        if (y < 1 || y + height + diameter > TFWorld.MAXHEIGHT) {
            return false;
        }
        final Block j1 = world.func_147439_a(x, y - 1, z);
        if (j1 != Blocks.field_150349_c && j1 != Blocks.field_150346_d) {
            return false;
        }
        this.buildTrunk(world, random, x, y, z, diameter, height);
        this.buildTinyCrown(world, random, x, y, z, diameter, height);
        this.buildBranchRing(world, random, x, y, z, diameter, 1, 0, 12, 0, 0.75, 0.0, 3, 5, 3, false);
        this.buildBranchRing(world, random, x, y, z, diameter, 1, 2, 18, 0, 0.9, 0.0, 3, 5, 3, false);
        this.setBlockAndMetadata(world, x - 1, y + 2, z, TFBlocks.magicLogSpecial, 0);
        return true;
    }
    
    protected void buildTinyCrown(final World world, final Random random, final int x, final int y, final int z, final int diameter, final int height) {
        final int crownRadius = 4;
        final int bvar = 1;
        this.buildBranchRing(world, random, x, y, z, diameter, height - crownRadius, 0, crownRadius, 0, 0.35, 0.0, bvar, bvar + 2, 1, true);
        this.buildBranchRing(world, random, x, y, z, diameter, height - crownRadius / 2, 0, crownRadius, 0, 0.28, 0.0, bvar, bvar + 2, 1, true);
        this.buildBranchRing(world, random, x, y, z, diameter, height, 0, crownRadius, 0, 0.15, 0.0, 2, 4, 0, true);
        this.buildBranchRing(world, random, x, y, z, diameter, height, 0, crownRadius / 2, 0, 0.05, 0.0, bvar, bvar + 2, 0, true);
    }
}
