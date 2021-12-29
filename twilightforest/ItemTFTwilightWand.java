// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.List;

public class ItemTFTwilightWand extends ItemTF
{
    protected ItemTFTwilightWand(final int par1) {
        super(par1);
        this.bR = 1;
        this.g(99);
    }
    
    public aan a(final aan par1ItemStack, final xd worldObj, final yw player) {
        if (par1ItemStack.i() < this.h()) {
            player.c(par1ItemStack, this.b(par1ItemStack));
        }
        else {
            player.am();
        }
        return par1ItemStack;
    }
    
    public void onUsingItemTick(final aan stack, final yw player, final int count) {
        if (stack.i() >= this.h()) {
            player.am();
            return;
        }
        if (count % 6 == 0) {
            final xd worldObj = player.k;
            worldObj.a((nn)player, "mob.ghast.fireball", 1.0f, (worldObj.r.nextFloat() - worldObj.r.nextFloat()) * 0.2f + 1.0f);
            if (!worldObj.F) {
                worldObj.a((nn)new EntityTFTwilightWandBolt(worldObj, (acq)player));
                stack.a(1, (acq)player);
            }
        }
    }
    
    public int b(final aan par1ItemStack) {
        return 72000;
    }
    
    public aaq c(final aan par1ItemStack) {
        return aaq.e;
    }
    
    @Override
    public fo f(final aan par1ItemStack) {
        return fo.c;
    }
    
    public void a(final aan par1ItemStack, final List par2List) {
        par2List.add(par1ItemStack.j() - par1ItemStack.i() + " charges left");
    }
}
