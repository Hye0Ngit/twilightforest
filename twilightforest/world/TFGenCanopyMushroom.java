// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.block.TFBlocks;
import java.util.Random;

public class TFGenCanopyMushroom extends TFGenerator
{
    private int treeBlock;
    private int treeMeta;
    private int branchMeta;
    private int leafBlock;
    private int leafMeta;
    
    public TFGenCanopyMushroom() {
        this.treeMeta = 10;
        this.branchMeta = 15;
        this.leafMeta = 5;
    }
    
    @Override
    public boolean a(final zv world, final Random random, final int x, final int y, final int z) {
        int treeHeight = 12;
        if (random.nextInt(3) == 0) {
            treeHeight += random.nextInt(5);
            if (random.nextInt(8) == 0) {
                treeHeight += random.nextInt(5);
            }
        }
        final int blockUnder = world.a(x, y - 1, z);
        if ((blockUnder != aou.y.cz && blockUnder != aou.z.cz && blockUnder != aou.bC.cz) || y >= 256 - treeHeight - 1) {
            return false;
        }
        this.treeBlock = ((random.nextInt(3) == 0) ? aou.bs.cz : aou.br.cz);
        this.leafBlock = this.treeBlock;
        this.buildBranch(world, x, y, z, 0, treeHeight, 0.0, 0.0, true, random);
        final int numBranches = 3 + random.nextInt(2);
        final double offset = random.nextDouble();
        for (int b = 0; b < numBranches; ++b) {
            this.buildBranch(world, x, y, z, treeHeight - 5 + b, 9.0, 0.3 * b + offset, 0.2, false, random);
        }
        return true;
    }
    
    void buildBranch(final zv world, final int x, final int y, final int z, final int height, final double length, final double angle, final double tilt, final boolean trunk, final Random treeRNG) {
        final int[] src = { x, y + height, z };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        if (src[0] != dest[0] || src[2] != dest[2]) {
            this.drawBresehnam(world, src[0], src[1], src[2], dest[0], src[1], dest[2], this.treeBlock, this.branchMeta, true);
            this.drawBresehnam(world, dest[0], src[1] + 1, dest[2], dest[0], dest[1] - 1, dest[2], this.treeBlock, this.treeMeta, true);
        }
        else {
            this.drawBresehnam(world, src[0], src[1], src[2], dest[0], dest[1] - 1, dest[2], this.treeBlock, this.treeMeta, true);
        }
        if (trunk) {
            this.addFirefly(world, x, y, z, 3 + treeRNG.nextInt(7), treeRNG.nextDouble());
        }
        this.drawMushroomCircle(world, dest[0], dest[1], dest[2], 4, this.leafBlock, true);
    }
    
    public void drawMushroomCircle(final zv world, final int sx, final int sy, final int sz, final int rad, final int blockValue, final boolean priority) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dz = 0; dz <= rad; ++dz) {
                int dist = (int)(Math.max(dx, dz) + Math.min(dx, dz) * 0.5);
                if (dx == 3 && dz == 3) {
                    dist = 6;
                }
                if (dx == 0) {
                    if (dz < rad) {
                        this.putBlockAndMetadata(world, sx + 0, sy, sz + dz, blockValue, 5, priority);
                        this.putBlockAndMetadata(world, sx + 0, sy, sz - dz, blockValue, 5, priority);
                    }
                    else {
                        this.putBlockAndMetadata(world, sx + 0, sy, sz + dz, blockValue, 8, priority);
                        this.putBlockAndMetadata(world, sx + 0, sy, sz - dz, blockValue, 2, priority);
                    }
                }
                else if (dz == 0) {
                    if (dx < rad) {
                        this.putBlockAndMetadata(world, sx + dx, sy, sz + 0, blockValue, 5, priority);
                        this.putBlockAndMetadata(world, sx - dx, sy, sz + 0, blockValue, 5, priority);
                    }
                    else {
                        this.putBlockAndMetadata(world, sx + dx, sy, sz + 0, blockValue, 6, priority);
                        this.putBlockAndMetadata(world, sx - dx, sy, sz + 0, blockValue, 4, priority);
                    }
                }
                else if (dist < rad) {
                    this.putBlockAndMetadata(world, sx + dx, sy, sz + dz, blockValue, 5, priority);
                    this.putBlockAndMetadata(world, sx + dx, sy, sz - dz, blockValue, 5, priority);
                    this.putBlockAndMetadata(world, sx - dx, sy, sz + dz, blockValue, 5, priority);
                    this.putBlockAndMetadata(world, sx - dx, sy, sz - dz, blockValue, 5, priority);
                }
                else if (dist == rad) {
                    this.putBlockAndMetadata(world, sx + dx, sy, sz + dz, blockValue, 9, priority);
                    this.putBlockAndMetadata(world, sx + dx, sy, sz - dz, blockValue, 3, priority);
                    this.putBlockAndMetadata(world, sx - dx, sy, sz + dz, blockValue, 7, priority);
                    this.putBlockAndMetadata(world, sx - dx, sy, sz - dz, blockValue, 1, priority);
                }
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
