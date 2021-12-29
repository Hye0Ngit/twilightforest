// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Iterator;
import java.util.List;
import twilightforest.entity.EntityTFQuestRam;

public class EntityAITFEatLoose extends og
{
    private EntityTFQuestRam temptedQuestRam;
    private int temptID;
    private int delayTemptCounter;
    private rb temptingItem;
    
    public EntityAITFEatLoose(final EntityTFQuestRam entityTFQuestRam, final int blockID) {
        this.temptedQuestRam = entityTFQuestRam;
        this.temptID = blockID;
        this.a(0);
    }
    
    public boolean a() {
        if (this.delayTemptCounter > 0) {
            --this.delayTemptCounter;
            return false;
        }
        this.temptingItem = null;
        final List nearbyItems = this.temptedQuestRam.q.a((Class)rb.class, this.temptedQuestRam.E.b(2.0, 2.0, 2.0));
        for (final rb itemNearby : nearbyItems) {
            if (itemNearby.d().c == this.temptID && !this.temptedQuestRam.isColorPresent(itemNearby.d().k()) && itemNearby.R()) {
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
        this.temptedQuestRam.aC().g();
        this.delayTemptCounter = 100;
    }
    
    public void e() {
        this.temptedQuestRam.az().a((mp)this.temptingItem, 30.0f, (float)this.temptedQuestRam.bs());
        if (this.temptedQuestRam.e((mp)this.temptingItem) < 6.25 && !this.temptedQuestRam.isColorPresent(this.temptingItem.d().k())) {
            this.temptingItem.w();
            this.temptedQuestRam.aR();
            this.temptedQuestRam.setColorPresent(this.temptingItem.d().k());
            this.temptedQuestRam.animateAddColor(this.temptingItem.d().k(), 50);
        }
    }
}
