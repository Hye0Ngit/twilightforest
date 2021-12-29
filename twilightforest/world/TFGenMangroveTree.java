// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;
import twilightforest.block.TFBlocks;

public class TFGenMangroveTree extends TFGenerator
{
    private int treeBlock;
    private int treeMeta;
    private int branchMeta;
    private int leafBlock;
    private int leafMeta;
    private int rootBlock;
    private int rootMeta;
    
    public TFGenMangroveTree() {
        this(false);
    }
    
    public TFGenMangroveTree(final boolean par1) {
        super(par1);
        this.treeBlock = TFBlocks.log.cz;
        this.treeMeta = 2;
        this.branchMeta = 14;
        this.leafBlock = TFBlocks.leaves.cz;
        this.leafMeta = 2;
        this.rootBlock = TFBlocks.root.cz;
        this.rootMeta = 0;
    }
    
    @Override
    public boolean a(final zv world, final Random random, final int x, final int y, final int z) {
        final int blockUnder = world.a(x, y - 1, z);
        if (blockUnder != aou.F.cz || y >= 109) {
            return false;
        }
        this.buildBranch(world, random, x, y, z, 5, 6 + random.nextInt(3), 0.0, 0.0, true);
        final int numBranches = random.nextInt(3);
        double offset = random.nextDouble();
        for (int b = 0; b < numBranches; ++b) {
            this.buildBranch(world, random, x, y, z, 7 + b, 6 + random.nextInt(2), 0.3 * b + offset, 0.25, false);
        }
        final int numRoots = 3 + random.nextInt(2);
        offset = random.nextDouble();
        for (int i = 0; i < numRoots; ++i) {
            final double rTilt = 0.75 + random.nextDouble() * 0.1;
            this.buildRoot(world, x, y, z, 5, 12.0, 0.4 * i + offset, rTilt);
        }
        this.addFirefly(world, x, y, z, 5 + random.nextInt(5), random.nextDouble());
        return true;
    }
    
    void buildBranch(final zv world, final Random random, final int x, final int y, final int z, final int height, final double length, final double angle, final double tilt, final boolean trunk) {
        final int[] src = { x, y + height, z };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        this.drawBresehnam(world, src[0], src[1], src[2], dest[0], dest[1], dest[2], this.treeBlock, trunk ? this.treeMeta : this.branchMeta, true);
        final int bSize = 2 + random.nextInt(3);
        if (bSize > 2) {
            this.putBlockAndMetadata(world, dest[0] + 1, dest[1], dest[2], this.treeBlock, this.branchMeta, true);
            this.putBlockAndMetadata(world, dest[0] - 1, dest[1], dest[2], this.treeBlock, this.branchMeta, true);
            this.putBlockAndMetadata(world, dest[0], dest[1], dest[2] + 1, this.treeBlock, this.branchMeta, true);
            this.putBlockAndMetadata(world, dest[0], dest[1], dest[2] - 1, this.treeBlock, this.branchMeta, true);
        }
        this.drawCircle(world, dest[0], dest[1] - 1, dest[2], (byte)(bSize - 1), this.leafBlock, this.leafMeta, false);
        this.drawCircle(world, dest[0], dest[1], dest[2], (byte)bSize, this.leafBlock, this.leafMeta, false);
        this.drawCircle(world, dest[0], dest[1] + 1, dest[2], (byte)(bSize - 2), this.leafBlock, this.leafMeta, false);
    }
    
    void buildRoot(final zv world, final int x, final int y, final int z, final int height, final double length, final double angle, final double tilt) {
        final int[] src = { x, y + height, z };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        final int[] lineArray = TFGenerator.getBresehnamArray(src[0], src[1], src[2], dest[0], dest[1], dest[2]);
        boolean stillAboveGround = true;
        for (int i = 0; i < lineArray.length; i += 3) {
            if (stillAboveGround && this.hasAirAround((aae)world, lineArray[i + 0], lineArray[i + 1], lineArray[i + 2])) {
                this.a(world, lineArray[i + 0], lineArray[i + 1], lineArray[i + 2], this.treeBlock, this.branchMeta);
                this.a(world, lineArray[i + 0], lineArray[i + 1] - 1, lineArray[i + 2], this.treeBlock, this.branchMeta);
            }
            else {
                this.a(world, lineArray[i + 0], lineArray[i + 1], lineArray[i + 2], this.rootBlock, this.rootMeta);
                this.a(world, lineArray[i + 0], lineArray[i + 1] - 1, lineArray[i + 2], this.rootBlock, this.rootMeta);
                stillAboveGround = false;
            }
        }
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
}
