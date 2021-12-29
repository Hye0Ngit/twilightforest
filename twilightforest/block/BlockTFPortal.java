// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import net.minecraft.server.MinecraftServer;
import twilightforest.TFTeleporter;
import twilightforest.TFAchievementPage;
import twilightforest.TwilightForestMod;
import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTFPortal extends aon
{
    public BlockTFPortal(final int i) {
        super(i, "TFPortal", ajz.D, false);
        this.c(-1.0f);
        this.a(aqw.m);
        this.a(0.75f);
    }
    
    public asu b(final abv world, final int i, final int j, final int k) {
        return null;
    }
    
    public void a(final ace iblockaccess, final int i, final int j, final int k) {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.75f, 1.0f);
    }
    
    public boolean c() {
        return false;
    }
    
    public boolean b() {
        return false;
    }
    
    public mr a(final int side, final int meta) {
        return aqw.bj.a(side, meta);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ms par1IconRegister) {
    }
    
    public boolean tryToCreatePortal(final abv world, final int dx, final int dy, final int dz) {
        if (this.isGoodPortalPool(world, dx, dy, dz)) {
            world.c((nm)new so(world, (double)dx, (double)dy, (double)dz));
            this.transmuteWaterToPortal(world, dx, dy, dz);
            return true;
        }
        return false;
    }
    
    public void transmuteWaterToPortal(final abv world, final int dx, final int dy, final int dz) {
        int px = dx;
        int pz = dz;
        if (world.g(px - 1, dy, pz) == ajz.h) {
            --px;
        }
        if (world.g(px, dy, pz - 1) == ajz.h) {
            --pz;
        }
        world.f(px + 0, dy, pz + 0, TFBlocks.portal.cF, 0, 2);
        world.f(px + 1, dy, pz + 0, TFBlocks.portal.cF, 0, 2);
        world.f(px + 1, dy, pz + 1, TFBlocks.portal.cF, 0, 2);
        world.f(px + 0, dy, pz + 1, TFBlocks.portal.cF, 0, 2);
        System.out.println("Transmuting water to portal");
    }
    
    public boolean isGoodPortalPool(final abv world, final int dx, final int dy, final int dz) {
        boolean flag = false;
        flag |= this.isGoodPortalPoolStrict(world, dx + 0, dy, dz + 0);
        flag |= this.isGoodPortalPoolStrict(world, dx - 1, dy, dz - 1);
        flag |= this.isGoodPortalPoolStrict(world, dx + 0, dy, dz - 1);
        flag |= this.isGoodPortalPoolStrict(world, dx + 1, dy, dz - 1);
        flag |= this.isGoodPortalPoolStrict(world, dx - 1, dy, dz + 0);
        flag |= this.isGoodPortalPoolStrict(world, dx + 1, dy, dz + 0);
        flag |= this.isGoodPortalPoolStrict(world, dx - 1, dy, dz + 1);
        flag |= this.isGoodPortalPoolStrict(world, dx + 0, dy, dz + 1);
        flag |= this.isGoodPortalPoolStrict(world, dx + 1, dy, dz + 1);
        return flag;
    }
    
    public boolean isGoodPortalPoolStrict(final abv world, final int dx, final int dy, final int dz) {
        boolean flag = true;
        flag &= (world.g(dx + 0, dy, dz + 0) == ajz.h);
        flag &= (world.g(dx + 1, dy, dz + 0) == ajz.h);
        flag &= (world.g(dx + 1, dy, dz + 1) == ajz.h);
        flag &= (world.g(dx + 0, dy, dz + 1) == ajz.h);
        flag &= this.isGrassOrDirt(world, dx - 1, dy, dz - 1);
        flag &= this.isGrassOrDirt(world, dx - 1, dy, dz + 0);
        flag &= this.isGrassOrDirt(world, dx - 1, dy, dz + 1);
        flag &= this.isGrassOrDirt(world, dx - 1, dy, dz + 2);
        flag &= this.isGrassOrDirt(world, dx + 0, dy, dz - 1);
        flag &= this.isGrassOrDirt(world, dx + 1, dy, dz - 1);
        flag &= this.isGrassOrDirt(world, dx + 0, dy, dz + 2);
        flag &= this.isGrassOrDirt(world, dx + 1, dy, dz + 2);
        flag &= this.isGrassOrDirt(world, dx + 2, dy, dz - 1);
        flag &= this.isGrassOrDirt(world, dx + 2, dy, dz + 0);
        flag &= this.isGrassOrDirt(world, dx + 2, dy, dz + 1);
        flag &= this.isGrassOrDirt(world, dx + 2, dy, dz + 2);
        flag &= world.g(dx + 0, dy - 1, dz + 0).a();
        flag &= world.g(dx + 1, dy - 1, dz + 0).a();
        flag &= world.g(dx + 1, dy - 1, dz + 1).a();
        flag &= world.g(dx + 0, dy - 1, dz + 1).a();
        flag &= this.isNatureBlock(world, dx - 1, dy + 1, dz - 1);
        flag &= this.isNatureBlock(world, dx - 1, dy + 1, dz + 0);
        flag &= this.isNatureBlock(world, dx - 1, dy + 1, dz + 1);
        flag &= this.isNatureBlock(world, dx - 1, dy + 1, dz + 2);
        flag &= this.isNatureBlock(world, dx + 0, dy + 1, dz - 1);
        flag &= this.isNatureBlock(world, dx + 1, dy + 1, dz - 1);
        flag &= this.isNatureBlock(world, dx + 0, dy + 1, dz + 2);
        flag &= this.isNatureBlock(world, dx + 1, dy + 1, dz + 2);
        flag &= this.isNatureBlock(world, dx + 2, dy + 1, dz - 1);
        flag &= this.isNatureBlock(world, dx + 2, dy + 1, dz + 0);
        flag &= this.isNatureBlock(world, dx + 2, dy + 1, dz + 1);
        flag &= this.isNatureBlock(world, dx + 2, dy + 1, dz + 2);
        return flag;
    }
    
    public boolean isNatureBlock(final abv world, final int dx, final int dy, final int dz) {
        final ajz mat = world.g(dx, dy, dz);
        return mat == ajz.k || mat == ajz.l || mat == ajz.j;
    }
    
    public void a(final abv world, final int x, final int y, final int z, final int notUsed) {
        boolean good = true;
        if (world.a(x - 1, y, z) == this.cF) {
            good &= this.isGrassOrDirt(world, x + 1, y, z);
        }
        else {
            good = (world.a(x + 1, y, z) == this.cF && (good & this.isGrassOrDirt(world, x - 1, y, z)));
        }
        if (world.a(x, y, z - 1) == this.cF) {
            good &= this.isGrassOrDirt(world, x, y, z + 1);
        }
        else {
            good = (world.a(x, y, z + 1) == this.cF && (good & this.isGrassOrDirt(world, x, y, z - 1)));
        }
        if (!good) {
            world.f(x, y, z, aqw.G.cF, 0, 3);
        }
    }
    
    protected boolean isGrassOrDirt(final abv world, final int dx, final int dy, final int dz) {
        return world.g(dx, dy, dz) == ajz.b || world.g(dx, dy, dz) == ajz.c;
    }
    
    public int a(final Random random) {
        return 0;
    }
    
    public int n() {
        return 1;
    }
    
    public void a(final abv world, final int i, final int j, final int k, final nm entity) {
        if (entity.o == null && entity.n == null && entity.ao <= 0) {
            if (entity instanceof ju) {
                final ju playerMP = (ju)entity;
                if (playerMP.ao > 0) {
                    playerMP.ao = 10;
                }
                else if (playerMP.ar != TwilightForestMod.dimensionID) {
                    playerMP.a((kt)TFAchievementPage.twilightPortal);
                    playerMP.a((kt)TFAchievementPage.twilightArrival);
                    playerMP.b.af().transferPlayerToDimension(playerMP, TwilightForestMod.dimensionID, (aci)new TFTeleporter(playerMP.b.a(TwilightForestMod.dimensionID)));
                    playerMP.a(0);
                    playerMP.a((kt)TFAchievementPage.twilightPortal);
                    playerMP.a((kt)TFAchievementPage.twilightArrival);
                    final int spawnX = lr.c(playerMP.u);
                    final int spawnY = lr.c(playerMP.v);
                    final int spawnZ = lr.c(playerMP.w);
                    playerMP.setSpawnChunk(new t(spawnX, spawnY, spawnZ), true, TwilightForestMod.dimensionID);
                }
                else {
                    playerMP.b.af().transferPlayerToDimension(playerMP, 0, (aci)new TFTeleporter(playerMP.b.a(0)));
                    playerMP.a(0);
                }
            }
            else if (entity.ar != TwilightForestMod.dimensionID) {
                this.sendEntityToDimension(entity, TwilightForestMod.dimensionID);
            }
            else {
                this.sendEntityToDimension(entity, 0);
            }
        }
    }
    
    public void sendEntityToDimension(final nm entity, final int par1) {
        if (!entity.q.I && !entity.M) {
            entity.q.C.a("changeDimension");
            final MinecraftServer minecraftserver = MinecraftServer.F();
            final int dim = entity.ar;
            final jr worldserver = minecraftserver.a(dim);
            final jr worldserver2 = minecraftserver.a(par1);
            entity.ar = par1;
            entity.q.e(entity);
            entity.M = false;
            entity.q.C.a("reposition");
            minecraftserver.af().transferEntityToWorld(entity, dim, worldserver, worldserver2, (aci)new TFTeleporter(worldserver2));
            entity.q.C.c("reloading");
            final nm transferEntity = ns.a(ns.b(entity), (abv)worldserver2);
            if (transferEntity != null) {
                transferEntity.a(entity, true);
                worldserver2.d(transferEntity);
            }
            entity.M = true;
            entity.q.C.b();
            worldserver.i();
            worldserver2.i();
            entity.q.C.b();
        }
    }
    
    public void b(final abv world, final int i, final int j, final int k, final Random random) {
        if (random.nextInt(100) == 0) {
            world.a(i + 0.5, j + 0.5, k + 0.5, "portal.portal", 1.0f, random.nextFloat() * 0.4f + 0.8f);
        }
        for (int l = 0; l < 4; ++l) {
            double d = i + random.nextFloat();
            final double d2 = j + random.nextFloat();
            double d3 = k + random.nextFloat();
            double d4 = 0.0;
            double d5 = 0.0;
            double d6 = 0.0;
            final int i2 = random.nextInt(2) * 2 - 1;
            d4 = (random.nextFloat() - 0.5) * 0.5;
            d5 = (random.nextFloat() - 0.5) * 0.5;
            d6 = (random.nextFloat() - 0.5) * 0.5;
            if (world.a(i - 1, j, k) == this.cF || world.a(i + 1, j, k) == this.cF) {
                d3 = k + 0.5 + 0.25 * i2;
                d6 = random.nextFloat() * 2.0f * i2;
            }
            else {
                d = i + 0.5 + 0.25 * i2;
                d4 = random.nextFloat() * 2.0f * i2;
            }
            world.a("portal", d, d2, d3, d4, d5, d6);
        }
    }
}
