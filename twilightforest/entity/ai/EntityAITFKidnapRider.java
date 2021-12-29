// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

public class EntityAITFKidnapRider extends nc
{
    private mi theEntityCreature;
    private float speed;
    private double randPosX;
    private double randPosY;
    private double randPosZ;
    
    public EntityAITFKidnapRider(final mi par1EntityCreature, final float par2) {
        this.theEntityCreature = par1EntityCreature;
        this.speed = par2;
        this.a(1);
    }
    
    public boolean a() {
        if (this.theEntityCreature.n == null || this.theEntityCreature.aB().nextInt(5) > 0) {
            return false;
        }
        final aoj var1 = op.a(this.theEntityCreature, 5, 4);
        if (var1 == null) {
            return false;
        }
        this.randPosX = var1.c;
        this.randPosY = var1.d;
        this.randPosZ = var1.e;
        return true;
    }
    
    public void c() {
        this.theEntityCreature.az().a(this.randPosX, this.randPosY, this.randPosZ, this.speed);
    }
    
    public boolean b() {
        return !this.theEntityCreature.az().f();
    }
}
