// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.entity.EntityTFMoonwormShot;
import twilightforest.block.TFBlocks;

public class ItemTFMoonwormQueen extends ItemTF
{
    private static final int FIRING_TIME = 12;
    
    protected ItemTFMoonwormQueen(final int par1) {
        super(par1);
        this.a((tj)TFItems.creativeTab);
        this.ck = 1;
        this.e(256);
    }
    
    public ur a(final ur par1ItemStack, final yc world, final qx player) {
        if (par1ItemStack.j() < this.m()) {
            player.a(par1ItemStack, this.c_(par1ItemStack));
        }
        else {
            player.bO();
        }
        return par1ItemStack;
    }
    
    public boolean a(final ur par1ItemStack, final qx player, final yc world, int x, int y, int z, int side, final float hitX, final float hitY, final float hitZ) {
        final int currentBlockID = world.a(x, y, z);
        if (currentBlockID == TFBlocks.moonworm.cm) {
            return false;
        }
        if (par1ItemStack != null && par1ItemStack.j() == this.m()) {
            return false;
        }
        if (currentBlockID == amq.aV.cm) {
            side = 1;
        }
        else if (currentBlockID != amq.bx.cm && currentBlockID != amq.aa.cm && currentBlockID != amq.ab.cm && (amq.p[currentBlockID] == null || !amq.p[currentBlockID].isBlockReplaceable(world, x, y, z))) {
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
            final int placementMeta = TFBlocks.moonworm.a(world, x, y, z, side, hitX, hitY, hitZ, 0);
            if (world.c(x, y, z, TFBlocks.moonworm.cm, placementMeta)) {
                if (world.a(x, y, z) == TFBlocks.moonworm.cm) {
                    TFBlocks.moonworm.a(world, x, y, z, (md)player);
                }
                world.a((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), this.getSound(), TFBlocks.moonworm.cz.c() / 2.0f, TFBlocks.moonworm.cz.d() * 0.8f);
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
    
    public void a(final ur par1ItemStack, final yc world, final qx player, final int useRemaining) {
        final int useTime = this.c_(par1ItemStack) - useRemaining;
        if (!world.I && useTime > 12 && par1ItemStack.j() + 1 < this.m()) {
            final boolean fired = world.d((lq)new EntityTFMoonwormShot(world, (md)player));
            if (fired) {
                par1ItemStack.a(2, (md)player);
                world.a((lq)player, this.getSound(), 1.0f, 1.0f);
            }
        }
    }
    
    public int getIconIndex(final ur stack, final int renderPass, final qx player, final ur usingItem, final int useRemaining) {
        if (usingItem != null && usingItem.b().cj == this.cj) {
            final int useTime = usingItem.m() - useRemaining;
            if (useTime >= 12) {
                return ((useTime >> 1) % 2 == 0) ? this.cl : (this.cl + 1);
            }
        }
        return this.cl;
    }
    
    public vs b_(final ur par1ItemStack) {
        return vs.e;
    }
    
    public int c_(final ur par1ItemStack) {
        return 72000;
    }
}
