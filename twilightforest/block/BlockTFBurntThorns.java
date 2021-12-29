// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.world.IBlockAccess;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;

public class BlockTFBurntThorns extends BlockTFThorns
{
    protected BlockTFBurntThorns() {
        this.func_149711_c(0.01f);
        this.func_149752_b(0.0f);
        this.func_149672_a(BlockTFBurntThorns.field_149776_m);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.setNames(new String[] { "burnt" });
    }
    
    @Override
    public void func_149670_a(final World world, final int x, final int y, final int z, final Entity entity) {
        if (!world.field_72995_K && entity instanceof EntityLivingBase) {
            final int metadata = world.func_72805_g(x, y, z);
            world.func_72926_e(2001, x, y, z, Block.func_149682_b((Block)this) + (metadata << 12));
            world.func_147468_f(x, y, z);
        }
    }
    
    @Override
    public boolean removedByPlayer(final World world, final EntityPlayer player, final int x, final int y, final int z) {
        world.func_147468_f(x, y, z);
        return true;
    }
    
    @Override
    public boolean canSustainLeaves(final IBlockAccess world, final int x, final int y, final int z) {
        return false;
    }
    
    @Override
    public void func_149749_a(final World world, final int x, final int y, final int z, final Block logBlock, final int metadata) {
    }
}
