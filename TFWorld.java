// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFWorld extends wz
{
    public static int SEALEVEL;
    public static int WORLDHEIGHT;
    
    public TFWorld(final wz world, final akv worldprovider) {
        super(world, worldprovider);
        this.v = this.z();
        TFWorld.SEALEVEL = TFWorld.WORLDHEIGHT / 4;
    }
    
    public void e() {
    }
    
    public ud x() {
        final ud twilightSpawn;
        final ud originalSpawn = twilightSpawn = new ud(this.x.c(), this.x.d(), this.x.e());
        if (twilightSpawn.equals((Object)originalSpawn) && this.a(twilightSpawn.a, twilightSpawn.b, twilightSpawn.c) == 0) {
            for (int py = twilightSpawn.b; py > 4; --py) {
                if (this.a(twilightSpawn.a, py, twilightSpawn.c) != 0) {
                    twilightSpawn.b = py;
                    break;
                }
            }
        }
        return twilightSpawn;
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
    
    public bm a(final nk entity, final float f) {
        final float f2 = 0.25f;
        float f3 = gh.b(f2 * 3.141593f * 2.0f) * 2.0f + 0.5f;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        final int i = gh.c(entity.o);
        final int j = gh.c(entity.q);
        final int k = this.i().a(i, j).a(0.5f);
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
        if (this.n > 0) {
            float f13 = this.n - f;
            if (f13 > 1.0f) {
                f13 = 1.0f;
            }
            f13 *= 0.45f;
            f4 = f4 * (1.0f - f13) + 0.8f * f13;
            f5 = f5 * (1.0f - f13) + 0.8f * f13;
            f6 = f6 * (1.0f - f13) + 1.0f * f13;
        }
        return bm.b((double)f4, (double)f5, (double)f6);
    }
    
    public float h(final float f) {
        return 0.5f;
    }
    
    static {
        TFWorld.SEALEVEL = 32;
        TFWorld.WORLDHEIGHT = 128;
    }
}
