// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.common.network.NetworkRegistry;
import twilightforest.TFGenericPacketHandler;
import java.util.Random;
import twilightforest.TwilightForestMod;
import twilightforest.world.ChunkProviderTwilightForest;
import twilightforest.world.WorldProviderTwilightForest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import twilightforest.item.TFItems;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import net.minecraft.block.Block;

public class BlockTFCastleDoor extends Block
{
    private IIcon activeIcon;
    private boolean isVanished;
    
    public BlockTFCastleDoor(final boolean isVanished) {
        super(isVanished ? Material.field_151592_s : Material.field_151576_e);
        this.isVanished = isVanished;
        this.field_149786_r = (isVanished ? 0 : 255);
        this.func_149647_a((CreativeTabs)TFItems.creativeTab);
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister register) {
        if (this.isVanished) {
            this.field_149761_L = register.func_94245_a("TwilightForest:castle_door_vanished");
            this.activeIcon = register.func_94245_a("TwilightForest:castle_door_vanished_active");
        }
        else {
            this.field_149761_L = register.func_94245_a("TwilightForest:castle_door");
            this.activeIcon = register.func_94245_a("TwilightForest:castle_door_active");
        }
    }
    
    @SideOnly(Side.CLIENT)
    public IIcon func_149673_e(final IBlockAccess world, final int x, final int y, final int z, final int side) {
        final int meta = world.func_72805_g(x, y, z);
        if (isMetaActive(meta)) {
            return this.activeIcon;
        }
        return this.field_149761_L;
    }
    
    public boolean func_149662_c() {
        return !this.isVanished;
    }
    
    public AxisAlignedBB func_149668_a(final World par1World, final int x, final int y, final int z) {
        if (this.isVanished) {
            return null;
        }
        this.func_149719_a((IBlockAccess)par1World, x, y, z);
        return super.func_149668_a(par1World, x, y, z);
    }
    
    public boolean func_149655_b(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4) {
        return !this.isVanished;
    }
    
    public boolean func_149727_a(final World par1World, final int x, final int y, final int z, final EntityPlayer par5EntityPlayer, final int par6, final float par7, final float par8, final float par9) {
        final int meta = par1World.func_72805_g(x, y, z);
        if (!isMetaActive(meta)) {
            if (isBlockLocked(par1World, x, y, z)) {
                par1World.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "random.click", 1.0f, 0.3f);
            }
            else {
                changeToActiveBlock(par1World, x, y, z, meta);
            }
            return true;
        }
        return false;
    }
    
    public static void changeToActiveBlock(final World par1World, final int x, final int y, final int z, final int meta) {
        changeToBlockMeta(par1World, x, y, z, meta | 0x8);
        playVanishSound(par1World, x, y, z);
        final Block blockAt = par1World.func_147439_a(x, y, z);
        par1World.func_147464_a(x, y, z, blockAt, 2 + par1World.field_73012_v.nextInt(5));
    }
    
    private static void changeToBlockMeta(final World par1World, final int x, final int y, final int z, final int meta) {
        final Block blockAt = par1World.func_147439_a(x, y, z);
        if (blockAt == TFBlocks.castleDoor || blockAt == TFBlocks.castleDoorVanished) {
            par1World.func_147465_d(x, y, z, blockAt, meta, 3);
            par1World.func_147458_c(x, y, z, x, y, z);
            par1World.func_147459_d(x, y, z, blockAt);
        }
    }
    
    public static boolean isBlockLocked(final World par1World, final int x, final int y, final int z) {
        final int meta = par1World.func_72805_g(x, y, z);
        if (!par1World.field_72995_K && par1World.field_73011_w instanceof WorldProviderTwilightForest) {
            final ChunkProviderTwilightForest chunkProvider = ((WorldProviderTwilightForest)par1World.field_73011_w).getChunkProvider();
            return chunkProvider.isStructureLocked(x, y, z, meta);
        }
        return false;
    }
    
    public static boolean isMetaActive(final int meta) {
        return (meta & 0x8) != 0x0;
    }
    
    public int tickRate() {
        return 5;
    }
    
    public int func_149645_b() {
        return TwilightForestMod.proxy.getCastleMagicBlockRenderID();
    }
    
    public void func_149674_a(final World par1World, final int x, final int y, final int z, final Random par5Random) {
        if (!par1World.field_72995_K) {
            final int meta = par1World.func_72805_g(x, y, z);
            if (this.isVanished) {
                if (isMetaActive(meta)) {
                    par1World.func_147465_d(x, y, z, TFBlocks.castleDoor, meta & 0x7, 3);
                    par1World.func_147459_d(x, y, z, (Block)this);
                    playVanishSound(par1World, x, y, z);
                }
                else {
                    changeToActiveBlock(par1World, x, y, z, meta);
                }
            }
            else if (isMetaActive(meta)) {
                par1World.func_147465_d(x, y, z, getOtherBlock(this), meta & 0x7, 3);
                par1World.func_147464_a(x, y, z, getOtherBlock(this), 80);
                par1World.func_147459_d(x, y, z, (Block)this);
                playReappearSound(par1World, x, y, z);
                par1World.func_147458_c(x, y, z, x, y, z);
                this.sendAnnihilateBlockPacket(par1World, x, y, z);
                checkAndActivateCastleDoor(par1World, x - 1, y, z);
                checkAndActivateCastleDoor(par1World, x + 1, y, z);
                checkAndActivateCastleDoor(par1World, x, y + 1, z);
                checkAndActivateCastleDoor(par1World, x, y - 1, z);
                checkAndActivateCastleDoor(par1World, x, y, z + 1);
                checkAndActivateCastleDoor(par1World, x, y, z - 1);
            }
        }
    }
    
    private void sendAnnihilateBlockPacket(final World world, final int x, final int y, final int z) {
        final FMLProxyPacket message = TFGenericPacketHandler.makeAnnihilateBlockPacket(x, y, z);
        final NetworkRegistry.TargetPoint targetPoint = new NetworkRegistry.TargetPoint(world.field_73011_w.field_76574_g, (double)x, (double)y, (double)z, 64.0);
        TwilightForestMod.genericChannel.sendToAllAround(message, targetPoint);
    }
    
    private static void playVanishSound(final World par1World, final int x, final int y, final int z) {
        par1World.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "random.fizz", 0.125f, par1World.field_73012_v.nextFloat() * 0.25f + 1.75f);
    }
    
    private static void playReappearSound(final World par1World, final int x, final int y, final int z) {
        par1World.func_72908_a(x + 0.5, y + 0.5, z + 0.5, "random.fizz", 0.125f, par1World.field_73012_v.nextFloat() * 0.25f + 1.25f);
    }
    
    private static Block getOtherBlock(final Block block) {
        return (block == TFBlocks.castleDoor) ? TFBlocks.castleDoorVanished : TFBlocks.castleDoor;
    }
    
    public static void checkAndActivateCastleDoor(final World world, final int x, final int y, final int z) {
        final Block block = world.func_147439_a(x, y, z);
        final int meta = world.func_72805_g(x, y, z);
        if (block == TFBlocks.castleDoor && !isMetaActive(meta) && !isBlockLocked(world, x, y, z)) {
            changeToActiveBlock(world, x, y, z, meta);
        }
    }
    
    @SideOnly(Side.CLIENT)
    public void func_149734_b(final World par1World, final int x, final int y, final int z, final Random par5Random) {
        final int meta = par1World.func_72805_g(x, y, z);
        if (isMetaActive(meta)) {}
        for (int i = 0; i < 1; ++i) {}
    }
    
    public void sparkle(final World world, final int x, final int y, final int z, final Random rand) {
        final double offset = 0.0625;
        for (int side = 0; side < 6; ++side) {
            double rx = x + rand.nextFloat();
            double ry = y + rand.nextFloat();
            double rz = z + rand.nextFloat();
            if (side == 0 && !world.func_147439_a(x, y + 1, z).func_149662_c()) {
                ry = y + 1 + offset;
            }
            if (side == 1 && !world.func_147439_a(x, y - 1, z).func_149662_c()) {
                ry = y + 0 - offset;
            }
            if (side == 2 && !world.func_147439_a(x, y, z + 1).func_149662_c()) {
                rz = z + 1 + offset;
            }
            if (side == 3 && !world.func_147439_a(x, y, z - 1).func_149662_c()) {
                rz = z + 0 - offset;
            }
            if (side == 4 && !world.func_147439_a(x + 1, y, z).func_149662_c()) {
                rx = x + 1 + offset;
            }
            if (side == 5 && !world.func_147439_a(x - 1, y, z).func_149662_c()) {
                rx = x + 0 - offset;
            }
            if (rx < x || rx > x + 1 || ry < 0.0 || ry > y + 1 || rz < z || rz > z + 1) {
                world.func_72869_a("reddust", rx, ry, rz, 0.0, 0.0, 0.0);
            }
        }
    }
}
