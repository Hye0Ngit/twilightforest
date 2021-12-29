// 
// Decompiled by Procyon v0.6-prerelease
// 

public abstract class xk
{
    public fq a;
    public du b;
    public yc c;
    public boolean d;
    public boolean e;
    public boolean f;
    public float[] g;
    public int h;
    private float[] i;
    
    public xk() {
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = new float[16];
        this.h = 0;
        this.i = new float[4];
    }
    
    public final void a(final fq world) {
        this.a = world;
        this.b = world.r().q();
        this.a();
        this.f();
    }
    
    protected void f() {
        final float f = 0.0f;
        for (int i = 0; i <= 15; ++i) {
            final float f2 = 1.0f - i / 15.0f;
            this.g[i] = (1.0f - f2) / (f2 * 3.0f + 1.0f) * (1.0f - f) + f;
        }
    }
    
    protected void a() {
        if (this.a.r().q() == du.b) {
            this.c = (yc)new hu(km.c, 0.5f, 0.5f);
        }
        else {
            this.c = new yc(this.a);
        }
    }
    
    public cr b() {
        if (this.b == du.b) {
            return (cr)new ha(this.a, this.a.m(), this.a.r().o());
        }
        return (cr)new ym(this.a, this.a.m(), this.a.r().o());
    }
    
    public boolean a(final int i, final int j) {
        final int k = this.a.a(i, j);
        return k == ud.w.bO;
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
    
    public boolean c() {
        return true;
    }
    
    public static xk a(final int i) {
        if (i == 7) {
            return new WorldProviderTwilightForest();
        }
        if (i == -1) {
            return (xk)new wg();
        }
        if (i == 0) {
            return (xk)new qw();
        }
        if (i == 1) {
            return (xk)new lm();
        }
        return null;
    }
    
    public bz d() {
        return null;
    }
    
    public int e() {
        if (this.b == du.b) {
            return 4;
        }
        return this.a.c / 2;
    }
}
