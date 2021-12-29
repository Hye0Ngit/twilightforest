// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Iterator;
import java.util.List;

public class EntityAITFFindLoose extends nc
{
    private mi temptedEntity;
    private int temptID;
    private float pursueSpeed;
    private int delayTemptCounter;
    private px temptingItem;
    
    public EntityAITFFindLoose(final EntityTFQuestRam entityTFQuestRam, final float speed, final int blockID) {
        this.temptedEntity = (mi)entityTFQuestRam;
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
        final List nearbyItems = this.temptedEntity.p.a((Class)px.class, this.temptedEntity.D.b(16.0, 4.0, 16.0));
        for (final px itemNearby : nearbyItems) {
            if (itemNearby.a.c == this.temptID && itemNearby.S()) {
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
        this.temptedEntity.az().g();
        this.delayTemptCounter = 100;
    }
    
    public void e() {
        this.temptedEntity.aw().a((lq)this.temptingItem, 30.0f, (float)this.temptedEntity.bp());
        if (this.temptedEntity.e((lq)this.temptingItem) < 6.25) {
            this.temptedEntity.az().g();
        }
        else {
            this.temptedEntity.az().a(this.temptingItem.t, this.temptingItem.u, this.temptingItem.v, this.pursueSpeed);
        }
    }
}
