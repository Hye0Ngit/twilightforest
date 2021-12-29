// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.entity.EntityTFRedcap;

public class EntityAITFRedcapLightTNT extends EntityAITFRedcapBase
{
    private float pursueSpeed;
    private int delayTemptCounter;
    private int tntX;
    private int tntY;
    private int tntZ;
    
    public EntityAITFRedcapLightTNT(final EntityTFRedcap hostEntity, final float speed) {
        this.me = hostEntity;
        this.pursueSpeed = speed;
        this.a(3);
    }
    
    public boolean a() {
        final s nearbyTNT = this.findBlockTNTNearby(8);
        if (this.delayTemptCounter > 0) {
            --this.delayTemptCounter;
            return false;
        }
        if (nearbyTNT != null) {
            this.tntX = nearbyTNT.a;
            this.tntY = nearbyTNT.b;
            this.tntZ = nearbyTNT.c;
            return true;
        }
        return false;
    }
    
    public boolean b() {
        return this.me.p.a(this.tntX, this.tntY, this.tntZ) == amq.ap.cm;
    }
    
    public void c() {
        this.me.b(0, EntityTFRedcap.heldFlint);
    }
    
    public void d() {
        this.me.az().g();
        this.me.b(0, this.me.getPick());
        this.delayTemptCounter = 20;
    }
    
    public void e() {
        this.me.aw().a((double)this.tntX, (double)this.tntY, (double)this.tntZ, 30.0f, (float)this.me.bp());
        if (this.me.f((double)this.tntX, (double)this.tntY, (double)this.tntZ) < 2.4) {
            this.me.aO();
            amq.ap.c(this.me.p, this.tntX, this.tntY, this.tntZ, 1);
            this.me.p.e(this.tntX, this.tntY, this.tntZ, 0);
            this.me.az().g();
        }
        else {
            this.me.az().a((double)this.tntX, (double)this.tntY, (double)this.tntZ, this.pursueSpeed);
        }
    }
}
