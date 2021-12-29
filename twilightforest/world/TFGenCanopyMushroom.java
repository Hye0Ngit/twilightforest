// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.block.TFBlocks;
import java.util.Random;

public class TFGenCanopyMushroom extends TFGenerator
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
    
    public TFGenCanopyMushroom() {
        this.treeMeta = 10;
        this.branchMeta = 15;
        this.leafMeta = 5;
    }
    
    @Override
    public boolean a(final yc world, final Random random, final int treeX, final int treeY, final int treeZ) {
        this.worldObj = world;
        this.treeRNG = random;
        final int blockUnder = world.a(treeX, treeY - 1, treeZ);
        if ((blockUnder != amq.x.cm && blockUnder != amq.y.cm && blockUnder != amq.bB.cm) || this.y >= 128 - this.treeHeight - 1) {
            return false;
        }
        this.x = treeX;
        this.y = treeY;
        this.z = treeZ;
        this.treeBlock = ((this.treeRNG.nextInt(3) == 0) ? amq.br.cm : amq.bq.cm);
        this.leafBlock = this.treeBlock;
        this.treeHeight = 12;
        if (this.treeRNG.nextInt(3) == 0) {
            this.treeHeight += this.treeRNG.nextInt(5);
            if (this.treeRNG.nextInt(8) == 0) {
                this.treeHeight += this.treeRNG.nextInt(5);
            }
        }
        this.buildBranch(0, this.treeHeight, 0.0, 0.0, true);
        final int numBranches = 3 + this.treeRNG.nextInt(2);
        final double offset = this.treeRNG.nextDouble();
        for (int b = 0; b < numBranches; ++b) {
            this.buildBranch(this.treeHeight - 5 + b, 9.0, 0.3 * b + offset, 0.2, false);
        }
        return true;
    }
    
    void buildBranch(final int height, final double length, final double angle, final double tilt, final boolean firefly) {
        final int[] src = { this.x, this.y + height, this.z };
        final int[] dest = TFGenerator.translate(src[0], src[1], src[2], length, angle, tilt);
        if (src[0] != dest[0] || src[2] != dest[2]) {
            this.drawBresehnam(src[0], src[1], src[2], dest[0], src[1], dest[2], this.treeBlock, this.branchMeta, true);
            this.drawBresehnam(dest[0], src[1] + 1, dest[2], dest[0], dest[1] - 1, dest[2], this.treeBlock, this.treeMeta, true);
        }
        else {
            this.drawBresehnam(src[0], src[1], src[2], dest[0], dest[1] - 1, dest[2], this.treeBlock, this.treeMeta, true);
        }
        if (firefly) {
            this.addFirefly(3 + this.treeRNG.nextInt(7), this.treeRNG.nextDouble());
        }
        this.drawMushroomCircle(dest[0], dest[1], dest[2], 4, this.leafBlock, true);
    }
    
    public void drawMushroomCircle(final int sx, final int sy, final int sz, final int rad, final int blockValue, final boolean priority) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dz = 0; dz <= rad; ++dz) {
                int dist = (int)(Math.max(dx, dz) + Math.min(dx, dz) * 0.5);
                if (dx == 3 && dz == 3) {
                    dist = 6;
                }
                if (dx == 0) {
                    if (dz < rad) {
                        this.putBlockAndMetadata(sx + 0, sy, sz + dz, blockValue, 5, priority);
                        this.putBlockAndMetadata(sx + 0, sy, sz - dz, blockValue, 5, priority);
                    }
                    else {
                        this.putBlockAndMetadata(sx + 0, sy, sz + dz, blockValue, 8, priority);
                        this.putBlockAndMetadata(sx + 0, sy, sz - dz, blockValue, 2, priority);
                    }
                }
                else if (dz == 0) {
                    if (dx < rad) {
                        this.putBlockAndMetadata(sx + dx, sy, sz + 0, blockValue, 5, priority);
                        this.putBlockAndMetadata(sx - dx, sy, sz + 0, blockValue, 5, priority);
                    }
                    else {
                        this.putBlockAndMetadata(sx + dx, sy, sz + 0, blockValue, 6, priority);
                        this.putBlockAndMetadata(sx - dx, sy, sz + 0, blockValue, 4, priority);
                    }
                }
                else if (dist < rad) {
                    this.putBlockAndMetadata(sx + dx, sy, sz + dz, blockValue, 5, priority);
                    this.putBlockAndMetadata(sx + dx, sy, sz - dz, blockValue, 5, priority);
                    this.putBlockAndMetadata(sx - dx, sy, sz + dz, blockValue, 5, priority);
                    this.putBlockAndMetadata(sx - dx, sy, sz - dz, blockValue, 5, priority);
                }
                else if (dist == rad) {
                    this.putBlockAndMetadata(sx + dx, sy, sz + dz, blockValue, 9, priority);
                    this.putBlockAndMetadata(sx + dx, sy, sz - dz, blockValue, 3, priority);
                    this.putBlockAndMetadata(sx - dx, sy, sz + dz, blockValue, 7, priority);
                    this.putBlockAndMetadata(sx - dx, sy, sz - dz, blockValue, 1, priority);
                }
            }
        }
    }
    
    private void addFirefly(final int height, final double angle) {
        final int iAngle = (int)(angle * 4.0);
        if (iAngle == 0) {
            this.putBlockAndMetadata(this.x + 1, this.y + height, this.z, TFBlocks.firefly.cm, 0, false);
        }
        else if (iAngle == 1) {
            this.putBlockAndMetadata(this.x - 1, this.y + height, this.z, TFBlocks.firefly.cm, 0, false);
        }
        else if (iAngle == 2) {
            this.putBlockAndMetadata(this.x, this.y + height, this.z + 1, TFBlocks.firefly.cm, 0, false);
        }
        else if (iAngle == 3) {
            this.putBlockAndMetadata(this.x, this.y + height, this.z - 1, TFBlocks.firefly.cm, 0, false);
        }
    }
}
