// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;
import twilightforest.block.TFBlocks;

public class TFGenMinersTree extends TFGenerator
{
    protected int treeBlock;
    protected int treeMeta;
    protected int branchMeta;
    protected int leafBlock;
    protected int leafMeta;
    protected int rootBlock;
    protected int rootMeta;
    
    public TFGenMinersTree() {
        this(false);
    }
    
    public TFGenMinersTree(final boolean notify) {
        super(notify);
        this.treeBlock = TFBlocks.magicLog.cF;
        this.treeMeta = 2;
        this.branchMeta = (this.treeMeta | 0xC);
        this.leafBlock = TFBlocks.magicLeaves.cF;
        this.leafMeta = 2;
        this.rootBlock = TFBlocks.root.cF;
        this.rootMeta = 0;
    }
    
    @Override
    public boolean a(final abv world, final Random rand, final int x, final int y, final int z) {
        final ajz materialUnder = world.g(x, y - 1, z);
        if ((materialUnder != ajz.b && materialUnder != ajz.c) || y >= TFWorld.MAXHEIGHT - 12) {
            return false;
        }
        for (int dy = 0; dy < 10; ++dy) {
            this.putBlockAndMetadata(world, x, y + dy, z, this.treeBlock, this.branchMeta, true);
        }
        this.putBranchWithLeaves(world, x, y + 9, z + 1, true);
        this.putBranchWithLeaves(world, x, y + 9, z + 2, false);
        this.putBranchWithLeaves(world, x, y + 8, z + 3, false);
        this.putBranchWithLeaves(world, x, y + 7, z + 4, false);
        this.putBranchWithLeaves(world, x, y + 6, z + 5, false);
        this.putBranchWithLeaves(world, x, y + 9, z - 1, true);
        this.putBranchWithLeaves(world, x, y + 9, z - 2, false);
        this.putBranchWithLeaves(world, x, y + 8, z - 3, false);
        this.putBranchWithLeaves(world, x, y + 7, z - 4, false);
        this.putBranchWithLeaves(world, x, y + 6, z - 5, false);
        this.putBlockAndMetadata(world, x, y + 1, z, TFBlocks.magicLogSpecial.cF, 2, true);
        world.a(x, y + 1, z, TFBlocks.magicLogSpecial.cF, TFBlocks.magicLogSpecial.a(world));
        if (this.hasAirAround((ace)world, x, y - 1, z)) {
            this.a(world, x, y - 1, z, this.treeBlock, this.treeMeta);
        }
        else {
            this.a(world, x, y - 1, z, this.rootBlock, this.rootMeta);
        }
        final int numRoots = 3 + rand.nextInt(2);
        final double offset = rand.nextDouble();
        for (int b = 0; b < numRoots; ++b) {
            this.buildRoot(world, offset, b, x, y, z);
        }
        return true;
    }
    
    protected void putBranchWithLeaves(final abv world, final int bx, final int by, final int bz, final boolean bushy) {
        this.putBlockAndMetadata(world, bx, by, bz, this.treeBlock, this.branchMeta, true);
        for (int lx = -1; lx <= 1; ++lx) {
            for (int ly = -1; ly <= 1; ++ly) {
                for (int lz = -1; lz <= 1; ++lz) {
                    if (bushy || Math.abs(ly) <= 0 || Math.abs(lx) <= 0) {
                        this.putBlockAndMetadata(world, bx + lx, by + ly, bz + lz, this.leafBlock, this.leafMeta, false);
                    }
                }
            }
        }
    }
    
    private void buildRoot(final abv world, final double offset, final int b, final int bx, final int by, final int bz) {
        final int[] dest = TFGenerator.translate(bx, by - b - 2, bz, 6.0, 0.3 * b + offset, 0.8);
        this.drawRoot(world, bx, by - b - 2, bz, dest[0], dest[1], dest[2]);
    }
    
    protected void drawRoot(final abv world, final int sx, final int sy, final int sz, final int dx, final int dy, final int dz) {
        if (world.g(dx, dy, dz).a()) {
            this.drawBresehnam(world, sx, sy, sz, dx, dy, dz, this.rootBlock, this.rootMeta, true);
        }
        else {
            final int[] lineArray = TFGenerator.getBresehnamArray(sx, sy, sz, dx, dy, dz);
            for (int i = 0; i < lineArray.length; i += 3) {
                if (world.a(lineArray[i + 0], lineArray[i + 1], lineArray[i + 2]) > 0 || TFGenerator.isNearSolid((ace)world, lineArray[i + 0], lineArray[i + 1], lineArray[i + 2])) {
                    this.a(world, lineArray[i + 0], lineArray[i + 1], lineArray[i + 2], this.rootBlock, this.rootMeta);
                }
            }
        }
    }
}
