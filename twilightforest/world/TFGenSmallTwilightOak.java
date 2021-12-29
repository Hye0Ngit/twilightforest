// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;

public class TFGenSmallTwilightOak extends TFTreeGenerator
{
    protected final int minTreeHeight;
    
    public TFGenSmallTwilightOak(final boolean par1) {
        this(par1, 4);
    }
    
    public TFGenSmallTwilightOak(final boolean par1, final int par2) {
        super(par1);
        this.minTreeHeight = par2;
        this.treeBlock = TFBlocks.log;
        this.treeMeta = 0;
        this.branchMeta = (this.treeMeta | 0xC);
        this.leafBlock = TFBlocks.leaves;
        this.leafMeta = 0;
        this.rootBlock = TFBlocks.root;
        this.rootMeta = 0;
    }
    
    public boolean func_76484_a(final World par1World, final Random par2Random, final int x, final int y, final int z) {
        final int height = par2Random.nextInt(3) + this.minTreeHeight;
        boolean allClear = true;
        if (y < 1 || y + height + 1 > 256) {
            return false;
        }
        for (int cy = y; cy <= y + 1 + height; ++cy) {
            byte width = 1;
            if (cy == y) {
                width = 0;
            }
            if (cy >= y + 1 + height - 2) {
                width = 2;
            }
            for (int cx = x - width; cx <= x + width && allClear; ++cx) {
                for (int cz = z - width; cz <= z + width && allClear; ++cz) {
                    if (cy >= 0 && cy < 256) {
                        final Block block;
                        final Block blockID = block = par1World.func_147439_a(cx, cy, cz);
                        if (blockID != Blocks.field_150350_a && !block.isLeaves((IBlockAccess)par1World, cx, cy, cz) && blockID != Blocks.field_150349_c && blockID != Blocks.field_150346_d && !block.isWood((IBlockAccess)par1World, cx, cy, cz)) {
                            allClear = false;
                        }
                    }
                    else {
                        allClear = false;
                    }
                }
            }
        }
        if (!allClear) {
            return false;
        }
        final Block blockUsing = par1World.func_147439_a(x, y - 1, z);
        if ((blockUsing == Blocks.field_150349_c || blockUsing == Blocks.field_150346_d) && y < 256 - height - 1) {
            this.setBlock(par1World, x, y - 1, z, Blocks.field_150346_d);
            final byte width = 3;
            final byte var18 = 0;
            for (int cz = y - width + height; cz <= y + height; ++cz) {
                final int number = cz - (y + height);
                for (int treeWidth = var18 + 1 - number / 2, tx = x - treeWidth; tx <= x + treeWidth; ++tx) {
                    final int var19 = tx - x;
                    for (int tz = z - treeWidth; tz <= z + treeWidth; ++tz) {
                        final int var20 = tz - z;
                        final Block block2 = par1World.func_147439_a(tx, cz, tz);
                        if ((Math.abs(var19) != treeWidth || Math.abs(var20) != treeWidth || (par2Random.nextInt(2) != 0 && number != 0)) && (block2 == null || block2.canBeReplacedByLeaves((IBlockAccess)par1World, tx, cz, tz))) {
                            this.setBlockAndMetadata(par1World, tx, cz, tz, this.leafBlock, this.leafMeta);
                        }
                    }
                }
            }
            for (int cz = 0; cz < height; ++cz) {
                final Block block3;
                final Block blockID = block3 = par1World.func_147439_a(x, y + cz, z);
                if (blockID == Blocks.field_150350_a || block3 == null || block3.isLeaves((IBlockAccess)par1World, x, y + cz, z)) {
                    this.setBlockAndMetadata(par1World, x, y + cz, z, this.treeBlock, this.treeMeta);
                }
            }
            return true;
        }
        return false;
    }
}
