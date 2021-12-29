// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;
import twilightforest.entity.ai.EntityAITFRedcapPlantTNT;

public class EntityTFRedcapSapper extends EntityTFRedcap
{
    public EntityTFRedcapSapper(final abv world) {
        super(world);
        this.c.a(4, (pr)new EntityAITFRedcapPlantTNT(this));
        this.setTntLeft(3);
        this.c(1, new yd(TFItems.ironwoodBoots));
        this.c(0, new yd(TFItems.ironwoodPick, 1));
    }
    
    @Override
    protected void ay() {
        super.ay();
        this.a(to.a).a(30.0);
    }
    
    public int aP() {
        int var1 = super.aP() + 2;
        if (var1 > 20) {
            var1 = 20;
        }
        return var1;
    }
    
    @Override
    public yd getPick() {
        return new yd(TFItems.ironwoodPick);
    }
}
