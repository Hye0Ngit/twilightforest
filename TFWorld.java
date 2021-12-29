import java.io.File;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFWorld extends ry
{
    public TFWorld(final ry world, final k worldprovider) {
        super(world, worldprovider);
        this.A = this.d();
    }
    
    protected ej d() {
        final File saveDirectory = ((e)this.B).a();
        d ichunkloader = null;
        if (this.B instanceof ar) {
            final File file1 = new File(saveDirectory, "DIM7");
            file1.mkdirs();
            ichunkloader = (d)new tn(file1);
        }
        else if (this.B instanceof e) {
            final File file1 = new File(saveDirectory, "DIM7");
            file1.mkdirs();
            ichunkloader = (d)new gy(file1, true);
        }
        return (ej)new jz((ry)this, ichunkloader, this.y.c());
    }
    
    public int a(final int i, final int j) {
        int k;
        for (k = 30; !this.h(i, k + 1, j); ++k) {}
        return this.a(i, k, j);
    }
    
    public void e() {
    }
    
    public int a(final float f) {
        float f2 = 0.5f;
        f2 *= (float)(1.0 - this.j(f) * 5.0f / 16.0);
        f2 *= (float)(1.0 - this.i(f) * 5.0f / 16.0);
        f2 = 1.0f - f2;
        return (int)(f2 * 11.0f);
    }
    
    public float b(final float f) {
        float f2 = 0.2f;
        f2 *= (float)(1.0 - this.j(f) * 5.0f / 16.0);
        f2 *= (float)(1.0 - this.i(f) * 5.0f / 16.0);
        return f2 * 0.8f + 0.2f;
    }
    
    public fb a(final ia entity, final float f) {
        final float f2 = 0.25f;
        float f3 = me.b(f2 * 3.141593f * 2.0f) * 2.0f + 0.5f;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        final int i = me.c(entity.s);
        final int j = me.c(entity.u);
        final int k = this.a().a(i, j).a(0.5f);
        float f4 = (k >> 16 & 0xFF) / 255.0f;
        float f5 = (k >> 8 & 0xFF) / 255.0f;
        float f6 = (k & 0xFF) / 255.0f;
        f4 *= f3;
        f5 *= f3;
        f6 *= f3;
        final float f7 = this.j(f);
        if (f7 > 0.0f) {
            final float f8 = (f4 * 0.3f + f5 * 0.59f + f6 * 0.11f) * 0.6f;
            final float f9 = 1.0f - f7 * 0.75f;
            f4 = f4 * f9 + f8 * (1.0f - f9);
            f5 = f5 * f9 + f8 * (1.0f - f9);
            f6 = f6 * f9 + f8 * (1.0f - f9);
        }
        final float f10 = this.i(f);
        if (f10 > 0.0f) {
            final float f11 = (f4 * 0.3f + f5 * 0.59f + f6 * 0.11f) * 0.2f;
            final float f12 = 1.0f - f10 * 0.75f;
            f4 = f4 * f12 + f11 * (1.0f - f12);
            f5 = f5 * f12 + f11 * (1.0f - f12);
            f6 = f6 * f12 + f11 * (1.0f - f12);
        }
        if (this.s > 0) {
            float f13 = this.s - f;
            if (f13 > 1.0f) {
                f13 = 1.0f;
            }
            f13 *= 0.45f;
            f4 = f4 * (1.0f - f13) + 0.8f * f13;
            f5 = f5 * (1.0f - f13) + 0.8f * f13;
            f6 = f6 * (1.0f - f13) + 1.0f * f13;
        }
        return fb.b((double)f4, (double)f5, (double)f6);
    }
    
    public float h(final float f) {
        return 0.5f;
    }
}
