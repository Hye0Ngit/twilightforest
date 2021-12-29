// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.Random;
import twilightforest.TwilightForestMod;
import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.item.TFItems;

public class BlockTFTrophyPedestal extends aqw
{
    private mr sprTopActive;
    private mr sprTop;
    private mr sprBottom;
    private mr sprNagaActive;
    private mr sprNaga;
    private mr sprLichActive;
    private mr sprLich;
    private mr sprHydraActive;
    private mr sprHydra;
    private mr sprUrghastActive;
    private mr sprUrghast;
    
    public BlockTFTrophyPedestal(final int par1) {
        super(par1, ajz.e);
        this.c(2.0f);
        this.b(2000.0f);
        this.a(BlockTFTrophyPedestal.k);
        this.a((wv)TFItems.creativeTab);
    }
    
    public mr a(final int side, final int meta) {
        if (side == 1) {
            return (meta > 0) ? this.sprTopActive : this.sprTop;
        }
        if (side == 2) {
            return (meta > 0) ? this.sprNagaActive : this.sprNaga;
        }
        if (side == 3) {
            return (meta > 0) ? this.sprLichActive : this.sprLich;
        }
        if (side == 4) {
            return (meta > 0) ? this.sprHydraActive : this.sprHydra;
        }
        if (side == 5) {
            return (meta > 0) ? this.sprUrghastActive : this.sprUrghast;
        }
        return this.sprTop;
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
        this.sprTopActive = par1IconRegister.a("TwilightForest:pedestal_top_active");
        this.sprTop = par1IconRegister.a("TwilightForest:pedestal_top");
        this.sprBottom = par1IconRegister.a("TwilightForest:pedestal_top");
        this.sprNagaActive = par1IconRegister.a("TwilightForest:pedestal_naga_active");
        this.sprNaga = par1IconRegister.a("TwilightForest:pedestal_naga");
        this.sprLichActive = par1IconRegister.a("TwilightForest:pedestal_lich_active");
        this.sprLich = par1IconRegister.a("TwilightForest:pedestal_lich");
        this.sprHydraActive = par1IconRegister.a("TwilightForest:pedestal_hydra_active");
        this.sprHydra = par1IconRegister.a("TwilightForest:pedestal_hydra");
        this.sprUrghastActive = par1IconRegister.a("TwilightForest:pedestal_urghast_active");
        this.sprUrghast = par1IconRegister.a("TwilightForest:pedestal_urghast");
    }
    
    public void a(final int par1, final wv par2CreativeTabs, final List par3List) {
        par3List.add(new yd(par1, 1, 0));
        par3List.add(new yd(par1, 1, 15));
    }
    
    public void a(final ace world, final int x, final int y, final int z) {
        this.a(0.0625f, 0.0f, 0.0625f, 0.9375f, 1.0f, 0.9375f);
    }
    
    public boolean b() {
        return false;
    }
    
    public boolean c() {
        return false;
    }
    
    public int d() {
        return TwilightForestMod.proxy.getPedestalBlockRenderID();
    }
    
    @SideOnly(Side.CLIENT)
    public boolean a(final ace par1IBlockAccess, final int par2, final int par3, final int par4, final int par5) {
        return true;
    }
    
    public void a(final abv par1World, final int x, final int y, final int z, final int myBlockID) {
        final int meta = par1World.h(x, y, z);
        if (!par1World.I && meta > 0 && this.isTrophyOnTop(par1World, x, y, z)) {
            par1World.a(x, y, z, this.cF, 1);
        }
    }
    
    private boolean isTrophyOnTop(final abv world, final int x, final int y, final int z) {
        return world.a(x, y + 1, z) == TFBlocks.trophy.cF;
    }
    
    public void a(final abv world, final int x, final int y, final int z, final Random par5Random) {
        if (!world.I) {
            final int meta = world.h(x, y, z);
            if (meta > 0 && this.isTrophyOnTop(world, x, y, z)) {
                this.removeNearbyShields(world, x, y, z);
                world.b(x, y, z, 0, 2);
                world.a(x + 0.5, y + 0.5, z + 0.5, "mob.zombie.infect", 4.0f, 0.1f);
            }
        }
    }
    
    protected void removeNearbyShields(final abv world, final int x, final int y, final int z) {
        for (int sx = -5; sx <= 5; ++sx) {
            for (int sy = -5; sy <= 5; ++sy) {
                for (int sz = -5; sz <= 5; ++sz) {
                    final int blockAt = world.a(x + sx, y + sy, z + sz);
                    final int metaAt = world.h(x + sx, y + sy, z + sz);
                    if (blockAt == TFBlocks.shield.cF && metaAt == 15) {
                        world.c(x + sx, y + sy, z + sz, 0);
                        world.e(2001, x + sx, y + sy, z + sz, blockAt + (metaAt << 12));
                    }
                }
            }
        }
    }
    
    public int a(final abv world) {
        return 10;
    }
    
    public float a(final ue par1EntityPlayer, final abv world, final int x, final int y, final int z) {
        final int meta = world.h(x, y, z);
        if (meta > 0) {
            return -1.0f;
        }
        return super.a(par1EntityPlayer, world, x, y, z);
    }
}
