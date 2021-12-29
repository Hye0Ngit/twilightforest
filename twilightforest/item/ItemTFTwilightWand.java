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
        this.cq = 1;
        this.e(99);
        this.a((uy)TFItems.creativeTab);
    }
    
    public wg a(final wg par1ItemStack, final zv worldObj, final sk player) {
        if (par1ItemStack.k() < this.n()) {
            player.a(par1ItemStack, this.c_(par1ItemStack));
        }
        else {
            player.bX();
        }
        return par1ItemStack;
    }
    
    public void onUsingItemTick(final wg stack, final sk player, final int count) {
        if (stack.k() >= this.n()) {
            player.bX();
            return;
        }
        if (count % 6 == 0) {
            final zv worldObj = player.q;
            worldObj.a((mp)player, "mob.ghast.fireball", 1.0f, (worldObj.s.nextFloat() - worldObj.s.nextFloat()) * 0.2f + 1.0f);
            if (!worldObj.I) {
                worldObj.d((mp)new EntityTFTwilightWandBolt(worldObj, (ng)player));
                stack.a(1, (ng)player);
            }
        }
    }
    
    public int c_(final wg par1ItemStack) {
        return 72000;
    }
    
    public xj b_(final wg par1ItemStack) {
        return xj.e;
    }
    
    @Override
    public wr f(final wg par1ItemStack) {
        return wr.c;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final wg par1ItemStack, final sk par2EntityPlayer, final List par3List, final boolean par4) {
        super.a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add(par1ItemStack.l() - par1ItemStack.k() + " charges left");
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void a(final ly par1IconRegister) {
        this.ct = par1IconRegister.a("twilightforest:" + this.a().substring(5));
    }
}
