// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import java.util.Random;
import twilightforest.block.TFBlocks;

public class TFGenWoodRoots extends TFGenerator
{
    private int rootBlock;
    private int rootMeta;
    private int oreBlock;
    private int oreMeta;
    
    public TFGenWoodRoots() {
        this.rootBlock = TFBlocks.root.cF;
        this.rootMeta = 0;
        this.oreBlock = TFBlocks.root.cF;
        this.oreMeta = 1;
    }
    
    @Override
    public boolean a(final abv world, final Random rand, final int x, final int y, final int z) {
        if (world.a(x, y, z) != aqw.y.cF) {
            return false;
        }
        float length = rand.nextFloat() * 6.0f + rand.nextFloat() * 6.0f + 4.0f;
        if (length > y) {
            length = (float)y;
        }
        final float tilt = 0.6f + rand.nextFloat() * 0.3f;
        return this.drawRoot(world, rand, x, y, z, length, rand.nextFloat(), tilt);
    }
    
    private boolean drawRoot(final abv world, final Random rand, final int x, final int y, final int z, final float length, final float angle, final float tilt) {
        return this.drawRoot(world, rand, x, y, z, x, y, z, length, angle, tilt);
    }
    
    private boolean drawRoot(final abv world, final Random rand, final int ox, final int oy, final int oz, final int x, final int y, final int z, final float length, final float angle, final float tilt) {
        final int[] dest = TFGenerator.translate(x, y, z, length, angle, tilt);
        final int limit = 7;
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
        if (world.a(dest[0], dest[1], dest[2]) != aqw.y.cF) {
            return false;
        }
        final int[] lineArray = TFGenerator.getBresehnamArray(x, y, z, dest[0], dest[1], dest[2]);
        for (int i = 0; i < lineArray.length; i += 3) {
            this.placeRootBlock(world, lineArray[i + 0], lineArray[i + 1], lineArray[i + 2], this.rootBlock, this.rootMeta);
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
    
    protected void placeRootBlock(final abv world, final int x, final int y, final int z, final int block, final int meta) {
        if (TFTreeGenerator.canRootGrowIn(world, x, y, z)) {
            this.a(world, x, y, z, block, meta);
        }
    }
}
