// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.block.material.Material;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;

public class TFGenSortingTree extends TFGenerator
{
    protected int treeBlock;
    protected int treeMeta;
    protected int branchMeta;
    protected int leafBlock;
    protected int leafMeta;
    protected int rootBlock;
    protected int rootMeta;
    
    public TFGenSortingTree() {
        this(false);
    }
    
    public TFGenSortingTree(final boolean notify) {
        super(notify);
        this.treeBlock = TFBlocks.magicLog.field_71990_ca;
        this.treeMeta = 3;
        this.branchMeta = (this.treeMeta | 0xC);
        this.leafBlock = TFBlocks.magicLeaves.field_71990_ca;
        this.leafMeta = 3;
        this.rootBlock = TFBlocks.root.field_71990_ca;
        this.rootMeta = 0;
    }
    
    public boolean func_76484_a(final World world, final Random rand, final int x, final int y, final int z) {
        final Material materialUnder = world.func_72803_f(x, y - 1, z);
        if ((materialUnder != Material.field_76247_b && materialUnder != Material.field_76248_c) || y >= TFWorld.MAXHEIGHT - 12) {
            return false;
        }
        for (int dy = 0; dy < 4; ++dy) {
            this.func_76485_a(world, x, y + dy, z, this.treeBlock, this.treeMeta);
        }
        this.putLeaves(world, x, y + 2, z, false);
        this.putLeaves(world, x, y + 3, z, false);
        this.func_76485_a(world, x, y + 1, z, TFBlocks.magicLogSpecial.field_71990_ca, 3);
        return true;
    }
    
    protected void putLeaves(final World world, final int bx, final int by, final int bz, final boolean bushy) {
        for (int lx = -1; lx <= 1; ++lx) {
            for (int ly = -1; ly <= 1; ++ly) {
                for (int lz = -1; lz <= 1; ++lz) {
                    if (bushy || Math.abs(ly) <= 0 || Math.abs(lx) + Math.abs(lz) <= 1) {
                        this.putLeafBlock(world, bx + lx, by + ly, bz + lz, this.leafBlock, this.leafMeta);
                    }
                }
            }
        }
    }
}
