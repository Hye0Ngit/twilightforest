// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Random;
import twilightforest.tileentity.TileEntityTFFirefly;

public class BlockTFFirefly extends BlockTFCritter
{
    public static int sprFirefly;
    
    protected BlockTFFirefly(final int index) {
        super(index);
    }
    
    public int tickRate() {
        return 50;
    }
    
    public int getLightValue(final aae world, final int x, final int y, final int z) {
        return 15;
    }
    
    @Override
    public aqj createTileEntity(final zv world, final int metadata) {
        return new TileEntityTFFirefly();
    }
    
    @Override
    public void a(final zv world, final int x, final int y, final int z) {
        super.a(world, x, y, z);
        world.a(x, y, z, this.cz, this.tickRate());
    }
    
    public void a(final zv world, final int x, final int y, final int z, final Random random) {
        if (world.n(x, y, z) < 12) {
            world.c(aag.b, x, y, z);
            world.j(x, y, z);
            world.a(x, y, z, this.cz, this.tickRate());
        }
    }
    
    static {
        BlockTFFirefly.sprFirefly = 4;
    }
}
