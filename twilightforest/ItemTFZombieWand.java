// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.List;

public class ItemTFZombieWand extends ItemTF
{
    protected ItemTFZombieWand(final int par1) {
        super(par1);
        this.bR = 1;
        this.g(9);
    }
    
    public aan a(final aan par1ItemStack, final xd worldObj, final yw player) {
        if (par1ItemStack.i() < this.h()) {
            player.c(par1ItemStack, this.b(par1ItemStack));
            if (!worldObj.F) {
                final pl mop = this.getPlayerPointVec(worldObj, player, 20.0f);
                if (mop != null) {
                    final EntityTFLoyalZombie zombie = new EntityTFLoyalZombie(worldObj);
                    zombie.b(mop.f.a, mop.f.b, mop.f.c, 1.0f, 1.0f);
                    zombie.b(true);
                    zombie.a(player.aA);
                    zombie.b(new alg(aad.g.H, 1200, 1));
                    worldObj.a((nn)zombie);
                    par1ItemStack.a(1, (acq)player);
                }
            }
        }
        else {
            player.am();
        }
        return par1ItemStack;
    }
    
    private pl getPlayerPointVec(final xd worldObj, final yw player, final float range) {
        final bo position = bo.b(player.o, player.p + player.I(), player.q);
        final bo look = player.k(1.0f);
        final bo dest = position.c(look.a * range, look.b * range, look.c * range);
        return worldObj.a(position, dest);
    }
    
    public int b(final aan par1ItemStack) {
        return 30;
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
