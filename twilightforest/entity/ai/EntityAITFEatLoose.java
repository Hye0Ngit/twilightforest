// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Iterator;
import java.util.List;
import twilightforest.entity.EntityTFQuestRam;

public class EntityAITFEatLoose extends nc
{
    private EntityTFQuestRam temptedQuestRam;
    private int temptID;
    private int delayTemptCounter;
    private px temptingItem;
    
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
        final List nearbyItems = this.temptedQuestRam.p.a((Class)px.class, this.temptedQuestRam.D.b(2.0, 2.0, 2.0));
        for (final px itemNearby : nearbyItems) {
            if (itemNearby.d().c == this.temptID && !this.temptedQuestRam.isColorPresent(itemNearby.d().j()) && itemNearby.S()) {
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
        this.temptedQuestRam.az().g();
        this.delayTemptCounter = 100;
    }
    
    public void e() {
        this.temptedQuestRam.aw().a((lq)this.temptingItem, 30.0f, (float)this.temptedQuestRam.bp());
        if (this.temptedQuestRam.e((lq)this.temptingItem) < 6.25 && !this.temptedQuestRam.isColorPresent(this.temptingItem.d().j())) {
            this.temptingItem.x();
            this.temptedQuestRam.aO();
            this.temptedQuestRam.setColorPresent(this.temptingItem.d().j());
            this.temptedQuestRam.animateAddColor(this.temptingItem.d().j(), 50);
        }
    }
}
