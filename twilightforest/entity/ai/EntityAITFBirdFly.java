// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

public class EntityAITFBirdFly extends nc
{
    private mi entity;
    private int airTime;
    
    public EntityAITFBirdFly(final mi par1EntityCreature, final float par2) {
        this.airTime = 0;
        this.entity = par1EntityCreature;
        this.a(0);
    }
    
    public boolean a() {
        return this.entity.aE() < 100 && this.entity.aB().nextInt(120) == 0 && this.airTime <= 0;
    }
    
    public boolean b() {
        --this.airTime;
        final mi entity = this.entity;
        entity.x += (0.30000001192092896 - this.entity.x) * 0.30000001192092896;
        return this.airTime > 0;
    }
    
    public void c() {
        System.out.println("Bird flap!");
        this.airTime = 80;
    }
}
