// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.tileentity.TileEntityTFFirefly;
import java.util.Random;

public class BlockTFFirefly extends BlockTFCritter
{
    public static int sprFirefly;
    public static Random rand;
    
    protected BlockTFFirefly(final int index) {
        super(index);
    }
    
    public int tickRate() {
        return 50 + BlockTFFirefly.rand.nextInt(50);
    }
    
    public int getLightValue(final ace world, final int x, final int y, final int z) {
        return 15;
    }
    
    @Override
    public asm createTileEntity(final abv world, final int metadata) {
        return new TileEntityTFFirefly();
    }
    
    @Override
    public void a(final abv world, final int x, final int y, final int z) {
        super.a(world, x, y, z);
    }
    
    public void a(final abv world, final int x, final int y, final int z, final Random random) {
        if (!world.I && world.n(x, y, z) < 12) {
            world.c(acg.b, x, y, z);
            world.j(x, y, z);
            world.a(x, y, z, this.cF, this.tickRate());
        }
    }
    
    static {
        BlockTFFirefly.sprFirefly = 4;
        BlockTFFirefly.rand = new Random();
    }
}
