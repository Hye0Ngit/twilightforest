// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.entity.EntityTFKobold;
import java.util.Iterator;
import java.util.List;

public class EntityAITFPanicOnFlockDeath extends pr
{
    private om flockCreature;
    private float speed;
    private double fleeX;
    private double fleeY;
    private double fleeZ;
    int fleeTimer;
    
    public EntityAITFPanicOnFlockDeath(final om par1EntityCreature, final float par2) {
        this.flockCreature = par1EntityCreature;
        this.speed = par2;
        this.a(1);
        this.fleeTimer = 0;
    }
    
    public boolean a() {
        boolean yikes = this.fleeTimer > 0;
        final List<of> flockList = this.flockCreature.q.a((Class)this.flockCreature.getClass(), this.flockCreature.E.b(4.0, 2.0, 4.0));
        for (final of flocker : flockList) {
            if (flocker.aB > 0) {
                yikes = true;
                break;
            }
        }
        if (!yikes) {
            return false;
        }
        final asz var1 = rg.a(this.flockCreature, 5, 4);
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
        this.flockCreature.k().a(this.fleeX, this.fleeY, this.fleeZ, (double)this.speed);
        if (this.flockCreature instanceof EntityTFKobold) {
            ((EntityTFKobold)this.flockCreature).setPanicked(true);
        }
    }
    
    public boolean b() {
        return this.fleeTimer > 0 && !this.flockCreature.k().g();
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
