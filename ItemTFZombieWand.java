// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ItemTFZombieWand extends ItemTF
{
    protected ItemTFZombieWand(final int par1) {
        super(par1);
        this.bQ = 1;
        this.f(9);
    }
    
    public kp a(final kp par1ItemStack, final ge worldObj, final ih player) {
        if (par1ItemStack.h() < this.f()) {
            player.a(par1ItemStack, this.c(par1ItemStack));
            if (!worldObj.F) {
                final wu mop = this.getPlayerPointVec(worldObj, player, 20.0f);
                if (mop != null) {
                    final EntityTFLoyalZombie zombie = new EntityTFLoyalZombie(worldObj);
                    zombie.b(mop.f.a, mop.f.b, mop.f.c, 1.0f, 1.0f);
                    zombie.b(true);
                    zombie.a(player.v);
                    zombie.e(new zv(kf.g.H, 1200, 1));
                    worldObj.b((tv)zombie);
                    par1ItemStack.a(1, (ne)player);
                }
            }
        }
        else {
            player.N();
        }
        return par1ItemStack;
    }
    
    private wu getPlayerPointVec(final ge worldObj, final ih player, final float range) {
        final cj position = cj.b(player.bm, player.bn + player.B(), player.bo);
        final cj look = player.f(1.0f);
        final cj dest = position.c(look.a * range, look.b * range, look.c * range);
        return worldObj.a(position, dest);
    }
    
    public int c(final kp par1ItemStack) {
        return 30;
    }
    
    public kt d(final kp par1ItemStack) {
        return kt.e;
    }
}
