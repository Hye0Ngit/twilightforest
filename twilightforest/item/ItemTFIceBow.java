// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.item.Item;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import twilightforest.entity.EntityIceArrow;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;

public class ItemTFIceBow extends ItemTFBowBase
{
    public ItemTFIceBow() {
        this.func_111206_d("TwilightForest:icebow");
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @Override
    protected EntityArrow getArrow(final World world, final EntityPlayer entityPlayer, final float velocity) {
        return new EntityIceArrow(world, entityPlayer, velocity);
    }
    
    public boolean func_82789_a(final ItemStack par1ItemStack, final ItemStack par2ItemStack) {
        return par2ItemStack.func_77973_b() == Item.func_150898_a(Blocks.field_150432_aD) || super.func_82789_a(par1ItemStack, par2ItemStack);
    }
}
