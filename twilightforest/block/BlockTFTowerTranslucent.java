// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import java.util.Random;
import net.minecraft.util.IIcon;
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
    public static IIcon TEX_REAPPEARING_INACTIVE;
    public static IIcon TEX_REAPPEARING_ACTIVE;
    public static IIcon TEX_BUILT_INACTIVE;
    public static IIcon TEX_BUILT_ACTIVE;
    public static IIcon TEX_REVERTER_REPLACEMENT;
    private static Random sideRNG;
    
    public BlockTFTowerTranslucent() {
        super(Material.field_151592_s);
        this.func_149711_c(50.0f);
        this.func_149752_b(2000.0f);
        this.func_149672_a(Block.field_149777_j);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    public int tickRate() {
        return 15;
    }
    
    public Item func_149650_a(final int par1, final Random par2Random, final int par3) {
        return null;
    }
    
    protected boolean func_149700_E() {
        return false;
    }
    
    public AxisAlignedBB func_149668_a(final World par1World, final int par2, final int par3, final int par4) {
        final int meta = par1World.func_72805_g(par2, par3, par4) & 0x7;
        if (meta == 0 || meta == 1) {
            return null;
        }
        this.func_149719_a((IBlockAccess)par1World, par2, par3, par4);
        return super.func_149668_a(par1World, par2, par3, par4);
    }
    
    public void func_149719_a(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4) {
        final int meta = par1IBlockAccess.func_72805_g(par2, par3, par4);
        if (meta == 0 || meta == 1) {
            this.func_149676_a(0.375f, 0.375f, 0.375f, 0.625f, 0.625f, 0.625f);
        }
        if (meta == 5) {
            this.func_149676_a(BlockTFTowerTranslucent.sideRNG.nextFloat() * 0.4f, BlockTFTowerTranslucent.sideRNG.nextFloat() * 0.4f, BlockTFTowerTranslucent.sideRNG.nextFloat() * 0.4f, 1.0f - BlockTFTowerTranslucent.sideRNG.nextFloat() * 0.4f, 1.0f - BlockTFTowerTranslucent.sideRNG.nextFloat() * 0.4f, 1.0f - BlockTFTowerTranslucent.sideRNG.nextFloat() * 0.4f);
        }
        else {
            this.func_149676_a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        }
    }
    
    public float func_149712_f(final World world, final int x, final int y, final int z) {
        final int meta = world.func_72805_g(x, y, z);
        if (meta == 4 || meta == 5) {
            return 0.3f;
        }
        return super.func_149712_f(world, x, y, z);
    }
    
    public boolean func_149655_b(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4) {
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
    
    public IIcon func_149691_a(final int side, final int meta) {
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
                final Block toMimic = (Block)(BlockTFTowerTranslucent.sideRNG.nextBoolean() ? (BlockTFTowerTranslucent.sideRNG.nextBoolean() ? Blocks.field_150427_aO : Blocks.field_150424_aL) : (BlockTFTowerTranslucent.sideRNG.nextBoolean() ? Blocks.field_150357_h : Blocks.field_150343_Z));
                return toMimic.func_149691_a(side, meta);
            }
            case 6: {
                return Blocks.field_150340_R.func_149691_a(side, meta);
            }
            case 7: {
                return Blocks.field_150484_ah.func_149691_a(side, meta);
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
        BlockTFTowerTranslucent.TEX_REAPPEARING_INACTIVE = par1IconRegister.func_94245_a("TwilightForest:towerdev_reappearing_trace_off");
        BlockTFTowerTranslucent.TEX_REAPPEARING_ACTIVE = par1IconRegister.func_94245_a("TwilightForest:towerdev_reappearing_trace_on");
        BlockTFTowerTranslucent.TEX_BUILT_INACTIVE = par1IconRegister.func_94245_a("TwilightForest:towerdev_built_off");
        BlockTFTowerTranslucent.TEX_BUILT_ACTIVE = par1IconRegister.func_94245_a("TwilightForest:towerdev_built_on");
        BlockTFTowerTranslucent.TEX_REVERTER_REPLACEMENT = par1IconRegister.func_94245_a("TwilightForest:towerdev_antibuilt");
    }
    
    public void func_149674_a(final World par1World, final int x, final int y, final int z, final Random par5Random) {
        if (!par1World.field_72995_K) {
            final int meta = par1World.func_72805_g(x, y, z);
            if (meta == 3) {
                par1World.func_147465_d(x, y, z, Blocks.field_150350_a, 0, 3);
                par1World.func_147459_d(x, y, z, (Block)this);
                par1World.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "random.pop", 0.3f, 0.5f);
                BlockTFTowerDevice.checkAndActivateVanishBlock(par1World, x - 1, y, z);
                BlockTFTowerDevice.checkAndActivateVanishBlock(par1World, x + 1, y, z);
                BlockTFTowerDevice.checkAndActivateVanishBlock(par1World, x, y + 1, z);
                BlockTFTowerDevice.checkAndActivateVanishBlock(par1World, x, y - 1, z);
                BlockTFTowerDevice.checkAndActivateVanishBlock(par1World, x, y, z + 1);
                BlockTFTowerDevice.checkAndActivateVanishBlock(par1World, x, y, z - 1);
            }
            if (meta == 1) {
                par1World.func_147465_d(x, y, z, TFBlocks.towerDevice, 0, 3);
                par1World.func_147459_d(x, y, z, (Block)this);
                par1World.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "random.click", 0.3f, 0.5f);
            }
            else if (meta == 0) {
                BlockTFTowerDevice.changeToActiveVanishBlock(par1World, x, y, z, 1);
            }
        }
    }
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
    }
    
    static {
        BlockTFTowerTranslucent.sideRNG = new Random();
    }
}
