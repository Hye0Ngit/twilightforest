// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;
import twilightforest.block.TFBlocks;

public class EntityTFMazeSlime extends qo
{
    private String slimeParticleString;
    
    public EntityTFMazeSlime(final yc par1World) {
        super(par1World);
        this.aG = "/twilightforest/mazeslime.png";
        this.a(1 << 1 + this.aa.nextInt(2));
    }
    
    protected qo i() {
        return new EntityTFMazeSlime(this.p);
    }
    
    public void a(final int par1) {
        super.a(par1);
        this.bd = par1 + 3;
    }
    
    public boolean bs() {
        return this.p.s > 0 && this.p.b(this.D) && this.p.a((lq)this, this.D).isEmpty() && !this.p.d(this.D) && this.isValidLightLevel();
    }
    
    public int aT() {
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
            this.slimeParticleString = "tilecrack_" + TFBlocks.mazestone.cm + "_1";
        }
        return this.slimeParticleString;
    }
    
    protected boolean isValidLightLevel() {
        final int var1 = ke.c(this.t);
        final int var2 = ke.c(this.D.b);
        final int var3 = ke.c(this.v);
        if (this.p.b(yo.a, var1, var2, var3) > this.aa.nextInt(32)) {
            return false;
        }
        int var4 = this.p.m(var1, var2, var3);
        if (this.p.M()) {
            final int var5 = this.p.j;
            this.p.j = 10;
            var4 = this.p.m(var1, var2, var3);
            this.p.j = var5;
        }
        return var4 <= this.aa.nextInt(8);
    }
    
    protected float aX() {
        return 0.1f * this.p();
    }
    
    protected void l(final int par1) {
        this.b(TFItems.charmOfKeeping1.cj, 1);
    }
}
