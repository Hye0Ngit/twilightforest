// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Random;

public class BlockTFPortal extends gz
{
    public BlockTFPortal(final int i, final int j) {
        super(i, j, acn.B, false);
        this.c(-1.0f);
        this.a(pb.j);
        this.a(0.75f);
    }
    
    public wu c(final xd world, final int i, final int j, final int k) {
        return null;
    }
    
    public void a(final ali iblockaccess, final int i, final int j, final int k) {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.75f, 1.0f);
    }
    
    public boolean a() {
        return false;
    }
    
    public boolean b() {
        return false;
    }
    
    public boolean tryToCreatePortal(final xd world, final int dx, final int dy, final int dz) {
        if (this.isGoodPortalPool(world, dx, dy, dz)) {
            world.e((nn)new d(world, (double)dx, (double)dy, (double)dz));
            this.transmuteWaterToPortal(world, dx, dy, dz);
            return true;
        }
        return false;
    }
    
    public void transmuteWaterToPortal(final xd world, final int dx, final int dy, final int dz) {
        int px = dx;
        int pz = dz;
        if (world.f(px - 1, dy, pz) == acn.g) {
            --px;
        }
        if (world.f(px, dy, pz - 1) == acn.g) {
            --pz;
        }
        world.o = true;
        world.g(px + 0, dy, pz + 0, TFBlocks.portal.bO);
        world.g(px + 1, dy, pz + 0, TFBlocks.portal.bO);
        world.g(px + 1, dy, pz + 1, TFBlocks.portal.bO);
        world.g(px + 0, dy, pz + 1, TFBlocks.portal.bO);
        world.o = false;
    }
    
    public boolean isGoodPortalPool(final xd world, final int dx, final int dy, final int dz) {
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
    
    public boolean isGoodPortalPoolStrict(final xd world, final int dx, final int dy, final int dz) {
        boolean flag = true;
        flag &= (world.f(dx + 0, dy, dz + 0) == acn.g);
        flag &= (world.f(dx + 1, dy, dz + 0) == acn.g);
        flag &= (world.f(dx + 1, dy, dz + 1) == acn.g);
        flag &= (world.f(dx + 0, dy, dz + 1) == acn.g);
        flag &= (world.f(dx - 1, dy, dz - 1) == acn.b);
        flag &= (world.f(dx - 1, dy, dz + 0) == acn.b);
        flag &= (world.f(dx - 1, dy, dz + 1) == acn.b);
        flag &= (world.f(dx - 1, dy, dz + 2) == acn.b);
        flag &= (world.f(dx + 0, dy, dz - 1) == acn.b);
        flag &= (world.f(dx + 1, dy, dz - 1) == acn.b);
        flag &= (world.f(dx + 0, dy, dz + 2) == acn.b);
        flag &= (world.f(dx + 1, dy, dz + 2) == acn.b);
        flag &= (world.f(dx + 2, dy, dz - 1) == acn.b);
        flag &= (world.f(dx + 2, dy, dz + 0) == acn.b);
        flag &= (world.f(dx + 2, dy, dz + 1) == acn.b);
        flag &= (world.f(dx + 2, dy, dz + 2) == acn.b);
        flag &= world.f(dx + 0, dy - 1, dz + 0).a();
        flag &= world.f(dx + 1, dy - 1, dz + 0).a();
        flag &= world.f(dx + 1, dy - 1, dz + 1).a();
        flag &= world.f(dx + 0, dy - 1, dz + 1).a();
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
    
    public boolean isNatureBlock(final xd world, final int dx, final int dy, final int dz) {
        final int[] goodList = { pb.af.bO, pb.ag.bO, pb.X.bO, pb.ae.bO, pb.ad.bO };
        final int whatsThere = world.a(dx, dy, dz);
        for (int i = 0; i < goodList.length; ++i) {
            if (whatsThere == goodList[i]) {
                return true;
            }
        }
        return false;
    }
    
    public void a(final xd world, final int x, final int y, final int z, final int notUsed) {
        boolean good = true;
        if (world.a(x - 1, y, z) == this.bO) {
            good &= this.isGrassOrDirt(world, x + 1, y, z);
        }
        else {
            good = (world.a(x + 1, y, z) == this.bO && (good & this.isGrassOrDirt(world, x - 1, y, z)));
        }
        if (world.a(x, y, z - 1) == this.bO) {
            good &= this.isGrassOrDirt(world, x, y, z + 1);
        }
        else {
            good = (world.a(x, y, z + 1) == this.bO && (good & this.isGrassOrDirt(world, x, y, z - 1)));
        }
        if (!good) {
            world.g(x, y, z, pb.B.bO);
        }
    }
    
    protected boolean isGrassOrDirt(final xd world, final int dx, final int dy, final int dz) {
        return world.f(dx, dy, dz) == acn.b || world.f(dx, dy, dz) == acn.c;
    }
    
    public int a(final Random random) {
        return 0;
    }
    
    public int c() {
        return 1;
    }
    
    public void a(final xd world, final int i, final int j, final int k, final nn entity) {
        if (entity.j == null && entity.i == null) {
            entity.R();
        }
    }
    
    public void b(final xd world, final int i, final int j, final int k, final Random random) {
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
            if (world.a(i - 1, j, k) == this.bO || world.a(i + 1, j, k) == this.bO) {
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
