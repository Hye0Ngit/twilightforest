// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import twilightforest.tileentity.TileEntityTFCinderFurnace;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import java.util.Random;
import net.minecraft.util.IIcon;
import net.minecraft.block.BlockContainer;

public class BlockTFCinderFurnace extends BlockContainer
{
    private static boolean isUpdating;
    private Boolean isLit;
    private IIcon topIcon;
    private Random furnaceRandom;
    
    protected BlockTFCinderFurnace(final Boolean isLit) {
        super(Material.field_151575_d);
        this.furnaceRandom = new Random();
        this.isLit = isLit;
        this.func_149711_c(7.0f);
        this.func_149715_a(((boolean)isLit) ? 1.0f : 0.0f);
        if (!isLit) {
            this.func_149647_a((CreativeTabs)TFItems.creativeTab);
        }
    }
    
    public TileEntity func_149915_a(final World p_149915_1_, final int p_149915_2_) {
        return new TileEntityTFCinderFurnace();
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_149691_a(final int side, final int meta) {
        return (side == 1) ? this.topIcon : ((side == 0) ? this.topIcon : this.field_149761_L);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister p_149651_1_) {
        this.field_149761_L = p_149651_1_.func_94245_a(((boolean)this.isLit) ? "furnace_front_on" : "furnace_front_off");
        this.topIcon = p_149651_1_.func_94245_a("furnace_top");
    }
    
    public boolean func_149727_a(final World world, final int x, final int y, final int z, final EntityPlayer player, final int p_149727_6_, final float p_149727_7_, final float p_149727_8_, final float p_149727_9_) {
        if (world.field_72995_K) {
            return true;
        }
        final TileEntityTFCinderFurnace tileentityfurnace = (TileEntityTFCinderFurnace)world.func_147438_o(x, y, z);
        if (tileentityfurnace != null) {
            player.openGui((Object)TwilightForestMod.instance, 2, world, x, y, z);
            return true;
        }
        return true;
    }
    
    public void func_149689_a(final World world, final int x, final int y, final int z, final EntityLivingBase p_149689_5_, final ItemStack itemStack) {
        if (itemStack.func_82837_s()) {
            ((TileEntityFurnace)world.func_147438_o(x, y, z)).func_145951_a(itemStack.func_82833_r());
        }
    }
    
    public static void updateFurnaceBlockState(final boolean isBurning, final World world, final int x, final int y, final int z) {
        final TileEntity tileentity = world.func_147438_o(x, y, z);
        BlockTFCinderFurnace.isUpdating = true;
        if (isBurning) {
            world.func_147449_b(x, y, z, TFBlocks.cinderFurnaceLit);
        }
        else {
            world.func_147449_b(x, y, z, TFBlocks.cinderFurnace);
        }
        BlockTFCinderFurnace.isUpdating = false;
        if (tileentity != null) {
            tileentity.func_145829_t();
            world.func_147455_a(x, y, z, tileentity);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149734_b(final World world, final int x, final int y, final int z, final Random random) {
        if (this.isLit) {
            final float f = x + 0.5f;
            final float f2 = y + 0.0f + random.nextFloat() * 6.0f / 16.0f;
            final float f3 = z + 0.5f;
            final float f4 = 0.52f;
            final float f5 = random.nextFloat() * 0.6f - 0.3f;
            final int l = random.nextInt(4) + 2;
            if (l == 4) {
                world.func_72869_a("smoke", (double)(f - f4), (double)f2, (double)(f3 + f5), 0.0, 0.0, 0.0);
                world.func_72869_a("flame", (double)(f - f4), (double)f2, (double)(f3 + f5), 0.0, 0.0, 0.0);
            }
            else if (l == 5) {
                world.func_72869_a("smoke", (double)(f + f4), (double)f2, (double)(f3 + f5), 0.0, 0.0, 0.0);
                world.func_72869_a("flame", (double)(f + f4), (double)f2, (double)(f3 + f5), 0.0, 0.0, 0.0);
            }
            else if (l == 2) {
                world.func_72869_a("smoke", (double)(f + f5), (double)f2, (double)(f3 - f4), 0.0, 0.0, 0.0);
                world.func_72869_a("flame", (double)(f + f5), (double)f2, (double)(f3 - f4), 0.0, 0.0, 0.0);
            }
            else if (l == 3) {
                world.func_72869_a("smoke", (double)(f + f5), (double)f2, (double)(f3 + f4), 0.0, 0.0, 0.0);
                world.func_72869_a("flame", (double)(f + f5), (double)f2, (double)(f3 + f4), 0.0, 0.0, 0.0);
            }
        }
    }
    
    public void func_149749_a(final World world, final int x, final int y, final int z, final Block block, final int p_149749_6_) {
        if (!BlockTFCinderFurnace.isUpdating) {
            final TileEntityTFCinderFurnace tileEntity = (TileEntityTFCinderFurnace)world.func_147438_o(x, y, z);
            if (tileEntity != null) {
                for (int i = 0; i < tileEntity.func_70302_i_(); ++i) {
                    final ItemStack itemstack = tileEntity.func_70301_a(i);
                    if (itemstack != null) {
                        final float dx = this.furnaceRandom.nextFloat() * 0.8f + 0.1f;
                        final float dy = this.furnaceRandom.nextFloat() * 0.8f + 0.1f;
                        final float dz = this.furnaceRandom.nextFloat() * 0.8f + 0.1f;
                        while (itemstack.field_77994_a > 0) {
                            int j1 = this.furnaceRandom.nextInt(21) + 10;
                            if (j1 > itemstack.field_77994_a) {
                                j1 = itemstack.field_77994_a;
                            }
                            final ItemStack itemStack = itemstack;
                            itemStack.field_77994_a -= j1;
                            final EntityItem entityitem = new EntityItem(world, (double)(x + dx), (double)(y + dy), (double)(z + dz), new ItemStack(itemstack.func_77973_b(), j1, itemstack.func_77960_j()));
                            if (itemstack.func_77942_o()) {
                                entityitem.func_92059_d().func_77982_d((NBTTagCompound)itemstack.func_77978_p().func_74737_b());
                            }
                            final float pointFive = 0.05f;
                            entityitem.field_70159_w = (float)this.furnaceRandom.nextGaussian() * pointFive;
                            entityitem.field_70181_x = (float)this.furnaceRandom.nextGaussian() * pointFive + 0.2f;
                            entityitem.field_70179_y = (float)this.furnaceRandom.nextGaussian() * pointFive;
                            world.func_72838_d((Entity)entityitem);
                        }
                    }
                }
                world.func_147453_f(x, y, z, block);
            }
        }
        super.func_149749_a(world, x, y, z, block, p_149749_6_);
    }
    
    public Item func_149650_a(final int meta, final Random rand, final int fortune) {
        return Item.func_150898_a(TFBlocks.cinderFurnace);
    }
    
    @SideOnly(Side.CLIENT)
    public Item func_149694_d(final World world, final int x, final int y, final int z) {
        return Item.func_150898_a(TFBlocks.cinderFurnace);
    }
}
