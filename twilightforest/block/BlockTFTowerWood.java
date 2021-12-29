// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.common.util.ForgeDirection;
import net.minecraft.entity.Entity;
import twilightforest.entity.EntityTFTowerTermite;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.IBlockAccess;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;

public class BlockTFTowerWood extends Block
{
    private static IIcon TEX_PLAIN;
    private static IIcon TEX_ENCASED;
    private static IIcon TEX_CRACKED;
    private static IIcon TEX_MOSSY;
    private static IIcon TEX_INFESTED;
    public static final int META_INFESTED = 4;
    
    public BlockTFTowerWood() {
        super(Material.field_151575_d);
        this.func_149711_c(40.0f);
        this.func_149752_b(10.0f);
        this.func_149672_a(Block.field_149766_f);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public int func_149720_d(final IBlockAccess par1IBlockAccess, final int x, final int y, final int z) {
        final int meta = par1IBlockAccess.func_72805_g(x, y, z);
        if (meta == 0 || meta == 2 || meta == 3 || meta == 4) {
            int value = x * 31 + y * 15 + z * 33;
            if ((value & 0x100) != 0x0) {
                value = 255 - (value & 0xFF);
            }
            value &= 0xFF;
            value >>= 1;
            value |= 0x80;
            return value << 16 | value << 8 | value;
        }
        return 16777215;
    }
    
    public IIcon func_149691_a(final int side, final int meta) {
        switch (meta) {
            default: {
                return BlockTFTowerWood.TEX_PLAIN;
            }
            case 1: {
                return BlockTFTowerWood.TEX_ENCASED;
            }
            case 2: {
                return BlockTFTowerWood.TEX_CRACKED;
            }
            case 3: {
                return BlockTFTowerWood.TEX_MOSSY;
            }
            case 4: {
                return BlockTFTowerWood.TEX_INFESTED;
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
        BlockTFTowerWood.TEX_PLAIN = par1IconRegister.func_94245_a("TwilightForest:towerwood_planks");
        BlockTFTowerWood.TEX_ENCASED = par1IconRegister.func_94245_a("TwilightForest:towerwood_encased");
        BlockTFTowerWood.TEX_CRACKED = par1IconRegister.func_94245_a("TwilightForest:towerwood_cracked");
        BlockTFTowerWood.TEX_MOSSY = par1IconRegister.func_94245_a("TwilightForest:towerwood_mossy");
        BlockTFTowerWood.TEX_INFESTED = par1IconRegister.func_94245_a("TwilightForest:towerwood_infested");
    }
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 3));
        par3List.add(new ItemStack(par1, 1, 4));
    }
    
    public int func_149692_a(final int meta) {
        return meta;
    }
    
    public int quantityDropped(final int meta, final int fortune, final Random random) {
        if (meta == 4) {
            return 0;
        }
        return super.quantityDropped(meta, fortune, random);
    }
    
    public float func_149712_f(final World world, final int x, final int y, final int z) {
        final int meta = world.func_72805_g(x, y, z);
        if (meta == 4) {
            return 0.75f;
        }
        return super.func_149712_f(world, x, y, z);
    }
    
    public void func_149690_a(final World par1World, final int x, final int y, final int z, final int meta, final float chance, final int something) {
        if (!par1World.field_72995_K && meta == 4) {
            final EntityTFTowerTermite termite = new EntityTFTowerTermite(par1World);
            termite.func_70012_b(x + 0.5, (double)y, z + 0.5, 0.0f, 0.0f);
            par1World.func_72838_d((Entity)termite);
            termite.func_70656_aK();
        }
        super.func_149690_a(par1World, x, y, z, meta, chance, something);
    }
    
    public int getFlammability(final IBlockAccess world, final int x, final int y, final int z, final ForgeDirection face) {
        return 1;
    }
    
    public int getFireSpreadSpeed(final IBlockAccess world, final int x, final int y, final int z, final ForgeDirection face) {
        return 0;
    }
}
