// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.ChunkCoordinates;
import cpw.mods.fml.common.FMLLog;
import twilightforest.block.TFBlocks;
import net.minecraft.world.World;
import twilightforest.world.TFWorld;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import java.util.Random;
import net.minecraft.world.WorldServer;
import net.minecraft.world.Teleporter;

public class TFTeleporter extends Teleporter
{
    protected WorldServer myWorld;
    protected Random rand;
    
    public TFTeleporter(final WorldServer par1WorldServer) {
        super(par1WorldServer);
        this.myWorld = par1WorldServer;
        if (this.rand == null) {
            this.rand = new Random();
        }
    }
    
    public boolean func_77184_b(final Entity entity, final double par3, final double par5, final double par7, final float par9) {
        final int c = 200;
        double d = -1.0;
        int i = 0;
        int j = 0;
        int k = 0;
        final int l = MathHelper.func_76128_c(entity.field_70165_t);
        final int i2 = MathHelper.func_76128_c(entity.field_70161_v);
        for (int j2 = l - c; j2 <= l + c; ++j2) {
            final double d2 = j2 + 0.5 - entity.field_70165_t;
            for (int j3 = i2 - c; j3 <= i2 + c; ++j3) {
                final double d3 = j3 + 0.5 - entity.field_70161_v;
                for (int k2 = TFWorld.MAXHEIGHT - 1; k2 >= 0; --k2) {
                    if (this.isBlockPortal((World)this.myWorld, j2, k2, j3)) {
                        while (this.isBlockPortal((World)this.myWorld, j2, k2 - 1, j3)) {
                            --k2;
                        }
                        final double d4 = k2 + 0.5 - entity.field_70163_u;
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
            if (this.isBlockPortal((World)this.myWorld, k3 - 1, l2, i3)) {
                portalX -= 0.5;
            }
            if (this.isBlockPortal((World)this.myWorld, k3 + 1, l2, i3)) {
                portalX += 0.5;
            }
            if (this.isBlockPortal((World)this.myWorld, k3, l2, i3 - 1)) {
                portalZ -= 0.5;
            }
            if (this.isBlockPortal((World)this.myWorld, k3, l2, i3 + 1)) {
                portalZ += 0.5;
            }
            int xOffset;
            int zOffset;
            for (xOffset = 0, zOffset = 0; xOffset == zOffset && xOffset == 0; xOffset = this.rand.nextInt(3) - this.rand.nextInt(3), zOffset = this.rand.nextInt(3) - this.rand.nextInt(3)) {}
            entity.func_70012_b(portalX + xOffset, portalY + 1.0, portalZ + zOffset, entity.field_70177_z, 0.0f);
            final double field_70159_w = 0.0;
            entity.field_70179_y = field_70159_w;
            entity.field_70181_x = field_70159_w;
            entity.field_70159_w = field_70159_w;
            return true;
        }
        return false;
    }
    
    public boolean isBlockPortal(final World world, final int x, final int y, final int z) {
        return world.func_72798_a(x, y, z) == TFBlocks.portal.field_71990_ca;
    }
    
    public boolean func_85188_a(final Entity entity) {
        ChunkCoordinates spot = this.findPortalCoords(entity, true);
        if (spot != null) {
            FMLLog.info("[TwilightForest] Found ideal portal spot", new Object[0]);
            this.makePortalAt((World)this.myWorld, spot.field_71574_a, spot.field_71572_b, spot.field_71573_c);
            return true;
        }
        FMLLog.info("[TwilightForest] Did not find ideal portal spot, shooting for okay one", new Object[0]);
        spot = this.findPortalCoords(entity, false);
        if (spot != null) {
            FMLLog.info("[TwilightForest] Found okay portal spot", new Object[0]);
            this.makePortalAt((World)this.myWorld, spot.field_71574_a, spot.field_71572_b, spot.field_71573_c);
            return true;
        }
        FMLLog.info("[TwilightForest] Did not even find an okay portal spot, just making a random one", new Object[0]);
        final double yFactor = (this.myWorld.field_73011_w.field_76574_g == 0) ? 2.0 : 0.5;
        final int entityX = MathHelper.func_76128_c(entity.field_70165_t);
        final int entityY = MathHelper.func_76128_c(entity.field_70163_u * yFactor);
        final int entityZ = MathHelper.func_76128_c(entity.field_70161_v);
        this.makePortalAt((World)this.myWorld, entityX, entityY, entityZ);
        return false;
    }
    
    public ChunkCoordinates findPortalCoords(final Entity entity, final boolean ideal) {
        final double yFactor = (this.myWorld.field_73011_w.field_76574_g == 0) ? 2.0 : 0.5;
        final int entityX = MathHelper.func_76128_c(entity.field_70165_t);
        final int entityY = MathHelper.func_76128_c(entity.field_70163_u * yFactor);
        final int entityZ = MathHelper.func_76128_c(entity.field_70161_v);
        double spotWeight = -1.0;
        ChunkCoordinates spot = null;
        final byte range = 16;
        for (int rx = entityX - range; rx <= entityX + range; ++rx) {
            final double xWeight = rx + 0.5 - entity.field_70165_t;
            for (int rz = entityZ - range; rz <= entityZ + range; ++rz) {
                final double zWeight = rz + 0.5 - entity.field_70161_v;
                for (int ry = 127; ry >= 0; --ry) {
                    if (this.myWorld.func_72799_c(rx, ry, rz)) {
                        while (ry > 0 && this.myWorld.func_72799_c(rx, ry - 1, rz)) {
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
                        final double yWeight = ry + 0.5 - entity.field_70163_u * yFactor;
                        final double rPosWeight = xWeight * xWeight + yWeight * yWeight + zWeight * zWeight;
                        if (spotWeight < 0.0 || rPosWeight < spotWeight) {
                            spotWeight = rPosWeight;
                            spot = new ChunkCoordinates(rx, ry, rz);
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
                    if ((potentialY == -1 && this.myWorld.func_72803_f(tx, ty, tz) != Material.field_76247_b) || (potentialY >= 0 && !this.myWorld.func_72803_f(tx, ty, tz).func_76222_j())) {
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
                    if ((potentialY == -1 && !this.myWorld.func_72803_f(tx, ty, tz).func_76220_a()) || (potentialY >= 0 && !this.myWorld.func_72803_f(tx, ty, tz).func_76222_j())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private void makePortalAt(final World world, final int px, int py, final int pz) {
        if (py < 30) {
            py = 30;
        }
        world.getClass();
        if (py > 118) {
            world.getClass();
            py = 118;
        }
        --py;
        world.func_72832_d(px - 1, py + 0, pz - 1, Block.field_71980_u.field_71990_ca, 0, 2);
        world.func_72832_d(px + 0, py + 0, pz - 1, Block.field_71980_u.field_71990_ca, 0, 2);
        world.func_72832_d(px + 1, py + 0, pz - 1, Block.field_71980_u.field_71990_ca, 0, 2);
        world.func_72832_d(px + 2, py + 0, pz - 1, Block.field_71980_u.field_71990_ca, 0, 2);
        world.func_72832_d(px - 1, py + 0, pz + 0, Block.field_71980_u.field_71990_ca, 0, 2);
        world.func_72832_d(px + 2, py + 0, pz + 0, Block.field_71980_u.field_71990_ca, 0, 2);
        world.func_72832_d(px - 1, py + 0, pz + 1, Block.field_71980_u.field_71990_ca, 0, 2);
        world.func_72832_d(px + 2, py + 0, pz + 1, Block.field_71980_u.field_71990_ca, 0, 2);
        world.func_72832_d(px - 1, py + 0, pz + 2, Block.field_71980_u.field_71990_ca, 0, 2);
        world.func_72832_d(px + 0, py + 0, pz + 2, Block.field_71980_u.field_71990_ca, 0, 2);
        world.func_72832_d(px + 1, py + 0, pz + 2, Block.field_71980_u.field_71990_ca, 0, 2);
        world.func_72832_d(px + 2, py + 0, pz + 2, Block.field_71980_u.field_71990_ca, 0, 2);
        world.func_72832_d(px + 0, py - 1, pz + 0, Block.field_71979_v.field_71990_ca, 0, 2);
        world.func_72832_d(px + 1, py - 1, pz + 0, Block.field_71979_v.field_71990_ca, 0, 2);
        world.func_72832_d(px + 0, py - 1, pz + 1, Block.field_71979_v.field_71990_ca, 0, 2);
        world.func_72832_d(px + 1, py - 1, pz + 1, Block.field_71979_v.field_71990_ca, 0, 2);
        world.func_72832_d(px + 0, py + 0, pz + 0, TFBlocks.portal.field_71990_ca, 0, 2);
        world.func_72832_d(px + 1, py + 0, pz + 0, TFBlocks.portal.field_71990_ca, 0, 2);
        world.func_72832_d(px + 0, py + 0, pz + 1, TFBlocks.portal.field_71990_ca, 0, 2);
        world.func_72832_d(px + 1, py + 0, pz + 1, TFBlocks.portal.field_71990_ca, 0, 2);
        for (int dx = -1; dx <= 2; ++dx) {
            for (int dz = -1; dz <= 2; ++dz) {
                for (int dy = 1; dy <= 5; ++dy) {
                    world.func_72832_d(px + dx, py + dy, pz + dz, 0, 0, 2);
                }
            }
        }
        world.func_72832_d(px - 1, py + 1, pz - 1, this.randNatureBlockID(world.field_73012_v), 2, 2);
        world.func_72832_d(px + 0, py + 1, pz - 1, this.randNatureBlockID(world.field_73012_v), 2, 2);
        world.func_72832_d(px + 1, py + 1, pz - 1, this.randNatureBlockID(world.field_73012_v), 2, 2);
        world.func_72832_d(px + 2, py + 1, pz - 1, this.randNatureBlockID(world.field_73012_v), 2, 2);
        world.func_72832_d(px - 1, py + 1, pz + 0, this.randNatureBlockID(world.field_73012_v), 2, 2);
        world.func_72832_d(px + 2, py + 1, pz + 0, this.randNatureBlockID(world.field_73012_v), 2, 2);
        world.func_72832_d(px - 1, py + 1, pz + 1, this.randNatureBlockID(world.field_73012_v), 2, 2);
        world.func_72832_d(px + 2, py + 1, pz + 1, this.randNatureBlockID(world.field_73012_v), 2, 2);
        world.func_72832_d(px - 1, py + 1, pz + 2, this.randNatureBlockID(world.field_73012_v), 2, 2);
        world.func_72832_d(px + 0, py + 1, pz + 2, this.randNatureBlockID(world.field_73012_v), 2, 2);
        world.func_72832_d(px + 1, py + 1, pz + 2, this.randNatureBlockID(world.field_73012_v), 2, 2);
        world.func_72832_d(px + 2, py + 1, pz + 2, this.randNatureBlockID(world.field_73012_v), 2, 2);
    }
    
    public int randNatureBlockID(final Random random) {
        final int[] block = { Block.field_72109_af.field_71990_ca, Block.field_72103_ag.field_71990_ca, Block.field_71962_X.field_71990_ca, Block.field_72107_ae.field_71990_ca, Block.field_72097_ad.field_71990_ca };
        return block[random.nextInt(block.length)];
    }
}
