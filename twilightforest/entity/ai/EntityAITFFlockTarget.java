// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class EntityAITFFlockTarget extends om
{
    md flockCreature;
    md flockTarget;
    
    public EntityAITFFlockTarget(final md par1EntityLiving, final boolean b) {
        super(par1EntityLiving, 32.0f, false);
        this.flockCreature = par1EntityLiving;
        this.a(1);
    }
    
    public boolean a() {
        final List flockList = this.flockCreature.p.a((Class)this.flockCreature.getClass(), this.flockCreature.D.b(16.0, 4.0, 16.0));
        final List targetList = new ArrayList();
        for (final md flocker : flockList) {
            if (flocker.aC() != null) {
                targetList.add(flocker.aC());
            }
        }
        if (targetList.isEmpty()) {
            return false;
        }
        final md randomTarget = targetList.get(this.flockCreature.p.t.nextInt(targetList.size()));
        System.out.println("randomTarget = " + randomTarget);
        this.flockTarget = randomTarget;
        return this.a(this.flockTarget, true);
    }
    
    public void c() {
        this.d.b(this.flockTarget);
        super.c();
    }
}
