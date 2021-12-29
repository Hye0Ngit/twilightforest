// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.util.ChunkCoordinates;
import net.minecraft.init.Blocks;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;
import net.minecraft.block.Block;

public class TFGenWoodRoots extends TFGenerator
{
    private Block rootBlock;
    private int rootMeta;
    private Block oreBlock;
    private int oreMeta;
    
    public TFGenWoodRoots() {
        this.rootBlock = TFBlocks.root;
        this.rootMeta = 0;
        this.oreBlock = TFBlocks.root;
        this.oreMeta = 1;
    }
    
    public boolean func_76484_a(final World world, final Random rand, final int x, final int y, final int z) {
        if (world.func_147439_a(x, y, z) != Blocks.field_150348_b) {
            return false;
        }
        float length = rand.nextFloat() * 6.0f + rand.nextFloat() * 6.0f + 4.0f;
        if (length > y) {
            length = (float)y;
        }
        final float tilt = 0.6f + rand.nextFloat() * 0.3f;
        return this.drawRoot(world, rand, x, y, z, length, rand.nextFloat(), tilt);
    }
    
    private boolean drawRoot(final World world, final Random rand, final int x, final int y, final int z, final float length, final float angle, final float tilt) {
        return this.drawRoot(world, rand, x, y, z, x, y, z, length, angle, tilt);
    }
    
    private boolean drawRoot(final World world, final Random rand, final int ox, final int oy, final int oz, final int x, final int y, final int z, final float length, final float angle, final float tilt) {
        final int[] dest = TFGenerator.translate(x, y, z, length, angle, tilt);
        final int limit = 6;
        if (ox + limit < dest[0]) {
            dest[0] = ox + limit;
        }
        if (ox - limit > dest[0]) {
            dest[0] = ox - limit;
        }
        if (oz + limit < dest[2]) {
            dest[2] = oz + limit;
        }
        if (oz - limit > dest[2]) {
            dest[2] = oz - limit;
        }
        if (world.func_147439_a(dest[0], dest[1], dest[2]) != Blocks.field_150348_b) {
            return false;
        }
        final ChunkCoordinates[] bresehnamArrayCoords;
        final ChunkCoordinates[] lineArray = bresehnamArrayCoords = TFGenerator.getBresehnamArrayCoords(x, y, z, dest[0], dest[1], dest[2]);
        for (final ChunkCoordinates coord : bresehnamArrayCoords) {
            this.placeRootBlock(world, coord.field_71574_a, coord.field_71572_b, coord.field_71573_c, this.rootBlock, this.rootMeta);
        }
        if (length > 8.0f && rand.nextInt(3) > 0) {
            final int[] nextSrc = TFGenerator.translate(x, y, z, length / 2.0f, angle, tilt);
            final float nextAngle = (angle + 0.25f + rand.nextFloat() * 0.5f) % 1.0f;
            final float nextTilt = 0.6f + rand.nextFloat() * 0.3f;
            this.drawRoot(world, rand, ox, oy, oz, nextSrc[0], nextSrc[1], nextSrc[2], length / 2.0f, nextAngle, nextTilt);
        }
        if (length > 6.0f && rand.nextInt(4) == 0) {
            final int[] ballSrc = TFGenerator.translate(x, y, z, length / 2.0f, angle, tilt);
            final int[] ballDest = TFGenerator.translate(ballSrc[0], ballSrc[1], ballSrc[2], 1.5, (angle + 0.5f) % 1.0f, 0.75);
            this.placeRootBlock(world, ballSrc[0], ballSrc[1], ballSrc[2], this.oreBlock, this.oreMeta);
            this.placeRootBlock(world, ballSrc[0], ballSrc[1], ballDest[2], this.oreBlock, this.oreMeta);
            this.placeRootBlock(world, ballDest[0], ballSrc[1], ballSrc[2], this.oreBlock, this.oreMeta);
            this.placeRootBlock(world, ballDest[0], ballSrc[1], ballDest[2], this.oreBlock, this.oreMeta);
            this.placeRootBlock(world, ballSrc[0], ballDest[1], ballSrc[2], this.oreBlock, this.oreMeta);
            this.placeRootBlock(world, ballSrc[0], ballDest[1], ballDest[2], this.oreBlock, this.oreMeta);
            this.placeRootBlock(world, ballDest[0], ballDest[1], ballSrc[2], this.oreBlock, this.oreMeta);
            this.placeRootBlock(world, ballDest[0], ballDest[1], ballDest[2], this.oreBlock, this.oreMeta);
        }
        return true;
    }
    
    protected void placeRootBlock(final World world, final int x, final int y, final int z, final Block rootBlock2, final int meta) {
        if (TFTreeGenerator.canRootGrowIn(world, x, y, z)) {
            this.setBlockAndMetadata(world, x, y, z, rootBlock2, meta);
        }
    }
}
