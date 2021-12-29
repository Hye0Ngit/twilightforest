// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;
import twilightforest.block.TFBlocks;

public class TFGenSmallTwilightOak extends TFGenerator
{
    protected final int minTreeHeight;
    protected int treeBlock;
    protected int treeMeta;
    protected int branchMeta;
    protected int leafBlock;
    protected int leafMeta;
    protected int rootBlock;
    protected int rootMeta;
    
    public TFGenSmallTwilightOak(final boolean par1) {
        this(par1, 4);
    }
    
    public TFGenSmallTwilightOak(final boolean par1, final int par2) {
        super(par1);
        this.treeBlock = TFBlocks.log.cm;
        this.treeMeta = 0;
        this.branchMeta = (this.treeMeta | 0xC);
        this.leafBlock = TFBlocks.leaves.cm;
        this.leafMeta = 0;
        this.rootBlock = TFBlocks.root.cm;
        this.rootMeta = 0;
        this.minTreeHeight = par2;
    }
    
    @Override
    public boolean a(final yc par1World, final Random par2Random, final int par3, final int par4, final int par5) {
        final int var6 = par2Random.nextInt(3) + this.minTreeHeight;
        boolean var7 = true;
        if (par4 < 1 || par4 + var6 + 1 > 256) {
            return false;
        }
        for (int var8 = par4; var8 <= par4 + 1 + var6; ++var8) {
            byte var9 = 1;
            if (var8 == par4) {
                var9 = 0;
            }
            if (var8 >= par4 + 1 + var6 - 2) {
                var9 = 2;
            }
            for (int var10 = par3 - var9; var10 <= par3 + var9 && var7; ++var10) {
                for (int var11 = par5 - var9; var11 <= par5 + var9 && var7; ++var11) {
                    if (var8 >= 0 && var8 < 256) {
                        final int var12 = par1World.a(var10, var8, var11);
                        final amq block = amq.p[var12];
                        if (var12 != 0 && !block.isLeaves(par1World, var10, var8, var11) && var12 != amq.x.cm && var12 != amq.y.cm && !block.isWood(par1World, var10, var8, var11)) {
                            var7 = false;
                        }
                    }
                    else {
                        var7 = false;
                    }
                }
            }
        }
        if (!var7) {
            return false;
        }
        int var8 = par1World.a(par3, par4 - 1, par5);
        if ((var8 == amq.x.cm || var8 == amq.y.cm) && par4 < 256 - var6 - 1) {
            this.a(par1World, par3, par4 - 1, par5, amq.y.cm);
            final byte var9 = 3;
            final byte var13 = 0;
            for (int var11 = par4 - var9 + var6; var11 <= par4 + var6; ++var11) {
                final int var12 = var11 - (par4 + var6);
                for (int var14 = var13 + 1 - var12 / 2, var15 = par3 - var14; var15 <= par3 + var14; ++var15) {
                    final int var16 = var15 - par3;
                    for (int var17 = par5 - var14; var17 <= par5 + var14; ++var17) {
                        final int var18 = var17 - par5;
                        final amq block2 = amq.p[par1World.a(var15, var11, var17)];
                        if ((Math.abs(var16) != var14 || Math.abs(var18) != var14 || (par2Random.nextInt(2) != 0 && var12 != 0)) && (block2 == null || block2.canBeReplacedByLeaves(par1World, var15, var11, var17))) {
                            this.a(par1World, var15, var11, var17, this.leafBlock, this.leafMeta);
                        }
                    }
                }
            }
            for (int var11 = 0; var11 < var6; ++var11) {
                final int var12 = par1World.a(par3, par4 + var11, par5);
                final amq block3 = amq.p[var12];
                if (var12 == 0 || block3 == null || block3.isLeaves(par1World, par3, par4 + var11, par5)) {
                    this.a(par1World, par3, par4 + var11, par5, this.treeBlock, this.treeMeta);
                }
            }
            return true;
        }
        return false;
    }
}
