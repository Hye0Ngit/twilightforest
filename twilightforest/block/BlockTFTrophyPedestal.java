// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.entity.player.EntityPlayer;
import java.util.Random;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import twilightforest.TwilightForestMod;
import net.minecraft.world.IBlockAccess;
import net.minecraft.item.ItemStack;
import java.util.List;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.Icon;
import net.minecraft.block.Block;

public class BlockTFTrophyPedestal extends Block
{
    private Icon sprTopActive;
    private Icon sprTop;
    private Icon sprBottom;
    private Icon sprNagaActive;
    private Icon sprNaga;
    private Icon sprLichActive;
    private Icon sprLich;
    private Icon sprHydraActive;
    private Icon sprHydra;
    private Icon sprUrghastActive;
    private Icon sprUrghast;
    
    public BlockTFTrophyPedestal(final int par1) {
        super(par1, Material.field_76246_e);
        this.func_71848_c(2.0f);
        this.func_71894_b(2000.0f);
        this.func_71884_a(BlockTFTrophyPedestal.field_71976_h);
        this.func_71849_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public Icon func_71858_a(final int side, final int meta) {
        if (side == 1) {
            return (meta > 7) ? this.sprTopActive : this.sprTop;
        }
        if (side >= 2 && side <= 5) {
            final int rotate = meta & 0x3;
            final int rotatedSide = (side - 2 + rotate) % 4;
            switch (rotatedSide) {
                case 0: {
                    return (meta > 7) ? this.sprNagaActive : this.sprNaga;
                }
                case 1: {
                    return (meta > 7) ? this.sprLichActive : this.sprLich;
                }
                case 2: {
                    return (meta > 7) ? this.sprHydraActive : this.sprHydra;
                }
                case 3: {
                    return (meta > 7) ? this.sprUrghastActive : this.sprUrghast;
                }
            }
        }
        return this.sprTop;
    }
    
    @SideOnly(Side.CLIENT)
    public void func_94332_a(final IconRegister par1IconRegister) {
        this.sprTopActive = par1IconRegister.func_94245_a("TwilightForest:pedestal_top_active");
        this.sprTop = par1IconRegister.func_94245_a("TwilightForest:pedestal_top");
        this.sprBottom = par1IconRegister.func_94245_a("TwilightForest:pedestal_top");
        this.sprNagaActive = par1IconRegister.func_94245_a("TwilightForest:pedestal_naga_active");
        this.sprNaga = par1IconRegister.func_94245_a("TwilightForest:pedestal_naga");
        this.sprLichActive = par1IconRegister.func_94245_a("TwilightForest:pedestal_lich_active");
        this.sprLich = par1IconRegister.func_94245_a("TwilightForest:pedestal_lich");
        this.sprHydraActive = par1IconRegister.func_94245_a("TwilightForest:pedestal_hydra_active");
        this.sprHydra = par1IconRegister.func_94245_a("TwilightForest:pedestal_hydra");
        this.sprUrghastActive = par1IconRegister.func_94245_a("TwilightForest:pedestal_urghast_active");
        this.sprUrghast = par1IconRegister.func_94245_a("TwilightForest:pedestal_urghast");
    }
    
    public void func_71879_a(final int par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 15));
    }
    
    public void func_71902_a(final IBlockAccess world, final int x, final int y, final int z) {
        this.func_71905_a(0.0625f, 0.0f, 0.0625f, 0.9375f, 1.0f, 0.9375f);
    }
    
    public boolean func_71886_c() {
        return false;
    }
    
    public boolean func_71926_d() {
        return false;
    }
    
    public int func_71857_b() {
        return TwilightForestMod.proxy.getPedestalBlockRenderID();
    }
    
    @SideOnly(Side.CLIENT)
    public boolean func_71877_c(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4, final int par5) {
        return true;
    }
    
    public void func_71863_a(final World par1World, final int x, final int y, final int z, final int myBlockID) {
        final int meta = par1World.func_72805_g(x, y, z);
        if (!par1World.field_72995_K && meta > 0 && this.isTrophyOnTop(par1World, x, y, z)) {
            par1World.func_72836_a(x, y, z, this.field_71990_ca, 1);
        }
    }
    
    public void func_71860_a(final World par1World, final int par2, final int par3, final int par4, final EntityLivingBase par5EntityLivingBase, final ItemStack par6ItemStack) {
        final int facing = MathHelper.func_76128_c(par5EntityLivingBase.field_70177_z * 4.0f / 360.0f + 0.5) & 0x3;
        final int latent = par6ItemStack.func_77960_j() & 0x8;
        if (facing == 0) {
            par1World.func_72921_c(par2, par3, par4, 0x0 | latent, 2);
        }
        if (facing == 1) {
            par1World.func_72921_c(par2, par3, par4, 0x1 | latent, 2);
        }
        if (facing == 2) {
            par1World.func_72921_c(par2, par3, par4, 0x3 | latent, 2);
        }
        if (facing == 3) {
            par1World.func_72921_c(par2, par3, par4, 0x2 | latent, 2);
        }
    }
    
    private boolean isTrophyOnTop(final World world, final int x, final int y, final int z) {
        return world.func_72798_a(x, y + 1, z) == TFBlocks.trophy.field_71990_ca;
    }
    
    public void func_71847_b(final World world, final int x, final int y, final int z, final Random par5Random) {
        if (!world.field_72995_K) {
            final int meta = world.func_72805_g(x, y, z);
            if (meta > 7 && this.isTrophyOnTop(world, x, y, z)) {
                this.removeNearbyShields(world, x, y, z);
                world.func_72921_c(x, y, z, meta & 0x7, 2);
                world.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "mob.zombie.infect", 4.0f, 0.1f);
            }
        }
    }
    
    protected void removeNearbyShields(final World world, final int x, final int y, final int z) {
        for (int sx = -5; sx <= 5; ++sx) {
            for (int sy = -5; sy <= 5; ++sy) {
                for (int sz = -5; sz <= 5; ++sz) {
                    final int blockAt = world.func_72798_a(x + sx, y + sy, z + sz);
                    final int metaAt = world.func_72805_g(x + sx, y + sy, z + sz);
                    if (blockAt == TFBlocks.shield.field_71990_ca && metaAt == 15) {
                        world.func_94575_c(x + sx, y + sy, z + sz, 0);
                        world.func_72926_e(2001, x + sx, y + sy, z + sz, blockAt + (metaAt << 12));
                    }
                }
            }
        }
    }
    
    public int func_71859_p_(final World world) {
        return 10;
    }
    
    public float func_71908_a(final EntityPlayer par1EntityPlayer, final World world, final int x, final int y, final int z) {
        final int meta = world.func_72805_g(x, y, z);
        if (meta > 0) {
            return -1.0f;
        }
        return super.func_71908_a(par1EntityPlayer, world, x, y, z);
    }
}
