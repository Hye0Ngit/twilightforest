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
        final t nearbyTNT = this.findBlockTNTNearby(8);
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
        return this.me.q.a(this.tntX, this.tntY, this.tntZ) == aou.aq.cz;
    }
    
    public void c() {
        this.me.c(0, EntityTFRedcap.heldFlint);
    }
    
    public void d() {
        this.me.aC().g();
        this.me.c(0, this.me.getPick());
        this.delayTemptCounter = 20;
    }
    
    public void e() {
        this.me.az().a((double)this.tntX, (double)this.tntY, (double)this.tntZ, 30.0f, (float)this.me.bs());
        if (this.me.f((double)this.tntX, (double)this.tntY, (double)this.tntZ) < 2.4) {
            this.me.aR();
            aou.aq.g(this.me.q, this.tntX, this.tntY, this.tntZ, 1);
            this.me.q.f(this.tntX, this.tntY, this.tntZ, 0, 0, 2);
            this.me.aC().g();
        }
        else {
            this.me.aC().a((double)this.tntX, (double)this.tntY, (double)this.tntZ, this.pursueSpeed);
        }
    }
}
