// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFKingSpider extends sb
{
    public EntityTFKingSpider(final zv world) {
        super(world);
        this.aH = "/mods/twilightforest/textures/model/kingspider.png";
        this.a(1.6f, 1.6f);
        this.bI = 0.35f;
        this.aC().a(true);
        this.bo.a(2, (og)new oo((ng)this, (Class)sk.class, this.bI, false));
        this.bo.a(3, (og)new ok((ng)this, this.bI));
        this.bo.a(6, (og)new pa((nl)this, 0.2f));
        this.bo.a(7, (og)new ol((ng)this, (Class)sk.class, 6.0f));
        this.bo.a(8, (og)new oz((ng)this));
        this.bp.a(2, (og)new pk((ng)this, false));
        this.bp.a(2, (og)new pl((ng)this, (Class)sk.class, 16.0f, 0, true));
    }
    
    protected boolean bh() {
        return true;
    }
    
    protected mp j() {
        final double var2 = 16.0;
        return (mp)this.q.b((mp)this, var2);
    }
    
    public float m() {
        return 1.9f;
    }
    
    public float bw() {
        return 2.0f;
    }
    
    public int aW() {
        return 30;
    }
    
    public int c(final mp par1Entity) {
        return 6;
    }
    
    public boolean g_() {
        return false;
    }
    
    public void bJ() {
        final EntityTFSkeletonDruid druid = new EntityTFSkeletonDruid(this.q);
        druid.b(this.u, this.v, this.w, this.A, 0.0f);
        druid.bJ();
        this.q.d((mp)druid);
        druid.a((mp)this);
    }
}
