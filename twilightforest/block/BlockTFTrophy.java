// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import java.util.Random;
import java.util.ArrayList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntitySkull;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.item.TFItems;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.tileentity.TileEntityTFTrophy;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockContainer;

public class BlockTFTrophy extends BlockContainer
{
    public BlockTFTrophy() {
        super(Material.field_151594_q);
        this.func_149676_a(0.25f, 0.0f, 0.25f, 0.75f, 0.5f, 0.75f);
    }
    
    public int func_149645_b() {
        return -1;
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    public boolean func_149686_d() {
        return false;
    }
    
    public AxisAlignedBB func_149668_a(final World par1World, final int par2, final int par3, final int par4) {
        this.func_149719_a((IBlockAccess)par1World, par2, par3, par4);
        return super.func_149668_a(par1World, par2, par3, par4);
    }
    
    public void func_149719_a(final IBlockAccess par1IBlockAccess, final int x, final int y, final int z) {
        final int meta = par1IBlockAccess.func_72805_g(x, y, z) & 0x7;
        final TileEntityTFTrophy trophy = (TileEntityTFTrophy)par1IBlockAccess.func_147438_o(x, y, z);
        if (trophy != null && trophy.func_145904_a() == 0) {
            switch (meta) {
                default: {
                    this.func_149676_a(0.25f, 0.0f, 0.25f, 0.75f, 0.5f, 0.75f);
                    break;
                }
                case 2:
                case 3: {
                    this.func_149676_a(0.25f, 0.25f, 0.0f, 0.75f, 0.75f, 1.0f);
                    break;
                }
                case 4:
                case 5: {
                    this.func_149676_a(0.0f, 0.25f, 0.25f, 1.0f, 0.75f, 0.75f);
                    break;
                }
            }
        }
        else if (trophy != null && trophy.func_145904_a() == 3) {
            this.func_149676_a(0.25f, 0.5f, 0.25f, 0.75f, 1.0f, 0.75f);
        }
        else {
            switch (meta) {
                default: {
                    this.func_149676_a(0.25f, 0.0f, 0.25f, 0.75f, 0.5f, 0.75f);
                    break;
                }
                case 2: {
                    this.func_149676_a(0.25f, 0.25f, 0.5f, 0.75f, 0.75f, 1.0f);
                    break;
                }
                case 3: {
                    this.func_149676_a(0.25f, 0.25f, 0.0f, 0.75f, 0.75f, 0.5f);
                    break;
                }
                case 4: {
                    this.func_149676_a(0.5f, 0.25f, 0.25f, 1.0f, 0.75f, 0.75f);
                    break;
                }
                case 5: {
                    this.func_149676_a(0.0f, 0.25f, 0.25f, 0.5f, 0.75f, 0.75f);
                    break;
                }
            }
        }
    }
    
    public void func_149689_a(final World par1World, final int par2, final int par3, final int par4, final EntityLivingBase par5EntityLiving, final ItemStack itemStack) {
        final int rotation = MathHelper.func_76128_c(par5EntityLiving.field_70177_z * 4.0f / 360.0f + 2.5) & 0x3;
        par1World.func_72921_c(par2, par3, par4, rotation, 2);
    }
    
    public TileEntity func_149915_a(final World var1, final int var2) {
        return (TileEntity)new TileEntityTFTrophy();
    }
    
    @SideOnly(Side.CLIENT)
    public Item idPicked(final World par1World, final int par2, final int par3, final int par4) {
        return TFItems.trophy;
    }
    
    public int func_149643_k(final World par1World, final int par2, final int par3, final int par4) {
        final TileEntity var5 = par1World.func_147438_o(par2, par3, par4);
        return (var5 != null && var5 instanceof TileEntitySkull) ? ((TileEntitySkull)var5).func_145904_a() : super.func_149643_k(par1World, par2, par3, par4);
    }
    
    public int func_149692_a(final int par1) {
        return par1;
    }
    
    public void func_149681_a(final World par1World, final int par2, final int par3, final int par4, int par5, final EntityPlayer par6EntityPlayer) {
        if (par6EntityPlayer.field_71075_bZ.field_75098_d) {
            par5 |= 0x8;
            par1World.func_72921_c(par2, par3, par4, par5, 2);
        }
        this.func_149697_b(par1World, par2, par3, par4, par5, 0);
        super.func_149681_a(par1World, par2, par3, par4, par5, par6EntityPlayer);
    }
    
    public ArrayList<ItemStack> getDrops(final World world, final int x, final int y, final int z, final int metadata, final int fortune) {
        final ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        if ((metadata & 0x8) == 0x0) {
            final ItemStack var7 = new ItemStack(TFItems.trophy, 1, this.func_149643_k(world, x, y, z));
            final TileEntityTFTrophy var8 = (TileEntityTFTrophy)world.func_147438_o(x, y, z);
            if (var8 == null) {
                return drops;
            }
            drops.add(var7);
        }
        return drops;
    }
    
    public Item func_149650_a(final int par1, final Random par2Random, final int par3) {
        return TFItems.trophy;
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_149691_a(final int side, final int meta) {
        return Blocks.field_150425_aM.func_149691_a(side, meta);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister par1IconRegister) {
    }
}
