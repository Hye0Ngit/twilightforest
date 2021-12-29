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
    private lx[] icons;
    private String[] iconNames;
    
    protected ItemTFOreMagnet(final int par1) {
        super(par1);
        this.iconNames = new String[] { "oreMagnet", "oreMagnet1", "oreMagnet2" };
        this.a((uy)TFItems.creativeTab);
        this.cq = 1;
        this.e(12);
    }
    
    public wg a(final wg par1ItemStack, final zv world, final sk player) {
        player.a(par1ItemStack, this.c_(par1ItemStack));
        return par1ItemStack;
    }
    
    public void a(final wg par1ItemStack, final zv world, final sk player, final int useRemaining) {
        final int useTime = this.c_(par1ItemStack) - useRemaining;
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
                par1ItemStack.a(moved, (ng)player);
                if (par1ItemStack.a == 0) {
                    player.cc();
                }
                world.a((mp)player, "mob.endermen.portal", 1.0f, 1.0f);
            }
        }
    }
    
    public lx getIcon(final wg stack, final int renderPass, final sk player, final wg usingItem, final int useRemaining) {
        if (usingItem != null && usingItem.b().cp == this.cp) {
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
    public void a(final ly par1IconRegister) {
        super.a(par1IconRegister);
        this.icons = new lx[this.iconNames.length];
        for (int i = 0; i < this.iconNames.length; ++i) {
            this.icons[i] = par1IconRegister.a("twilightforest:" + this.iconNames[i]);
        }
    }
    
    public xj b_(final wg par1ItemStack) {
        return xj.e;
    }
    
    public int c_(final wg par1ItemStack) {
        return 72000;
    }
    
    protected int doMagnet(final zv world, final sk player, final float yawOffset, final float pitchOffset) {
        final double range = 32.0;
        final aqw srcVec = world.T().a(player.u, player.v + player.e(), player.w);
        final aqw lookVec = this.getOffsetLook(player, yawOffset, pitchOffset);
        final aqw destVec = srcVec.c(lookVec.c * range, lookVec.d * range, lookVec.e * range);
        final int useX = kx.c(srcVec.c);
        final int useY = kx.c(srcVec.d);
        final int useZ = kx.c(srcVec.e);
        final int destX = kx.c(destVec.c);
        final int destY = kx.c(destVec.d);
        final int destZ = kx.c(destVec.e);
        final int blocksMoved = doMagnet(world, useX, useY, useZ, destX, destY, destZ);
        return blocksMoved;
    }
    
    public static int doMagnet(final zv world, final int useX, final int useY, final int useZ, final int destX, final int destY, final int destZ) {
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
        for (int i = 0; i < blockCoords.length; i += 3) {
            final int searchX = blockCoords[i + 0];
            final int searchY = blockCoords[i + 1];
            final int searchZ = blockCoords[i + 2];
            final int searchID = world.a(searchX, searchY, searchZ);
            final int searchMeta = world.h(searchX, searchY, searchZ);
            if (baseY == -1 && isReplaceable(world, searchID, searchMeta, searchX, searchY, searchZ)) {
                baseX = searchX;
                baseY = searchY;
                baseZ = searchZ;
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
            for (final t coord : veinBlocks) {
                final int replaceX = coord.a + offX;
                final int replaceY = coord.b + offY;
                final int replaceZ = coord.c + offZ;
                final int replaceID = world.a(replaceX, replaceY, replaceZ);
                final int replaceMeta = world.h(replaceX, replaceY, replaceZ);
                if (isReplaceable(world, replaceID, replaceMeta, replaceX, replaceY, replaceZ) || replaceID == 0) {
                    world.f(coord.a, coord.b, coord.c, aou.x.cz, 0, 2);
                    world.f(replaceX, replaceY, replaceZ, foundID, foundMeta, 2);
                    ++blocksMoved;
                }
            }
        }
        return blocksMoved;
    }
    
    private aqw getOffsetLook(final sk player, final float yawOffset, final float pitchOffset) {
        final float var2 = kx.b(-(player.A + yawOffset) * 0.017453292f - 3.1415927f);
        final float var3 = kx.a(-(player.A + yawOffset) * 0.017453292f - 3.1415927f);
        final float var4 = -kx.b(-(player.B + pitchOffset) * 0.017453292f);
        final float var5 = kx.a(-(player.B + pitchOffset) * 0.017453292f);
        return player.q.T().a((double)(var3 * var4), (double)var5, (double)(var2 * var4));
    }
    
    private static boolean isReplaceable(final zv world, final int replaceID, final int replaceMeta, final int x, final int y, final int z) {
        return replaceID == aou.z.cz || replaceID == aou.y.cz || replaceID == aou.J.cz || (replaceID > 0 && aou.r[replaceID].isGenMineableReplaceable(world, x, y, z, aou.x.cz));
    }
    
    private static boolean findVein(final zv world, final int x, final int y, final int z, final int oreID, final int oreMeta, final ArrayList veinBlocks) {
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
        return blockID != aou.M.cz && (blockID == aou.L.cz || blockID == aou.aA.cz || blockID == aou.bV.cz || blockID == aou.K.cz || blockID == aou.R.cz || blockID == aou.aR.cz || blockID == aou.aS.cz || (blockID == TFBlocks.root.cz && meta == 1) || aou.r[blockID].a().toLowerCase().contains("ore"));
    }
}
