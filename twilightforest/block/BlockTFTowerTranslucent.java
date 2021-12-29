// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import twilightforest.item.TFItems;

public class BlockTFTowerTranslucent extends aou
{
    public static final int META_REAPPEARING_INACTIVE = 0;
    public static final int META_REAPPEARING_ACTIVE = 1;
    public static final int META_BUILT_INACTIVE = 2;
    public static final int META_BUILT_ACTIVE = 3;
    public static final int META_REVERTER_REPLACEMENT = 4;
    public static lx TEX_REAPPEARING_INACTIVE;
    public static lx TEX_REAPPEARING_ACTIVE;
    public static lx TEX_BUILT_INACTIVE;
    public static lx TEX_BUILT_ACTIVE;
    public static lx TEX_REVERTER_REPLACEMENT;
    
    public BlockTFTowerTranslucent(final int id) {
        super(id, ahz.r);
        this.c(50.0f);
        this.b(2000.0f);
        this.a(aou.k);
        this.a((uy)TFItems.creativeTab);
    }
    
    public boolean c() {
        return false;
    }
    
    public int tickRate() {
        return 15;
    }
    
    public int a(final int par1, final Random par2Random, final int par3) {
        return 0;
    }
    
    public aqr b(final zv par1World, final int par2, final int par3, final int par4) {
        final int meta = par1World.h(par2, par3, par4) & 0x7;
        if (meta == 0 || meta == 1) {
            return null;
        }
        this.a((aae)par1World, par2, par3, par4);
        return super.b(par1World, par2, par3, par4);
    }
    
    public void a(final aae par1IBlockAccess, final int par2, final int par3, final int par4) {
        final int meta = par1IBlockAccess.h(par2, par3, par4);
        if (meta == 0 || meta == 1) {
            this.a(0.375f, 0.375f, 0.375f, 0.625f, 0.625f, 0.625f);
        }
        else {
            this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
    }
    
    public float l(final zv world, final int x, final int y, final int z) {
        final int meta = world.h(x, y, z);
        if (meta == 4) {
            return 0.3f;
        }
        return super.l(world, x, y, z);
    }
    
    public boolean b(final aae par1IBlockAccess, final int par2, final int par3, final int par4) {
        final int meta = par1IBlockAccess.h(par2, par3, par4);
        switch (meta) {
            default: {
                return false;
            }
            case 2:
            case 3:
            case 4: {
                return true;
            }
        }
    }
    
    public lx a(final int side, final int meta) {
        switch (meta) {
            default: {
                return BlockTFTowerTranslucent.TEX_REAPPEARING_INACTIVE;
            }
            case 1: {
                return BlockTFTowerTranslucent.TEX_REAPPEARING_ACTIVE;
            }
            case 2: {
                return BlockTFTowerTranslucent.TEX_BUILT_INACTIVE;
            }
            case 3: {
                return BlockTFTowerTranslucent.TEX_BUILT_ACTIVE;
            }
            case 4: {
                return BlockTFTowerTranslucent.TEX_REVERTER_REPLACEMENT;
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
        BlockTFTowerTranslucent.TEX_REAPPEARING_INACTIVE = par1IconRegister.a("twilightforest:towerdev_reappearing_trace_off");
        BlockTFTowerTranslucent.TEX_REAPPEARING_ACTIVE = par1IconRegister.a("twilightforest:towerdev_reappearing_trace_on");
        BlockTFTowerTranslucent.TEX_BUILT_INACTIVE = par1IconRegister.a("twilightforest:towerdev_built_off");
        BlockTFTowerTranslucent.TEX_BUILT_ACTIVE = par1IconRegister.a("twilightforest:towerdev_built_on");
        BlockTFTowerTranslucent.TEX_REVERTER_REPLACEMENT = par1IconRegister.a("twilightforest:towerdev_antibuilt");
    }
    
    public void a(final zv par1World, final int x, final int y, final int z, final Random par5Random) {
        if (!par1World.I) {
            final int meta = par1World.h(x, y, z);
            if (meta == 3) {
                par1World.f(x, y, z, 0, 0, 3);
                par1World.f(x, y, z, this.cz);
                par1World.a(x + 0.5, y + 0.5, z + 0.5, "random.pop", 0.3f, 0.5f);
                par1World.g(x, y, z, x, y, z);
                BlockTFTowerDevice.checkAndActivateVanishBlock(par1World, x - 1, y, z);
                BlockTFTowerDevice.checkAndActivateVanishBlock(par1World, x + 1, y, z);
                BlockTFTowerDevice.checkAndActivateVanishBlock(par1World, x, y + 1, z);
                BlockTFTowerDevice.checkAndActivateVanishBlock(par1World, x, y - 1, z);
                BlockTFTowerDevice.checkAndActivateVanishBlock(par1World, x, y, z + 1);
                BlockTFTowerDevice.checkAndActivateVanishBlock(par1World, x, y, z - 1);
            }
            if (meta == 1) {
                par1World.f(x, y, z, TFBlocks.towerDevice.cz, 0, 3);
                par1World.f(x, y, z, this.cz);
                par1World.a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.5f);
                par1World.g(x, y, z, x, y, z);
            }
            else if (meta == 0) {
                BlockTFTowerDevice.changeToActiveVanishBlock(par1World, x, y, z, 1);
            }
        }
    }
    
    public void a(final int par1, final uy par2CreativeTabs, final List par3List) {
    }
}
