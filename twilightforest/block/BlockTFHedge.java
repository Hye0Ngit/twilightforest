// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.ForgeDirection;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.Vec3;
import net.minecraft.util.MovingObjectPosition;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.block.BlockLeavesBase;

public class BlockTFHedge extends BlockLeavesBase
{
    public int damageDone;
    public static Icon sprHedge;
    public static Icon sprDarkwoodLeaves;
    
    protected BlockTFHedge(final int i) {
        super(i, Material.field_76268_x, false);
        this.damageDone = 3;
        this.func_71848_c(2.0f);
        this.func_71894_b(10.0f);
        this.func_71884_a(Block.field_71965_g);
        this.func_71849_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public AxisAlignedBB func_71872_e(final World world, final int x, final int y, final int z) {
        final int meta = world.func_72805_g(x, y, z);
        switch (meta) {
            case 0: {
                final float f = 0.0625f;
                return AxisAlignedBB.func_72332_a().func_72299_a((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1 - f), (double)(z + 1));
            }
            default: {
                return AxisAlignedBB.func_72332_a().func_72299_a((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1), (double)(z + 1));
            }
        }
    }
    
    public boolean func_71926_d() {
        return true;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean func_71877_c(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4, final int par5) {
        final int i1 = par1IBlockAccess.func_72798_a(par2, par3, par4);
        return (this.field_72131_c || i1 != this.field_71990_ca) && super.func_71877_c(par1IBlockAccess, par2, par3, par4, par5);
    }
    
    public int func_71899_b(int meta) {
        if (meta == 2) {
            meta = 0;
        }
        if (meta == 1) {
            return 3;
        }
        return meta;
    }
    
    public Icon func_71858_a(final int side, final int meta) {
        switch (meta) {
            case 1: {
                return BlockTFHedge.sprDarkwoodLeaves;
            }
            default: {
                return BlockTFHedge.sprHedge;
            }
        }
    }
    
    public void func_71869_a(final World world, final int x, final int y, final int z, final Entity entity) {
        int meta = world.func_72805_g(x, y, z);
        if (meta == 2) {
            meta = 0;
        }
        if (meta == 0 && this.shouldDamage(entity)) {
            entity.func_70097_a(DamageSource.field_76367_g, this.damageDone);
        }
    }
    
    public void func_71891_b(final World world, final int x, final int y, final int z, final Entity entity) {
        int meta = world.func_72805_g(x, y, z);
        if (meta == 2) {
            meta = 0;
        }
        if (meta == 0 && this.shouldDamage(entity)) {
            entity.func_70097_a(DamageSource.field_76367_g, this.damageDone);
        }
    }
    
    public void func_71921_a(final World world, final int x, final int y, final int z, final EntityPlayer entityplayer) {
        int meta = world.func_72805_g(x, y, z);
        if (meta == 2) {
            meta = 0;
        }
        if (meta == 0 && !world.field_72995_K) {
            world.func_72836_a(x, y, z, this.field_71990_ca, 10);
        }
    }
    
    public void func_71893_a(final World world, final EntityPlayer entityplayer, final int i, final int j, final int k, int meta) {
        super.func_71893_a(world, entityplayer, i, j, k, meta);
        if (meta == 2) {
            meta = 0;
        }
        if (meta == 0) {
            entityplayer.func_70097_a(DamageSource.field_76367_g, this.damageDone);
        }
    }
    
    public void func_71847_b(final World world, final int x, final int y, final int z, final Random random) {
        final double range = 4.0;
        final List nearbyPlayers = world.func_72872_a((Class)EntityPlayer.class, AxisAlignedBB.func_72332_a().func_72299_a((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1), (double)(z + 1)).func_72314_b(range, range, range));
        for (final EntityPlayer player : nearbyPlayers) {
            if (player.field_82175_bq) {
                final MovingObjectPosition mop = this.getPlayerPointVec(world, player, range);
                if (mop == null || world.func_72798_a(mop.field_72311_b, mop.field_72312_c, mop.field_72309_d) != this.field_71990_ca) {
                    continue;
                }
                player.func_70097_a(DamageSource.field_76367_g, this.damageDone);
                world.func_72836_a(x, y, z, this.field_71990_ca, 10);
            }
        }
    }
    
    private MovingObjectPosition getPlayerPointVec(final World worldObj, final EntityPlayer player, final double range) {
        final Vec3 position = worldObj.func_82732_R().func_72345_a(player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v);
        final Vec3 look = player.func_70676_i(1.0f);
        final Vec3 dest = position.func_72441_c(look.field_72450_a * range, look.field_72448_b * range, look.field_72449_c * range);
        return worldObj.func_72933_a(position, dest);
    }
    
    private boolean shouldDamage(final Entity entity) {
        return !(entity instanceof EntitySpider) && !(entity instanceof EntityItem) && !entity.func_82144_au();
    }
    
    public int getFlammability(final IBlockAccess world, final int x, final int y, final int z, final int metadata, final ForgeDirection face) {
        return (metadata == 1) ? 1 : 0;
    }
    
    public int getFireSpreadSpeed(final World world, final int x, final int y, final int z, final int metadata, final ForgeDirection face) {
        return 0;
    }
    
    public void func_71879_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 1));
    }
    
    public int func_71925_a(final Random par1Random) {
        return (par1Random.nextInt(40) == 0) ? 1 : 0;
    }
    
    public int func_71885_a(final int meta, final Random par2Random, final int par3) {
        if (meta == 1) {
            return TFBlocks.sapling.field_71990_ca;
        }
        return -1;
    }
    
    public ItemStack getPickBlock(final MovingObjectPosition target, final World world, final int x, final int y, final int z) {
        return new ItemStack(this.field_71990_ca, 1, world.func_72805_g(x, y, z));
    }
    
    public void func_71914_a(final World par1World, final int par2, final int par3, final int par4, final int meta, final float par6, final int fortune) {
        if (!par1World.field_72995_K && meta == 1 && par1World.field_73012_v.nextInt(40) == 0) {
            final int var9 = this.func_71885_a(meta, par1World.field_73012_v, fortune);
            this.func_71929_a(par1World, par2, par3, par4, new ItemStack(var9, 1, this.func_71899_b(meta)));
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94332_a(final IconRegister par1IconRegister) {
        BlockTFHedge.sprHedge = par1IconRegister.func_94245_a("twilightforest:hedge");
        BlockTFHedge.sprDarkwoodLeaves = par1IconRegister.func_94245_a("twilightforest:darkwood_leaves");
    }
}
