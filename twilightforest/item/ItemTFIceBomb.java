// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.entity.EntityLivingBase;
import twilightforest.entity.boss.EntityTFIceBomb;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class ItemTFIceBomb extends ItemTF
{
    private IIcon[] snowIcon;
    
    public ItemTFIceBomb() {
        this.snowIcon = new IIcon[4];
        this.func_77625_d(16);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void func_94581_a(final IIconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("TwilightForest:" + this.func_77658_a().substring(5));
        for (int i = 0; i < 4; ++i) {
            this.snowIcon[i] = par1IconRegister.func_94245_a("TwilightForest:snow_" + i);
        }
    }
    
    public IIcon getSnowIcon(final int i) {
        return this.snowIcon[i];
    }
    
    public ItemStack func_77659_a(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        if (!par3EntityPlayer.field_71075_bZ.field_75098_d) {
            --par1ItemStack.field_77994_a;
        }
        par2World.func_72956_a((Entity)par3EntityPlayer, "random.bow", 0.5f, 0.4f / (ItemTFIceBomb.field_77697_d.nextFloat() * 0.4f + 0.8f));
        if (!par2World.field_72995_K) {
            par2World.func_72838_d((Entity)new EntityTFIceBomb(par2World, (EntityLivingBase)par3EntityPlayer));
        }
        return par1ItemStack;
    }
}
