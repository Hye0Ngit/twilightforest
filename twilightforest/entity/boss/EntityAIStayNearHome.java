// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.boss;

import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.Vec3;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIStayNearHome extends EntityAIBase
{
    private EntityCreature entity;
    private float speed;
    
    public EntityAIStayNearHome(final EntityCreature entityTFYetiAlpha, final float sp) {
        this.entity = entityTFYetiAlpha;
        this.speed = sp;
        this.func_75248_a(1);
    }
    
    public boolean func_75250_a() {
        final boolean isOutOfRange = !this.entity.func_110173_bK();
        return isOutOfRange;
    }
    
    public boolean func_75253_b() {
        return !this.entity.func_70661_as().func_75500_f();
    }
    
    public void func_75249_e() {
        if (this.entity.func_70092_e((double)this.entity.func_110172_bL().field_71574_a, (double)this.entity.func_110172_bL().field_71572_b, (double)this.entity.func_110172_bL().field_71573_c) > 256.0) {
            final Vec3 vec3 = RandomPositionGenerator.func_75464_a(this.entity, 14, 3, Vec3.func_72443_a(this.entity.func_110172_bL().field_71574_a + 0.5, (double)this.entity.func_110172_bL().field_71572_b, this.entity.func_110172_bL().field_71573_c + 0.5));
            if (vec3 != null) {
                this.entity.func_70661_as().func_75492_a(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c, (double)this.speed);
            }
        }
        else {
            this.entity.func_70661_as().func_75492_a(this.entity.func_110172_bL().field_71574_a + 0.5, (double)this.entity.func_110172_bL().field_71572_b, this.entity.func_110172_bL().field_71573_c + 0.5, (double)this.speed);
        }
    }
}
