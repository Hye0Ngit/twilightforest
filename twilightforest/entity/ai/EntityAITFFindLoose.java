// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Iterator;
import java.util.List;
import twilightforest.entity.EntityTFQuestRam;

public class EntityAITFFindLoose extends og
{
    private nl temptedEntity;
    private int temptID;
    private float pursueSpeed;
    private int delayTemptCounter;
    private rb temptingItem;
    
    public EntityAITFFindLoose(final EntityTFQuestRam entityTFQuestRam, final float speed, final int blockID) {
        this.temptedEntity = (nl)entityTFQuestRam;
        this.pursueSpeed = speed;
        this.temptID = blockID;
        this.a(3);
    }
    
    public boolean a() {
        if (this.delayTemptCounter > 0) {
            --this.delayTemptCounter;
            return false;
        }
        this.temptingItem = null;
        final List nearbyItems = this.temptedEntity.q.a((Class)rb.class, this.temptedEntity.E.b(16.0, 4.0, 16.0));
        for (final rb itemNearby : nearbyItems) {
            if (itemNearby.d().c == this.temptID && itemNearby.R()) {
                this.temptingItem = itemNearby;
                break;
            }
        }
        return this.temptingItem != null;
    }
    
    public boolean b() {
        return this.a();
    }
    
    public void c() {
    }
    
    public void d() {
        this.temptingItem = null;
        this.temptedEntity.aC().g();
        this.delayTemptCounter = 100;
    }
    
    public void e() {
        this.temptedEntity.az().a((mp)this.temptingItem, 30.0f, (float)this.temptedEntity.bs());
        if (this.temptedEntity.e((mp)this.temptingItem) < 6.25) {
            this.temptedEntity.aC().g();
        }
        else {
            this.temptedEntity.aC().a(this.temptingItem.u, this.temptingItem.v, this.temptingItem.w, this.pursueSpeed);
        }
    }
}
