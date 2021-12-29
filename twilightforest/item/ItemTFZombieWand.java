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
        this.cw = 1;
        this.e(9);
        this.a((wv)TFItems.creativeTab);
    }
    
    public yd a(final yd par1ItemStack, final abv worldObj, final ue player) {
        if (par1ItemStack.k() < this.o()) {
            player.a(par1ItemStack, this.d_(par1ItemStack));
            if (!worldObj.I) {
                final asx mop = this.getPlayerPointVec(worldObj, player, 20.0f);
                if (mop != null) {
                    final EntityTFLoyalZombie zombie = new EntityTFLoyalZombie(worldObj);
                    zombie.a(mop.f.c, mop.f.d, mop.f.e, 1.0f, 1.0f);
                    zombie.j(true);
                    zombie.b(player.bu);
                    zombie.c(new ni(nh.g.H, 1200, 1));
                    worldObj.d((nm)zombie);
                    par1ItemStack.a(1, (oe)player);
                }
            }
        }
        else {
            player.bs();
        }
        return par1ItemStack;
    }
    
    private asx getPlayerPointVec(final abv worldObj, final ue player, final float range) {
        final asz position = worldObj.V().a(player.u, player.v + player.f(), player.w);
        final asz look = player.j(1.0f);
        final asz dest = position.c(look.c * range, look.d * range, look.e * range);
        return worldObj.a(position, dest);
    }
    
    public int d_(final yd par1ItemStack) {
        return 30;
    }
    
    public zi c_(final yd par1ItemStack) {
        return zi.e;
    }
    
    @Override
    public yp f(final yd par1ItemStack) {
        return yp.c;
    }
    
    public void a(final yd par1ItemStack, final ue par2EntityPlayer, final List par3List, final boolean par4) {
        par3List.add(par1ItemStack.l() - par1ItemStack.k() + " charges left");
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void a(final ms par1IconRegister) {
        this.cz = par1IconRegister.a("TwilightForest:" + this.a().substring(5));
    }
}
