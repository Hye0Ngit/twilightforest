// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.block.TFBlocks;
import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import java.util.ArrayList;
import net.minecraft.init.Blocks;
import twilightforest.world.TFGenerator;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.item.EnumAction;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

public class ItemTFOreMagnet extends ItemTF
{
    private static final float WIGGLE = 10.0f;
    private IIcon[] icons;
    private String[] iconNames;
    
    protected ItemTFOreMagnet() {
        this.iconNames = new String[] { "oreMagnet", "oreMagnet1", "oreMagnet2" };
        this.func_77637_a((CreativeTabs)TFItems.creativeTab);
        this.field_77777_bU = 1;
        this.func_77656_e(12);
    }
    
    public ItemStack func_77659_a(final ItemStack par1ItemStack, final World world, final EntityPlayer player) {
        player.func_71008_a(par1ItemStack, this.func_77626_a(par1ItemStack));
        return par1ItemStack;
    }
    
    public void func_77615_a(final ItemStack par1ItemStack, final World world, final EntityPlayer player, final int useRemaining) {
        final int useTime = this.func_77626_a(par1ItemStack) - useRemaining;
        if (!world.field_72995_K && useTime > 10) {
            int moved = this.doMagnet(world, player, 0.0f, 0.0f);
            if (moved == 0) {
                moved = this.doMagnet(world, player, 10.0f, 0.0f);
            }
            if (moved == 0) {
                moved = this.doMagnet(world, player, 10.0f, 10.0f);
            }
            if (moved == 0) {
                moved = this.doMagnet(world, player, 0.0f, 10.0f);
            }
            if (moved == 0) {
                moved = this.doMagnet(world, player, -10.0f, 10.0f);
            }
            if (moved == 0) {
                moved = this.doMagnet(world, player, -10.0f, 0.0f);
            }
            if (moved == 0) {
                moved = this.doMagnet(world, player, -10.0f, -10.0f);
            }
            if (moved == 0) {
                moved = this.doMagnet(world, player, 0.0f, -10.0f);
            }
            if (moved == 0) {
                moved = this.doMagnet(world, player, 10.0f, -10.0f);
            }
            if (moved > 0) {
                par1ItemStack.func_77972_a(moved, (EntityLivingBase)player);
                if (par1ItemStack.field_77994_a == 0) {
                    player.func_71028_bD();
                }
                world.func_72956_a((Entity)player, "mob.endermen.portal", 1.0f, 1.0f);
            }
        }
    }
    
    public IIcon getIcon(final ItemStack stack, final int renderPass, final EntityPlayer player, final ItemStack usingItem, final int useRemaining) {
        if (usingItem != null && usingItem.func_77973_b() == this) {
            final int useTime = usingItem.func_77988_m() - useRemaining;
            if (useTime >= 20) {
                return ((useTime >> 2) % 2 == 0) ? this.icons[2] : this.icons[1];
            }
            if (useTime > 10) {
                return this.icons[1];
            }
        }
        return this.icons[0];
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void func_94581_a(final IIconRegister par1IconRegister) {
        super.func_94581_a(par1IconRegister);
        this.icons = new IIcon[this.iconNames.length];
        for (int i = 0; i < this.iconNames.length; ++i) {
            this.icons[i] = par1IconRegister.func_94245_a("TwilightForest:" + this.iconNames[i]);
        }
    }
    
    public EnumAction func_77661_b(final ItemStack par1ItemStack) {
        return EnumAction.bow;
    }
    
    public int func_77626_a(final ItemStack par1ItemStack) {
        return 72000;
    }
    
    protected int doMagnet(final World world, final EntityPlayer player, final float yawOffset, final float pitchOffset) {
        final double range = 32.0;
        final Vec3 srcVec = Vec3.func_72443_a(player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v);
        final Vec3 lookVec = this.getOffsetLook(player, yawOffset, pitchOffset);
        final Vec3 destVec = srcVec.func_72441_c(lookVec.field_72450_a * range, lookVec.field_72448_b * range, lookVec.field_72449_c * range);
        final int useX = MathHelper.func_76128_c(srcVec.field_72450_a);
        final int useY = MathHelper.func_76128_c(srcVec.field_72448_b);
        final int useZ = MathHelper.func_76128_c(srcVec.field_72449_c);
        final int destX = MathHelper.func_76128_c(destVec.field_72450_a);
        final int destY = MathHelper.func_76128_c(destVec.field_72448_b);
        final int destZ = MathHelper.func_76128_c(destVec.field_72449_c);
        final int blocksMoved = doMagnet(world, useX, useY, useZ, destX, destY, destZ);
        return blocksMoved;
    }
    
    public static int doMagnet(final World world, final int useX, final int useY, final int useZ, final int destX, final int destY, final int destZ) {
        int blocksMoved = 0;
        final ChunkCoordinates[] lineArray = TFGenerator.getBresehnamArrayCoords(useX, useY, useZ, destX, destY, destZ);
        Block foundID = Blocks.field_150350_a;
        int foundMeta = -1;
        int foundX = -1;
        int foundY = -1;
        int foundZ = -1;
        int baseX = -1;
        int baseY = -1;
        int baseZ = -1;
        boolean isNetherrack = false;
        for (final ChunkCoordinates coord : lineArray) {
            final Block searchID = world.func_147439_a(coord.field_71574_a, coord.field_71572_b, coord.field_71573_c);
            final int searchMeta = world.func_72805_g(coord.field_71574_a, coord.field_71572_b, coord.field_71573_c);
            if (baseY == -1) {
                if (isReplaceable(world, searchID, searchMeta, coord.field_71574_a, coord.field_71572_b, coord.field_71573_c)) {
                    baseX = coord.field_71574_a;
                    baseY = coord.field_71572_b;
                    baseZ = coord.field_71573_c;
                }
                else if (isNetherReplaceable(world, searchID, searchMeta, coord.field_71574_a, coord.field_71572_b, coord.field_71573_c)) {
                    isNetherrack = true;
                    baseX = coord.field_71574_a;
                    baseY = coord.field_71572_b;
                    baseZ = coord.field_71573_c;
                }
            }
            if (searchID != Blocks.field_150350_a && isOre(searchID, searchMeta)) {
                foundID = searchID;
                foundMeta = searchMeta;
                foundX = coord.field_71574_a;
                foundY = coord.field_71572_b;
                foundZ = coord.field_71573_c;
                break;
            }
        }
        if (baseY != -1 && foundID != Blocks.field_150350_a) {
            final ArrayList<ChunkCoordinates> veinBlocks = new ArrayList<ChunkCoordinates>();
            findVein(world, foundX, foundY, foundZ, foundID, foundMeta, veinBlocks);
            final int offX = baseX - foundX;
            final int offY = baseY - foundY;
            final int offZ = baseZ - foundZ;
            for (final ChunkCoordinates coord2 : veinBlocks) {
                final int replaceX = coord2.field_71574_a + offX;
                final int replaceY = coord2.field_71572_b + offY;
                final int replaceZ = coord2.field_71573_c + offZ;
                final Block replaceID = world.func_147439_a(replaceX, replaceY, replaceZ);
                final int replaceMeta = world.func_72805_g(replaceX, replaceY, replaceZ);
                Label_0470: {
                    if (isNetherrack) {
                        if (isNetherReplaceable(world, replaceID, replaceMeta, replaceX, replaceY, replaceZ)) {
                            break Label_0470;
                        }
                    }
                    else if (isReplaceable(world, replaceID, replaceMeta, replaceX, replaceY, replaceZ)) {
                        break Label_0470;
                    }
                    if (replaceID != Blocks.field_150350_a) {
                        continue;
                    }
                }
                world.func_147465_d(coord2.field_71574_a, coord2.field_71572_b, coord2.field_71573_c, isNetherrack ? Blocks.field_150424_aL : Blocks.field_150348_b, 0, 2);
                world.func_147465_d(replaceX, replaceY, replaceZ, foundID, foundMeta, 2);
                ++blocksMoved;
            }
        }
        return blocksMoved;
    }
    
    private Vec3 getOffsetLook(final EntityPlayer player, final float yawOffset, final float pitchOffset) {
        final float var2 = MathHelper.func_76134_b(-(player.field_70177_z + yawOffset) * 0.017453292f - 3.1415927f);
        final float var3 = MathHelper.func_76126_a(-(player.field_70177_z + yawOffset) * 0.017453292f - 3.1415927f);
        final float var4 = -MathHelper.func_76134_b(-(player.field_70125_A + pitchOffset) * 0.017453292f);
        final float var5 = MathHelper.func_76126_a(-(player.field_70125_A + pitchOffset) * 0.017453292f);
        return Vec3.func_72443_a((double)(var3 * var4), (double)var5, (double)(var2 * var4));
    }
    
    private static boolean isReplaceable(final World world, final Block replaceID, final int replaceMeta, final int x, final int y, final int z) {
        return replaceID == Blocks.field_150346_d || replaceID == Blocks.field_150349_c || replaceID == Blocks.field_150351_n || (replaceID != Blocks.field_150350_a && replaceID.isReplaceableOreGen(world, x, y, z, Blocks.field_150348_b));
    }
    
    private static boolean isNetherReplaceable(final World world, final Block replaceID, final int replaceMeta, final int x, final int y, final int z) {
        return replaceID == Blocks.field_150424_aL || (replaceID != Blocks.field_150350_a && replaceID.isReplaceableOreGen(world, x, y, z, Blocks.field_150424_aL));
    }
    
    private static boolean findVein(final World world, final int x, final int y, final int z, final Block oreID, final int oreMeta, final ArrayList<ChunkCoordinates> veinBlocks) {
        final ChunkCoordinates here = new ChunkCoordinates(x, y, z);
        if (veinBlocks.contains(here)) {
            return false;
        }
        if (veinBlocks.size() >= 24) {
            return false;
        }
        if (world.func_147439_a(x, y, z) == oreID && world.func_72805_g(x, y, z) == oreMeta) {
            veinBlocks.add(here);
            findVein(world, x + 1, y, z, oreID, oreMeta, veinBlocks);
            findVein(world, x - 1, y, z, oreID, oreMeta, veinBlocks);
            findVein(world, x, y + 1, z, oreID, oreMeta, veinBlocks);
            findVein(world, x, y - 1, z, oreID, oreMeta, veinBlocks);
            findVein(world, x, y, z + 1, oreID, oreMeta, veinBlocks);
            findVein(world, x, y, z - 1, oreID, oreMeta, veinBlocks);
            return true;
        }
        return false;
    }
    
    public static boolean isOre(final Block blockID, final int meta) {
        return blockID != Blocks.field_150365_q && (blockID == Blocks.field_150366_p || blockID == Blocks.field_150482_ag || blockID == Blocks.field_150412_bA || blockID == Blocks.field_150352_o || blockID == Blocks.field_150369_x || blockID == Blocks.field_150450_ax || blockID == Blocks.field_150439_ay || blockID == Blocks.field_150449_bY || (blockID == TFBlocks.root && meta == 1) || blockID.func_149739_a().toLowerCase().contains("ore"));
    }
}
