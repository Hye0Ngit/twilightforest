// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.block.TFBlocks;
import java.util.Iterator;
import java.util.ArrayList;
import twilightforest.world.TFGenerator;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTFOreMagnet extends ItemTF
{
    private static final float WIGGLE = 10.0f;
    private mr[] icons;
    private String[] iconNames;
    
    protected ItemTFOreMagnet(final int par1) {
        super(par1);
        this.iconNames = new String[] { "oreMagnet", "oreMagnet1", "oreMagnet2" };
        this.a((wv)TFItems.creativeTab);
        this.cw = 1;
        this.e(12);
    }
    
    public yd a(final yd par1ItemStack, final abv world, final ue player) {
        player.a(par1ItemStack, this.d_(par1ItemStack));
        return par1ItemStack;
    }
    
    public void a(final yd par1ItemStack, final abv world, final ue player, final int useRemaining) {
        final int useTime = this.d_(par1ItemStack) - useRemaining;
        if (!world.I && useTime > 10) {
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
                par1ItemStack.a(moved, (oe)player);
                if (par1ItemStack.b == 0) {
                    player.by();
                }
                world.a((nm)player, "mob.endermen.portal", 1.0f, 1.0f);
            }
        }
    }
    
    public mr getIcon(final yd stack, final int renderPass, final ue player, final yd usingItem, final int useRemaining) {
        if (usingItem != null && usingItem.b().cv == this.cv) {
            final int useTime = usingItem.n() - useRemaining;
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
    public void a(final ms par1IconRegister) {
        super.a(par1IconRegister);
        this.icons = new mr[this.iconNames.length];
        for (int i = 0; i < this.iconNames.length; ++i) {
            this.icons[i] = par1IconRegister.a("TwilightForest:" + this.iconNames[i]);
        }
    }
    
    public zi c_(final yd par1ItemStack) {
        return zi.e;
    }
    
    public int d_(final yd par1ItemStack) {
        return 72000;
    }
    
    protected int doMagnet(final abv world, final ue player, final float yawOffset, final float pitchOffset) {
        final double range = 32.0;
        final asz srcVec = world.V().a(player.u, player.v + player.f(), player.w);
        final asz lookVec = this.getOffsetLook(player, yawOffset, pitchOffset);
        final asz destVec = srcVec.c(lookVec.c * range, lookVec.d * range, lookVec.e * range);
        final int useX = lr.c(srcVec.c);
        final int useY = lr.c(srcVec.d);
        final int useZ = lr.c(srcVec.e);
        final int destX = lr.c(destVec.c);
        final int destY = lr.c(destVec.d);
        final int destZ = lr.c(destVec.e);
        final int blocksMoved = doMagnet(world, useX, useY, useZ, destX, destY, destZ);
        return blocksMoved;
    }
    
    public static int doMagnet(final abv world, final int useX, final int useY, final int useZ, final int destX, final int destY, final int destZ) {
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
            final int searchID = world.a(searchX, searchY, searchZ);
            final int searchMeta = world.h(searchX, searchY, searchZ);
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
            final ArrayList<t> veinBlocks = new ArrayList<t>();
            findVein(world, foundX, foundY, foundZ, foundID, foundMeta, veinBlocks);
            final int offX = baseX - foundX;
            final int offY = baseY - foundY;
            final int offZ = baseZ - foundZ;
            for (final t coord : veinBlocks) {
                final int replaceX = coord.a + offX;
                final int replaceY = coord.b + offY;
                final int replaceZ = coord.c + offZ;
                final int replaceID = world.a(replaceX, replaceY, replaceZ);
                final int replaceMeta = world.h(replaceX, replaceY, replaceZ);
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
                world.f(coord.a, coord.b, coord.c, isNetherrack ? aqw.bg.cF : aqw.y.cF, 0, 2);
                world.f(replaceX, replaceY, replaceZ, foundID, foundMeta, 2);
                ++blocksMoved;
            }
        }
        return blocksMoved;
    }
    
    private asz getOffsetLook(final ue player, final float yawOffset, final float pitchOffset) {
        final float var2 = lr.b(-(player.A + yawOffset) * 0.017453292f - 3.1415927f);
        final float var3 = lr.a(-(player.A + yawOffset) * 0.017453292f - 3.1415927f);
        final float var4 = -lr.b(-(player.B + pitchOffset) * 0.017453292f);
        final float var5 = lr.a(-(player.B + pitchOffset) * 0.017453292f);
        return player.q.V().a((double)(var3 * var4), (double)var5, (double)(var2 * var4));
    }
    
    private static boolean isReplaceable(final abv world, final int replaceID, final int replaceMeta, final int x, final int y, final int z) {
        return replaceID == aqw.A.cF || replaceID == aqw.z.cF || replaceID == aqw.K.cF || (replaceID > 0 && aqw.s[replaceID].isGenMineableReplaceable(world, x, y, z, aqw.y.cF));
    }
    
    private static boolean isNetherReplaceable(final abv world, final int replaceID, final int replaceMeta, final int x, final int y, final int z) {
        return replaceID == aqw.bg.cF || (replaceID > 0 && aqw.s[replaceID].isGenMineableReplaceable(world, x, y, z, aqw.bg.cF));
    }
    
    private static boolean findVein(final abv world, final int x, final int y, final int z, final int oreID, final int oreMeta, final ArrayList<t> veinBlocks) {
        final t here = new t(x, y, z);
        if (veinBlocks.contains(here)) {
            return false;
        }
        if (veinBlocks.size() >= 24) {
            return false;
        }
        if (world.a(x, y, z) == oreID && world.h(x, y, z) == oreMeta) {
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
        return blockID != aqw.N.cF && (blockID == aqw.M.cF || blockID == aqw.aB.cF || blockID == aqw.bW.cF || blockID == aqw.L.cF || blockID == aqw.S.cF || blockID == aqw.aS.cF || blockID == aqw.aT.cF || blockID == aqw.aT.cF || blockID == aqw.cu.cF || (blockID == TFBlocks.root.cF && meta == 1) || aqw.s[blockID].a().toLowerCase().contains("ore"));
    }
}
