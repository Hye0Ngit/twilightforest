// 
// Decompiled by Procyon v0.6-prerelease
// 

public class ItemTFTwilightWand extends ItemTF
{
    protected ItemTFTwilightWand(final int par1) {
        super(par1);
        this.bQ = 1;
        this.f(99);
    }
    
    public kp a(final kp par1ItemStack, final ge worldObj, final ih player) {
        if (par1ItemStack.h() < this.f()) {
            player.a(par1ItemStack, this.c(par1ItemStack));
        }
        else {
            player.N();
        }
        return par1ItemStack;
    }
    
    public void onUsingItemTick(final kp stack, final ih player, final int count) {
        if (stack.h() >= this.f()) {
            player.N();
            return;
        }
        if (count % 6 == 0) {
            final ge worldObj = player.bi;
            worldObj.a((tv)player, "mob.ghast.fireball", player.p(), (worldObj.r.nextFloat() - worldObj.r.nextFloat()) * 0.2f + 1.0f);
            if (!worldObj.F) {
                worldObj.b((tv)new EntityTFTwilightWandBolt(worldObj, (ne)player));
                stack.a(1, (ne)player);
            }
        }
    }
    
    public int c(final kp par1ItemStack) {
        return 72000;
    }
    
    public kt d(final kp par1ItemStack) {
        return kt.e;
    }
}
