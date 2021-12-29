// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import java.util.Random;
import net.minecraft.util.Icon;
import net.minecraft.block.Block;

public class BlockTFTowerTranslucent extends Block
{
    public static final int META_REAPPEARING_INACTIVE = 0;
    public static final int META_REAPPEARING_ACTIVE = 1;
    public static final int META_BUILT_INACTIVE = 2;
    public static final int META_BUILT_ACTIVE = 3;
    public static final int META_REVERTER_REPLACEMENT = 4;
    public static final int META_REACTOR_DEBRIS = 5;
    public static final int META_FAKE_GOLD = 6;
    public static final int META_FAKE_DIAMOND = 7;
    public static Icon TEX_REAPPEARING_INACTIVE;
    public static Icon TEX_REAPPEARING_ACTIVE;
    public static Icon TEX_BUILT_INACTIVE;
    public static Icon TEX_BUILT_ACTIVE;
    public static Icon TEX_REVERTER_REPLACEMENT;
    private static Random sideRNG;
    
    public BlockTFTowerTranslucent(final int id) {
        super(id, Material.field_76264_q);
        this.func_71848_c(50.0f);
        this.func_71894_b(2000.0f);
        this.func_71884_a(Block.field_71977_i);
        this.func_71849_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public boolean func_71926_d() {
        return false;
    }
    
    public int tickRate() {
        return 15;
    }
    
    public int func_71885_a(final int par1, final Random par2Random, final int par3) {
        return 0;
    }
    
    public AxisAlignedBB func_71872_e(final World par1World, final int par2, final int par3, final int par4) {
        final int meta = par1World.func_72805_g(par2, par3, par4) & 0x7;
        if (meta == 0 || meta == 1) {
            return null;
        }
        this.func_71902_a((IBlockAccess)par1World, par2, par3, par4);
        return super.func_71872_e(par1World, par2, par3, par4);
    }
    
    public void func_71902_a(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4) {
        final int meta = par1IBlockAccess.func_72805_g(par2, par3, par4);
        if (meta == 0 || meta == 1) {
            this.func_71905_a(0.375f, 0.375f, 0.375f, 0.625f, 0.625f, 0.625f);
        }
        if (meta == 5) {
            this.func_71905_a(BlockTFTowerTranslucent.sideRNG.nextFloat() * 0.4f, BlockTFTowerTranslucent.sideRNG.nextFloat() * 0.4f, BlockTFTowerTranslucent.sideRNG.nextFloat() * 0.4f, 1.0f - BlockTFTowerTranslucent.sideRNG.nextFloat() * 0.4f, 1.0f - BlockTFTowerTranslucent.sideRNG.nextFloat() * 0.4f, 1.0f - BlockTFTowerTranslucent.sideRNG.nextFloat() * 0.4f);
        }
        else {
            this.func_71905_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
    }
    
    public float func_71934_m(final World world, final int x, final int y, final int z) {
        final int meta = world.func_72805_g(x, y, z);
        if (meta == 4 || meta == 5) {
            return 0.3f;
        }
        return super.func_71934_m(world, x, y, z);
    }
    
    public boolean func_71918_c(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4) {
        final int meta = par1IBlockAccess.func_72805_g(par2, par3, par4);
        switch (meta) {
            default: {
                return false;
            }
            case 2:
            case 3:
            case 4:
            case 5: {
                return true;
            }
        }
    }
    
    public Icon func_71858_a(final int side, final int meta) {
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
            case 5: {
                final Block toMimic = (Block)(BlockTFTowerTranslucent.sideRNG.nextBoolean() ? (BlockTFTowerTranslucent.sideRNG.nextBoolean() ? Block.field_72015_be : Block.field_72012_bb) : (BlockTFTowerTranslucent.sideRNG.nextBoolean() ? Block.field_71986_z : Block.field_72089_ap));
                return toMimic.func_71858_a(side, meta);
            }
            case 6: {
                return Block.field_72105_ah.func_71858_a(side, meta);
            }
            case 7: {
                return Block.field_72071_ax.func_71858_a(side, meta);
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94332_a(final IconRegister par1IconRegister) {
        BlockTFTowerTranslucent.TEX_REAPPEARING_INACTIVE = par1IconRegister.func_94245_a("twilightforest:towerdev_reappearing_trace_off");
        BlockTFTowerTranslucent.TEX_REAPPEARING_ACTIVE = par1IconRegister.func_94245_a("twilightforest:towerdev_reappearing_trace_on");
        BlockTFTowerTranslucent.TEX_BUILT_INACTIVE = par1IconRegister.func_94245_a("twilightforest:towerdev_built_off");
        BlockTFTowerTranslucent.TEX_BUILT_ACTIVE = par1IconRegister.func_94245_a("twilightforest:towerdev_built_on");
        BlockTFTowerTranslucent.TEX_REVERTER_REPLACEMENT = par1IconRegister.func_94245_a("twilightforest:towerdev_antibuilt");
    }
    
    public void func_71847_b(final World par1World, final int x, final int y, final int z, final Random par5Random) {
        if (!par1World.field_72995_K) {
            final int meta = par1World.func_72805_g(x, y, z);
            if (meta == 3) {
                par1World.func_72832_d(x, y, z, 0, 0, 3);
                par1World.func_72898_h(x, y, z, this.field_71990_ca);
                par1World.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "random.pop", 0.3f, 0.5f);
                par1World.func_72909_d(x, y, z, x, y, z);
                BlockTFTowerDevice.checkAndActivateVanishBlock(par1World, x - 1, y, z);
                BlockTFTowerDevice.checkAndActivateVanishBlock(par1World, x + 1, y, z);
                BlockTFTowerDevice.checkAndActivateVanishBlock(par1World, x, y + 1, z);
                BlockTFTowerDevice.checkAndActivateVanishBlock(par1World, x, y - 1, z);
                BlockTFTowerDevice.checkAndActivateVanishBlock(par1World, x, y, z + 1);
                BlockTFTowerDevice.checkAndActivateVanishBlock(par1World, x, y, z - 1);
            }
            if (meta == 1) {
                par1World.func_72832_d(x, y, z, TFBlocks.towerDevice.field_71990_ca, 0, 3);
                par1World.func_72898_h(x, y, z, this.field_71990_ca);
                par1World.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.5f);
                par1World.func_72909_d(x, y, z, x, y, z);
            }
            else if (meta == 0) {
                BlockTFTowerDevice.changeToActiveVanishBlock(par1World, x, y, z, 1);
            }
        }
    }
    
    public void func_71879_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
    }
    
    static {
        BlockTFTowerTranslucent.sideRNG = new Random();
    }
}
