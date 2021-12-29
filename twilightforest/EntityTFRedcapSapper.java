// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFRedcapSapper extends EntityTFRedcap
{
    public EntityTFRedcapSapper(final xv world) {
        super(world);
        this.bm.a(4, (nc)new EntityAITFRedcapPlantTNT(this));
        this.aF = "/twilightforest/redcapsapper.png";
        this.setTntLeft(3);
        this.b(1, new um(TFItems.ironwoodBoots));
        this.b(0, new um(TFItems.ironwoodPick, 1));
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
    public um getPick() {
        return new um(TFItems.ironwoodPick);
    }
}
