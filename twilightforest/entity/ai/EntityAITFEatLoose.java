// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Iterator;
import java.util.List;
import twilightforest.entity.passive.EntityTFQuestRam;

public class EntityAITFEatLoose extends pr
{
    private EntityTFQuestRam temptedQuestRam;
    private int temptID;
    private int delayTemptCounter;
    private sr temptingItem;
    
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
        final List<sr> nearbyItems = this.temptedQuestRam.q.a((Class)sr.class, this.temptedQuestRam.E.b(2.0, 2.0, 2.0));
        for (final sr itemNearby : nearbyItems) {
            if (itemNearby.d().d == this.temptID && !this.temptedQuestRam.isColorPresent(itemNearby.d().k()) && itemNearby.S()) {
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
        this.temptedQuestRam.k().h();
        this.delayTemptCounter = 100;
    }
    
    public void e() {
        this.temptedQuestRam.h().a((nm)this.temptingItem, 30.0f, (float)this.temptedQuestRam.bp());
        if (this.temptedQuestRam.e((nm)this.temptingItem) < 6.25 && !this.temptedQuestRam.isColorPresent(this.temptingItem.d().k())) {
            this.temptingItem.w();
            this.temptedQuestRam.p();
            this.temptedQuestRam.setColorPresent(this.temptingItem.d().k());
            this.temptedQuestRam.animateAddColor(this.temptingItem.d().k(), 50);
        }
    }
}
