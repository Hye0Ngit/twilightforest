// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import java.util.List;
import twilightforest.entity.EntityTFLoyalZombie;

public class ItemTFZombieWand extends ItemTF
{
    protected ItemTFZombieWand(final int par1) {
        super(par1);
        this.ck = 1;
        this.e(9);
        this.a((tj)TFItems.creativeTab);
    }
    
    public ur a(final ur par1ItemStack, final yc worldObj, final qx player) {
        if (par1ItemStack.j() < this.m()) {
            player.a(par1ItemStack, this.c_(par1ItemStack));
            if (!worldObj.I) {
                final aoh mop = this.getPlayerPointVec(worldObj, player, 20.0f);
                if (mop != null) {
                    final EntityTFLoyalZombie zombie = new EntityTFLoyalZombie(worldObj);
                    zombie.a(mop.f.c, mop.f.d, mop.f.e, 1.0f, 1.0f);
                    zombie.g(true);
                    zombie.a(player.bR);
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
    
    private aoh getPlayerPointVec(final yc worldObj, final qx player, final float range) {
        final aoj position = worldObj.S().a(player.t, player.u + player.e(), player.v);
        final aoj look = player.i(1.0f);
        final aoj dest = position.c(look.c * range, look.d * range, look.e * range);
        return worldObj.a(position, dest);
    }
    
    public int c_(final ur par1ItemStack) {
        return 30;
    }
    
    public vs b_(final ur par1ItemStack) {
        return vs.e;
    }
    
    @Override
    public vb f(final ur par1ItemStack) {
        return vb.c;
    }
    
    public void a(final ur par1ItemStack, final qx par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(par1ItemStack.k() - par1ItemStack.j() + " charges left");
    }
}
