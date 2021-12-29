// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class BlockTFFirefly extends BlockTFCritter
{
    public static int sprFirefly;
    
    protected BlockTFFirefly(final int index) {
        super(index);
        this.cl = BlockTFFirefly.sprFirefly;
    }
    
    public int r_() {
        return 50;
    }
    
    public int a(final int side, final int meta) {
        return BlockTFFirefly.sprFirefly;
    }
    
    public int getLightValue(final yf world, final int x, final int y, final int z) {
        return 15;
    }
    
    @Override
    public anq createTileEntity(final xv world, final int metadata) {
        return new TileEntityTFFirefly();
    }
    
    @Override
    public void g(final xv world, final int x, final int y, final int z) {
        super.g(world, x, y, z);
        world.a(x, y, z, this.cm, this.r_());
    }
    
    public void b(final xv world, final int x, final int y, final int z, final Random random) {
        if (world.m(x, y, z) < 12) {
            world.c(yh.b, x, y, z);
            world.i(x, y, z);
            world.a(x, y, z, this.cm, this.r_());
        }
    }
    
    static {
        BlockTFFirefly.sprFirefly = 4;
    }
}
