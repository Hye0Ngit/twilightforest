// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.List;

public class ItemTFZombieWand extends ItemTF
{
    protected ItemTFZombieWand(final int par1) {
        super(par1);
        this.ch = 1;
        this.e(9);
        this.a(th.j);
    }
    
    public um a(final um par1ItemStack, final xv worldObj, final qx player) {
        if (par1ItemStack.j() < this.m()) {
            player.a(par1ItemStack, this.a(par1ItemStack));
            if (!worldObj.J) {
                final anz mop = this.getPlayerPointVec(worldObj, player, 20.0f);
                if (mop != null) {
                    final EntityTFLoyalZombie zombie = new EntityTFLoyalZombie(worldObj);
                    zombie.a(mop.f.c, mop.f.d, mop.f.e, 1.0f, 1.0f);
                    zombie.g(true);
                    zombie.a(player.bQ);
                    zombie.d(new lm(ll.g.H, 1200, 1));
                    worldObj.d((lq)zombie);
                    par1ItemStack.a(1, (md)player);
                }
            }
        }
        else {
            player.bO();
        }
        return par1ItemStack;
    }
    
    private anz getPlayerPointVec(final xv worldObj, final qx player, final float range) {
        final aob position = worldObj.S().a(player.t, player.u + player.e(), player.v);
        final aob look = player.i(1.0f);
        final aob dest = position.c(look.c * range, look.d * range, look.e * range);
        return worldObj.a(position, dest);
    }
    
    public int a(final um par1ItemStack) {
        return 30;
    }
    
    public vn d_(final um par1ItemStack) {
        return vn.e;
    }
    
    @Override
    public uw e(final um par1ItemStack) {
        return uw.c;
    }
    
    public void a(final um par1ItemStack, final qx par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(par1ItemStack.k() - par1ItemStack.j() + " charges left");
    }
}
