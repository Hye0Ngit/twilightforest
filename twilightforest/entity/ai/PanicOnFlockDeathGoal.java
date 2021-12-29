// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.entity.KoboldEntity;
import net.minecraft.util.math.vector.Vector3d;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.LivingEntity;
import java.util.EnumSet;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.ai.goal.Goal;

public class PanicOnFlockDeathGoal extends Goal
{
    private CreatureEntity flockCreature;
    private float speed;
    private double fleeX;
    private double fleeY;
    private double fleeZ;
    private int fleeTimer;
    
    public PanicOnFlockDeathGoal(final CreatureEntity creature, final float speed) {
        this.flockCreature = creature;
        this.speed = speed;
        this.func_220684_a((EnumSet)EnumSet.of(Goal.Flag.MOVE));
        this.fleeTimer = 0;
    }
    
    public boolean func_75250_a() {
        boolean yikes = this.fleeTimer > 0;
        final List<CreatureEntity> flockList = this.flockCreature.field_70170_p.func_217357_a((Class)this.flockCreature.getClass(), this.flockCreature.func_174813_aQ().func_72314_b(4.0, 2.0, 4.0));
        for (final LivingEntity flocker : flockList) {
            if (flocker.field_70725_aQ > 0) {
                yikes = true;
                break;
            }
        }
        if (!yikes) {
            return false;
        }
        final Vector3d target = RandomPositionGenerator.func_75463_a(this.flockCreature, 5, 4);
        if (target == null) {
            return false;
        }
        this.fleeX = target.field_72450_a;
        this.fleeY = target.field_72448_b;
        this.fleeZ = target.field_72449_c;
        return true;
    }
    
    public void func_75249_e() {
        this.fleeTimer = 40;
        this.flockCreature.func_70661_as().func_75492_a(this.fleeX, this.fleeY, this.fleeZ, (double)this.speed);
        if (this.flockCreature instanceof KoboldEntity) {
            ((KoboldEntity)this.flockCreature).setPanicked(true);
        }
    }
    
    public boolean func_75253_b() {
        return this.fleeTimer > 0 && !this.flockCreature.func_70661_as().func_75500_f();
    }
    
    public void func_75246_d() {
        --this.fleeTimer;
    }
    
    public void func_75251_c() {
        this.fleeTimer -= 20;
        if (this.flockCreature instanceof KoboldEntity) {
            ((KoboldEntity)this.flockCreature).setPanicked(false);
        }
    }
}
