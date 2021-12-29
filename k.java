// 
// Decompiled by Procyon v0.6-prerelease
// 

public abstract class k
{
    public ry a;
    public vh b;
    public boolean c;
    public boolean d;
    public boolean e;
    public float[] f;
    public int g;
    private float[] h;
    
    public k() {
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = new float[16];
        this.g = 0;
        this.h = new float[4];
    }
    
    public final void a(final ry world) {
        this.a = world;
        this.b();
        this.a();
    }
    
    protected void a() {
        final float f = 0.0f;
        for (int i = 0; i <= 15; ++i) {
            final float f2 = 1.0f - i / 15.0f;
            this.f[i] = (1.0f - f2) / (f2 * 3.0f + 1.0f) * (1.0f - f) + f;
        }
    }
    
    protected void b() {
        this.b = new vh(this.a);
    }
    
    public ej c() {
        return (ej)new xj(this.a, this.a.t(), this.a.z().r());
    }
    
    public boolean a(final int i, final int j) {
        final int k = this.a.a(i, j);
        return k == yy.u.bM;
    }
    
    public float a(final long l, final float f) {
        final int i = (int)(l % 24000L);
        float f2 = (i + f) / 24000.0f - 0.25f;
        if (f2 < 0.0f) {
            ++f2;
        }
        if (f2 > 1.0f) {
            --f2;
        }
        final float f3 = f2;
        f2 = 1.0f - (float)((Math.cos(f2 * 3.141592653589793) + 1.0) / 2.0);
        f2 = f3 + (f2 - f3) / 3.0f;
        return f2;
    }
    
    public int b(final long l, final float f) {
        return (int)(l / 24000L) % 8;
    }
    
    public float[] a(final float f, final float f1) {
        final float f2 = 0.4f;
        final float f3 = me.b(f * 3.141593f * 2.0f) - 0.0f;
        final float f4 = -0.0f;
        if (f3 >= f4 - f2 && f3 <= f4 + f2) {
            final float f5 = (f3 - f4) / f2 * 0.5f + 0.5f;
            float f6 = 1.0f - (1.0f - me.a(f5 * 3.141593f)) * 0.99f;
            f6 *= f6;
            this.h[0] = f5 * 0.3f + 0.7f;
            this.h[1] = f5 * f5 * 0.7f + 0.2f;
            this.h[2] = f5 * f5 * 0.0f + 0.2f;
            this.h[3] = f6;
            return this.h;
        }
        return null;
    }
    
    public fb b(final float f, final float f1) {
        float f2 = me.b(f * 3.141593f * 2.0f) * 2.0f + 0.5f;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        float f3 = 0.7529412f;
        float f4 = 0.8470588f;
        float f5 = 1.0f;
        f3 *= f2 * 0.94f + 0.06f;
        f4 *= f2 * 0.94f + 0.06f;
        f5 *= f2 * 0.91f + 0.09f;
        return fb.b((double)f3, (double)f4, (double)f5);
    }
    
    public boolean d() {
        return true;
    }
    
    public static k a(final int i) {
        if (i == 7) {
            return new WorldProviderTwilightForest();
        }
        if (i == -1) {
            return (k)new aau();
        }
        if (i == 0) {
            return (k)new ix();
        }
        if (i == 1) {
            return (k)new ol();
        }
        return null;
    }
    
    public float e() {
        return (float)this.a.c;
    }
    
    public boolean f() {
        return true;
    }
    
    public dh g() {
        return null;
    }
}
