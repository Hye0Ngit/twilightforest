// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.Iterator;
import java.util.List;

public class EntityAITFPanicOnFlockDeath extends nc
{
    private mi flockCreature;
    private float speed;
    private double fleeX;
    private double fleeY;
    private double fleeZ;
    int fleeTimer;
    
    public EntityAITFPanicOnFlockDeath(final mi par1EntityCreature, final float par2) {
        this.flockCreature = par1EntityCreature;
        this.speed = par2;
        this.a(1);
        this.fleeTimer = 0;
    }
    
    public boolean a() {
        boolean yikes = this.fleeTimer > 0;
        final List flockList = this.flockCreature.p.a((Class)this.flockCreature.getClass(), this.flockCreature.D.b(4.0, 2.0, 4.0));
        for (final md flocker : flockList) {
            if (flocker.aX > 0) {
                yikes = true;
                break;
            }
        }
        if (!yikes) {
            return false;
        }
        final aob var1 = op.a(this.flockCreature, 5, 4);
        if (var1 == null) {
            return false;
        }
        this.fleeX = var1.c;
        this.fleeY = var1.d;
        this.fleeZ = var1.e;
        return true;
    }
    
    public void c() {
        this.fleeTimer = 40;
        this.flockCreature.az().a(this.fleeX, this.fleeY, this.fleeZ, this.speed);
        if (this.flockCreature instanceof EntityTFKobold) {
            ((EntityTFKobold)this.flockCreature).setPanicked(true);
        }
    }
    
    public boolean b() {
        return this.fleeTimer > 0 && !this.flockCreature.az().f();
    }
    
    public void e() {
        --this.fleeTimer;
    }
    
    public void d() {
        this.fleeTimer -= 20;
        if (this.flockCreature instanceof EntityTFKobold) {
            ((EntityTFKobold)this.flockCreature).setPanicked(false);
        }
    }
}
