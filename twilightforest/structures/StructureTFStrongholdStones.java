// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.structures;

import java.util.Random;

public class StructureTFStrongholdStones extends air
{
    public void a(final Random par1Random, final int par2, final int par3, final int par4, final boolean par5) {
        if (!par5) {
            this.a = 0;
            this.b = 0;
        }
        else {
            this.a = aqw.br.cF;
            final float var6 = par1Random.nextFloat();
            if (var6 < 0.2f) {
                this.b = 2;
            }
            else if (var6 < 0.5f) {
                this.b = 1;
            }
            else if (var6 < 0.55f) {
                this.a = aqw.bq.cF;
                this.b = 2;
            }
            else {
                this.b = 0;
            }
        }
    }
}
