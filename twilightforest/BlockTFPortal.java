// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class BlockTFPortal extends akf
{
    public BlockTFPortal(final int i, final int j) {
        super(i, j, agb.C, false);
        this.c(-1.0f);
        this.a(amj.j);
        this.a(0.75f);
    }
    
    public anw e(final xv world, final int i, final int j, final int k) {
        return null;
    }
    
    public void a(final yf iblockaccess, final int i, final int j, final int k) {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.75f, 1.0f);
    }
    
    public boolean c() {
        return false;
    }
    
    public boolean b() {
        return false;
    }
    
    public boolean tryToCreatePortal(final xv world, final int dx, final int dy, final int dz) {
        if (this.isGoodPortalPool(world, dx, dy, dz)) {
            world.c((lq)new pu(world, (double)dx, (double)dy, (double)dz));
            this.transmuteWaterToPortal(world, dx, dy, dz);
            return true;
        }
        return false;
    }
    
    public void transmuteWaterToPortal(final xv world, final int dx, final int dy, final int dz) {
        int px = dx;
        int pz = dz;
        if (world.g(px - 1, dy, pz) == agb.h) {
            --px;
        }
        if (world.g(px, dy, pz - 1) == agb.h) {
            --pz;
        }
        world.s = true;
        world.e(px + 0, dy, pz + 0, TFBlocks.portal.cm);
        world.e(px + 1, dy, pz + 0, TFBlocks.portal.cm);
        world.e(px + 1, dy, pz + 1, TFBlocks.portal.cm);
        world.e(px + 0, dy, pz + 1, TFBlocks.portal.cm);
        world.s = false;
    }
    
    public boolean isGoodPortalPool(final xv world, final int dx, final int dy, final int dz) {
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
    
    public boolean isGoodPortalPoolStrict(final xv world, final int dx, final int dy, final int dz) {
        boolean flag = true;
        flag &= (world.g(dx + 0, dy, dz + 0) == agb.h);
        flag &= (world.g(dx + 1, dy, dz + 0) == agb.h);
        flag &= (world.g(dx + 1, dy, dz + 1) == agb.h);
        flag &= (world.g(dx + 0, dy, dz + 1) == agb.h);
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
    
    public boolean isNatureBlock(final xv world, final int dx, final int dy, final int dz) {
        final agb mat = world.g(dx, dy, dz);
        return mat == agb.k || mat == agb.l || mat == agb.j;
    }
    
    public void a(final xv world, final int x, final int y, final int z, final int notUsed) {
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
            world.e(x, y, z, amj.E.cm);
        }
    }
    
    protected boolean isGrassOrDirt(final xv world, final int dx, final int dy, final int dz) {
        return world.g(dx, dy, dz) == agb.b || world.g(dx, dy, dz) == agb.c;
    }
    
    public int a(final Random random) {
        return 0;
    }
    
    public int n() {
        return 1;
    }
    
    public void a(final xv world, final int i, final int j, final int k, final lq entity) {
        if (entity.o == null && entity.n == null && entity instanceof iq) {
            final iq playerMP = (iq)entity;
            if (playerMP.an > 0) {
                playerMP.an = 10;
            }
            else if (playerMP.ap != TwilightForestMod.dimensionID) {
                playerMP.a((jl)TFAchievementPage.twilightPortal);
                playerMP.a((jl)TFAchievementPage.twilightArrival);
                playerMP.b.ad().transferPlayerToDimension(playerMP, TwilightForestMod.dimensionID, (yj)new TFTeleporter(playerMP.b.a(TwilightForestMod.dimensionID)));
                playerMP.a(0);
                playerMP.a((jl)TFAchievementPage.twilightPortal);
                playerMP.a((jl)TFAchievementPage.twilightArrival);
            }
            else {
                playerMP.b.ad().transferPlayerToDimension(playerMP, 0, (yj)new TFTeleporter(playerMP.b.a(0)));
                playerMP.a(0);
            }
        }
    }
    
    public void a(final xv world, final int i, final int j, final int k, final Random random) {
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
