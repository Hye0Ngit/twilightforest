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
        this.ck = 1;
        this.e(99);
        this.a((tj)TFItems.creativeTab);
    }
    
    public ur a(final ur par1ItemStack, final yc worldObj, final qx player) {
        if (par1ItemStack.j() < this.m()) {
            player.a(par1ItemStack, this.c_(par1ItemStack));
        }
        else {
            player.bO();
        }
        return par1ItemStack;
    }
    
    public void onUsingItemTick(final ur stack, final qx player, final int count) {
        if (stack.j() >= this.m()) {
            player.bO();
            return;
        }
        if (count % 6 == 0) {
            final yc worldObj = player.p;
            worldObj.a((lq)player, "mob.ghast.fireball", 1.0f, (worldObj.t.nextFloat() - worldObj.t.nextFloat()) * 0.2f + 1.0f);
            if (!worldObj.I) {
                worldObj.d((lq)new EntityTFTwilightWandBolt(worldObj, (md)player));
                stack.a(1, (md)player);
            }
        }
    }
    
    public int c_(final ur par1ItemStack) {
        return 72000;
    }
    
    public vs b_(final ur par1ItemStack) {
        return vs.e;
    }
    
    @Override
    public vb f(final ur par1ItemStack) {
        return vb.c;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ur par1ItemStack, final qx par2EntityPlayer, final List par3List, final boolean par4) {
        super.a(par1ItemStack, par2EntityPlayer, par3List, par4);
        par3List.add(par1ItemStack.k() - par1ItemStack.j() + " charges left");
    }
}
