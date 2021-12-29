// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

public class EntityAITFKidnapRider extends pr
{
    private om theEntityCreature;
    private float speed;
    private double randPosX;
    private double randPosY;
    private double randPosZ;
    
    public EntityAITFKidnapRider(final om par1EntityCreature, final float par2) {
        this.theEntityCreature = par1EntityCreature;
        this.speed = par2;
        this.a(1);
    }
    
    public boolean a() {
        if (this.theEntityCreature.n == null || this.theEntityCreature.aC().nextInt(5) > 0) {
            return false;
        }
        final asz var1 = rg.a(this.theEntityCreature, 5, 4);
        if (var1 == null) {
            return false;
        }
        this.randPosX = var1.c;
        this.randPosY = var1.d;
        this.randPosZ = var1.e;
        return true;
    }
    
    public void c() {
        this.theEntityCreature.k().a(this.randPosX, this.randPosY, this.randPosZ, (double)this.speed);
    }
    
    public boolean b() {
        return !this.theEntityCreature.k().g();
    }
}
