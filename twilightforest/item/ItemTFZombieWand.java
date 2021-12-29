// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import java.util.List;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.EnumAction;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.Potion;
import twilightforest.entity.EntityTFLoyalZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;

public class ItemTFZombieWand extends ItemTF
{
    protected ItemTFZombieWand(final int par1) {
        super(par1);
        this.field_77777_bU = 1;
        this.func_77656_e(9);
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public ItemStack func_77659_a(final ItemStack par1ItemStack, final World worldObj, final EntityPlayer player) {
        if (par1ItemStack.func_77960_j() < this.func_77612_l()) {
            player.func_71008_a(par1ItemStack, this.func_77626_a(par1ItemStack));
            if (!worldObj.field_72995_K) {
                final MovingObjectPosition mop = this.getPlayerPointVec(worldObj, player, 20.0f);
                if (mop != null) {
                    final EntityTFLoyalZombie zombie = new EntityTFLoyalZombie(worldObj);
                    zombie.func_70080_a(mop.field_72307_f.field_72450_a, mop.field_72307_f.field_72448_b, mop.field_72307_f.field_72449_c, 1.0f, 1.0f);
                    zombie.func_70903_f(true);
                    zombie.func_70910_a(player.field_71092_bJ);
                    zombie.func_70690_d(new PotionEffect(Potion.field_76420_g.field_76415_H, 1200, 1));
                    worldObj.func_72838_d((Entity)zombie);
                    par1ItemStack.func_77972_a(1, (EntityLivingBase)player);
                }
            }
        }
        else {
            player.func_71034_by();
        }
        return par1ItemStack;
    }
    
    private MovingObjectPosition getPlayerPointVec(final World worldObj, final EntityPlayer player, final float range) {
        final Vec3 position = worldObj.func_82732_R().func_72345_a(player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v);
        final Vec3 look = player.func_70676_i(1.0f);
        final Vec3 dest = position.func_72441_c(look.field_72450_a * range, look.field_72448_b * range, look.field_72449_c * range);
        return worldObj.func_72933_a(position, dest);
    }
    
    public int func_77626_a(final ItemStack par1ItemStack) {
        return 30;
    }
    
    public EnumAction func_77661_b(final ItemStack par1ItemStack) {
        return EnumAction.bow;
    }
    
    @Override
    public EnumRarity func_77613_e(final ItemStack par1ItemStack) {
        return EnumRarity.rare;
    }
    
    public void func_77624_a(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(par1ItemStack.func_77958_k() - par1ItemStack.func_77960_j() + " charges left");
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void func_94581_a(final IconRegister par1IconRegister) {
        this.field_77791_bV = par1IconRegister.func_94245_a("TwilightForest:" + this.func_77658_a().substring(5));
    }
}
