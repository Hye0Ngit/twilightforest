// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;
import twilightforest.block.TFBlocks;

public class EntityTFMazeSlime extends tr
{
    private String slimeParticleString;
    
    public EntityTFMazeSlime(final abv par1World) {
        super(par1World);
        this.a(1 << 1 + this.ab.nextInt(2));
    }
    
    protected tr bK() {
        return new EntityTFMazeSlime(this.q);
    }
    
    public void a(final int par1) {
        super.a(par1);
        this.b = par1 + 3;
    }
    
    public boolean bs() {
        return this.q.r > 0 && this.q.b(this.E) && this.q.a((nm)this, this.E).isEmpty() && !this.q.d(this.E) && this.isValidLightLevel();
    }
    
    protected void ay() {
        super.ay();
        final int size = this.bR();
        this.a(to.a).a(2.0 * size * size);
    }
    
    protected boolean bN() {
        return true;
    }
    
    protected int bO() {
        return super.bO() + 3;
    }
    
    protected String bJ() {
        if (this.slimeParticleString == null) {
            this.slimeParticleString = "tilecrack_" + TFBlocks.mazestone.cF + "_1";
        }
        return this.slimeParticleString;
    }
    
    protected boolean isValidLightLevel() {
        final int var1 = lr.c(this.u);
        final int var2 = lr.c(this.E.b);
        final int var3 = lr.c(this.w);
        if (this.q.b(acg.a, var1, var2, var3) > this.ab.nextInt(32)) {
            return false;
        }
        int var4 = this.q.n(var1, var2, var3);
        if (this.q.P()) {
            final int var5 = this.q.j;
            this.q.j = 10;
            var4 = this.q.n(var1, var2, var3);
            this.q.j = var5;
        }
        return var4 <= this.ab.nextInt(8);
    }
    
    protected float aZ() {
        return 0.1f * this.bR();
    }
    
    protected void l(final int par1) {
        this.b(TFItems.charmOfKeeping1.cv, 1);
    }
}
