// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class ItemTFMoonwormQueen extends ItemTF
{
    private static final int FIRING_TIME = 12;
    
    protected ItemTFMoonwormQueen(final int par1) {
        super(par1);
        this.a(th.i);
        this.ch = 1;
        this.e(256);
    }
    
    public um a(final um par1ItemStack, final xv world, final qx player) {
        if (par1ItemStack.j() < this.m()) {
            player.a(par1ItemStack, this.a(par1ItemStack));
        }
        else {
            player.bO();
        }
        return par1ItemStack;
    }
    
    public boolean a(final um par1ItemStack, final qx player, final xv world, int x, int y, int z, int side, final float hitX, final float hitY, final float hitZ) {
        final int currentBlockID = world.a(x, y, z);
        if (currentBlockID == TFBlocks.moonworm.cm) {
            return false;
        }
        if (par1ItemStack != null && par1ItemStack.j() == this.m()) {
            return false;
        }
        if (currentBlockID == amj.aV.cm) {
            side = 1;
        }
        else if (currentBlockID != amj.bx.cm && currentBlockID != amj.aa.cm && currentBlockID != amj.ab.cm && (amj.p[currentBlockID] == null || !amj.p[currentBlockID].isBlockReplaceable(world, x, y, z))) {
            if (side == 0) {
                --y;
            }
            if (side == 1) {
                ++y;
            }
            if (side == 2) {
                --z;
            }
            if (side == 3) {
                ++z;
            }
            if (side == 4) {
                --x;
            }
            if (side == 5) {
                ++x;
            }
        }
        if (world.a(TFBlocks.moonworm.cm, x, y, z, false, side, (lq)player)) {
            if (world.b(x, y, z, TFBlocks.moonworm.cm)) {
                if (world.a(x, y, z) == TFBlocks.moonworm.cm) {
                    ((BlockTFMoonworm)TFBlocks.moonworm).updateBlockMetadata(world, x, y, z, side, hitX, hitY, hitZ);
                    TFBlocks.moonworm.a(world, x, y, z, (md)player);
                }
                world.a((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), this.getSound(), (TFBlocks.firefly.cz.c() + 1.0f) / 2.0f, TFBlocks.firefly.cz.d() * 0.8f);
                if (par1ItemStack != null) {
                    par1ItemStack.a(1, (md)player);
                    player.bO();
                }
            }
            return true;
        }
        return false;
    }
    
    public String getSound() {
        return "mob.slime.big";
    }
    
    public void a(final um par1ItemStack, final xv world, final qx player, final int useRemaining) {
        final int useTime = this.a(par1ItemStack) - useRemaining;
        if (!world.J && useTime > 12 && par1ItemStack.j() + 1 < this.m()) {
            final boolean fired = world.d((lq)new EntityTFMoonwormShot(world, (md)player));
            if (fired) {
                par1ItemStack.a(2, (md)player);
                world.a((lq)player, this.getSound(), 1.0f, 1.0f);
            }
        }
    }
    
    public int getIconIndex(final um stack, final int renderPass, final qx player, final um usingItem, final int useRemaining) {
        if (usingItem != null && usingItem.b().cg == this.cg) {
            final int useTime = usingItem.m() - useRemaining;
            if (useTime >= 12) {
                return ((useTime >> 1) % 2 == 0) ? this.ci : (this.ci + 1);
            }
        }
        return this.ci;
    }
    
    public vn d_(final um par1ItemStack) {
        return vn.e;
    }
    
    public int a(final um par1ItemStack) {
        return 72000;
    }
}
