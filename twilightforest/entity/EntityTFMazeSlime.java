// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;
import twilightforest.block.TFBlocks;

public class EntityTFMazeSlime extends sa
{
    private String slimeParticleString;
    
    public EntityTFMazeSlime(final zv par1World) {
        super(par1World);
        this.aH = "/mods/twilightforest/textures/model/mazeslime.png";
        this.a(1 << 1 + this.ab.nextInt(2));
    }
    
    protected sa i() {
        return new EntityTFMazeSlime(this.q);
    }
    
    public void a(final int par1) {
        super.a(par1);
        this.be = par1 + 3;
    }
    
    public boolean bv() {
        return this.q.r > 0 && this.q.b(this.E) && this.q.a((mp)this, this.E).isEmpty() && !this.q.d(this.E) && this.isValidLightLevel();
    }
    
    public int aW() {
        final int size = this.p();
        return 2 * size * size;
    }
    
    protected boolean l() {
        return true;
    }
    
    protected int m() {
        return super.m() + 3;
    }
    
    protected String h() {
        if (this.slimeParticleString == null) {
            this.slimeParticleString = "tilecrack_" + TFBlocks.mazestone.cz + "_1";
        }
        return this.slimeParticleString;
    }
    
    protected boolean isValidLightLevel() {
        final int var1 = kx.c(this.u);
        final int var2 = kx.c(this.E.b);
        final int var3 = kx.c(this.w);
        if (this.q.b(aag.a, var1, var2, var3) > this.ab.nextInt(32)) {
            return false;
        }
        int var4 = this.q.n(var1, var2, var3);
        if (this.q.N()) {
            final int var5 = this.q.j;
            this.q.j = 10;
            var4 = this.q.n(var1, var2, var3);
            this.q.j = var5;
        }
        return var4 <= this.ab.nextInt(8);
    }
    
    protected float ba() {
        return 0.1f * this.p();
    }
    
    protected void l(final int par1) {
        this.b(TFItems.charmOfKeeping1.cp, 1);
    }
}
