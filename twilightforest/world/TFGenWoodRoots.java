// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.world;

import net.minecraft.block.Block;
import java.util.Random;
import net.minecraft.world.World;
import twilightforest.block.TFBlocks;

public class TFGenWoodRoots extends TFGenerator
{
    private int rootBlock;
    private int rootMeta;
    private int oreBlock;
    private int oreMeta;
    
    public TFGenWoodRoots() {
        this.rootBlock = TFBlocks.root.field_71990_ca;
        this.rootMeta = 0;
        this.oreBlock = TFBlocks.root.field_71990_ca;
        this.oreMeta = 1;
    }
    
    @Override
    public boolean func_76484_a(final World world, final Random rand, final int x, final int y, final int z) {
        if (world.func_72798_a(x, y, z) != Block.field_71981_t.field_71990_ca) {
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
        final int[] dest = TFGenerator.translate(x, y, z, length, angle, tilt);
        final int limit = 8;
        if (x + limit < dest[0]) {
            dest[0] = x + limit;
        }
        if (x - limit > dest[0]) {
            dest[0] = x - limit;
        }
        if (z + limit < dest[2]) {
            dest[2] = z + limit;
        }
        if (z - limit > dest[2]) {
            dest[2] = z - limit;
        }
        if (world.func_72798_a(dest[0], dest[1], dest[2]) != Block.field_71981_t.field_71990_ca) {
            return false;
        }
        this.drawBresehnam(world, x, y, z, dest[0], dest[1], dest[2], this.rootBlock, this.rootMeta, true);
        if (length > 8.0f && rand.nextInt(3) > 0) {
            final int[] nextSrc = TFGenerator.translate(x, y, z, length / 2.0f, angle, tilt);
            final float nextAngle = (angle + 0.25f + rand.nextFloat() * 0.5f) % 1.0f;
            final float nextTilt = 0.6f + rand.nextFloat() * 0.3f;
            this.drawRoot(world, rand, nextSrc[0], nextSrc[1], nextSrc[2], length / 2.0f, nextAngle, nextTilt);
        }
        if (length > 6.0f && rand.nextInt(4) == 0) {
            final int[] ballSrc = TFGenerator.translate(x, y, z, length / 2.0f, angle, tilt);
            final int[] ballDest = TFGenerator.translate(ballSrc[0], ballSrc[1], ballSrc[2], 1.5, (angle + 0.5f) % 1.0f, 0.75);
            world.func_72832_d(ballSrc[0], ballSrc[1], ballSrc[2], this.oreBlock, this.oreMeta, 2);
            world.func_72832_d(ballSrc[0], ballSrc[1], ballDest[2], this.oreBlock, this.oreMeta, 2);
            world.func_72832_d(ballDest[0], ballSrc[1], ballSrc[2], this.oreBlock, this.oreMeta, 2);
            world.func_72832_d(ballDest[0], ballSrc[1], ballDest[2], this.oreBlock, this.oreMeta, 2);
            world.func_72832_d(ballSrc[0], ballDest[1], ballSrc[2], this.oreBlock, this.oreMeta, 2);
            world.func_72832_d(ballSrc[0], ballDest[1], ballDest[2], this.oreBlock, this.oreMeta, 2);
            world.func_72832_d(ballDest[0], ballDest[1], ballSrc[2], this.oreBlock, this.oreMeta, 2);
            world.func_72832_d(ballDest[0], ballDest[1], ballDest[2], this.oreBlock, this.oreMeta, 2);
        }
        return true;
    }
}
