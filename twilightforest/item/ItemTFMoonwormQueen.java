// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.entity.EntityTFMoonwormShot;
import twilightforest.block.TFBlocks;

public class ItemTFMoonwormQueen extends ItemTF
{
    private static final int FIRING_TIME = 12;
    private lx[] icons;
    private String[] iconNames;
    
    protected ItemTFMoonwormQueen(final int par1) {
        super(par1);
        this.iconNames = new String[] { "moonwormQueen", "moonwormQueenAlt" };
        this.a((uy)TFItems.creativeTab);
        this.cq = 1;
        this.e(256);
    }
    
    public wg a(final wg par1ItemStack, final zv world, final sk player) {
        if (par1ItemStack.k() < this.n()) {
            player.a(par1ItemStack, this.c_(par1ItemStack));
        }
        else {
            player.bX();
        }
        return par1ItemStack;
    }
    
    public boolean a(final wg par1ItemStack, final sk player, final zv world, int x, int y, int z, int side, final float hitX, final float hitY, final float hitZ) {
        final int currentBlockID = world.a(x, y, z);
        if (currentBlockID == TFBlocks.moonworm.cz) {
            return false;
        }
        if (par1ItemStack != null && par1ItemStack.k() == this.n()) {
            return false;
        }
        if (currentBlockID == aou.aW.cz) {
            side = 1;
        }
        else if (currentBlockID != aou.by.cz && currentBlockID != aou.ab.cz && currentBlockID != aou.ac.cz && (aou.r[currentBlockID] == null || !aou.r[currentBlockID].isBlockReplaceable(world, x, y, z))) {
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
        if (world.a(TFBlocks.moonworm.cz, x, y, z, false, side, (mp)player, par1ItemStack)) {
            final int placementMeta = TFBlocks.moonworm.a(world, x, y, z, side, hitX, hitY, hitZ, 0);
            if (world.f(x, y, z, TFBlocks.moonworm.cz, placementMeta, 3)) {
                if (world.a(x, y, z) == TFBlocks.moonworm.cz) {
                    TFBlocks.moonworm.a(world, x, y, z, (ng)player, par1ItemStack);
                }
                world.a((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), this.getSound(), TFBlocks.moonworm.cM.c() / 2.0f, TFBlocks.moonworm.cM.d() * 0.8f);
                if (par1ItemStack != null) {
                    par1ItemStack.a(1, (ng)player);
                    player.bX();
                }
            }
            return true;
        }
        return false;
    }
    
    public String getSound() {
        return "mob.slime.big";
    }
    
    public void a(final wg par1ItemStack, final zv world, final sk player, final int useRemaining) {
        final int useTime = this.c_(par1ItemStack) - useRemaining;
        if (!world.I && useTime > 12 && par1ItemStack.k() + 1 < this.n()) {
            final boolean fired = world.d((mp)new EntityTFMoonwormShot(world, (ng)player));
            if (fired) {
                par1ItemStack.a(2, (ng)player);
                world.a((mp)player, this.getSound(), 1.0f, 1.0f);
            }
        }
    }
    
    public lx getIcon(final wg stack, final int renderPass, final sk player, final wg usingItem, final int useRemaining) {
        if (usingItem != null && usingItem.b().cp == this.cp) {
            final int useTime = usingItem.n() - useRemaining;
            if (useTime >= 12) {
                return ((useTime >> 1) % 2 == 0) ? this.icons[0] : this.icons[1];
            }
        }
        return this.icons[0];
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void a(final ly par1IconRegister) {
        super.a(par1IconRegister);
        this.icons = new lx[this.iconNames.length];
        for (int i = 0; i < this.iconNames.length; ++i) {
            this.icons[i] = par1IconRegister.a("twilightforest:" + this.iconNames[i]);
        }
    }
    
    public xj b_(final wg par1ItemStack) {
        return xj.e;
    }
    
    public int c_(final wg par1ItemStack) {
        return 72000;
    }
}
