// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import twilightforest.block.BlockTFTowerDevice;
import twilightforest.block.TFBlocks;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemTFTowerKey extends ItemTF
{
    protected ItemTFTowerKey(final int par1) {
        super(par1);
    }
    
    public boolean func_77648_a(final ItemStack itemStack, final EntityPlayer player, final World world, final int x, final int y, final int z, final int side, final float fx, final float fy, final float fz) {
        if (!world.field_72995_K && world.func_72798_a(x, y, z) == TFBlocks.towerDevice.field_71990_ca && world.func_72805_g(x, y, z) == 4) {
            BlockTFTowerDevice.unlockBlock(world, x, y, z);
            --itemStack.field_77994_a;
            return true;
        }
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void func_94581_a(final IconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("twilightforest:" + this.func_77658_a().substring(5));
    }
}
