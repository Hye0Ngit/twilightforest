// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.util.math.vector.Vector3d;
import java.util.EnumSet;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.Goal;

public class StayNearHomeGoal extends Goal
{
    private final CreatureEntity entity;
    private final float speed;
    
    public StayNearHomeGoal(final CreatureEntity entityTFYetiAlpha, final float sp) {
        this.entity = entityTFYetiAlpha;
        this.speed = sp;
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE));
    }
    
    public boolean func_75250_a() {
        return !this.entity.func_213383_dH();
    }
    
    public boolean func_75253_b() {
        return !this.entity.func_70661_as().func_75500_f();
    }
    
    public void func_75249_e() {
        if (this.entity.func_195048_a(Vector3d.func_237491_b_((Vector3i)this.entity.func_213384_dI())) > 256.0) {
            final Vector3d vec3 = RandomPositionGenerator.func_75464_a(this.entity, 14, 3, new Vector3d(this.entity.func_213384_dI().func_177958_n() + 0.5, (double)this.entity.func_213384_dI().func_177956_o(), this.entity.func_213384_dI().func_177952_p() + 0.5));
            if (vec3 != null) {
                this.entity.func_70661_as().func_75492_a(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c, (double)this.speed);
            }
        }
        else {
            this.entity.func_70661_as().func_75492_a(this.entity.func_213384_dI().func_177958_n() + 0.5, (double)this.entity.func_213384_dI().func_177956_o(), this.entity.func_213384_dI().func_177952_p() + 0.5, (double)this.speed);
        }
    }
}
