// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Iterator;
import java.util.List;
import twilightforest.entity.passive.EntityTFQuestRam;

public class EntityAITFFindLoose extends pr
{
    private om temptedEntity;
    private int temptID;
    private float pursueSpeed;
    private int delayTemptCounter;
    private sr temptingItem;
    
    public EntityAITFFindLoose(final EntityTFQuestRam entityTFQuestRam, final float speed, final int blockID) {
        this.temptedEntity = (om)entityTFQuestRam;
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
        final List<sr> nearbyItems = this.temptedEntity.q.a((Class)sr.class, this.temptedEntity.E.b(16.0, 4.0, 16.0));
        for (final sr itemNearby : nearbyItems) {
            if (itemNearby.d().d == this.temptID && itemNearby.S()) {
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
        this.temptedEntity.k().h();
        this.delayTemptCounter = 100;
    }
    
    public void e() {
        this.temptedEntity.h().a((nm)this.temptingItem, 30.0f, (float)this.temptedEntity.bp());
        if (this.temptedEntity.e((nm)this.temptingItem) < 6.25) {
            this.temptedEntity.k().h();
        }
        else {
            this.temptedEntity.k().a(this.temptingItem.u, this.temptingItem.v, this.temptingItem.w, (double)this.pursueSpeed);
        }
    }
}
