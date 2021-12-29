// 
// Decompiled by Procyon v0.6-prerelease
// 

public abstract class BlockTFCritter extends ags
{
    protected BlockTFCritter(final int index, final aci material) {
        super(index, material);
    }
    
    protected BlockTFCritter(final int index, final int sprite, final aci material) {
        super(index, sprite, material);
    }
    
    public void b_(final wz world, final int i, final int j, final int k) {
        super.b_(world, i, j, k);
    }
    
    public int e() {
        return 50;
    }
    
    public ph a(final wz world, final int i, final int j, final int k, final bm vec3d, final bm vec3d1) {
        final int l = world.e(i, j, k) & 0x7;
        final float f = 0.15f;
        if (l == 1) {
            this.a(0.0f, 0.2f, 0.5f - f, f * 2.0f, 0.8f, 0.5f + f);
        }
        else if (l == 2) {
            this.a(1.0f - f * 2.0f, 0.2f, 0.5f - f, 1.0f, 0.8f, 0.5f + f);
        }
        else if (l == 3) {
            this.a(0.5f - f, 0.2f, 0.0f, 0.5f + f, 0.8f, f * 2.0f);
        }
        else if (l == 4) {
            this.a(0.5f - f, 0.2f, 1.0f - f * 2.0f, 0.5f + f, 0.8f, 1.0f);
        }
        else if (l == 5) {
            this.a(0.5f - f, 0.0f, 0.2f, 0.5f + f, f * 2.0f, 0.8f);
        }
        else if (l == 6) {
            this.a(0.5f - f, 1.0f - f * 2.0f, 0.2f, 0.5f + f, 1.0f, 0.8f);
        }
        else {
            final float f2 = 0.1f;
            this.a(0.5f - f2, 0.0f, 0.5f - f2, 0.5f + f2, 0.6f, 0.5f + f2);
        }
        return super.a(world, i, j, k, vec3d, vec3d1);
    }
    
    public wq c(final wz world, final int i, final int j, final int k) {
        return null;
    }
    
    public boolean a() {
        return false;
    }
    
    public boolean b() {
        return false;
    }
    
    public boolean e(final wz world, final int i, final int j, final int k) {
        return this.canPlaceAt(world, i - 1, j, k) || this.canPlaceAt(world, i + 1, j, k) || this.canPlaceAt(world, i, j, k - 1) || this.canPlaceAt(world, i, j, k + 1) || this.canPlaceAt(world, i, j - 1, k) || this.canPlaceAt(world, i, j + 1, k);
    }
    
    public void c(final wz world, final int i, final int j, final int k, final int l) {
        int meta = world.e(i, j, k);
        if (l == 1 && this.canPlaceAt(world, i, j - 1, k)) {
            meta = 5;
        }
        if (l == 0 && this.canPlaceAt(world, i, j + 1, k)) {
            meta = 6;
        }
        if (l == 2 && this.canPlaceAt(world, i, j, k + 1)) {
            meta = 4;
        }
        if (l == 3 && this.canPlaceAt(world, i, j, k - 1)) {
            meta = 3;
        }
        if (l == 4 && this.canPlaceAt(world, i + 1, j, k)) {
            meta = 2;
        }
        if (l == 5 && this.canPlaceAt(world, i - 1, j, k)) {
            meta = 1;
        }
        world.f(i, j, k, meta);
    }
    
    public void a(final wz world, final int i, final int j, final int k) {
        super.a(world, i, j, k);
        if (this.canPlaceAt(world, i - 1, j, k)) {
            world.f(i, j, k, 1);
        }
        else if (this.canPlaceAt(world, i + 1, j, k)) {
            world.f(i, j, k, 2);
        }
        else if (this.canPlaceAt(world, i, j, k - 1)) {
            world.f(i, j, k, 3);
        }
        else if (this.canPlaceAt(world, i, j, k + 1)) {
            world.f(i, j, k, 4);
        }
        else if (this.canPlaceAt(world, i, j - 1, k)) {
            world.f(i, j, k, 5);
        }
        this.dropCritterIfCantStay(world, i, j, k);
    }
    
    private boolean dropCritterIfCantStay(final wz world, final int i, final int j, final int k) {
        if (!this.e(world, i, j, k)) {
            this.a(world, i, j, k, world.e(i, j, k), 0);
            world.g(i, j, k, 0);
            return false;
        }
        return true;
    }
    
    public void a(final wz world, final int i, final int j, final int k, final int l) {
        if (this.dropCritterIfCantStay(world, i, j, k)) {
            final int i2 = world.e(i, j, k);
            boolean flag = false;
            if (!world.h(i - 1, j, k) && i2 == 1) {
                flag = true;
            }
            if (!world.h(i + 1, j, k) && i2 == 2) {
                flag = true;
            }
            if (!world.h(i, j, k - 1) && i2 == 3) {
                flag = true;
            }
            if (!world.h(i, j, k + 1) && i2 == 4) {
                flag = true;
            }
            if (!this.canPlaceAt(world, i, j - 1, k) && i2 == 5) {
                flag = true;
            }
            if (flag) {
                this.a(world, i, j, k, world.e(i, j, k), 0);
                world.g(i, j, k, 0);
            }
        }
    }
    
    protected abstract boolean canPlaceAt(final wz p0, final int p1, final int p2, final int p3);
}
