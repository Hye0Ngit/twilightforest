// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFWorld extends ge
{
    public static int SEALEVEL;
    public static int WORLDHEIGHT;
    
    public TFWorld(final zb par1iSaveHandler, final String par2Str, final ip par3WorldSettings, final zl par4WorldProvider) {
        super(par1iSaveHandler, par2Str, par3WorldSettings, par4WorldProvider);
    }
    
    public cf p() {
        final cf twilightSpawn;
        final cf originalSpawn = twilightSpawn = new cf(this.x.c(), this.x.d(), this.x.e());
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
        f2 *= (float)(1.0 - this.d(f) * 5.0f / 16.0);
        f2 *= (float)(1.0 - this.c(f) * 5.0f / 16.0);
        f2 = 1.0f - f2;
        return (int)(f2 * 11.0f);
    }
    
    public float func_35464_b(final float f) {
        float f2 = 0.2f;
        f2 *= (float)(1.0 - this.d(f) * 5.0f / 16.0);
        f2 *= (float)(1.0 - this.c(f) * 5.0f / 16.0);
        return f2 * 0.8f + 0.2f;
    }
    
    public float getStarBrightness(final float f) {
        return 0.5f;
    }
    
    static {
        TFWorld.SEALEVEL = 32;
        TFWorld.WORLDHEIGHT = 128;
    }
}
