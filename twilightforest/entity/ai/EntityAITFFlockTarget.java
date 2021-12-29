// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;

public class EntityAITFFlockTarget extends EntityAITarget
{
    private final EntityLivingBase flockCreature;
    private EntityLivingBase flockTarget;
    
    public EntityAITFFlockTarget(final EntityCreature creature, final boolean checkSight) {
        super(creature, false);
        this.flockCreature = (EntityLivingBase)creature;
        this.func_75248_a(1);
    }
    
    public boolean func_75250_a() {
        final List<EntityLivingBase> flockList = this.flockCreature.field_70170_p.func_72872_a((Class)this.flockCreature.getClass(), this.flockCreature.func_174813_aQ().func_72314_b(16.0, 4.0, 16.0));
        final List<EntityLivingBase> targetList = new ArrayList<EntityLivingBase>();
        for (final EntityLivingBase flocker : flockList) {
            if (flocker.func_70643_av() != null) {
                targetList.add(flocker.func_70643_av());
            }
        }
        if (targetList.isEmpty()) {
            return false;
        }
        this.flockTarget = targetList.get(this.flockCreature.field_70170_p.field_73012_v.nextInt(targetList.size()));
        return this.func_75296_a(this.flockTarget, true);
    }
    
    public void func_75249_e() {
        this.field_75299_d.func_70624_b(this.flockTarget);
        super.func_75249_e();
    }
    
    public void func_75251_c() {
        this.flockTarget = null;
        super.func_75251_c();
    }
}
