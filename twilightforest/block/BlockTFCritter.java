// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import twilightforest.TwilightForestMod;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

public abstract class BlockTFCritter extends Block
{
    protected BlockTFCritter(final int index) {
        super(index, Material.field_76265_p);
        this.func_71848_c(0.0f);
        this.func_71849_a((CreativeTabs)TFItems.creativeTab);
        this.field_72020_cn = new StepSoundTFInsect("squish", 0.25f, 0.6f);
    }
    
    public void func_71902_a(final IBlockAccess world, final int x, final int y, final int z) {
        final int facing = world.func_72805_g(x, y, z) & 0x7;
        final float wide = 0.15f;
        if (facing == 1) {
            this.func_71905_a(0.0f, 0.2f, 0.5f - wide, wide * 2.0f, 0.8f, 0.5f + wide);
        }
        else if (facing == 2) {
            this.func_71905_a(1.0f - wide * 2.0f, 0.2f, 0.5f - wide, 1.0f, 0.8f, 0.5f + wide);
        }
        else if (facing == 3) {
            this.func_71905_a(0.5f - wide, 0.2f, 0.0f, 0.5f + wide, 0.8f, wide * 2.0f);
        }
        else if (facing == 4) {
            this.func_71905_a(0.5f - wide, 0.2f, 1.0f - wide * 2.0f, 0.5f + wide, 0.8f, 1.0f);
        }
        else if (facing == 5) {
            this.func_71905_a(0.5f - wide, 0.0f, 0.2f, 0.5f + wide, wide * 2.0f, 0.8f);
        }
        else if (facing == 6) {
            this.func_71905_a(0.5f - wide, 1.0f - wide * 2.0f, 0.2f, 0.5f + wide, 1.0f, 0.8f);
        }
        else {
            final float f1 = 0.1f;
            this.func_71905_a(0.5f - f1, 0.0f, 0.5f - f1, 0.5f + f1, 0.6f, 0.5f + f1);
        }
    }
    
    public AxisAlignedBB func_71872_e(final World world, final int i, final int j, final int k) {
        return null;
    }
    
    public boolean func_71926_d() {
        return false;
    }
    
    public boolean func_71886_c() {
        return false;
    }
    
    public int func_71857_b() {
        return TwilightForestMod.proxy.getCritterBlockRenderID();
    }
    
    public boolean func_71930_b(final World world, final int x, final int y, final int z) {
        return this.canPlaceAt(world, x - 1, y, z) || this.canPlaceAt(world, x + 1, y, z) || this.canPlaceAt(world, x, y, z - 1) || this.canPlaceAt(world, x, y, z + 1) || this.canPlaceAt(world, x, y - 1, z) || this.canPlaceAt(world, x, y + 1, z);
    }
    
    public int func_85104_a(final World par1World, final int x, final int y, final int z, final int placementFacing, final float par6, final float par7, final float par8, int meta) {
        if (placementFacing == 1 && this.canPlaceAt(par1World, x, y - 1, z)) {
            meta = 5;
        }
        if (placementFacing == 0 && this.canPlaceAt(par1World, x, y + 1, z)) {
            meta = 6;
        }
        if (placementFacing == 2 && par1World.isBlockSolidOnSide(x, y, z + 1, ForgeDirection.NORTH, true)) {
            meta = 4;
        }
        if (placementFacing == 3 && par1World.isBlockSolidOnSide(x, y, z - 1, ForgeDirection.SOUTH, true)) {
            meta = 3;
        }
        if (placementFacing == 4 && par1World.isBlockSolidOnSide(x + 1, y, z, ForgeDirection.WEST, true)) {
            meta = 2;
        }
        if (placementFacing == 5 && par1World.isBlockSolidOnSide(x - 1, y, z, ForgeDirection.EAST, true)) {
            meta = 1;
        }
        return meta;
    }
    
    public void func_71861_g(final World world, final int x, final int y, final int z) {
        if (world.func_72805_g(x, y, z) == 0) {
            if (this.canPlaceAt(world, x - 1, y, z)) {
                world.func_72921_c(x, y, z, 1, 2);
            }
            else if (this.canPlaceAt(world, x + 1, y, z)) {
                world.func_72921_c(x, y, z, 2, 2);
            }
            else if (this.canPlaceAt(world, x, y, z - 1)) {
                world.func_72921_c(x, y, z, 3, 2);
            }
            else if (this.canPlaceAt(world, x, y, z + 1)) {
                world.func_72921_c(x, y, z, 4, 2);
            }
            else if (this.canPlaceAt(world, x, y - 1, z)) {
                world.func_72921_c(x, y, z, 5, 2);
            }
            else if (this.canPlaceAt(world, x, y + 1, z)) {
                world.func_72921_c(x, y, z, 6, 2);
            }
        }
        this.dropCritterIfCantStay(world, x, y, z);
        final int meta = world.func_72805_g(x, y, z);
        if (meta == 0) {
            world.func_72836_a(x, y, z, this.field_71990_ca, this.func_71859_p_(world));
        }
    }
    
    public boolean dropCritterIfCantStay(final World world, final int x, final int y, final int z) {
        if (!this.func_71930_b(world, x, y, z)) {
            this.func_71897_c(world, x, y, z, world.func_72805_g(x, y, z), 0);
            world.func_94571_i(x, y, z);
            return false;
        }
        return true;
    }
    
    public void func_71863_a(final World world, final int x, final int y, final int z, final int blockID) {
        if (this.dropCritterIfCantStay(world, x, y, z)) {
            final int facing = world.func_72805_g(x, y, z) & 0x7;
            boolean flag = false;
            if (!this.canPlaceAt(world, x - 1, y, z) && facing == 1) {
                flag = true;
            }
            if (!this.canPlaceAt(world, x + 1, y, z) && facing == 2) {
                flag = true;
            }
            if (!this.canPlaceAt(world, x, y, z - 1) && facing == 3) {
                flag = true;
            }
            if (!this.canPlaceAt(world, x, y, z + 1) && facing == 4) {
                flag = true;
            }
            if (!this.canPlaceAt(world, x, y - 1, z) && facing == 5) {
                flag = true;
            }
            if (!this.canPlaceAt(world, x, y + 1, z) && facing == 6) {
                flag = true;
            }
            if (flag) {
                this.func_71897_c(world, x, y, z, 0, 0);
                world.func_94571_i(x, y, z);
            }
        }
    }
    
    public boolean canPlaceAt(final World world, final int x, final int y, final int z) {
        return world.func_72809_s(x, y, z) || world.func_72803_f(x, y, z) == Material.field_76257_i || world.func_72803_f(x, y, z) == Material.field_76268_x;
    }
    
    public boolean hasTileEntity(final int metadata) {
        return true;
    }
    
    public abstract TileEntity createTileEntity(final World p0, final int p1);
    
    public void func_71879_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94332_a(final IconRegister par1IconRegister) {
        this.field_94336_cN = par1IconRegister.func_94245_a("TwilightForest:" + this.func_71917_a().substring(5));
    }
}
