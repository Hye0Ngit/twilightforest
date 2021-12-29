// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;
import twilightforest.block.TFBlocks;

public class TFGenCanopyTree extends TFGenerator
{
    protected int treeBlock;
    protected int treeMeta;
    protected int branchMeta;
    protected int leafBlock;
    protected int leafMeta;
    protected int rootBlock;
    protected int rootMeta;
    protected int minHeight;
    protected int chanceAddFirstFive;
    protected int chanceAddSecondFive;
    
    public TFGenCanopyTree() {
        this(false);
    }
    
    public TFGenCanopyTree(final boolean par1) {
        super(par1);
        this.treeBlock = TFBlocks.log.cz;
        this.treeMeta = 1;
        this.branchMeta = 13;
        this.leafBlock = TFBlocks.leaves.cz;
        this.leafMeta = 1;
        this.rootBlock = TFBlocks.root.cz;
        this.rootMeta = 0;
        this.minHeight = 20;
        this.chanceAddFirstFive = 3;
        this.chanceAddSecondFive = 8;
    }
    
    @Override
    public boolean a(final zv world, final Random random, final int x, final int y, final int z) {
        final ahz materialUnder = world.g(x, y - 1, z);
        if ((materialUnder != ahz.b && materialUnder != ahz.c) || y >= TFWorld.MAXHEIGHT - 12) {
            return false;
        }
        int treeHeight = this.minHeight;
        if (random.nextInt(this.chanceAddFirstFive) == 0) {
            treeHeight += random.nextInt(5);
            if (random.nextInt(this.chanceAddSecondFive) == 0) {
                treeHeight += random.nextInt(5);
            }
        }
        this.buildBranch(world, x, y, z, 0, treeHeight, 0.0, 0.0, true, random);
        final int numBranches = 3 + random.nextInt(2);
        double offset = random.nextDouble();
        for (int b = 0; b < numBranches; ++b) {
            this.buildBranch(world, x, y, z, treeHeight - 10 + b, 9.0, 0.3 * b + offset, 0.2, false, random);
        }
        if (this.hasAirAround((aae)world, x, y - 1, z)) {
            this.a(world, x, y - 1, z, this.treeBlock, this.treeMeta);
        }
        else {
            this.a(world, x, y - 1, z, this.rootBlock, this.rootMeta);
        }
        final int numRoots = 3 + random.nextInt(2);
        offset = random.nextDouble();
        for (int b2 = 0; b2 < numRoots; ++b2) {
            this.buildRoot(world, x, y, z, offset, b2);
        }
        return true;
    }
    
    void buildBranch(final zv world, final int x, final int y, final int z, final int height, final double length, final double angle, final double tilt, final boolean trunk, final Random treeRNG) {
        final int[] src = { x, y + height, z };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        this.drawBresehnam(world, src[0], src[1], src[2], dest[0], dest[1], dest[2], this.treeBlock, trunk ? this.treeMeta : this.branchMeta, true);
        if (trunk) {
            this.addFirefly(world, x, y, z, 3 + treeRNG.nextInt(7), treeRNG.nextDouble());
        }
        this.putBlockAndMetadata(world, dest[0] + 1, dest[1], dest[2], this.treeBlock, this.branchMeta, true);
        this.putBlockAndMetadata(world, dest[0] - 1, dest[1], dest[2], this.treeBlock, this.branchMeta, true);
        this.putBlockAndMetadata(world, dest[0], dest[1], dest[2] + 1, this.treeBlock, this.branchMeta, true);
        this.putBlockAndMetadata(world, dest[0], dest[1], dest[2] - 1, this.treeBlock, this.branchMeta, true);
        this.drawCircle(world, dest[0], dest[1] - 1, dest[2], 3, this.leafBlock, this.leafMeta, false);
        this.drawCircle(world, dest[0], dest[1], dest[2], 4, this.leafBlock, this.leafMeta, false);
        this.drawCircle(world, dest[0], dest[1] + 1, dest[2], 2, this.leafBlock, this.leafMeta, false);
    }
    
    private void addFirefly(final zv world, final int x, final int y, final int z, final int height, final double angle) {
        final int iAngle = (int)(angle * 4.0);
        if (iAngle == 0) {
            this.putBlockAndMetadata(world, x + 1, y + height, z, TFBlocks.firefly.cz, 0, false);
        }
        else if (iAngle == 1) {
            this.putBlockAndMetadata(world, x - 1, y + height, z, TFBlocks.firefly.cz, 0, false);
        }
        else if (iAngle == 2) {
            this.putBlockAndMetadata(world, x, y + height, z + 1, TFBlocks.firefly.cz, 0, false);
        }
        else if (iAngle == 3) {
            this.putBlockAndMetadata(world, x, y + height, z - 1, TFBlocks.firefly.cz, 0, false);
        }
    }
    
    private void buildRoot(final zv world, final int x, final int y, final int z, final double offset, final int b) {
        final int[] dest = TFGenerator.translate(x, y - b - 2, z, 6.0, 0.3 * b + offset, 0.8);
        this.drawRoot(world, x, y - b - 2, z, dest[0], dest[1], dest[2]);
    }
    
    protected void drawRoot(final zv world, final int sx, final int sy, final int sz, final int dx, final int dy, final int dz) {
        if (world.g(dx, dy, dz).a()) {
            this.drawBresehnam(world, sx, sy, sz, dx, dy, dz, this.rootBlock, this.rootMeta, true);
        }
        else {
            final int[] lineArray = TFGenerator.getBresehnamArray(sx, sy, sz, dx, dy, dz);
            for (int i = 0; i < lineArray.length; i += 3) {
                if (world.a(lineArray[i + 0], lineArray[i + 1], lineArray[i + 2]) > 0 || this.isNearSolid((aae)world, lineArray[i + 0], lineArray[i + 1], lineArray[i + 2])) {
                    this.a(world, lineArray[i + 0], lineArray[i + 1], lineArray[i + 2], this.rootBlock, this.rootMeta);
                }
            }
        }
    }
}
