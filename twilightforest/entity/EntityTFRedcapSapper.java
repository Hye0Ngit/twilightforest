// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.item.TFItems;
import twilightforest.entity.ai.EntityAITFRedcapPlantTNT;

public class EntityTFRedcapSapper extends EntityTFRedcap
{
    public EntityTFRedcapSapper(final zv world) {
        super(world);
        this.bo.a(4, (og)new EntityAITFRedcapPlantTNT(this));
        this.aH = "/mods/twilightforest/textures/model/redcapsapper.png";
        this.setTntLeft(3);
        this.c(1, new wg(TFItems.ironwoodBoots));
        this.c(0, new wg(TFItems.ironwoodPick, 1));
    }
    
    @Override
    public int aW() {
        return 30;
    }
    
    public int aZ() {
        int var1 = super.aZ() + 2;
        if (var1 > 20) {
            var1 = 20;
        }
        return var1;
    }
    
    @Override
    public wg getPick() {
        return new wg(TFItems.ironwoodPick);
    }
}
