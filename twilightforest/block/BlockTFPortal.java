// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.block;

import twilightforest.TFTeleporter;
import twilightforest.TFAchievementPage;
import twilightforest.TwilightForestMod;
import java.util.Random;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTFPortal extends amm
{
    public BlockTFPortal(final int i) {
        super(i, "TFPortal", ahz.C, false);
        this.c(-1.0f);
        this.a(aou.l);
        this.a(0.75f);
    }
    
    public aqr b(final zv world, final int i, final int j, final int k) {
        return null;
    }
    
    public void a(final aae iblockaccess, final int i, final int j, final int k) {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.75f, 1.0f);
    }
    
    public boolean c() {
        return false;
    }
    
    public boolean b() {
        return false;
    }
    
    public lx a(final int side, final int meta) {
        return aou.bi.a(side, meta);
    }
    
    @SideOnly(Side.CLIENT)
    public void a(final ly par1IconRegister) {
    }
    
    public boolean tryToCreatePortal(final zv world, final int dx, final int dy, final int dz) {
        if (this.isGoodPortalPool(world, dx, dy, dz)) {
            world.c((mp)new qy(world, (double)dx, (double)dy, (double)dz));
            this.transmuteWaterToPortal(world, dx, dy, dz);
            return true;
        }
        return false;
    }
    
    public void transmuteWaterToPortal(final zv world, final int dx, final int dy, final int dz) {
        int px = dx;
        int pz = dz;
        if (world.g(px - 1, dy, pz) == ahz.h) {
            --px;
        }
        if (world.g(px, dy, pz - 1) == ahz.h) {
            --pz;
        }
        world.f(px + 0, dy, pz + 0, TFBlocks.portal.cz, 0, 2);
        world.f(px + 1, dy, pz + 0, TFBlocks.portal.cz, 0, 2);
        world.f(px + 1, dy, pz + 1, TFBlocks.portal.cz, 0, 2);
        world.f(px + 0, dy, pz + 1, TFBlocks.portal.cz, 0, 2);
        System.out.println("Transmuting water to portal");
    }
    
    public boolean isGoodPortalPool(final zv world, final int dx, final int dy, final int dz) {
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
    
    public boolean isGoodPortalPoolStrict(final zv world, final int dx, final int dy, final int dz) {
        boolean flag = true;
        flag &= (world.g(dx + 0, dy, dz + 0) == ahz.h);
        flag &= (world.g(dx + 1, dy, dz + 0) == ahz.h);
        flag &= (world.g(dx + 1, dy, dz + 1) == ahz.h);
        flag &= (world.g(dx + 0, dy, dz + 1) == ahz.h);
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
    
    public boolean isNatureBlock(final zv world, final int dx, final int dy, final int dz) {
        final ahz mat = world.g(dx, dy, dz);
        return mat == ahz.k || mat == ahz.l || mat == ahz.j;
    }
    
    public void a(final zv world, final int x, final int y, final int z, final int notUsed) {
        boolean good = true;
        if (world.a(x - 1, y, z) == this.cz) {
            good &= this.isGrassOrDirt(world, x + 1, y, z);
        }
        else {
            good = (world.a(x + 1, y, z) == this.cz && (good & this.isGrassOrDirt(world, x - 1, y, z)));
        }
        if (world.a(x, y, z - 1) == this.cz) {
            good &= this.isGrassOrDirt(world, x, y, z + 1);
        }
        else {
            good = (world.a(x, y, z + 1) == this.cz && (good & this.isGrassOrDirt(world, x, y, z - 1)));
        }
        if (!good) {
            world.f(x, y, z, aou.F.cz, 0, 2);
        }
    }
    
    protected boolean isGrassOrDirt(final zv world, final int dx, final int dy, final int dz) {
        return world.g(dx, dy, dz) == ahz.b || world.g(dx, dy, dz) == ahz.c;
    }
    
    public int a(final Random random) {
        return 0;
    }
    
    public int n() {
        return 1;
    }
    
    public void a(final zv world, final int i, final int j, final int k, final mp entity) {
        if (entity.o == null && entity.n == null && entity instanceof jc) {
            final jc playerMP = (jc)entity;
            if (playerMP.ao > 0) {
                playerMP.ao = 10;
            }
            else if (playerMP.ar != TwilightForestMod.dimensionID) {
                playerMP.a((ka)TFAchievementPage.twilightPortal);
                playerMP.a((ka)TFAchievementPage.twilightArrival);
                playerMP.b.ad().transferPlayerToDimension(playerMP, TwilightForestMod.dimensionID, (aai)new TFTeleporter(playerMP.b.a(TwilightForestMod.dimensionID)));
                playerMP.a(0);
                playerMP.a((ka)TFAchievementPage.twilightPortal);
                playerMP.a((ka)TFAchievementPage.twilightArrival);
            }
            else {
                playerMP.b.ad().transferPlayerToDimension(playerMP, 0, (aai)new TFTeleporter(playerMP.b.a(0)));
                playerMP.a(0);
            }
        }
    }
    
    public void b(final zv world, final int i, final int j, final int k, final Random random) {
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
            if (world.a(i - 1, j, k) == this.cz || world.a(i + 1, j, k) == this.cz) {
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
