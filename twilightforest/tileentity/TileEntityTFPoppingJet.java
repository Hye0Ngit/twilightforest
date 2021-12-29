// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import twilightforest.block.TFBlocks;

public class TileEntityTFPoppingJet extends any
{
    int counter;
    
    public TileEntityTFPoppingJet() {
        this.counter = 0;
    }
    
    public void g() {
        if (++this.counter >= 80) {
            this.counter = 0;
            if (!this.k.I && this.k.a(this.l, this.m, this.n) == TFBlocks.fireJet.cm) {
                this.k.d(this.l, this.m, this.n, TFBlocks.fireJet.cm, 10);
            }
            this.w_();
        }
        else if (this.counter % 20 == 0) {
            this.k.a("lava", this.l + 0.5, this.m + 1.5, this.n + 0.5, 0.0, 0.0, 0.0);
            this.k.a((double)this.l, (double)this.m, (double)this.n, "liquid.lavapop", 0.2f + this.k.t.nextFloat() * 0.2f, 0.9f + this.k.t.nextFloat() * 0.15f);
        }
    }
}
