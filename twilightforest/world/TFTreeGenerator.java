// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.world.IBlockAccess;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public abstract class TFTreeGenerator extends WorldGenAbstractTree
{
    protected Block treeBlock;
    protected int treeMeta;
    protected int branchMeta;
    protected Block leafBlock;
    protected int leafMeta;
    protected Block rootBlock;
    protected int rootMeta;
    
    public TFTreeGenerator() {
        this(false);
    }
    
    public TFTreeGenerator(final boolean par1) {
        super(par1);
        this.treeBlock = TFBlocks.log;
        this.treeMeta = 3;
        this.branchMeta = 15;
        this.leafBlock = TFBlocks.hedge;
        this.leafMeta = 1;
        this.rootBlock = TFBlocks.root;
        this.rootMeta = 0;
    }
    
    protected void buildRoot(final World world, final int x, final int y, final int z, final double offset, final int b) {
        final ChunkCoordinates dest = translateCoords(x, y - b - 2, z, 5.0, 0.3 * b + offset, 0.8);
        final ChunkCoordinates[] bresehnamArrayCoords;
        final ChunkCoordinates[] lineArray = bresehnamArrayCoords = getBresehnamArrayCoords(x, y - b - 2, z, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c);
        for (final ChunkCoordinates coord : bresehnamArrayCoords) {
            this.placeRootBlock(world, coord.field_71574_a, coord.field_71572_b, coord.field_71573_c, this.rootBlock, this.rootMeta);
        }
    }
    
    protected void placeRootBlock(final World world, final int x, final int y, final int z, final Block rootBlock2, final int meta) {
        if (canRootGrowIn(world, x, y, z)) {
            this.setBlockAndMetadata(world, x, y, z, rootBlock2, meta);
        }
    }
    
    public static boolean canRootGrowIn(final World world, final int x, final int y, final int z) {
        final Block blockID = world.func_147439_a(x, y, z);
        if (blockID == Blocks.field_150350_a) {
            return isNearSolid(world, x, y, z);
        }
        return blockID != Blocks.field_150357_h && blockID != Blocks.field_150343_Z && blockID != TFBlocks.shield;
    }
    
    public static int[] translate(final int sx, final int sy, final int sz, final double distance, final double angle, final double tilt) {
        return TFGenerator.translate(sx, sy, sz, distance, angle, tilt);
    }
    
    protected static ChunkCoordinates translateCoords(final int sx, final int sy, final int sz, final double length, final double angle, final double tilt) {
        return TFGenerator.translateCoords(sx, sy, sz, length, angle, tilt);
    }
    
    public static ChunkCoordinates[] getBresehnamArrayCoords(final ChunkCoordinates src, final ChunkCoordinates dest) {
        return TFGenerator.getBresehnamArrayCoords(src.field_71574_a, src.field_71572_b, src.field_71573_c, dest.field_71574_a, dest.field_71572_b, dest.field_71573_c);
    }
    
    public static ChunkCoordinates[] getBresehnamArrayCoords(final int x1, final int y1, final int z1, final int x2, final int y2, final int z2) {
        return TFGenerator.getBresehnamArrayCoords(x1, y1, z1, x2, y2, z2);
    }
    
    protected static boolean isNearSolid(final World world, final int bx, final int by, final int bz) {
        return TFGenerator.isNearSolid(world, bx, by, bz);
    }
    
    protected static boolean hasAirAround(final World world, final int bx, final int by, final int bz) {
        return TFGenerator.hasAirAround(world, bx, by, bz);
    }
    
    protected void setBlock(final World world, final int x, final int y, final int z, final Block block) {
        this.func_150515_a(world, x, y, z, block);
    }
    
    protected void setBlockAndMetadata(final World world, final int x, final int y, final int z, final Block block, final int meta) {
        this.func_150516_a(world, x, y, z, block, meta);
    }
    
    public void makeLeafCircle(final World world, final int sx, final int sy, final int sz, final int rad, final Block blockValue, final int metaValue) {
        this.makeLeafCircle(world, sx, sy, sz, rad, blockValue, metaValue, false);
    }
    
    protected void drawBresehnam(final World world, final int x1, final int y1, final int z1, final int x2, final int y2, final int z2, final Block blockValue, final int metaValue) {
        if (x1 == x2 && z1 == z2) {
            for (int l = Math.max(y1, y2), i = Math.min(y1, y2); i < l; ++i) {
                this.setBlockAndMetadata(world, x1, i, z1, blockValue, metaValue);
            }
        }
        else {
            final ChunkCoordinates[] bresehnamArrayCoords;
            final ChunkCoordinates[] lineArray = bresehnamArrayCoords = getBresehnamArrayCoords(x1, y1, z1, x2, y2, z2);
            for (final ChunkCoordinates pixel : bresehnamArrayCoords) {
                this.setBlockAndMetadata(world, pixel.field_71574_a, pixel.field_71572_b, pixel.field_71573_c, blockValue, metaValue);
            }
        }
    }
    
    public void makeLeafCircle(final World world, final int sx, final int sy, final int sz, final int rad, final Block blockValue, final int metaValue, final boolean useHack) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dz = 0; dz <= rad; ++dz) {
                int dist = Math.max(dx, dz) + (Math.min(dx, dz) >> 1);
                if (useHack && dx == 3 && dz == 3) {
                    dist = 6;
                }
                if (dist <= rad) {
                    this.putLeafBlock(world, sx + dx, sy, sz + dz, blockValue, metaValue);
                    this.putLeafBlock(world, sx + dx, sy, sz - dz, blockValue, metaValue);
                    this.putLeafBlock(world, sx - dx, sy, sz + dz, blockValue, metaValue);
                    this.putLeafBlock(world, sx - dx, sy, sz - dz, blockValue, metaValue);
                }
            }
        }
    }
    
    public void makeLeafCircle2(final World world, final int sx, final int sy, final int sz, final int rad, final Block blockValue, final int metaValue, final boolean useHack) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dz = 0; dz <= rad; ++dz) {
                if (dx * dx + dz * dz <= rad * rad) {
                    this.putLeafBlock(world, sx + 1 + dx, sy, sz + 1 + dz, blockValue, metaValue);
                    this.putLeafBlock(world, sx + 1 + dx, sy, sz - dz, blockValue, metaValue);
                    this.putLeafBlock(world, sx - dx, sy, sz + 1 + dz, blockValue, metaValue);
                    this.putLeafBlock(world, sx - dx, sy, sz - dz, blockValue, metaValue);
                }
            }
        }
    }
    
    public void drawLeafBlob(final World world, final int sx, final int sy, final int sz, final int rad, final Block blockValue, final int metaValue) {
        for (byte dx = 0; dx <= rad; ++dx) {
            for (byte dy = 0; dy <= rad; ++dy) {
                for (byte dz = 0; dz <= rad; ++dz) {
                    int dist = 0;
                    if (dx >= dy && dx >= dz) {
                        dist = dx + (Math.max(dy, dz) >> 1) + (Math.min(dy, dz) >> 2);
                    }
                    else if (dy >= dx && dy >= dz) {
                        dist = dy + (Math.max(dx, dz) >> 1) + (Math.min(dx, dz) >> 2);
                    }
                    else {
                        dist = dz + (Math.max(dx, dy) >> 1) + (Math.min(dx, dy) >> 2);
                    }
                    if (dist <= rad) {
                        this.putLeafBlock(world, sx + dx, sy + dy, sz + dz, blockValue, metaValue);
                        this.putLeafBlock(world, sx + dx, sy + dy, sz - dz, blockValue, metaValue);
                        this.putLeafBlock(world, sx - dx, sy + dy, sz + dz, blockValue, metaValue);
                        this.putLeafBlock(world, sx - dx, sy + dy, sz - dz, blockValue, metaValue);
                        this.putLeafBlock(world, sx + dx, sy - dy, sz + dz, blockValue, metaValue);
                        this.putLeafBlock(world, sx + dx, sy - dy, sz - dz, blockValue, metaValue);
                        this.putLeafBlock(world, sx - dx, sy - dy, sz + dz, blockValue, metaValue);
                        this.putLeafBlock(world, sx - dx, sy - dy, sz - dz, blockValue, metaValue);
                    }
                }
            }
        }
    }
    
    public void putLeafBlock(final World world, final int x, final int y, final int z, final Block blockValue, final int metaValue) {
        final Block block;
        final Block whatsThere = block = world.func_147439_a(x, y, z);
        if (block == null || block.canBeReplacedByLeaves((IBlockAccess)world, x, y, z)) {
            this.setBlockAndMetadata(world, x, y, z, blockValue, metaValue);
        }
    }
}
