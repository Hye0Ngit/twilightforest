// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.init.Blocks;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatFileWriter;
import net.minecraft.stats.StatisticsFile;
import net.minecraft.client.entity.EntityClientPlayerMP;
import twilightforest.TFAchievementPage;
import net.minecraft.entity.player.EntityPlayerMP;
import java.util.Iterator;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.entity.player.EntityPlayer;
import java.util.Random;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import twilightforest.TwilightForestMod;
import net.minecraft.world.IBlockAccess;
import net.minecraft.item.ItemStack;
import java.util.List;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;

public class BlockTFTrophyPedestal extends Block
{
    private IIcon sprTopActive;
    private IIcon sprTop;
    private IIcon sprBottom;
    private IIcon sprNagaActive;
    private IIcon sprNaga;
    private IIcon sprLichActive;
    private IIcon sprLich;
    private IIcon sprHydraActive;
    private IIcon sprHydra;
    private IIcon sprUrghastActive;
    private IIcon sprUrghast;
    
    public BlockTFTrophyPedestal() {
        super(Material.field_151576_e);
        this.func_149711_c(2.0f);
        this.func_149752_b(2000.0f);
        this.func_149672_a(Block.field_149769_e);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    public IIcon func_149691_a(final int side, final int meta) {
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
    public void func_149651_a(final IIconRegister par1IconRegister) {
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
    
    public void func_149666_a(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(par1, 1, 0));
        par3List.add(new ItemStack(par1, 1, 15));
    }
    
    public void func_149719_a(final IBlockAccess world, final int x, final int y, final int z) {
        this.func_149676_a(0.0625f, 0.0f, 0.0625f, 0.9375f, 1.0f, 0.9375f);
    }
    
    public boolean func_149686_d() {
        return false;
    }
    
    public boolean func_149662_c() {
        return false;
    }
    
    public int func_149645_b() {
        return TwilightForestMod.proxy.getPedestalBlockRenderID();
    }
    
    @SideOnly(Side.CLIENT)
    public boolean func_149646_a(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4, final int par5) {
        return true;
    }
    
    public void func_149695_a(final World par1World, final int x, final int y, final int z, final Block myBlockID) {
        final int meta = par1World.func_72805_g(x, y, z);
        if (!par1World.field_72995_K && meta > 0 && this.isTrophyOnTop(par1World, x, y, z)) {
            par1World.func_147464_a(x, y, z, (Block)this, 1);
        }
    }
    
    public void func_149689_a(final World par1World, final int par2, final int par3, final int par4, final EntityLivingBase par5EntityLivingBase, final ItemStack par6ItemStack) {
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
        return world.func_147439_a(x, y + 1, z) == TFBlocks.trophy;
    }
    
    public void func_149674_a(final World world, final int x, final int y, final int z, final Random par5Random) {
        if (!world.field_72995_K) {
            final int meta = world.func_72805_g(x, y, z);
            if (this.isTrophyOnTop(world, x, y, z)) {
                if (meta > 7) {
                    if (world.func_82736_K().func_82766_b("tfEnforcedProgression")) {
                        if (this.areNearbyPlayersEligible(world, x, y, z)) {
                            this.doPedestalEffect(world, x, y, z, meta);
                        }
                        this.warnIneligiblePlayers(world, x, y, z);
                    }
                    else {
                        this.doPedestalEffect(world, x, y, z, meta);
                    }
                }
                this.rewardNearbyPlayers(world, x, y, z);
            }
        }
    }
    
    private void warnIneligiblePlayers(final World world, final int x, final int y, final int z) {
        final List<EntityPlayer> nearbyPlayers = world.func_72872_a((Class)EntityPlayer.class, AxisAlignedBB.func_72330_a((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1), (double)(z + 1)).func_72314_b(16.0, 16.0, 16.0));
        for (final EntityPlayer player : nearbyPlayers) {
            if (!this.isPlayerEligible(player)) {
                player.func_145747_a((IChatComponent)new ChatComponentText("You are unworthy."));
            }
        }
    }
    
    private boolean areNearbyPlayersEligible(final World world, final int x, final int y, final int z) {
        boolean isEligible = false;
        final List<EntityPlayer> nearbyPlayers = world.func_72872_a((Class)EntityPlayer.class, AxisAlignedBB.func_72330_a((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1), (double)(z + 1)).func_72314_b(16.0, 16.0, 16.0));
        for (final EntityPlayer player : nearbyPlayers) {
            isEligible |= this.isPlayerEligible(player);
        }
        return isEligible;
    }
    
    private boolean isPlayerEligible(final EntityPlayer player) {
        if (player instanceof EntityPlayerMP && ((EntityPlayerMP)player).func_147099_x() != null) {
            final StatisticsFile stats = ((EntityPlayerMP)player).func_147099_x();
            return stats.func_77443_a(TFAchievementPage.twilightProgressTrophyPedestal.field_75992_c);
        }
        if (player instanceof EntityClientPlayerMP && ((EntityClientPlayerMP)player).func_146107_m() != null) {
            final StatFileWriter stats2 = ((EntityClientPlayerMP)player).func_146107_m();
            return stats2.func_77443_a(TFAchievementPage.twilightProgressTrophyPedestal.field_75992_c);
        }
        return false;
    }
    
    private void doPedestalEffect(final World world, final int x, final int y, final int z, final int meta) {
        this.removeNearbyShields(world, x, y, z);
        world.func_72921_c(x, y, z, meta & 0x7, 2);
        world.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "mob.zombie.infect", 4.0f, 0.1f);
    }
    
    private void rewardNearbyPlayers(final World world, final int x, final int y, final int z) {
        final List<EntityPlayer> nearbyPlayers = world.func_72872_a((Class)EntityPlayer.class, AxisAlignedBB.func_72330_a((double)x, (double)y, (double)z, (double)(x + 1), (double)(y + 1), (double)(z + 1)).func_72314_b(16.0, 16.0, 16.0));
        for (final EntityPlayer player : nearbyPlayers) {
            player.func_71029_a((StatBase)TFAchievementPage.twilightProgressTrophyPedestal);
        }
    }
    
    protected void removeNearbyShields(final World world, final int x, final int y, final int z) {
        for (int sx = -5; sx <= 5; ++sx) {
            for (int sy = -5; sy <= 5; ++sy) {
                for (int sz = -5; sz <= 5; ++sz) {
                    final Block blockAt = world.func_147439_a(x + sx, y + sy, z + sz);
                    final int metaAt = world.func_72805_g(x + sx, y + sy, z + sz);
                    if (blockAt == TFBlocks.shield && metaAt == 15) {
                        world.func_147465_d(x + sx, y + sy, z + sz, Blocks.field_150350_a, 0, 2);
                        world.func_72926_e(2001, x + sx, y + sy, z + sz, Block.func_149682_b(blockAt) + (metaAt << 12));
                    }
                }
            }
        }
    }
    
    public int func_149738_a(final World world) {
        return 10;
    }
    
    public float func_149737_a(final EntityPlayer par1EntityPlayer, final World world, final int x, final int y, final int z) {
        final int meta = world.func_72805_g(x, y, z);
        if (meta > 0) {
            return -1.0f;
        }
        return super.func_149737_a(par1EntityPlayer, world, x, y, z);
    }
}
