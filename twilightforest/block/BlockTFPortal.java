// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.TFTeleporter;
import twilightforest.TFAchievementPage;
import twilightforest.TwilightForestMod;
import java.util.Random;

public class BlockTFPortal extends akm
{
    public BlockTFPortal(final int i, final int j) {
        super(i, j, agi.C, false);
        this.c(-1.0f);
        this.a(amq.j);
        this.a(0.75f);
    }
    
    public aoe e(final yc world, final int i, final int j, final int k) {
        return null;
    }
    
    public void a(final ym iblockaccess, final int i, final int j, final int k) {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.75f, 1.0f);
    }
    
    public boolean c() {
        return false;
    }
    
    public boolean b() {
        return false;
    }
    
    public boolean tryToCreatePortal(final yc world, final int dx, final int dy, final int dz) {
        if (this.isGoodPortalPool(world, dx, dy, dz)) {
            world.c((lq)new pu(world, (double)dx, (double)dy, (double)dz));
            this.transmuteWaterToPortal(world, dx, dy, dz);
            return true;
        }
        return false;
    }
    
    public void transmuteWaterToPortal(final yc world, final int dx, final int dy, final int dz) {
        int px = dx;
        int pz = dz;
        if (world.g(px - 1, dy, pz) == agi.h) {
            --px;
        }
        if (world.g(px, dy, pz - 1) == agi.h) {
            --pz;
        }
        world.r = true;
        world.e(px + 0, dy, pz + 0, TFBlocks.portal.cm);
        world.e(px + 1, dy, pz + 0, TFBlocks.portal.cm);
        world.e(px + 1, dy, pz + 1, TFBlocks.portal.cm);
        world.e(px + 0, dy, pz + 1, TFBlocks.portal.cm);
        world.r = false;
    }
    
    public boolean isGoodPortalPool(final yc world, final int dx, final int dy, final int dz) {
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
    
    public boolean isGoodPortalPoolStrict(final yc world, final int dx, final int dy, final int dz) {
        boolean flag = true;
        flag &= (world.g(dx + 0, dy, dz + 0) == agi.h);
        flag &= (world.g(dx + 1, dy, dz + 0) == agi.h);
        flag &= (world.g(dx + 1, dy, dz + 1) == agi.h);
        flag &= (world.g(dx + 0, dy, dz + 1) == agi.h);
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
    
    public boolean isNatureBlock(final yc world, final int dx, final int dy, final int dz) {
        final agi mat = world.g(dx, dy, dz);
        return mat == agi.k || mat == agi.l || mat == agi.j;
    }
    
    public void a(final yc world, final int x, final int y, final int z, final int notUsed) {
        boolean good = true;
        if (world.a(x - 1, y, z) == this.cm) {
            good &= this.isGrassOrDirt(world, x + 1, y, z);
        }
        else {
            good = (world.a(x + 1, y, z) == this.cm && (good & this.isGrassOrDirt(world, x - 1, y, z)));
        }
        if (world.a(x, y, z - 1) == this.cm) {
            good &= this.isGrassOrDirt(world, x, y, z + 1);
        }
        else {
            good = (world.a(x, y, z + 1) == this.cm && (good & this.isGrassOrDirt(world, x, y, z - 1)));
        }
        if (!good) {
            world.e(x, y, z, amq.E.cm);
        }
    }
    
    protected boolean isGrassOrDirt(final yc world, final int dx, final int dy, final int dz) {
        return world.g(dx, dy, dz) == agi.b || world.g(dx, dy, dz) == agi.c;
    }
    
    public int a(final Random random) {
        return 0;
    }
    
    public int n() {
        return 1;
    }
    
    public void a(final yc world, final int i, final int j, final int k, final lq entity) {
        if (entity.o == null && entity.n == null && entity instanceof iq) {
            final iq playerMP = (iq)entity;
            if (playerMP.an > 0) {
                playerMP.an = 10;
            }
            else if (playerMP.aq != TwilightForestMod.dimensionID) {
                playerMP.a((jl)TFAchievementPage.twilightPortal);
                playerMP.a((jl)TFAchievementPage.twilightArrival);
                playerMP.b.ad().transferPlayerToDimension(playerMP, TwilightForestMod.dimensionID, (yq)new TFTeleporter(playerMP.b.a(TwilightForestMod.dimensionID)));
                playerMP.a(0);
                playerMP.a((jl)TFAchievementPage.twilightPortal);
                playerMP.a((jl)TFAchievementPage.twilightArrival);
            }
            else {
                playerMP.b.ad().transferPlayerToDimension(playerMP, 0, (yq)new TFTeleporter(playerMP.b.a(0)));
                playerMP.a(0);
            }
        }
    }
    
    public void a(final yc world, final int i, final int j, final int k, final Random random) {
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
            if (world.a(i - 1, j, k) == this.cm || world.a(i + 1, j, k) == this.cm) {
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
