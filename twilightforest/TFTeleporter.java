// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import cpw.mods.fml.common.FMLLog;
import twilightforest.block.TFBlocks;
import twilightforest.world.TFWorld;
import java.util.Random;

public class TFTeleporter extends aci
{
    protected jr myWorld;
    protected Random rand;
    
    public TFTeleporter(final jr par1WorldServer) {
        super(par1WorldServer);
        this.myWorld = par1WorldServer;
        if (this.rand == null) {
            this.rand = new Random();
        }
    }
    
    public boolean b(final nm entity, final double par3, final double par5, final double par7, final float par9) {
        final int c = 200;
        double d = -1.0;
        int i = 0;
        int j = 0;
        int k = 0;
        final int l = lr.c(entity.u);
        final int i2 = lr.c(entity.w);
        for (int j2 = l - c; j2 <= l + c; ++j2) {
            final double d2 = j2 + 0.5 - entity.u;
            for (int j3 = i2 - c; j3 <= i2 + c; ++j3) {
                final double d3 = j3 + 0.5 - entity.w;
                for (int k2 = TFWorld.WORLDHEIGHT - 1; k2 >= 0; --k2) {
                    if (this.isBlockPortal((abv)this.myWorld, j2, k2, j3)) {
                        while (this.isBlockPortal((abv)this.myWorld, j2, k2 - 1, j3)) {
                            --k2;
                        }
                        final double d4 = k2 + 0.5 - entity.v;
                        final double d5 = d2 * d2 + d4 * d4 + d3 * d3;
                        if (d < 0.0 || d5 < d) {
                            d = d5;
                            i = j2;
                            j = k2;
                            k = j3;
                        }
                    }
                }
            }
        }
        if (d >= 0.0) {
            final int k3 = i;
            final int l2 = j;
            final int i3 = k;
            double portalX = k3 + 0.5;
            final double portalY = l2 + 0.5;
            double portalZ = i3 + 0.5;
            if (this.isBlockPortal((abv)this.myWorld, k3 - 1, l2, i3)) {
                portalX -= 0.5;
            }
            if (this.isBlockPortal((abv)this.myWorld, k3 + 1, l2, i3)) {
                portalX += 0.5;
            }
            if (this.isBlockPortal((abv)this.myWorld, k3, l2, i3 - 1)) {
                portalZ -= 0.5;
            }
            if (this.isBlockPortal((abv)this.myWorld, k3, l2, i3 + 1)) {
                portalZ += 0.5;
            }
            int xOffset;
            int zOffset;
            for (xOffset = 0, zOffset = 0; xOffset == zOffset && xOffset == 0; xOffset = this.rand.nextInt(3) - this.rand.nextInt(3), zOffset = this.rand.nextInt(3) - this.rand.nextInt(3)) {}
            entity.b(portalX + xOffset, portalY + 1.0, portalZ + zOffset, entity.A, 0.0f);
            final double x = 0.0;
            entity.z = x;
            entity.y = x;
            entity.x = x;
            return true;
        }
        return false;
    }
    
    public boolean isBlockPortal(final abv world, final int x, final int y, final int z) {
        return world.a(x, y, z) == TFBlocks.portal.cF;
    }
    
    public boolean a(final nm entity) {
        t spot = this.findPortalCoords(entity, true);
        if (spot != null) {
            FMLLog.info("[TwilightForest] Found ideal portal spot", new Object[0]);
            this.makePortalAt((abv)this.myWorld, spot.a, spot.b, spot.c);
            return true;
        }
        FMLLog.info("[TwilightForest] Did not find ideal portal spot, shooting for okay one", new Object[0]);
        spot = this.findPortalCoords(entity, false);
        if (spot != null) {
            FMLLog.info("[TwilightForest] Found okay portal spot", new Object[0]);
            this.makePortalAt((abv)this.myWorld, spot.a, spot.b, spot.c);
            return true;
        }
        FMLLog.info("[TwilightForest] Did not even find an okay portal spot, just making a random one", new Object[0]);
        final double yFactor = (this.myWorld.t.i == 0) ? 2.0 : 0.5;
        final int entityX = lr.c(entity.u);
        final int entityY = lr.c(entity.v * yFactor);
        final int entityZ = lr.c(entity.w);
        this.makePortalAt((abv)this.myWorld, entityX, entityY, entityZ);
        return false;
    }
    
    public t findPortalCoords(final nm entity, final boolean ideal) {
        final double yFactor = (this.myWorld.t.i == 0) ? 2.0 : 0.5;
        final int entityX = lr.c(entity.u);
        final int entityY = lr.c(entity.v * yFactor);
        final int entityZ = lr.c(entity.w);
        double spotWeight = -1.0;
        t spot = null;
        final byte range = 16;
        for (int rx = entityX - range; rx <= entityX + range; ++rx) {
            final double xWeight = rx + 0.5 - entity.u;
            for (int rz = entityZ - range; rz <= entityZ + range; ++rz) {
                final double zWeight = rz + 0.5 - entity.w;
                for (int ry = 127; ry >= 0; --ry) {
                    if (this.myWorld.c(rx, ry, rz)) {
                        while (ry > 0 && this.myWorld.c(rx, ry - 1, rz)) {
                            --ry;
                        }
                        if (ideal) {
                            if (!this.isIdealPortal(rx, rz, ry)) {
                                continue;
                            }
                        }
                        else if (!this.isOkayPortal(rx, rz, ry)) {
                            continue;
                        }
                        final double yWeight = ry + 0.5 - entity.v * yFactor;
                        final double rPosWeight = xWeight * xWeight + yWeight * yWeight + zWeight * zWeight;
                        if (spotWeight < 0.0 || rPosWeight < spotWeight) {
                            spotWeight = rPosWeight;
                            spot = new t(rx, ry, rz);
                        }
                    }
                }
            }
        }
        return spot;
    }
    
    public boolean isIdealPortal(final int rx, final int rz, final int ry) {
        for (int potentialZ = 0; potentialZ < 4; ++potentialZ) {
            for (int potentialX = 0; potentialX < 4; ++potentialX) {
                for (int potentialY = -1; potentialY < 3; ++potentialY) {
                    final int tx = rx + (potentialX - 1);
                    final int ty = ry + potentialY;
                    final int tz = rz + (potentialZ - 1);
                    if ((potentialY == -1 && this.myWorld.g(tx, ty, tz) != ajz.b) || (potentialY >= 0 && !this.myWorld.g(tx, ty, tz).j())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean isOkayPortal(final int rx, final int rz, final int ry) {
        for (int potentialZ = 0; potentialZ < 4; ++potentialZ) {
            for (int potentialX = 0; potentialX < 4; ++potentialX) {
                for (int potentialY = -1; potentialY < 3; ++potentialY) {
                    final int tx = rx + (potentialX - 1);
                    final int ty = ry + potentialY;
                    final int tz = rz + (potentialZ - 1);
                    if ((potentialY == -1 && !this.myWorld.g(tx, ty, tz).a()) || (potentialY >= 0 && !this.myWorld.g(tx, ty, tz).j())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private void makePortalAt(final abv world, final int px, int py, final int pz) {
        if (py < 30) {
            py = 30;
        }
        world.getClass();
        if (py > 118) {
            world.getClass();
            py = 118;
        }
        --py;
        world.f(px - 1, py + 0, pz - 1, aqw.z.cF, 0, 2);
        world.f(px + 0, py + 0, pz - 1, aqw.z.cF, 0, 2);
        world.f(px + 1, py + 0, pz - 1, aqw.z.cF, 0, 2);
        world.f(px + 2, py + 0, pz - 1, aqw.z.cF, 0, 2);
        world.f(px - 1, py + 0, pz + 0, aqw.z.cF, 0, 2);
        world.f(px + 2, py + 0, pz + 0, aqw.z.cF, 0, 2);
        world.f(px - 1, py + 0, pz + 1, aqw.z.cF, 0, 2);
        world.f(px + 2, py + 0, pz + 1, aqw.z.cF, 0, 2);
        world.f(px - 1, py + 0, pz + 2, aqw.z.cF, 0, 2);
        world.f(px + 0, py + 0, pz + 2, aqw.z.cF, 0, 2);
        world.f(px + 1, py + 0, pz + 2, aqw.z.cF, 0, 2);
        world.f(px + 2, py + 0, pz + 2, aqw.z.cF, 0, 2);
        world.f(px + 0, py - 1, pz + 0, aqw.A.cF, 0, 2);
        world.f(px + 1, py - 1, pz + 0, aqw.A.cF, 0, 2);
        world.f(px + 0, py - 1, pz + 1, aqw.A.cF, 0, 2);
        world.f(px + 1, py - 1, pz + 1, aqw.A.cF, 0, 2);
        world.f(px + 0, py + 0, pz + 0, TFBlocks.portal.cF, 0, 2);
        world.f(px + 1, py + 0, pz + 0, TFBlocks.portal.cF, 0, 2);
        world.f(px + 0, py + 0, pz + 1, TFBlocks.portal.cF, 0, 2);
        world.f(px + 1, py + 0, pz + 1, TFBlocks.portal.cF, 0, 2);
        for (int dx = -1; dx <= 2; ++dx) {
            for (int dz = -1; dz <= 2; ++dz) {
                for (int dy = 1; dy <= 5; ++dy) {
                    world.f(px + dx, py + dy, pz + dz, 0, 0, 2);
                }
            }
        }
        world.f(px - 1, py + 1, pz - 1, this.randNatureBlockID(world.s), 2, 2);
        world.f(px + 0, py + 1, pz - 1, this.randNatureBlockID(world.s), 2, 2);
        world.f(px + 1, py + 1, pz - 1, this.randNatureBlockID(world.s), 2, 2);
        world.f(px + 2, py + 1, pz - 1, this.randNatureBlockID(world.s), 2, 2);
        world.f(px - 1, py + 1, pz + 0, this.randNatureBlockID(world.s), 2, 2);
        world.f(px + 2, py + 1, pz + 0, this.randNatureBlockID(world.s), 2, 2);
        world.f(px - 1, py + 1, pz + 1, this.randNatureBlockID(world.s), 2, 2);
        world.f(px + 2, py + 1, pz + 1, this.randNatureBlockID(world.s), 2, 2);
        world.f(px - 1, py + 1, pz + 2, this.randNatureBlockID(world.s), 2, 2);
        world.f(px + 0, py + 1, pz + 2, this.randNatureBlockID(world.s), 2, 2);
        world.f(px + 1, py + 1, pz + 2, this.randNatureBlockID(world.s), 2, 2);
        world.f(px + 2, py + 1, pz + 2, this.randNatureBlockID(world.s), 2, 2);
    }
    
    public int randNatureBlockID(final Random random) {
        final int[] block = { aqw.ak.cF, aqw.al.cF, aqw.ac.cF, aqw.aj.cF, aqw.ai.cF };
        return block[random.nextInt(block.length)];
    }
}
