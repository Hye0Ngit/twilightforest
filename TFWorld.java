// 
// Decompiled by Procyon v0.6-prerelease
// 

public class TFWorld extends fq
{
    public TFWorld(final fq world, final xk worldprovider) {
        super((xc)null, (String)null, (hr)null, (xk)null);
        this.A = this.p();
        this.e = this.c / 4 - 1;
    }
    
    public void setSpawnLocation() {
    }
    
    public bz o() {
        final bz twilightSpawn;
        final bz originalSpawn = twilightSpawn = new bz(this.C.c(), this.C.d(), this.C.e());
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
    
    public float getStarBrightness(final float f) {
        return 0.5f;
    }
}
