import java.util.Random;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class BlockTFPortal extends ld
{
    public BlockTFPortal(final int i, final int j) {
        super(i, j, na.B, false);
    }
    
    public fp e(final ge world, final int i, final int j, final int k) {
        return null;
    }
    
    public void a(final zy iblockaccess, final int i, final int j, final int k) {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.75f, 1.0f);
    }
    
    public boolean a() {
        return false;
    }
    
    public boolean b() {
        return false;
    }
    
    public boolean tryToCreatePortal(final ge world, final int dx, final int dy, final int dz) {
        if (this.isGoodPortalPool(world, dx, dy, dz)) {
            world.a((tv)new d(world, (double)dx, (double)dy, (double)dz));
            this.transmuteWaterToPortal(world, dx, dy, dz);
            return true;
        }
        return false;
    }
    
    public void transmuteWaterToPortal(final ge world, final int dx, final int dy, final int dz) {
        int px = dx;
        int pz = dz;
        if (world.d(px - 1, dy, pz) == na.g) {
            --px;
        }
        if (world.d(px, dy, pz - 1) == na.g) {
            --pz;
        }
        world.o = true;
        world.e(px + 0, dy, pz + 0, TFBlocks.portal.bO);
        world.e(px + 1, dy, pz + 0, TFBlocks.portal.bO);
        world.e(px + 1, dy, pz + 1, TFBlocks.portal.bO);
        world.e(px + 0, dy, pz + 1, TFBlocks.portal.bO);
        world.o = false;
    }
    
    public boolean isGoodPortalPool(final ge world, final int dx, final int dy, final int dz) {
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
    
    public boolean isGoodPortalPoolStrict(final ge world, final int dx, final int dy, final int dz) {
        boolean flag = true;
        flag &= (world.d(dx + 0, dy, dz + 0) == na.g);
        flag &= (world.d(dx + 1, dy, dz + 0) == na.g);
        flag &= (world.d(dx + 1, dy, dz + 1) == na.g);
        flag &= (world.d(dx + 0, dy, dz + 1) == na.g);
        flag &= (world.d(dx - 1, dy, dz - 1) == na.b);
        flag &= (world.d(dx - 1, dy, dz + 0) == na.b);
        flag &= (world.d(dx - 1, dy, dz + 1) == na.b);
        flag &= (world.d(dx - 1, dy, dz + 2) == na.b);
        flag &= (world.d(dx + 0, dy, dz - 1) == na.b);
        flag &= (world.d(dx + 1, dy, dz - 1) == na.b);
        flag &= (world.d(dx + 0, dy, dz + 2) == na.b);
        flag &= (world.d(dx + 1, dy, dz + 2) == na.b);
        flag &= (world.d(dx + 2, dy, dz - 1) == na.b);
        flag &= (world.d(dx + 2, dy, dz + 0) == na.b);
        flag &= (world.d(dx + 2, dy, dz + 1) == na.b);
        flag &= (world.d(dx + 2, dy, dz + 2) == na.b);
        flag &= world.d(dx + 0, dy - 1, dz + 0).a();
        flag &= world.d(dx + 1, dy - 1, dz + 0).a();
        flag &= world.d(dx + 1, dy - 1, dz + 1).a();
        flag &= world.d(dx + 0, dy - 1, dz + 1).a();
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
    
    public boolean isNatureBlock(final ge world, final int dx, final int dy, final int dz) {
        final int[] goodList = { vz.af.bO, vz.ag.bO, vz.X.bO, vz.ae.bO, vz.ad.bO };
        final int whatsThere = world.a(dx, dy, dz);
        for (int i = 0; i < goodList.length; ++i) {
            if (whatsThere == goodList[i]) {
                return true;
            }
        }
        return false;
    }
    
    public void a(final ge world, final int x, final int y, final int z, final int notUsed) {
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
            world.e(x, y, z, vz.B.bO);
        }
    }
    
    protected boolean isGrassOrDirt(final ge world, final int dx, final int dy, final int dz) {
        return world.d(dx, dy, dz) == na.b || world.d(dx, dy, dz) == na.c;
    }
    
    public int a(final Random random) {
        return 0;
    }
    
    public int getRenderBlockPass() {
        return 1;
    }
    
    public void a(final ge world, final int i, final int j, final int k, final tv entity) {
        if (entity.bh == null && entity.bg == null) {
            entity.ad();
        }
    }
    
    public void randomDisplayTick(final ge world, final int i, final int j, final int k, final Random random) {
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
