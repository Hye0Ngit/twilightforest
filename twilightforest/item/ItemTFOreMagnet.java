// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.block.TFBlocks;
import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.util.ChunkCoordinates;
import java.util.ArrayList;
import twilightforest.world.TFGenerator;
import net.minecraft.util.Vec3;
import net.minecraft.util.MathHelper;
import net.minecraft.item.EnumAction;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;

public class ItemTFOreMagnet extends ItemTF
{
    private static final float WIGGLE = 10.0f;
    private Icon[] icons;
    private String[] iconNames;
    
    protected ItemTFOreMagnet(final int par1) {
        super(par1);
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
                par1ItemStack.func_77972_a(moved, (EntityLiving)player);
                if (par1ItemStack.field_77994_a == 0) {
                    player.func_71028_bD();
                }
                world.func_72956_a((Entity)player, "mob.endermen.portal", 1.0f, 1.0f);
            }
        }
    }
    
    public Icon getIcon(final ItemStack stack, final int renderPass, final EntityPlayer player, final ItemStack usingItem, final int useRemaining) {
        if (usingItem != null && usingItem.func_77973_b().field_77779_bT == this.field_77779_bT) {
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
    public void func_94581_a(final IconRegister par1IconRegister) {
        super.func_94581_a(par1IconRegister);
        this.icons = new Icon[this.iconNames.length];
        for (int i = 0; i < this.iconNames.length; ++i) {
            this.icons[i] = par1IconRegister.func_94245_a("twilightforest:" + this.iconNames[i]);
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
        final Vec3 srcVec = world.func_82732_R().func_72345_a(player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v);
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
        final int[] blockCoords = TFGenerator.getBresehnamArray(useX, useY, useZ, destX, destY, destZ);
        int foundID = -1;
        int foundMeta = -1;
        int foundX = -1;
        int foundY = -1;
        int foundZ = -1;
        int baseX = -1;
        int baseY = -1;
        int baseZ = -1;
        boolean isNetherrack = false;
        for (int i = 0; i < blockCoords.length; i += 3) {
            final int searchX = blockCoords[i + 0];
            final int searchY = blockCoords[i + 1];
            final int searchZ = blockCoords[i + 2];
            final int searchID = world.func_72798_a(searchX, searchY, searchZ);
            final int searchMeta = world.func_72805_g(searchX, searchY, searchZ);
            if (baseY == -1) {
                if (isReplaceable(world, searchID, searchMeta, searchX, searchY, searchZ)) {
                    baseX = searchX;
                    baseY = searchY;
                    baseZ = searchZ;
                }
                else if (isNetherReplaceable(world, searchID, searchMeta, searchX, searchY, searchZ)) {
                    isNetherrack = true;
                    baseX = searchX;
                    baseY = searchY;
                    baseZ = searchZ;
                }
            }
            if (searchID > 0 && isOre(searchID, searchMeta)) {
                foundID = searchID;
                foundMeta = searchMeta;
                foundX = searchX;
                foundY = searchY;
                foundZ = searchZ;
                break;
            }
        }
        if (baseY != -1 && foundID != -1) {
            final ArrayList veinBlocks = new ArrayList();
            findVein(world, foundX, foundY, foundZ, foundID, foundMeta, veinBlocks);
            final int offX = baseX - foundX;
            final int offY = baseY - foundY;
            final int offZ = baseZ - foundZ;
            for (final ChunkCoordinates coord : veinBlocks) {
                final int replaceX = coord.field_71574_a + offX;
                final int replaceY = coord.field_71572_b + offY;
                final int replaceZ = coord.field_71573_c + offZ;
                final int replaceID = world.func_72798_a(replaceX, replaceY, replaceZ);
                final int replaceMeta = world.func_72805_g(replaceX, replaceY, replaceZ);
                Label_0409: {
                    if (isNetherrack) {
                        if (isNetherReplaceable(world, replaceID, replaceMeta, replaceX, replaceY, replaceZ)) {
                            break Label_0409;
                        }
                    }
                    else if (isReplaceable(world, replaceID, replaceMeta, replaceX, replaceY, replaceZ)) {
                        break Label_0409;
                    }
                    if (replaceID != 0) {
                        continue;
                    }
                }
                world.func_72832_d(coord.field_71574_a, coord.field_71572_b, coord.field_71573_c, isNetherrack ? Block.field_72012_bb.field_71990_ca : Block.field_71981_t.field_71990_ca, 0, 2);
                world.func_72832_d(replaceX, replaceY, replaceZ, foundID, foundMeta, 2);
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
        return player.field_70170_p.func_82732_R().func_72345_a((double)(var3 * var4), (double)var5, (double)(var2 * var4));
    }
    
    private static boolean isReplaceable(final World world, final int replaceID, final int replaceMeta, final int x, final int y, final int z) {
        return replaceID == Block.field_71979_v.field_71990_ca || replaceID == Block.field_71980_u.field_71990_ca || replaceID == Block.field_71940_F.field_71990_ca || (replaceID > 0 && Block.field_71973_m[replaceID].isGenMineableReplaceable(world, x, y, z, Block.field_71981_t.field_71990_ca));
    }
    
    private static boolean isNetherReplaceable(final World world, final int replaceID, final int replaceMeta, final int x, final int y, final int z) {
        return replaceID == Block.field_72012_bb.field_71990_ca || (replaceID > 0 && Block.field_71973_m[replaceID].isGenMineableReplaceable(world, x, y, z, Block.field_72012_bb.field_71990_ca));
    }
    
    private static boolean findVein(final World world, final int x, final int y, final int z, final int oreID, final int oreMeta, final ArrayList veinBlocks) {
        final ChunkCoordinates here = new ChunkCoordinates(x, y, z);
        if (veinBlocks.contains(here)) {
            return false;
        }
        if (veinBlocks.size() >= 24) {
            return false;
        }
        if (world.func_72798_a(x, y, z) == oreID && world.func_72805_g(x, y, z) == oreMeta) {
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
    
    public static boolean isOre(final int blockID, final int meta) {
        return blockID != Block.field_71950_I.field_71990_ca && (blockID == Block.field_71949_H.field_71990_ca || blockID == Block.field_72073_aw.field_71990_ca || blockID == Block.field_72068_bR.field_71990_ca || blockID == Block.field_71941_G.field_71990_ca || blockID == Block.field_71947_N.field_71990_ca || blockID == Block.field_72047_aN.field_71990_ca || blockID == Block.field_72048_aO.field_71990_ca || blockID == Block.field_72048_aO.field_71990_ca || blockID == Block.field_94342_cr.field_71990_ca || (blockID == TFBlocks.root.field_71990_ca && meta == 1) || Block.field_71973_m[blockID].func_71917_a().toLowerCase().contains("ore"));
    }
}
