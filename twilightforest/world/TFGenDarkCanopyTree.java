// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.block.TFBlocks;
import java.util.Random;

public class TFGenDarkCanopyTree extends TFGenerator
{
    private Random treeRNG;
    private int x;
    private int y;
    private int z;
    private int treeHeight;
    private int treeBlock;
    private int treeMeta;
    private int branchMeta;
    private int leafBlock;
    private int leafMeta;
    private int rootBlock;
    private int rootMeta;
    
    public TFGenDarkCanopyTree() {
        this(false);
    }
    
    public TFGenDarkCanopyTree(final boolean par1) {
        super(par1);
        this.treeBlock = TFBlocks.log.cm;
        this.treeMeta = 3;
        this.branchMeta = 15;
        this.leafBlock = TFBlocks.hedge.cm;
        this.leafMeta = 1;
        this.rootBlock = TFBlocks.root.cm;
        this.rootMeta = 0;
    }
    
    @Override
    public boolean a(final yc world, final Random random, final int treeX, int treeY, final int treeZ) {
        this.worldObj = world;
        this.treeRNG = random;
        boolean foundDirt = false;
        for (int dy = treeY; dy >= TFWorld.SEALEVEL; --dy) {
            final agi materialUnder = world.g(treeX, dy - 1, treeZ);
            if (materialUnder == agi.b || materialUnder == agi.c) {
                foundDirt = true;
                treeY = dy;
                break;
            }
            if (materialUnder == agi.e) {
                break;
            }
            if (materialUnder == agi.p) {
                break;
            }
        }
        if (!foundDirt) {
            return false;
        }
        if (world.g(treeX + 1, this.y, treeZ + 0) == agi.d || world.g(treeX - 1, this.y, treeZ + 0) == agi.d || world.g(treeX + 0, this.y, treeZ + 1) == agi.d || world.g(treeX + 0, this.y, treeZ - 1) == agi.d) {
            return false;
        }
        this.x = treeX;
        this.y = treeY;
        this.z = treeZ;
        this.treeHeight = 4 + this.treeRNG.nextInt(3);
        this.drawBresehnam(this.x, this.y, this.z, this.x, this.y + this.treeHeight, this.z, this.treeBlock, this.treeMeta, true);
        final int numBranches = 4;
        double offset = this.treeRNG.nextFloat();
        for (int b = 0; b < numBranches; ++b) {
            this.buildBranch(this.treeHeight - numBranches + b / 2, 8.0, 0.23 * b + offset, 0.23);
        }
        if (this.hasAirAround((ym)world, this.x, this.y - 1, this.z)) {
            world.c(this.x, this.y - 1, this.z, this.treeBlock, this.treeMeta);
        }
        else {
            world.c(this.x, this.y - 1, this.z, this.rootBlock, this.rootMeta);
        }
        final int numRoots = 3 + this.treeRNG.nextInt(2);
        offset = this.treeRNG.nextDouble();
        for (int b2 = 0; b2 < numRoots; ++b2) {
            this.buildRoot(offset, b2);
        }
        return true;
    }
    
    void buildBranch(final int height, final double length, final double angle, final double tilt) {
        final int[] src = { this.x, this.y + height, this.z };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        this.drawBresehnam(src[0], src[1], src[2], dest[0], dest[1], dest[2], this.treeBlock, this.branchMeta, true);
        byte leafSize = 4;
        if (this.treeRNG.nextInt(3) == 0) {
            leafSize += (byte)(this.treeRNG.nextInt(3) - 1);
        }
        if (this.worldObj.a(dest[0], dest[1] - 1, dest[2]) == 0 || this.worldObj.a(dest[0], dest[1] + 1, dest[2]) == 0 || this.worldObj.a(dest[0] + 4, dest[1], dest[2]) == 0 || this.worldObj.a(dest[0] - 4, dest[1], dest[2]) == 0 || this.worldObj.a(dest[0], dest[1], dest[2] + 4) == 0 || this.worldObj.a(dest[0], dest[1], dest[2] - 4) == 0) {
            this.drawCircle(dest[0], dest[1] - 1, dest[2], leafSize, this.leafBlock, this.leafMeta, false);
            this.drawCircle(dest[0], dest[1], dest[2], leafSize + 1, this.leafBlock, this.leafMeta, false);
            this.drawCircle(dest[0], dest[1] + 1, dest[2], leafSize, this.leafBlock, this.leafMeta, false);
            this.drawCircle(dest[0], dest[1] + 2, dest[2], leafSize - 2, this.leafBlock, this.leafMeta, false);
        }
    }
    
    void nullifySkyLightUnderBranch(final int sx, final int sy, final int sz, final int rad) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dz = 0; dz <= rad; ++dz) {
                final int dist = Math.max(dx, dz) + (Math.min(dx, dz) >> 1);
                if (dist <= rad) {
                    this.nullifySkyLightColumn(sx + dx, sy, sz + dz);
                    this.nullifySkyLightColumn(sx + dx, sy, sz - dz);
                    this.nullifySkyLightColumn(sx - dx, sy, sz + dz);
                    this.nullifySkyLightColumn(sx - dx, sy, sz - dz);
                }
            }
        }
    }
    
    void nullifySkyLightColumn(final int dx, final int dy, final int dz) {
        for (int y = dy; y >= 0; --y) {
            this.worldObj.b(yo.a, dx, y, dz, 0);
        }
    }
    
    private void buildRoot(final double offset, final int b) {
        final int[] dest = TFGenerator.translate(this.x, this.y - b - 2, this.z, 5.0, 0.3 * b + offset, 0.8);
        if (this.worldObj.g(dest[0], dest[1], dest[2]).a()) {
            this.drawBresehnam(this.x, this.y - b - 2, this.z, dest[0], dest[1], dest[2], this.rootBlock, this.rootMeta, true);
        }
        else {
            final int[] lineArray = TFGenerator.getBresehnamArray(this.x, this.y - b - 2, this.z, dest[0], dest[1], dest[2]);
            for (int i = 0; i < lineArray.length; i += 3) {
                if (this.worldObj.a(lineArray[i + 0], lineArray[i + 1], lineArray[i + 2]) > 0 || this.isNearSolid((ym)this.worldObj, lineArray[i + 0], lineArray[i + 1], lineArray[i + 2])) {
                    this.worldObj.c(lineArray[i + 0], lineArray[i + 1], lineArray[i + 2], this.rootBlock, this.rootMeta);
                }
            }
        }
    }
}
