// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;

public class TFGenLargeWinter extends TFTreeGenerator
{
    public TFGenLargeWinter() {
        this(false);
    }
    
    public TFGenLargeWinter(final boolean par1) {
        super(par1);
        this.treeBlock = Block.field_71951_J.field_71990_ca;
        this.treeMeta = 1;
        this.branchMeta = 13;
        this.leafBlock = Block.field_71952_K.field_71990_ca;
        this.leafMeta = 1;
        this.rootBlock = TFBlocks.root.field_71990_ca;
        this.rootMeta = 0;
    }
    
    public boolean func_76484_a(final World world, final Random random, final int x, final int y, final int z) {
        int treeHeight = 35;
        if (random.nextInt(3) == 0) {
            treeHeight += random.nextInt(10);
            if (random.nextInt(8) == 0) {
                treeHeight += random.nextInt(10);
            }
        }
        final int blockUnder = world.func_72798_a(x, y - 1, z);
        if ((blockUnder != Block.field_71980_u.field_71990_ca && blockUnder != Block.field_71979_v.field_71990_ca) || y >= TFWorld.MAXHEIGHT - treeHeight) {
            return false;
        }
        this.buildTrunk(world, x, y, z, treeHeight);
        this.makeLeaves(world, x, y, z, treeHeight);
        final int numRoots = 4 + random.nextInt(3);
        final float offset = random.nextFloat();
        for (int b = 0; b < numRoots; ++b) {
            this.buildRoot(world, x, y, z, offset, b);
        }
        return true;
    }
    
    private void makeLeaves(final World world, final int x, final int y, final int z, final int treeHeight) {
        final int offGround = 3;
        final int leafType = 1;
        for (int dy = 0; dy < treeHeight; ++dy) {
            final int radius = this.leafRadius(treeHeight, dy, leafType);
            this.makeLeafCircle2(world, x, y + offGround + treeHeight - dy, z, radius, this.leafBlock, this.leafMeta, false);
            this.makePineBranches(world, x, y + offGround + treeHeight - dy, z, radius);
        }
    }
    
    private void makePineBranches(final World world, final int x, final int y, final int z, final int radius) {
        final int branchLength = (radius > 4) ? (radius - 1) : (radius - 2);
        switch (y % 2) {
            case 0: {
                for (int i = 1; i <= branchLength; ++i) {
                    this.func_76485_a(world, x + 0 - i, y, z + 0, this.treeBlock, (this.branchMeta & 0x3) | 0x4);
                    this.func_76485_a(world, x + 0, y, z + 1 + i, this.treeBlock, (this.branchMeta & 0x3) | 0x8);
                    this.func_76485_a(world, x + 1 + i, y, z + 1, this.treeBlock, (this.branchMeta & 0x3) | 0x4);
                    this.func_76485_a(world, x + 1, y, z - 0 - i, this.treeBlock, (this.branchMeta & 0x3) | 0x8);
                }
                break;
            }
            case 1: {
                for (int i = 1; i <= branchLength; ++i) {
                    this.func_76485_a(world, x + 0 - i, y, z + 1, this.treeBlock, (this.branchMeta & 0x3) | 0x4);
                    this.func_76485_a(world, x + 1, y, z + 1 + i, this.treeBlock, (this.branchMeta & 0x3) | 0x8);
                    this.func_76485_a(world, x + 1 + i, y, z + 0, this.treeBlock, (this.branchMeta & 0x3) | 0x4);
                    this.func_76485_a(world, x + 0, y, z - 0 - i, this.treeBlock, (this.branchMeta & 0x3) | 0x8);
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
    
    private void buildTrunk(final World world, final int x, final int y, final int z, final int treeHeight) {
        for (int dy = 0; dy < treeHeight; ++dy) {
            this.func_76485_a(world, x + 0, y + dy, z + 0, this.treeBlock, this.treeMeta);
            this.func_76485_a(world, x + 1, y + dy, z + 0, this.treeBlock, this.treeMeta);
            this.func_76485_a(world, x + 0, y + dy, z + 1, this.treeBlock, this.treeMeta);
            this.func_76485_a(world, x + 1, y + dy, z + 1, this.treeBlock, this.treeMeta);
        }
    }
}
