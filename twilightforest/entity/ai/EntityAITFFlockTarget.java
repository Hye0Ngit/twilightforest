// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class EntityAITFFlockTarget extends rd
{
    oe flockCreature;
    oe flockTarget;
    
    public EntityAITFFlockTarget(final om par1EntityLiving, final boolean b) {
        super(par1EntityLiving, false);
        this.flockCreature = (oe)par1EntityLiving;
        this.a(1);
    }
    
    public boolean a() {
        final List<oe> flockList = this.flockCreature.q.a((Class)this.flockCreature.getClass(), this.flockCreature.E.b(16.0, 4.0, 16.0));
        final List<oe> targetList = new ArrayList<oe>();
        for (final oe flocker : flockList) {
            if (flocker.aD() != null) {
                targetList.add(flocker.aD());
            }
        }
        if (targetList.isEmpty()) {
            return false;
        }
        final oe randomTarget = targetList.get(this.flockCreature.q.s.nextInt(targetList.size()));
        System.out.println("randomTarget = " + randomTarget);
        this.flockTarget = randomTarget;
        return this.a(this.flockTarget, true);
    }
    
    public void c() {
        this.c.d(this.flockTarget);
        super.c();
    }
}
