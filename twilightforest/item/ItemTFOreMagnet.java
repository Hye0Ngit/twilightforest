// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.item;

import twilightforest.block.TFBlocks;
import java.util.Iterator;
import java.util.ArrayList;
import twilightforest.world.TFGenerator;

public class ItemTFOreMagnet extends ItemTF
{
    private static final float WIGGLE = 10.0f;
    
    protected ItemTFOreMagnet(final int par1) {
        super(par1);
        this.a((tj)TFItems.creativeTab);
        this.ck = 1;
        this.e(12);
    }
    
    public ur a(final ur par1ItemStack, final yc world, final qx player) {
        player.a(par1ItemStack, this.c_(par1ItemStack));
        return par1ItemStack;
    }
    
    public void a(final ur par1ItemStack, final yc world, final qx player, final int useRemaining) {
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
            player.b("Cost: " + moved);
            if (moved > 0) {
                par1ItemStack.a(moved, (md)player);
                if (par1ItemStack.a == 0) {
                    player.bT();
                }
                world.a((lq)player, "mob.endermen.portal", 1.0f, 1.0f);
            }
        }
    }
    
    public int getIconIndex(final ur stack, final int renderPass, final qx player, final ur usingItem, final int useRemaining) {
        if (usingItem != null && usingItem.b().cj == this.cj) {
            final int useTime = usingItem.m() - useRemaining;
            if (useTime >= 20) {
                return ((useTime >> 2) % 2 == 0) ? (this.cl + 2) : (this.cl + 1);
            }
            if (useTime > 10) {
                return this.cl + 1;
            }
        }
        return this.cl;
    }
    
    public vs b_(final ur par1ItemStack) {
        return vs.e;
    }
    
    public int c_(final ur par1ItemStack) {
        return 72000;
    }
    
    private int doMagnet(final yc world, final qx player, final float yawOffset, final float pitchOffset) {
        int blocksMoved = 0;
        final double range = 32.0;
        final aoj srcVec = world.S().a(player.t, player.u + player.e(), player.v);
        final aoj lookVec = this.getOffsetLook(player, yawOffset, pitchOffset);
        final aoj destVec = srcVec.c(lookVec.c * range, lookVec.d * range, lookVec.e * range);
        final int useX = ke.c(srcVec.c);
        final int useY = ke.c(srcVec.d);
        final int useZ = ke.c(srcVec.e);
        final int destX = ke.c(destVec.c);
        final int destY = ke.c(destVec.d);
        final int destZ = ke.c(destVec.e);
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
            if (baseY == -1 && this.isReplaceable(world, searchID, searchMeta, searchX, searchY, searchZ)) {
                baseX = searchX;
                baseY = searchY;
                baseZ = searchZ;
            }
            if (searchID > 0 && this.isOre(searchID, searchMeta)) {
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
            this.findVein(world, foundX, foundY, foundZ, foundID, foundMeta, veinBlocks);
            final int offX = baseX - foundX;
            final int offY = baseY - foundY;
            final int offZ = baseZ - foundZ;
            for (final s coord : veinBlocks) {
                final int replaceX = coord.a + offX;
                final int replaceY = coord.b + offY;
                final int replaceZ = coord.c + offZ;
                final int replaceID = world.a(replaceX, replaceY, replaceZ);
                final int replaceMeta = world.h(replaceX, replaceY, replaceZ);
                if (this.isReplaceable(world, replaceID, replaceMeta, replaceX, replaceY, replaceZ) || replaceID == 0) {
                    world.c(coord.a, coord.b, coord.c, amq.w.cm, 0);
                    world.c(replaceX, replaceY, replaceZ, foundID, foundMeta);
                    ++blocksMoved;
                }
            }
        }
        return blocksMoved;
    }
    
    private aoj getOffsetLook(final qx player, final float yawOffset, final float pitchOffset) {
        final float var2 = ke.b(-(player.z + yawOffset) * 0.017453292f - 3.1415927f);
        final float var3 = ke.a(-(player.z + yawOffset) * 0.017453292f - 3.1415927f);
        final float var4 = -ke.b(-(player.A + pitchOffset) * 0.017453292f);
        final float var5 = ke.a(-(player.A + pitchOffset) * 0.017453292f);
        return player.p.S().a((double)(var3 * var4), (double)var5, (double)(var2 * var4));
    }
    
    private boolean isReplaceable(final yc world, final int replaceID, final int replaceMeta, final int x, final int y, final int z) {
        return replaceID == amq.y.cm || replaceID == amq.x.cm || replaceID == amq.I.cm || (replaceID > 0 && amq.p[replaceID].isGenMineableReplaceable(world, x, y, z));
    }
    
    private boolean findVein(final yc world, final int x, final int y, final int z, final int oreID, final int oreMeta, final ArrayList veinBlocks) {
        final s here = new s(x, y, z);
        if (veinBlocks.contains(here)) {
            return false;
        }
        if (veinBlocks.size() >= 24) {
            return false;
        }
        if (world.a(x, y, z) == oreID && world.h(x, y, z) == oreMeta) {
            veinBlocks.add(here);
            this.findVein(world, x + 1, y, z, oreID, oreMeta, veinBlocks);
            this.findVein(world, x - 1, y, z, oreID, oreMeta, veinBlocks);
            this.findVein(world, x, y + 1, z, oreID, oreMeta, veinBlocks);
            this.findVein(world, x, y - 1, z, oreID, oreMeta, veinBlocks);
            this.findVein(world, x, y, z + 1, oreID, oreMeta, veinBlocks);
            this.findVein(world, x, y, z - 1, oreID, oreMeta, veinBlocks);
            return true;
        }
        return false;
    }
    
    public boolean isOre(final int blockID, final int meta) {
        return blockID != amq.L.cm && (blockID == amq.K.cm || blockID == amq.az.cm || blockID == amq.bU.cm || blockID == amq.J.cm || blockID == amq.Q.cm || blockID == amq.aQ.cm || blockID == amq.aR.cm || (blockID == TFBlocks.root.cm && meta == 1) || amq.p[blockID].B().contains("Ore"));
    }
}
