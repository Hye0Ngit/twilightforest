import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFPortal extends aaf
{
    public BlockTFPortal(final int i, final int j) {
        super(i, j, p.A, false);
    }
    
    public c b(final ry world, final int i, final int j, final int k) {
        return null;
    }
    
    public void b(final kq iblockaccess, final int i, final int j, final int k) {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.75f, 1.0f);
    }
    
    public boolean a() {
        return false;
    }
    
    public boolean b() {
        return false;
    }
    
    public boolean tryToCreatePortal(final ry world, final int dx, final int dy, final int dz) {
        if (this.isGoodPortalPool(world, dx, dy, dz)) {
            world.e((ia)new su(world, (double)dx, (double)dy, (double)dz));
            this.transmuteWaterToPortal(world, dx, dy, dz);
            return true;
        }
        return false;
    }
    
    public void transmuteWaterToPortal(final ry world, final int dx, final int dy, final int dz) {
        int px = dx;
        int pz = dz;
        if (world.e(px - 1, dy, pz) == p.g) {
            --px;
        }
        if (world.e(px, dy, pz - 1) == p.g) {
            --pz;
        }
        world.t = true;
        world.g(px + 0, dy, pz + 0, TFBlocks.portal.bM);
        world.g(px + 1, dy, pz + 0, TFBlocks.portal.bM);
        world.g(px + 1, dy, pz + 1, TFBlocks.portal.bM);
        world.g(px + 0, dy, pz + 1, TFBlocks.portal.bM);
        world.t = false;
    }
    
    public boolean isGoodPortalPool(final ry world, final int dx, final int dy, final int dz) {
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
    
    public boolean isGoodPortalPoolStrict(final ry world, final int dx, final int dy, final int dz) {
        boolean flag = true;
        flag &= (world.e(dx + 0, dy, dz + 0) == p.g);
        flag &= (world.e(dx + 1, dy, dz + 0) == p.g);
        flag &= (world.e(dx + 1, dy, dz + 1) == p.g);
        flag &= (world.e(dx + 0, dy, dz + 1) == p.g);
        flag &= (world.e(dx - 1, dy, dz - 1) == p.b);
        flag &= (world.e(dx - 1, dy, dz + 0) == p.b);
        flag &= (world.e(dx - 1, dy, dz + 1) == p.b);
        flag &= (world.e(dx - 1, dy, dz + 2) == p.b);
        flag &= (world.e(dx + 0, dy, dz - 1) == p.b);
        flag &= (world.e(dx + 1, dy, dz - 1) == p.b);
        flag &= (world.e(dx + 0, dy, dz + 2) == p.b);
        flag &= (world.e(dx + 1, dy, dz + 2) == p.b);
        flag &= (world.e(dx + 2, dy, dz - 1) == p.b);
        flag &= (world.e(dx + 2, dy, dz + 0) == p.b);
        flag &= (world.e(dx + 2, dy, dz + 1) == p.b);
        flag &= (world.e(dx + 2, dy, dz + 2) == p.b);
        flag &= world.e(dx + 0, dy - 1, dz + 0).b();
        flag &= world.e(dx + 1, dy - 1, dz + 0).b();
        flag &= world.e(dx + 1, dy - 1, dz + 1).b();
        flag &= world.e(dx + 0, dy - 1, dz + 1).b();
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
    
    public boolean isNatureBlock(final ry world, final int dx, final int dy, final int dz) {
        final int[] goodList = { yy.af.bM, yy.ag.bM, yy.X.bM, yy.ae.bM, yy.ad.bM };
        final int whatsThere = world.a(dx, dy, dz);
        for (int i = 0; i < goodList.length; ++i) {
            if (whatsThere == goodList[i]) {
                return true;
            }
        }
        return false;
    }
    
    public void a(final ry world, final int x, final int y, final int z, final int notUsed) {
        boolean good = true;
        if (world.a(x - 1, y, z) == this.bM) {
            good &= this.isGrassOrDirt(world, x + 1, y, z);
        }
        else {
            good = (world.a(x + 1, y, z) == this.bM && (good & this.isGrassOrDirt(world, x - 1, y, z)));
        }
        if (world.a(x, y, z - 1) == this.bM) {
            good &= this.isGrassOrDirt(world, x, y, z + 1);
        }
        else {
            good = (world.a(x, y, z + 1) == this.bM && (good & this.isGrassOrDirt(world, x, y, z - 1)));
        }
        if (!good) {
            world.g(x, y, z, yy.B.bM);
        }
    }
    
    protected boolean isGrassOrDirt(final ry world, final int dx, final int dy, final int dz) {
        return world.e(dx, dy, dz) == p.b || world.e(dx, dy, dz) == p.c;
    }
    
    public int a(final Random random) {
        return 0;
    }
    
    public int h() {
        return 1;
    }
    
    public void a(final ry world, final int i, final int j, final int k, final ia entity) {
        if (entity.n == null && entity.m == null) {
            entity.S();
        }
    }
    
    public void b(final ry world, final int i, final int j, final int k, final Random random) {
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
            if (world.a(i - 1, j, k) == this.bM || world.a(i + 1, j, k) == this.bM) {
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
