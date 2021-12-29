// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class EntityAITFFlockTarget extends pq
{
    ng flockCreature;
    ng flockTarget;
    
    public EntityAITFFlockTarget(final ng par1EntityLiving, final boolean b) {
        super(par1EntityLiving, 32.0f, false);
        this.flockCreature = par1EntityLiving;
        this.a(1);
    }
    
    public boolean a() {
        final List flockList = this.flockCreature.q.a((Class)this.flockCreature.getClass(), this.flockCreature.E.b(16.0, 4.0, 16.0));
        final List targetList = new ArrayList();
        for (final ng flocker : flockList) {
            if (flocker.aF() != null) {
                targetList.add(flocker.aF());
            }
        }
        if (targetList.isEmpty()) {
            return false;
        }
        final ng randomTarget = targetList.get(this.flockCreature.q.s.nextInt(targetList.size()));
        System.out.println("randomTarget = " + randomTarget);
        this.flockTarget = randomTarget;
        return this.a(this.flockTarget, true);
    }
    
    public void c() {
        this.d.b(this.flockTarget);
        super.c();
    }
}
