// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;
import twilightforest.block.TFBlocks;

public class TFGenDarkCanopyTree extends TFGenerator
{
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
        this.treeBlock = TFBlocks.log.cz;
        this.treeMeta = 3;
        this.branchMeta = 15;
        this.leafBlock = TFBlocks.hedge.cz;
        this.leafMeta = 1;
        this.rootBlock = TFBlocks.root.cz;
        this.rootMeta = 0;
    }
    
    @Override
    public boolean a(final zv world, final Random random, final int x, int y, final int z) {
        boolean foundDirt = false;
        for (int dy = y; dy >= TFWorld.SEALEVEL; --dy) {
            final ahz materialUnder = world.g(x, dy - 1, z);
            if (materialUnder == ahz.b || materialUnder == ahz.c) {
                foundDirt = true;
                y = dy;
                break;
            }
            if (materialUnder == ahz.e) {
                break;
            }
            if (materialUnder == ahz.p) {
                break;
            }
        }
        if (!foundDirt) {
            return false;
        }
        if (world.g(x + 1, y, z + 0) == ahz.d || world.g(x - 1, y, z + 0) == ahz.d || world.g(x + 0, y, z + 1) == ahz.d || world.g(x + 0, y, z - 1) == ahz.d) {
            return false;
        }
        final int treeHeight = 4 + random.nextInt(3);
        this.drawBresehnam(world, x, y, z, x, y + treeHeight, z, this.treeBlock, this.treeMeta, true);
        final int numBranches = 4;
        double offset = random.nextFloat();
        for (int b = 0; b < numBranches; ++b) {
            this.buildBranch(world, x, y, z, treeHeight - numBranches + b / 2, 8.0, 0.23 * b + offset, 0.23, random);
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
    
    void buildBranch(final zv world, final int x, final int y, final int z, final int height, final double length, final double angle, final double tilt, final Random random) {
        final int[] src = { x, y + height, z };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        this.drawBresehnam(world, src[0], src[1], src[2], dest[0], dest[1], dest[2], this.treeBlock, this.branchMeta, true);
        byte leafSize = 4;
        if (random.nextInt(3) == 0) {
            leafSize += (byte)(random.nextInt(3) - 1);
        }
        if (world.a(dest[0], dest[1] - 1, dest[2]) == 0 || world.a(dest[0], dest[1] + 1, dest[2]) == 0 || world.a(dest[0] + 4, dest[1], dest[2]) == 0 || world.a(dest[0] - 4, dest[1], dest[2]) == 0 || world.a(dest[0], dest[1], dest[2] + 4) == 0 || world.a(dest[0], dest[1], dest[2] - 4) == 0) {
            this.drawCircle(world, dest[0], dest[1] - 1, dest[2], leafSize, this.leafBlock, this.leafMeta, false);
            this.drawCircle(world, dest[0], dest[1], dest[2], leafSize + 1, this.leafBlock, this.leafMeta, false);
            this.drawCircle(world, dest[0], dest[1] + 1, dest[2], leafSize, this.leafBlock, this.leafMeta, false);
            this.drawCircle(world, dest[0], dest[1] + 2, dest[2], leafSize - 2, this.leafBlock, this.leafMeta, false);
        }
    }
    
    void nullifySkyLightUnderBranch(final zv world, final int sx, final int sy, final int sz, final int rad) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dz = 0; dz <= rad; ++dz) {
                final int dist = Math.max(dx, dz) + (Math.min(dx, dz) >> 1);
                if (dist <= rad) {
                    this.nullifySkyLightColumn(world, sx + dx, sy, sz + dz);
                    this.nullifySkyLightColumn(world, sx + dx, sy, sz - dz);
                    this.nullifySkyLightColumn(world, sx - dx, sy, sz + dz);
                    this.nullifySkyLightColumn(world, sx - dx, sy, sz - dz);
                }
            }
        }
    }
    
    void nullifySkyLightColumn(final zv world, final int dx, final int dy, final int dz) {
        for (int y = dy; y >= 0; --y) {
            world.b(aag.a, dx, y, dz, 0);
        }
    }
    
    private void buildRoot(final zv world, final int x, final int y, final int z, final double offset, final int b) {
        final int[] dest = TFGenerator.translate(x, y - b - 2, z, 5.0, 0.3 * b + offset, 0.8);
        if (world.g(dest[0], dest[1], dest[2]).a()) {
            this.drawBresehnam(world, x, y - b - 2, z, dest[0], dest[1], dest[2], this.rootBlock, this.rootMeta, true);
        }
        else {
            final int[] lineArray = TFGenerator.getBresehnamArray(x, y - b - 2, z, dest[0], dest[1], dest[2]);
            for (int i = 0; i < lineArray.length; i += 3) {
                if (world.a(lineArray[i + 0], lineArray[i + 1], lineArray[i + 2]) > 0 || this.isNearSolid((aae)world, lineArray[i + 0], lineArray[i + 1], lineArray[i + 2])) {
                    this.a(world, lineArray[i + 0], lineArray[i + 1], lineArray[i + 2], this.rootBlock, this.rootMeta);
                }
            }
        }
    }
}
