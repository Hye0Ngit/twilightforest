// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.block.Block;
import net.minecraft.util.Icon;
import java.util.Random;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.item.ItemStack;
import java.util.ArrayList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntitySkull;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.item.TFItems;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.tileentity.TileEntityTFTrophy;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.block.material.Material;
import net.minecraft.block.BlockContainer;

public class BlockTFTrophy extends BlockContainer
{
    public BlockTFTrophy(final int par1) {
        super(par1, Material.field_76265_p);
        this.func_71905_a(0.25f, 0.0f, 0.25f, 0.75f, 0.5f, 0.75f);
    }
    
    public int func_71857_b() {
        return -1;
    }
    
    public boolean func_71926_d() {
        return false;
    }
    
    public boolean func_71886_c() {
        return false;
    }
    
    public AxisAlignedBB func_71872_e(final World par1World, final int par2, final int par3, final int par4) {
        this.func_71902_a((IBlockAccess)par1World, par2, par3, par4);
        return super.func_71872_e(par1World, par2, par3, par4);
    }
    
    public void func_71902_a(final IBlockAccess par1IBlockAccess, final int x, final int y, final int z) {
        final int meta = par1IBlockAccess.func_72805_g(x, y, z) & 0x7;
        final TileEntityTFTrophy trophy = (TileEntityTFTrophy)par1IBlockAccess.func_72796_p(x, y, z);
        if (trophy != null && trophy.func_82117_a() == 0) {
            switch (meta) {
                default: {
                    this.func_71905_a(0.25f, 0.0f, 0.25f, 0.75f, 0.5f, 0.75f);
                    break;
                }
                case 2:
                case 3: {
                    this.func_71905_a(0.25f, 0.25f, 0.0f, 0.75f, 0.75f, 1.0f);
                    break;
                }
                case 4:
                case 5: {
                    this.func_71905_a(0.0f, 0.25f, 0.25f, 1.0f, 0.75f, 0.75f);
                    break;
                }
            }
        }
        else if (trophy != null && trophy.func_82117_a() == 3) {
            this.func_71905_a(0.25f, 0.5f, 0.25f, 0.75f, 1.0f, 0.75f);
        }
        else {
            switch (meta) {
                default: {
                    this.func_71905_a(0.25f, 0.0f, 0.25f, 0.75f, 0.5f, 0.75f);
                    break;
                }
                case 2: {
                    this.func_71905_a(0.25f, 0.25f, 0.5f, 0.75f, 0.75f, 1.0f);
                    break;
                }
                case 3: {
                    this.func_71905_a(0.25f, 0.25f, 0.0f, 0.75f, 0.75f, 0.5f);
                    break;
                }
                case 4: {
                    this.func_71905_a(0.5f, 0.25f, 0.25f, 1.0f, 0.75f, 0.75f);
                    break;
                }
                case 5: {
                    this.func_71905_a(0.0f, 0.25f, 0.25f, 0.5f, 0.75f, 0.75f);
                    break;
                }
            }
        }
    }
    
    public void onBlockPlacedBy(final World par1World, final int par2, final int par3, final int par4, final EntityLivingBase par5EntityLiving) {
        final int var6 = MathHelper.func_76128_c(par5EntityLiving.field_70177_z * 4.0f / 360.0f + 2.5) & 0x3;
        par1World.func_72921_c(par2, par3, par4, var6, 2);
    }
    
    public TileEntity func_72274_a(final World par1World) {
        return (TileEntity)new TileEntityTFTrophy();
    }
    
    @SideOnly(Side.CLIENT)
    public int func_71922_a(final World par1World, final int par2, final int par3, final int par4) {
        return TFItems.trophy.field_77779_bT;
    }
    
    public int func_71873_h(final World par1World, final int par2, final int par3, final int par4) {
        final TileEntity var5 = par1World.func_72796_p(par2, par3, par4);
        return (var5 != null && var5 instanceof TileEntitySkull) ? ((TileEntitySkull)var5).func_82117_a() : super.func_71873_h(par1World, par2, par3, par4);
    }
    
    public int func_71899_b(final int par1) {
        return par1;
    }
    
    public void func_71846_a(final World par1World, final int par2, final int par3, final int par4, int par5, final EntityPlayer par6EntityPlayer) {
        if (par6EntityPlayer.field_71075_bZ.field_75098_d) {
            par5 |= 0x8;
            par1World.func_72921_c(par2, par3, par4, par5, 2);
        }
        this.func_71897_c(par1World, par2, par3, par4, par5, 0);
        super.func_71846_a(par1World, par2, par3, par4, par5, par6EntityPlayer);
    }
    
    public void func_71852_a(final World par1World, final int par2, final int par3, final int par4, final int par5, final int par6) {
        super.func_71852_a(par1World, par2, par3, par4, par5, par6);
    }
    
    public ArrayList<ItemStack> getBlockDropped(final World world, final int x, final int y, final int z, final int metadata, final int fortune) {
        final ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        if ((metadata & 0x8) == 0x0) {
            final ItemStack var7 = new ItemStack(TFItems.trophy.field_77779_bT, 1, this.func_71873_h(world, x, y, z));
            final TileEntityTFTrophy var8 = (TileEntityTFTrophy)world.func_72796_p(x, y, z);
            if (var8 == null) {
                return drops;
            }
            if (var8.func_82117_a() == 3 && var8.func_82120_c() != null && var8.func_82120_c().length() > 0) {
                var7.func_77982_d(new NBTTagCompound());
                var7.func_77978_p().func_74778_a("SkullOwner", var8.func_82120_c());
            }
            drops.add(var7);
        }
        return drops;
    }
    
    public int func_71885_a(final int par1, final Random par2Random, final int par3) {
        return TFItems.trophy.field_77779_bT;
    }
    
    @SideOnly(Side.CLIENT)
    public Icon func_71858_a(final int side, final int meta) {
        return Block.field_72013_bc.func_71858_a(side, meta);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94332_a(final IconRegister par1IconRegister) {
    }
}
