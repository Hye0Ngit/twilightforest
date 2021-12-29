// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.block.TFBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class ItemTFTrophy extends ItemTF
{
    private static final String[] trophyTypes;
    public static final String[] trophyTextures;
    public mr[] trophyIcons;
    
    public ItemTFTrophy(final int par1) {
        super(par1);
        this.a((wv)TFItems.creativeTab);
        this.e(0);
        this.a(true);
    }
    
    public void a(final int par1, final wv par2CreativeTabs, final List par3List) {
        for (int j = 0; j < ItemTFTrophy.trophyTypes.length; ++j) {
            par3List.add(new yd(par1, 1, j));
        }
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public yp f(final yd par1ItemStack) {
        return yp.c;
    }
    
    public boolean a(final yd itemStack, final ue player, final abv world, int x, int y, int z, final int direction, final float par8, final float par9, final float par10) {
        if (direction == 0) {
            return false;
        }
        if (!world.g(x, y, z).a()) {
            return false;
        }
        if (direction == 1) {
            ++y;
        }
        if (direction == 2) {
            --z;
        }
        if (direction == 3) {
            ++z;
        }
        if (direction == 4) {
            --x;
        }
        if (direction == 5) {
            ++x;
        }
        if (!player.a(x, y, z, direction, itemStack)) {
            return false;
        }
        if (!TFBlocks.trophy.c(world, x, y, z)) {
            return false;
        }
        world.f(x, y, z, TFBlocks.trophy.cF, direction, 3);
        int skullRotate = 0;
        if (direction == 1) {
            skullRotate = (lr.c(player.A * 16.0f / 360.0f + 0.5) & 0xF);
        }
        final asm tileEntity = world.r(x, y, z);
        if (tileEntity != null && tileEntity instanceof ask) {
            String skullName = "";
            if (itemStack.p() && itemStack.q().b("SkullOwner")) {
                skullName = itemStack.q().i("SkullOwner");
            }
            ((ask)tileEntity).a(itemStack.k(), skullName);
            ((ask)tileEntity).a(skullRotate);
        }
        --itemStack.b;
        return true;
    }
    
    public String d(final yd par1ItemStack) {
        int i = par1ItemStack.k();
        if (i < 0 || i >= ItemTFTrophy.trophyTypes.length) {
            i = 0;
        }
        return super.a() + "." + ItemTFTrophy.trophyTypes[i];
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void a(final ms par1IconRegister) {
        this.trophyIcons = new mr[ItemTFTrophy.trophyTextures.length];
        for (int i = 0; i < ItemTFTrophy.trophyTextures.length; ++i) {
            this.trophyIcons[i] = par1IconRegister.a("TwilightForest:" + ItemTFTrophy.trophyTextures[i]);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public mr b_(int par1) {
        if (par1 < 0 || par1 >= ItemTFTrophy.trophyTypes.length) {
            par1 = 0;
        }
        return this.trophyIcons[par1];
    }
    
    static {
        trophyTypes = new String[] { "hydra", "naga", "lich", "ur-ghast" };
        trophyTextures = new String[] { "hydraTrophy", "nagaTrophy", "lichTrophy", "urGhastTrophy" };
    }
}
