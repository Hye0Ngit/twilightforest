// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.entity.EntityTFKobold;
import net.minecraft.util.Vec3;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAITFPanicOnFlockDeath extends EntityAIBase
{
    private EntityCreature flockCreature;
    private float speed;
    private double fleeX;
    private double fleeY;
    private double fleeZ;
    int fleeTimer;
    
    public EntityAITFPanicOnFlockDeath(final EntityCreature par1EntityCreature, final float par2) {
        this.flockCreature = par1EntityCreature;
        this.speed = par2;
        this.func_75248_a(1);
        this.fleeTimer = 0;
    }
    
    public boolean func_75250_a() {
        boolean yikes = this.fleeTimer > 0;
        final List flockList = this.flockCreature.field_70170_p.func_72872_a((Class)this.flockCreature.getClass(), this.flockCreature.field_70121_D.func_72314_b(4.0, 2.0, 4.0));
        for (final EntityLiving flocker : flockList) {
            if (flocker.field_70725_aQ > 0) {
                yikes = true;
                break;
            }
        }
        if (!yikes) {
            return false;
        }
        final Vec3 var1 = RandomPositionGenerator.func_75463_a(this.flockCreature, 5, 4);
        if (var1 == null) {
            return false;
        }
        this.fleeX = var1.field_72450_a;
        this.fleeY = var1.field_72448_b;
        this.fleeZ = var1.field_72449_c;
        return true;
    }
    
    public void func_75249_e() {
        this.fleeTimer = 40;
        this.flockCreature.func_70661_as().func_75492_a(this.fleeX, this.fleeY, this.fleeZ, this.speed);
        if (this.flockCreature instanceof EntityTFKobold) {
            ((EntityTFKobold)this.flockCreature).setPanicked(true);
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
        if (this.flockCreature instanceof EntityTFKobold) {
            ((EntityTFKobold)this.flockCreature).setPanicked(false);
        }
    }
}
