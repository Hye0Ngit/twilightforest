// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class TFGenWoodRoots extends TFGenerator
{
    private int rootBlock;
    private int rootMeta;
    private int oreBlock;
    private int oreMeta;
    
    public TFGenWoodRoots() {
        this.rootBlock = TFBlocks.wood.bO;
        this.rootMeta = 6;
        this.oreBlock = TFBlocks.wood.bO;
        this.oreMeta = 14;
    }
    
    @Override
    public boolean a(final xd world, final Random rand, final int x, final int y, final int z) {
        this.worldObj = world;
        if (world.a(x, y, z) != pb.t.bO) {
            return false;
        }
        float length = rand.nextFloat() * 6.0f + rand.nextFloat() * 6.0f + 4.0f;
        if (length > y) {
            length = (float)y;
        }
        final float tilt = 0.6f + rand.nextFloat() * 0.3f;
        return this.drawRoot(world, rand, x, y, z, length, rand.nextFloat(), tilt);
    }
    
    private boolean drawRoot(final xd world, final Random rand, final int x, final int y, final int z, final float length, final float angle, final float tilt) {
        final int[] dest = TFGenerator.translate(x, y, z, length, angle, tilt);
        if (world.a(dest[0], dest[1], dest[2]) != pb.t.bO) {
            return false;
        }
        this.drawBresehnam(x, y, z, dest[0], dest[1], dest[2], this.rootBlock, this.rootMeta, true);
        if (length > 8.0f && rand.nextInt(3) > 0) {
            final int[] nextSrc = TFGenerator.translate(x, y, z, length / 2.0f, angle, tilt);
            final float nextAngle = (angle + 0.25f + rand.nextFloat() * 0.5f) % 1.0f;
            final float nextTilt = 0.6f + rand.nextFloat() * 0.3f;
            this.drawRoot(world, rand, nextSrc[0], nextSrc[1], nextSrc[2], length / 2.0f, nextAngle, nextTilt);
        }
        if (length > 6.0f && rand.nextInt(4) == 0) {
            final int[] ballSrc = TFGenerator.translate(x, y, z, length / 2.0f, angle, tilt);
            final int[] ballDest = TFGenerator.translate(ballSrc[0], ballSrc[1], ballSrc[2], 1.5, (angle + 0.5f) % 1.0f, 0.75);
            world.b(ballSrc[0], ballSrc[1], ballSrc[2], this.oreBlock, this.oreMeta);
            world.b(ballSrc[0], ballSrc[1], ballDest[2], this.oreBlock, this.oreMeta);
            world.b(ballDest[0], ballSrc[1], ballSrc[2], this.oreBlock, this.oreMeta);
            world.b(ballDest[0], ballSrc[1], ballDest[2], this.oreBlock, this.oreMeta);
            world.b(ballSrc[0], ballDest[1], ballSrc[2], this.oreBlock, this.oreMeta);
            world.b(ballSrc[0], ballDest[1], ballDest[2], this.oreBlock, this.oreMeta);
            world.b(ballDest[0], ballDest[1], ballSrc[2], this.oreBlock, this.oreMeta);
            world.b(ballDest[0], ballDest[1], ballDest[2], this.oreBlock, this.oreMeta);
        }
        return true;
    }
}
