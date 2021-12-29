// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Random;
import twilightforest.tileentity.TileEntityTFMoonworm;

public class BlockTFMoonworm extends BlockTFCritter
{
    public static int sprMoonworm;
    
    protected BlockTFMoonworm(final int index) {
        super(index);
    }
    
    public int tickRate() {
        return 50;
    }
    
    @Override
    public void a(final ace world, final int x, final int y, final int z) {
        final int facing = world.h(x, y, z) & 0x7;
        final float wide = 0.25f;
        if (facing == 1) {
            this.a(0.0f, 0.25f, 0.5f - wide, wide, 0.75f, 0.5f + wide);
        }
        else if (facing == 2) {
            this.a(1.0f - wide, 0.25f, 0.5f - wide, 1.0f, 0.75f, 0.5f + wide);
        }
        else if (facing == 3) {
            this.a(0.5f - wide, 0.25f, 0.0f, 0.5f + wide, 0.75f, wide);
        }
        else if (facing == 4) {
            this.a(0.5f - wide, 0.25f, 1.0f - wide, 0.5f + wide, 0.75f, 1.0f);
        }
        else if (facing == 5) {
            this.a(0.5f - wide, 0.0f, 0.25f, 0.5f + wide, wide, 0.75f);
        }
        else if (facing == 6) {
            this.a(0.5f - wide, 1.0f - wide, 0.25f, 0.5f + wide, 1.0f, 0.75f);
        }
        else {
            final float f1 = 0.1f;
            this.a(0.5f - f1, 0.0f, 0.5f - f1, 0.5f + f1, 0.6f, 0.5f + f1);
        }
    }
    
    public int getLightValue(final ace world, final int x, final int y, final int z) {
        return 14;
    }
    
    @Override
    public asm createTileEntity(final abv world, final int metadata) {
        return new TileEntityTFMoonworm();
    }
    
    @Override
    public void a(final abv world, final int x, final int y, final int z) {
        super.a(world, x, y, z);
        world.a(x, y, z, this.cF, this.tickRate());
    }
    
    public void a(final abv world, final int x, final int y, final int z, final Random random) {
        if (world.n(x, y, z) < 12) {
            world.c(acg.b, x, y, z);
            world.j(x, y, z);
            world.a(x, y, z, this.cF, this.tickRate());
        }
    }
    
    @Override
    public boolean dropCritterIfCantStay(final abv world, final int x, final int y, final int z) {
        if (!this.c(world, x, y, z)) {
            world.f(x, y, z, 0, 0, 3);
            return false;
        }
        return true;
    }
    
    public int quantityDropped(final int meta, final int fortune, final Random random) {
        return 0;
    }
    
    static {
        BlockTFMoonworm.sprMoonworm = 52;
    }
}
