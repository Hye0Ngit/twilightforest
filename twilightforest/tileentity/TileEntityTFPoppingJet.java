// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.tileentity;

import twilightforest.block.TFBlocks;

public class TileEntityTFPoppingJet extends asm
{
    int counter;
    int nextMeta;
    
    public TileEntityTFPoppingJet() {
        this(10);
    }
    
    public TileEntityTFPoppingJet(final int parNextMeta) {
        this.counter = 0;
        this.nextMeta = parNextMeta;
    }
    
    public void h() {
        if (++this.counter >= 80) {
            this.counter = 0;
            if (!this.k.I && this.k.a(this.l, this.m, this.n) == TFBlocks.fireJet.cF) {
                this.k.f(this.l, this.m, this.n, TFBlocks.fireJet.cF, this.nextMeta, 3);
            }
            this.w_();
        }
        else if (this.counter % 20 == 0) {
            this.k.a("lava", this.l + 0.5, this.m + 1.5, this.n + 0.5, 0.0, 0.0, 0.0);
            this.k.a((double)this.l, (double)this.m, (double)this.n, "liquid.lavapop", 0.2f + this.k.s.nextFloat() * 0.2f, 0.9f + this.k.s.nextFloat() * 0.15f);
        }
    }
    
    public void a(final bx par1NBTTagCompound) {
        super.a(par1NBTTagCompound);
        this.nextMeta = par1NBTTagCompound.e("NextMeta");
    }
    
    public void b(final bx par1NBTTagCompound) {
        super.b(par1NBTTagCompound);
        par1NBTTagCompound.a("NextMeta", this.nextMeta);
    }
}
