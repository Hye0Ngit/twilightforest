// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAITarget;

public class EntityAITFFlockTarget extends EntityAITarget
{
    EntityLiving flockCreature;
    EntityLiving flockTarget;
    
    public EntityAITFFlockTarget(final EntityLiving par1EntityLiving, final boolean b) {
        super(par1EntityLiving, 32.0f, false);
        this.flockCreature = par1EntityLiving;
        this.func_75248_a(1);
    }
    
    public boolean func_75250_a() {
        final List flockList = this.flockCreature.field_70170_p.func_72872_a((Class)this.flockCreature.getClass(), this.flockCreature.field_70121_D.func_72314_b(16.0, 4.0, 16.0));
        final List targetList = new ArrayList();
        for (final EntityLiving flocker : flockList) {
            if (flocker.func_70643_av() != null) {
                targetList.add(flocker.func_70643_av());
            }
        }
        if (targetList.isEmpty()) {
            return false;
        }
        final EntityLiving randomTarget = targetList.get(this.flockCreature.field_70170_p.field_73012_v.nextInt(targetList.size()));
        System.out.println("randomTarget = " + randomTarget);
        this.flockTarget = randomTarget;
        return this.func_75296_a(this.flockTarget, true);
    }
    
    public void func_75249_e() {
        this.field_75299_d.func_70624_b(this.flockTarget);
        super.func_75249_e();
    }
}
