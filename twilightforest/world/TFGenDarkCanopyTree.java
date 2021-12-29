// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;
import twilightforest.block.TFBlocks;

public class TFGenDarkCanopyTree extends TFTreeGenerator
{
    public TFGenDarkCanopyTree() {
        this(false);
    }
    
    public TFGenDarkCanopyTree(final boolean par1) {
        super(par1);
        this.treeBlock = TFBlocks.log.cF;
        this.treeMeta = 3;
        this.branchMeta = 15;
        this.leafBlock = TFBlocks.hedge.cF;
        this.leafMeta = 1;
        this.rootBlock = TFBlocks.root.cF;
        this.rootMeta = 0;
    }
    
    @Override
    public boolean a(final abv world, final Random random, final int x, int y, final int z) {
        boolean foundDirt = false;
        for (int dy = y; dy >= TFWorld.SEALEVEL; --dy) {
            final ajz materialUnder = world.g(x, dy - 1, z);
            if (materialUnder == ajz.b || materialUnder == ajz.c) {
                foundDirt = true;
                y = dy;
                break;
            }
            if (materialUnder == ajz.e) {
                break;
            }
            if (materialUnder == ajz.p) {
                break;
            }
        }
        if (!foundDirt) {
            return false;
        }
        if (world.g(x + 1, y, z + 0) == ajz.d || world.g(x - 1, y, z + 0) == ajz.d || world.g(x + 0, y, z + 1) == ajz.d || world.g(x + 0, y, z - 1) == ajz.d) {
            return false;
        }
        final int treeHeight = 4 + random.nextInt(3);
        this.drawBresehnam(world, x, y, z, x, y + treeHeight, z, this.treeBlock, this.treeMeta, true);
        final int numBranches = 4;
        double offset = random.nextFloat();
        for (int b = 0; b < numBranches; ++b) {
            this.buildBranch(world, x, y, z, treeHeight - numBranches + b / 2, 8.0, 0.23 * b + offset, 0.23, random);
        }
        if (this.hasAirAround((ace)world, x, y - 1, z)) {
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
    
    void buildBranch(final abv world, final int x, final int y, final int z, final int height, final double length, final double angle, final double tilt, final Random random) {
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
    
    void nullifySkyLightUnderBranch(final abv world, final int sx, final int sy, final int sz, final int rad) {
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
    
    void nullifySkyLightColumn(final abv world, final int dx, final int dy, final int dz) {
        for (int y = dy; y >= 0; --y) {
            world.b(acg.a, dx, y, dz, 0);
        }
    }
}
