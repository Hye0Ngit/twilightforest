// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import twilightforest.entity.EntityTFTwilightWandBolt;

public class ItemTFTwilightWand extends ItemTF
{
    protected ItemTFTwilightWand(final int par1) {
        super(par1);
        this.cw = 1;
        this.e(99);
        this.a((wv)TFItems.creativeTab);
    }
    
    public yd a(final yd par1ItemStack, final abv worldObj, final ue player) {
        if (par1ItemStack.k() < this.o()) {
            player.a(par1ItemStack, this.d_(par1ItemStack));
        }
        else {
            player.bs();
        }
        return par1ItemStack;
    }
    
    public void onUsingItemTick(final yd stack, final ue player, final int count) {
        if (stack.k() >= this.o()) {
            player.bs();
            return;
        }
        if (count % 6 == 0) {
            final abv worldObj = player.q;
            worldObj.a((nm)player, "mob.ghast.fireball", 1.0f, (worldObj.s.nextFloat() - worldObj.s.nextFloat()) * 0.2f + 1.0f);
            if (!worldObj.I) {
                worldObj.d((nm)new EntityTFTwilightWandBolt(worldObj, (oe)player));
                stack.a(1, (oe)player);
            }
        }
    }
    
    public int d_(final yd par1ItemStack) {
        return 72000;
    }
    
    public zi c_(final yd par1ItemStack) {
        return zi.e;
    }
    
    @Override
    public yp f(final yd par1ItemStack) {
        return yp.c;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final yd par1ItemStack, final ue par2EntityPlayer, final List par3List, final boolean par4) {
        super.a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add(par1ItemStack.l() - par1ItemStack.k() + " charges left");
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void a(final ms par1IconRegister) {
        this.cz = par1IconRegister.a("TwilightForest:" + this.a().substring(5));
    }
}
