// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFKingSpider extends qp
{
    public EntityTFKingSpider(final yc world) {
        super(world);
        this.aG = "/twilightforest/hedgespider.png";
        this.a(1.9f, 1.6f);
    }
    
    protected lq j() {
        final double var2 = 16.0;
        return (lq)this.p.b((lq)this, var2);
    }
    
    public float m() {
        return 2.0f;
    }
    
    public float bt() {
        return 2.0f;
    }
    
    public int aT() {
        return 30;
    }
    
    public int c(final lq par1Entity) {
        return 6;
    }
}
