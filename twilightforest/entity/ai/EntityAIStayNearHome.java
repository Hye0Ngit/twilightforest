// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIStayNearHome extends EntityAIBase
{
    private final EntityCreature entity;
    private final float speed;
    
    public EntityAIStayNearHome(final EntityCreature entityTFYetiAlpha, final float sp) {
        this.entity = entityTFYetiAlpha;
        this.speed = sp;
        this.func_75248_a(1);
    }
    
    public boolean func_75250_a() {
        return !this.entity.func_110173_bK();
    }
    
    public boolean func_75253_b() {
        return !this.entity.func_70661_as().func_75500_f();
    }
    
    public void func_75249_e() {
        if (this.entity.func_174818_b(this.entity.func_180486_cf()) > 256.0) {
            final Vec3d vec3 = RandomPositionGenerator.func_75464_a(this.entity, 14, 3, new Vec3d(this.entity.func_180486_cf().func_177958_n() + 0.5, (double)this.entity.func_180486_cf().func_177956_o(), this.entity.func_180486_cf().func_177952_p() + 0.5));
            if (vec3 != null) {
                this.entity.func_70661_as().func_75492_a(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c, (double)this.speed);
            }
        }
        else {
            this.entity.func_70661_as().func_75492_a(this.entity.func_180486_cf().func_177958_n() + 0.5, (double)this.entity.func_180486_cf().func_177956_o(), this.entity.func_180486_cf().func_177952_p() + 0.5, (double)this.speed);
        }
    }
}
