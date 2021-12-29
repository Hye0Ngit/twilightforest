// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
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
    protected BlockTFCritter() {
        super(Material.field_151594_q);
        this.func_149711_c(0.0f);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        this.field_149762_H = new StepSoundTFInsect("squish", 0.25f, 0.6f);
    }
    
    public void func_149719_a(final IBlockAccess world, final int x, final int y, final int z) {
        final int facing = world.func_72805_g(x, y, z) & 0x7;
        final float wide = 0.15f;
        if (facing == 1) {
            this.func_149676_a(0.0f, 0.2f, 0.5f - wide, wide * 2.0f, 0.8f, 0.5f + wide);
        }
        else if (facing == 2) {
            this.func_149676_a(1.0f - wide * 2.0f, 0.2f, 0.5f - wide, 1.0f, 0.8f, 0.5f + wide);
        }
        else if (facing == 3) {
            this.func_149676_a(0.5f - wide, 0.2f, 0.0f, 0.5f + wide, 0.8f, wide * 2.0f);
        }
        else if (facing == 4) {
            this.func_149676_a(0.5f - wide, 0.2f, 1.0f - wide * 2.0f, 0.5f + wide, 0.8f, 1.0f);
        }
        else if (facing == 5) {
            this.func_149676_a(0.5f - wide, 0.0f, 0.2f, 0.5f + wide, wide * 2.0f, 0.8f);
        }
        else if (facing == 6) {
            this.func_149676_a(0.5f - wide, 1.0f - wide * 2.0f, 0.2f, 0.5f + wide, 1.0f, 0.8f);
        }
        else {
            final float f1 = 0.1f;
            this.func_149676_a(0.5f - f1, 0.0f, 0.5f - f1, 0.5f + f1, 0.6f, 0.5f + f1);
        }
    }
    
    public AxisAlignedBB func_149668_a(final World world, final int i, final int j, final int k) {
        return null;
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    public boolean func_149686_d() {
        return false;
    }
    
    public int func_149645_b() {
        return TwilightForestMod.proxy.getCritterBlockRenderID();
    }
    
    public boolean func_149742_c(final World world, final int x, final int y, final int z) {
        return this.canPlaceAt(world, x - 1, y, z) || this.canPlaceAt(world, x + 1, y, z) || this.canPlaceAt(world, x, y, z - 1) || this.canPlaceAt(world, x, y, z + 1) || this.canPlaceAt(world, x, y - 1, z) || this.canPlaceAt(world, x, y + 1, z);
    }
    
    public int func_149660_a(final World par1World, final int x, final int y, final int z, final int placementFacing, final float par6, final float par7, final float par8, int meta) {
        if (placementFacing == 1 && this.canPlaceAt(par1World, x, y - 1, z)) {
            meta = 5;
        }
        if (placementFacing == 0 && this.canPlaceAt(par1World, x, y + 1, z)) {
            meta = 6;
        }
        if (placementFacing == 2 && par1World.isSideSolid(x, y, z + 1, ForgeDirection.NORTH, true)) {
            meta = 4;
        }
        if (placementFacing == 3 && par1World.isSideSolid(x, y, z - 1, ForgeDirection.SOUTH, true)) {
            meta = 3;
        }
        if (placementFacing == 4 && par1World.isSideSolid(x + 1, y, z, ForgeDirection.WEST, true)) {
            meta = 2;
        }
        if (placementFacing == 5 && par1World.isSideSolid(x - 1, y, z, ForgeDirection.EAST, true)) {
            meta = 1;
        }
        return meta;
    }
    
    public void func_149726_b(final World world, final int x, final int y, final int z) {
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
            world.func_147464_a(x, y, z, (Block)this, this.func_149738_a(world));
        }
    }
    
    public boolean dropCritterIfCantStay(final World world, final int x, final int y, final int z) {
        if (!this.func_149742_c(world, x, y, z)) {
            this.func_149697_b(world, x, y, z, world.func_72805_g(x, y, z), 0);
            world.func_147468_f(x, y, z);
            return false;
        }
        return true;
    }
    
    public void func_149695_a(final World world, final int x, final int y, final int z, final Block blockID) {
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
                this.func_149697_b(world, x, y, z, 0, 0);
                world.func_147468_f(x, y, z);
            }
        }
    }
    
    public boolean canPlaceAt(final World world, final int x, final int y, final int z) {
        return world.func_147445_c(x, y, z, true) || world.func_147439_a(x, y, z).func_149688_o() == Material.field_151584_j || world.func_147439_a(x, y, z).func_149688_o() == Material.field_151570_A;
    }
    
    public boolean hasTileEntity(final int metadata) {
        return true;
    }
    
    public abstract TileEntity createTileEntity(final World p0, final int p1);
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
        this.field_149761_L = par1IconRegister.func_94245_a("TwilightForest:" + this.func_149739_a().substring(5));
    }
}
