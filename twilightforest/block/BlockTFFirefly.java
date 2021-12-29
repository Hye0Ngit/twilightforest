// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.EnumSkyBlock;
import twilightforest.tileentity.TileEntityTFFirefly;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
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
    
    public int getLightValue(final IBlockAccess world, final int x, final int y, final int z) {
        return 15;
    }
    
    @Override
    public TileEntity createTileEntity(final World world, final int metadata) {
        return new TileEntityTFFirefly();
    }
    
    @Override
    public void func_71861_g(final World world, final int x, final int y, final int z) {
        super.func_71861_g(world, x, y, z);
    }
    
    public void func_71847_b(final World world, final int x, final int y, final int z, final Random random) {
        if (!world.field_72995_K && world.func_72957_l(x, y, z) < 12) {
            world.func_72936_c(EnumSkyBlock.Block, x, y, z);
            world.func_72845_h(x, y, z);
            world.func_72836_a(x, y, z, this.field_71990_ca, this.tickRate());
        }
    }
    
    static {
        BlockTFFirefly.sprFirefly = 4;
        BlockTFFirefly.rand = new Random();
    }
}
