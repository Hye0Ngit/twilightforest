// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityAITFBirdFly extends rc
{
    private aaa entity;
    private int airTime;
    
    public EntityAITFBirdFly(final aaa par1EntityCreature, final float par2) {
        this.airTime = 0;
        this.entity = par1EntityCreature;
        this.a(0);
    }
    
    public boolean a() {
        return this.entity.aR() < 100 && this.entity.aO().nextInt(120) == 0 && this.airTime <= 0;
    }
    
    public boolean b() {
        --this.airTime;
        final aaa entity = this.entity;
        entity.s += (0.30000001192092896 - this.entity.s) * 0.30000001192092896;
        return this.airTime > 0;
    }
    
    public void c() {
        System.out.println("Bird flap!");
        this.airTime = 80;
    }
}
