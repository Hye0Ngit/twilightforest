// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraftforge.common.ForgeDirection;
import net.minecraft.entity.Entity;
import twilightforest.entity.EntityTFTowerTermite;
import net.minecraft.world.World;
import java.util.Random;
import net.minecraft.item.ItemStack;
import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.IBlockAccess;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.block.Block;

public class BlockTFTowerWood extends Block
{
    private static Icon TEX_PLAIN;
    private static Icon TEX_ENCASED;
    private static Icon TEX_CRACKED;
    private static Icon TEX_MOSSY;
    private static Icon TEX_INFESTED;
    public static final int META_INFESTED = 4;
    
    public BlockTFTowerWood(final int id) {
        super(id, Material.field_76245_d);
        this.func_71848_c(40.0f);
        this.func_71894_b(10.0f);
        this.func_71884_a(Block.field_71967_e);
        this.func_71849_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public int func_71920_b(final IBlockAccess par1IBlockAccess, final int x, final int y, final int z) {
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
    
    public Icon func_71858_a(final int side, final int meta) {
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
    public void func_94332_a(final IconRegister par1IconRegister) {
        BlockTFTowerWood.TEX_PLAIN = par1IconRegister.func_94245_a("twilightforest:towerwood_planks");
        BlockTFTowerWood.TEX_ENCASED = par1IconRegister.func_94245_a("twilightforest:towerwood_encased");
        BlockTFTowerWood.TEX_CRACKED = par1IconRegister.func_94245_a("twilightforest:towerwood_cracked");
        BlockTFTowerWood.TEX_MOSSY = par1IconRegister.func_94245_a("twilightforest:towerwood_mossy");
        BlockTFTowerWood.TEX_INFESTED = par1IconRegister.func_94245_a("twilightforest:towerwood_infested");
    }
    
    public void func_71879_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
        par3List.add(new ItemStack(par1, 1, 2));
        par3List.add(new ItemStack(par1, 1, 3));
        par3List.add(new ItemStack(par1, 1, 4));
    }
    
    public int func_71899_b(final int meta) {
        return meta;
    }
    
    public int quantityDropped(final int meta, final int fortune, final Random random) {
        if (meta == 4) {
            return 0;
        }
        return super.quantityDropped(meta, fortune, random);
    }
    
    public float func_71934_m(final World world, final int x, final int y, final int z) {
        final int meta = world.func_72805_g(x, y, z);
        if (meta == 4) {
            return 0.75f;
        }
        return super.func_71934_m(world, x, y, z);
    }
    
    public void func_71898_d(final World par1World, final int x, final int y, final int z, final int meta) {
        if (!par1World.field_72995_K && meta == 4) {
            final EntityTFTowerTermite termite = new EntityTFTowerTermite(par1World);
            termite.func_70012_b(x + 0.5, (double)y, z + 0.5, 0.0f, 0.0f);
            par1World.func_72838_d((Entity)termite);
            termite.func_70656_aK();
        }
        super.func_71898_d(par1World, x, y, z, meta);
    }
    
    public int getFlammability(final IBlockAccess world, final int x, final int y, final int z, final int metadata, final ForgeDirection face) {
        return 1;
    }
    
    public int getFireSpreadSpeed(final World world, final int x, final int y, final int z, final int metadata, final ForgeDirection face) {
        return 0;
    }
}
