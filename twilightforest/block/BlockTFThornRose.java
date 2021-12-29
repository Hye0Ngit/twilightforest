// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public class BlockTFThornRose extends Block
{
    protected BlockTFThornRose() {
        super(Material.field_151585_k);
        this.func_149711_c(10.0f);
        this.func_149672_a(BlockTFThornRose.field_149779_h);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        final float radius = 0.4f;
        this.func_149676_a(0.5f - radius, 0.5f - radius, 0.5f - radius, 0.5f + radius, 0.5f + radius, 0.5f + radius);
    }
    
    public int func_149645_b() {
        return 1;
    }
    
    public boolean func_149686_d() {
        return false;
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    public boolean func_149742_c(final World world, final int x, final int y, final int z) {
        return this.func_149718_j(world, x, y, z);
    }
    
    public AxisAlignedBB func_149668_a(final World world, final int x, final int y, final int z) {
        return null;
    }
    
    public void func_149695_a(final World world, final int x, final int y, final int z, final Block block) {
        if (!this.func_149718_j(world, x, y, z)) {
            this.func_149697_b(world, x, y, z, world.func_72805_g(x, y, z), 0);
            world.func_147468_f(x, y, z);
        }
    }
    
    public boolean func_149718_j(final World world, final int x, final int y, final int z) {
        boolean supported = false;
        for (final ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
            final int dx = x + dir.offsetX;
            final int dy = y + dir.offsetY;
            final int dz = z + dir.offsetZ;
            if (world.func_147439_a(dx, dy, dz).canSustainLeaves((IBlockAccess)world, dx, dy, dz)) {
                supported = true;
            }
        }
        return supported;
    }
}
