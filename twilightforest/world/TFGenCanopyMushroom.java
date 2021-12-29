// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import twilightforest.block.TFBlocks;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.world.World;
import net.minecraft.init.Blocks;

public class TFGenCanopyMushroom extends TFTreeGenerator
{
    public TFGenCanopyMushroom() {
        this(false);
    }
    
    public TFGenCanopyMushroom(final boolean par1) {
        super(par1);
        this.treeBlock = Blocks.field_150419_aX;
        this.treeMeta = 10;
        this.branchMeta = 15;
        this.leafBlock = Blocks.field_150419_aX;
        this.leafMeta = 5;
    }
    
    public boolean func_76484_a(final World world, final Random random, final int x, final int y, final int z) {
        int treeHeight = 12;
        if (random.nextInt(3) == 0) {
            treeHeight += random.nextInt(5);
            if (random.nextInt(8) == 0) {
                treeHeight += random.nextInt(5);
            }
        }
        final Block blockUnder = world.func_147439_a(x, y - 1, z);
        if ((blockUnder != Blocks.field_150349_c && blockUnder != Blocks.field_150346_d && blockUnder != Blocks.field_150391_bh) || y >= 256 - treeHeight - 1) {
            return false;
        }
        this.treeBlock = ((random.nextInt(3) == 0) ? Blocks.field_150419_aX : Blocks.field_150420_aW);
        this.leafBlock = this.treeBlock;
        this.buildBranch(world, x, y, z, 0, treeHeight, 0.0, 0.0, true, random);
        final int numBranches = 3 + random.nextInt(2);
        final double offset = random.nextDouble();
        for (int b = 0; b < numBranches; ++b) {
            this.buildBranch(world, x, y, z, treeHeight - 5 + b, 9.0, 0.3 * b + offset, 0.2, false, random);
        }
        return true;
    }
    
    void buildBranch(final World world, final int x, final int y, final int z, final int height, final double length, final double angle, final double tilt, final boolean trunk, final Random treeRNG) {
        final ChunkCoordinates src = new ChunkCoordinates(x, y + height, z);
        final ChunkCoordinates dest = TFTreeGenerator.translateCoords(src.field_71574_a, src.field_71572_b, src.field_71573_c, length, angle, tilt);
        if (dest.field_71574_a - x < -4) {
            dest.field_71574_a = x - 4;
        }
        if (dest.field_71574_a - x > 4) {
            dest.field_71574_a = x + 4;
        }
        if (dest.field_71573_c - z < -4) {
            dest.field_71573_c = z - 4;
        }
        if (dest.field_71573_c - z > 4) {
            dest.field_71573_c = z + 4;
        }
        if (src.field_71574_a != dest.field_71574_a || src.field_71573_c != dest.field_71573_c) {
            this.drawBresehnam(world, src.field_71574_a, src.field_71572_b, src.field_71573_c, dest.field_71574_a, src.field_71572_b, dest.field_71573_c, this.treeBlock, this.branchMeta);
            this.drawBresehnam(world, dest.field_71574_a, src.field_71572_b + 1, dest.field_71573_c, dest.field_71574_a, dest.field_71572_b - 1, dest.field_71573_c, this.treeBlock, this.treeMeta);
        }
        else {
            this.drawBresehnam(world, src.field_71574_a, src.field_71572_b, src.field_71573_c, dest.field_71574_a, dest.field_71572_b - 1, dest.field_71573_c, this.treeBlock, this.treeMeta);
        }
        if (trunk) {
            this.addFirefly(world, x, y, z, 3 + treeRNG.nextInt(7), treeRNG.nextDouble());
        }
        this.drawMushroomCircle(world, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c, 4, this.leafBlock);
    }
    
    public void drawMushroomCircle(final World world, final int sx, final int sy, final int sz, final int rad, final Block blockValue) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dz = 0; dz <= rad; ++dz) {
                int dist = (int)(Math.max(dx, dz) + Math.min(dx, dz) * 0.5);
                if (dx == 3 && dz == 3) {
                    dist = 6;
                }
                if (dx == 0) {
                    if (dz < rad) {
                        this.setBlockAndMetadata(world, sx + 0, sy, sz + dz, blockValue, 5);
                        this.setBlockAndMetadata(world, sx + 0, sy, sz - dz, blockValue, 5);
                    }
                    else {
                        this.setBlockAndMetadata(world, sx + 0, sy, sz + dz, blockValue, 8);
                        this.setBlockAndMetadata(world, sx + 0, sy, sz - dz, blockValue, 2);
                    }
                }
                else if (dz == 0) {
                    if (dx < rad) {
                        this.setBlockAndMetadata(world, sx + dx, sy, sz + 0, blockValue, 5);
                        this.setBlockAndMetadata(world, sx - dx, sy, sz + 0, blockValue, 5);
                    }
                    else {
                        this.setBlockAndMetadata(world, sx + dx, sy, sz + 0, blockValue, 6);
                        this.setBlockAndMetadata(world, sx - dx, sy, sz + 0, blockValue, 4);
                    }
                }
                else if (dist < rad) {
                    this.setBlockAndMetadata(world, sx + dx, sy, sz + dz, blockValue, 5);
                    this.setBlockAndMetadata(world, sx + dx, sy, sz - dz, blockValue, 5);
                    this.setBlockAndMetadata(world, sx - dx, sy, sz + dz, blockValue, 5);
                    this.setBlockAndMetadata(world, sx - dx, sy, sz - dz, blockValue, 5);
                }
                else if (dist == rad) {
                    this.setBlockAndMetadata(world, sx + dx, sy, sz + dz, blockValue, 9);
                    this.setBlockAndMetadata(world, sx + dx, sy, sz - dz, blockValue, 3);
                    this.setBlockAndMetadata(world, sx - dx, sy, sz + dz, blockValue, 7);
                    this.setBlockAndMetadata(world, sx - dx, sy, sz - dz, blockValue, 1);
                }
            }
        }
    }
    
    private void addFirefly(final World world, final int x, final int y, final int z, final int height, final double angle) {
        final int iAngle = (int)(angle * 4.0);
        if (iAngle == 0) {
            this.setBlockAndMetadata(world, x + 1, y + height, z, TFBlocks.firefly, 0);
        }
        else if (iAngle == 1) {
            this.setBlockAndMetadata(world, x - 1, y + height, z, TFBlocks.firefly, 0);
        }
        else if (iAngle == 2) {
            this.setBlockAndMetadata(world, x, y + height, z + 1, TFBlocks.firefly, 0);
        }
        else if (iAngle == 3) {
            this.setBlockAndMetadata(world, x, y + height, z - 1, TFBlocks.firefly, 0);
        }
    }
}
