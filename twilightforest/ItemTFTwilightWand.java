// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import java.util.List;

public class ItemTFTwilightWand extends ItemTF
{
    protected ItemTFTwilightWand(final int par1) {
        super(par1);
        this.ch = 1;
        this.e(99);
        this.a(th.j);
    }
    
    public um a(final um par1ItemStack, final xv worldObj, final qx player) {
        if (par1ItemStack.j() < this.m()) {
            player.a(par1ItemStack, this.a(par1ItemStack));
        }
        else {
            player.bO();
        }
        return par1ItemStack;
    }
    
    public void onUsingItemTick(final um stack, final qx player, final int count) {
        if (stack.j() >= this.m()) {
            player.bO();
            return;
        }
        if (count % 6 == 0) {
            final xv worldObj = player.p;
            worldObj.a((lq)player, "mob.ghast.fireball", 1.0f, (worldObj.u.nextFloat() - worldObj.u.nextFloat()) * 0.2f + 1.0f);
            if (!worldObj.J) {
                worldObj.d((lq)new EntityTFTwilightWandBolt(worldObj, (md)player));
                stack.a(1, (md)player);
            }
        }
    }
    
    public int a(final um par1ItemStack) {
        return 72000;
    }
    
    public vn d_(final um par1ItemStack) {
        return vn.e;
    }
    
    @Override
    public uw e(final um par1ItemStack) {
        return uw.c;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final um par1ItemStack, final qx par2EntityPlayer, final List par3List, final boolean par4) {
        super.a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add(par1ItemStack.k() - par1ItemStack.j() + " charges left");
    }
}
