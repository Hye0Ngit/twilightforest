// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;
import twilightforest.entity.ai.EntityAITFRedcapPlantTNT;

public class EntityTFRedcapSapper extends EntityTFRedcap
{
    public EntityTFRedcapSapper(final yc world) {
        super(world);
        this.bn.a(4, (nc)new EntityAITFRedcapPlantTNT(this));
        this.aG = "/twilightforest/redcapsapper.png";
        this.setTntLeft(3);
        this.b(1, new ur(TFItems.ironwoodBoots));
        this.b(0, new ur(TFItems.ironwoodPick, 1));
    }
    
    @Override
    public int aT() {
        return 30;
    }
    
    public int aW() {
        int var1 = super.aW() + 2;
        if (var1 > 20) {
            var1 = 20;
        }
        return var1;
    }
    
    @Override
    public ur getPick() {
        return new ur(TFItems.ironwoodPick);
    }
}
