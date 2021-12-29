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
    private mr[] icons;
    private String[] iconNames;
    
    protected ItemTFMoonwormQueen(final int par1) {
        super(par1);
        this.iconNames = new String[] { "moonwormQueen", "moonwormQueenAlt" };
        this.a((wv)TFItems.creativeTab);
        this.cw = 1;
        this.e(256);
    }
    
    public yd a(final yd par1ItemStack, final abv world, final ue player) {
        if (par1ItemStack.k() < this.o()) {
            player.a(par1ItemStack, this.d_(par1ItemStack));
        }
        else {
            player.bs();
        }
        return par1ItemStack;
    }
    
    public boolean a(final yd par1ItemStack, final ue player, final abv world, int x, int y, int z, int side, final float hitX, final float hitY, final float hitZ) {
        final int currentBlockID = world.a(x, y, z);
        if (currentBlockID == TFBlocks.moonworm.cF) {
            return false;
        }
        if (par1ItemStack != null && par1ItemStack.k() == this.o()) {
            return false;
        }
        if (currentBlockID == aqw.aX.cF) {
            side = 1;
        }
        else if (currentBlockID != aqw.bz.cF && currentBlockID != aqw.ac.cF && currentBlockID != aqw.ad.cF && (aqw.s[currentBlockID] == null || !aqw.s[currentBlockID].isBlockReplaceable(world, x, y, z))) {
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
        if (world.a(TFBlocks.moonworm.cF, x, y, z, false, side, (nm)player, par1ItemStack)) {
            final int placementMeta = TFBlocks.moonworm.a(world, x, y, z, side, hitX, hitY, hitZ, 0);
            if (world.f(x, y, z, TFBlocks.moonworm.cF, placementMeta, 3)) {
                if (world.a(x, y, z) == TFBlocks.moonworm.cF) {
                    TFBlocks.moonworm.a(world, x, y, z, (oe)player, par1ItemStack);
                }
                world.a((double)(x + 0.5f), (double)(y + 0.5f), (double)(z + 0.5f), this.getSound(), TFBlocks.moonworm.cS.c() / 2.0f, TFBlocks.moonworm.cS.d() * 0.8f);
                if (par1ItemStack != null) {
                    par1ItemStack.a(1, (oe)player);
                    player.bs();
                }
            }
            return true;
        }
        return false;
    }
    
    public String getSound() {
        return "mob.slime.big";
    }
    
    public void a(final yd par1ItemStack, final abv world, final ue player, final int useRemaining) {
        final int useTime = this.d_(par1ItemStack) - useRemaining;
        if (!world.I && useTime > 12 && par1ItemStack.k() + 1 < this.o()) {
            final boolean fired = world.d((nm)new EntityTFMoonwormShot(world, (oe)player));
            if (fired) {
                par1ItemStack.a(2, (oe)player);
                world.a((nm)player, this.getSound(), 1.0f, 1.0f);
            }
        }
    }
    
    public mr getIcon(final yd stack, final int renderPass, final ue player, final yd usingItem, final int useRemaining) {
        if (usingItem != null && usingItem.b().cv == this.cv) {
            final int useTime = usingItem.n() - useRemaining;
            if (useTime >= 12) {
                return ((useTime >> 1) % 2 == 0) ? this.icons[0] : this.icons[1];
            }
        }
        return this.icons[0];
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void a(final ms par1IconRegister) {
        super.a(par1IconRegister);
        this.icons = new mr[this.iconNames.length];
        for (int i = 0; i < this.iconNames.length; ++i) {
            this.icons[i] = par1IconRegister.a("TwilightForest:" + this.iconNames[i]);
        }
    }
    
    public zi c_(final yd par1ItemStack) {
        return zi.e;
    }
    
    public int d_(final yd par1ItemStack) {
        return 72000;
    }
}
