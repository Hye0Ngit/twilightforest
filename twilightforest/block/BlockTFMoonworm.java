// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Random;
import net.minecraft.block.Block;
import twilightforest.tileentity.TileEntityTFMoonworm;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;

public class BlockTFMoonworm extends BlockTFCritter
{
    public static int sprMoonworm;
    
    protected BlockTFMoonworm() {
    }
    
    public int tickRate() {
        return 50;
    }
    
    @Override
    public void func_149719_a(final IBlockAccess world, final int x, final int y, final int z) {
        final int facing = world.func_72805_g(x, y, z) & 0x7;
        final float wide = 0.25f;
        if (facing == 1) {
            this.func_149676_a(0.0f, 0.25f, 0.5f - wide, wide, 0.75f, 0.5f + wide);
        }
        else if (facing == 2) {
            this.func_149676_a(1.0f - wide, 0.25f, 0.5f - wide, 1.0f, 0.75f, 0.5f + wide);
        }
        else if (facing == 3) {
            this.func_149676_a(0.5f - wide, 0.25f, 0.0f, 0.5f + wide, 0.75f, wide);
        }
        else if (facing == 4) {
            this.func_149676_a(0.5f - wide, 0.25f, 1.0f - wide, 0.5f + wide, 0.75f, 1.0f);
        }
        else if (facing == 5) {
            this.func_149676_a(0.5f - wide, 0.0f, 0.25f, 0.5f + wide, wide, 0.75f);
        }
        else if (facing == 6) {
            this.func_149676_a(0.5f - wide, 1.0f - wide, 0.25f, 0.5f + wide, 1.0f, 0.75f);
        }
        else {
            final float f1 = 0.1f;
            this.func_149676_a(0.5f - f1, 0.0f, 0.5f - f1, 0.5f + f1, 0.6f, 0.5f + f1);
        }
    }
    
    public int getLightValue(final IBlockAccess world, final int x, final int y, final int z) {
        return 14;
    }
    
    @Override
    public TileEntity createTileEntity(final World world, final int metadata) {
        return new TileEntityTFMoonworm();
    }
    
    @Override
    public void func_149726_b(final World world, final int x, final int y, final int z) {
        super.func_149726_b(world, x, y, z);
        world.func_147464_a(x, y, z, (Block)this, this.tickRate());
    }
    
    public void func_149674_a(final World world, final int x, final int y, final int z, final Random random) {
        if (world.func_72957_l(x, y, z) < 12) {
            world.func_147464_a(x, y, z, (Block)this, this.tickRate());
        }
    }
    
    @Override
    public boolean dropCritterIfCantStay(final World world, final int x, final int y, final int z) {
        if (!this.func_149742_c(world, x, y, z)) {
            world.func_147468_f(x, y, z);
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
