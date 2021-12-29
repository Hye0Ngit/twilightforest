// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import twilightforest.entity.EntityTFLoyalZombie;

public class ItemTFZombieWand extends ItemTF
{
    protected ItemTFZombieWand(final int par1) {
        super(par1);
        this.cq = 1;
        this.e(9);
        this.a((uy)TFItems.creativeTab);
    }
    
    public wg a(final wg par1ItemStack, final zv worldObj, final sk player) {
        if (par1ItemStack.k() < this.n()) {
            player.a(par1ItemStack, this.c_(par1ItemStack));
            if (!worldObj.I) {
                final aqu mop = this.getPlayerPointVec(worldObj, player, 20.0f);
                if (mop != null) {
                    final EntityTFLoyalZombie zombie = new EntityTFLoyalZombie(worldObj);
                    zombie.a(mop.f.c, mop.f.d, mop.f.e, 1.0f, 1.0f);
                    zombie.j(true);
                    zombie.a(player.bS);
                    zombie.d(new ml(mk.g.H, 1200, 1));
                    worldObj.d((mp)zombie);
                    par1ItemStack.a(1, (ng)player);
                }
            }
        }
        else {
            player.bX();
        }
        return par1ItemStack;
    }
    
    private aqu getPlayerPointVec(final zv worldObj, final sk player, final float range) {
        final aqw position = worldObj.T().a(player.u, player.v + player.e(), player.w);
        final aqw look = player.i(1.0f);
        final aqw dest = position.c(look.c * range, look.d * range, look.e * range);
        return worldObj.a(position, dest);
    }
    
    public int c_(final wg par1ItemStack) {
        return 30;
    }
    
    public xj b_(final wg par1ItemStack) {
        return xj.e;
    }
    
    @Override
    public wr f(final wg par1ItemStack) {
        return wr.c;
    }
    
    public void a(final wg par1ItemStack, final sk par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(par1ItemStack.l() - par1ItemStack.k() + " charges left");
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void a(final ly par1IconRegister) {
        this.ct = par1IconRegister.a("twilightforest:" + this.a().substring(5));
    }
}
