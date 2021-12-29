// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.util.StringTranslate;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemAxe;

public class ItemTFMinotaurAxe extends ItemAxe
{
    private static final int BONUS_CHARGING_DAMAGE = 7;
    private Entity bonusDamageEntity;
    private EntityPlayer bonusDamagePlayer;
    private int myDamageVsEntity;
    
    protected ItemTFMinotaurAxe(final int par1, final EnumToolMaterial par2EnumToolMaterial) {
        super(par1, par2EnumToolMaterial);
        this.myDamageVsEntity = 4 + par2EnumToolMaterial.func_78000_c();
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public void func_77633_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        final ItemStack istack = new ItemStack(par1, 1, 0);
        par3List.add(istack);
    }
    
    public boolean onLeftClickEntity(final ItemStack stack, final EntityPlayer player, final Entity entity) {
        if (player.func_70051_ag()) {
            this.bonusDamageEntity = entity;
            this.bonusDamagePlayer = player;
        }
        return false;
    }
    
    public int func_77649_a(final Entity par1Entity) {
        if (this.bonusDamagePlayer != null && this.bonusDamageEntity != null && par1Entity == this.bonusDamageEntity) {
            this.bonusDamagePlayer.func_71047_c(par1Entity);
            this.bonusDamagePlayer = null;
            this.bonusDamageEntity = null;
            return this.myDamageVsEntity + 7;
        }
        return this.myDamageVsEntity;
    }
    
    public int func_77619_b() {
        return EnumToolMaterial.GOLD.func_77995_e();
    }
    
    @SideOnly(Side.CLIENT)
    public void func_77624_a(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        super.func_77624_a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add(StringTranslate.func_74808_a().func_74805_b(this.func_77658_a() + ".tooltip"));
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94581_a(final IconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("twilightforest:" + this.func_77658_a().substring(5));
    }
}
