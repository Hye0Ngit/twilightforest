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
    public lx[] trophyIcons;
    
    public ItemTFTrophy(final int par1) {
        super(par1);
        this.a((uy)TFItems.creativeTab);
        this.e(0);
        this.a(true);
    }
    
    public void a(final int par1, final uy par2CreativeTabs, final List par3List) {
        for (int j = 0; j < ItemTFTrophy.trophyTypes.length; ++j) {
            par3List.add(new wg(par1, 1, j));
        }
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public wr f(final wg par1ItemStack) {
        return wr.c;
    }
    
    public boolean a(final wg itemStack, final sk player, final zv world, int x, int y, int z, final int direction, final float par8, final float par9, final float par10) {
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
        world.f(x, y, z, TFBlocks.trophy.cz, direction, 3);
        int skullRotate = 0;
        if (direction == 1) {
            skullRotate = (kx.c(player.A * 16.0f / 360.0f + 0.5) & 0xF);
        }
        final aqj tileEntity = world.r(x, y, z);
        if (tileEntity != null && tileEntity instanceof aqh) {
            String skullName = "";
            if (itemStack.p() && itemStack.q().b("SkullOwner")) {
                skullName = itemStack.q().i("SkullOwner");
            }
            ((aqh)tileEntity).a(itemStack.k(), skullName);
            ((aqh)tileEntity).a(skullRotate);
        }
        --itemStack.a;
        return true;
    }
    
    public String d(final wg par1ItemStack) {
        int i = par1ItemStack.k();
        if (i < 0 || i >= ItemTFTrophy.trophyTypes.length) {
            i = 0;
        }
        return super.a() + "." + ItemTFTrophy.trophyTypes[i];
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void a(final ly par1IconRegister) {
        this.trophyIcons = new lx[ItemTFTrophy.trophyTextures.length];
        for (int i = 0; i < ItemTFTrophy.trophyTextures.length; ++i) {
            this.trophyIcons[i] = par1IconRegister.a("twilightforest:" + ItemTFTrophy.trophyTextures[i]);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public lx a_(int par1) {
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
