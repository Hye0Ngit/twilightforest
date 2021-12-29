// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAITFKidnapRider extends EntityAIBase
{
    private EntityCreature theEntityCreature;
    private float speed;
    private double randPosX;
    private double randPosY;
    private double randPosZ;
    
    public EntityAITFKidnapRider(final EntityCreature creature, final float speed) {
        this.theEntityCreature = creature;
        this.speed = speed;
        this.func_75248_a(1);
    }
    
    public boolean func_75250_a() {
        if (this.theEntityCreature.func_184187_bx() == null || this.theEntityCreature.func_70681_au().nextInt(5) > 0) {
            return false;
        }
        final Vec3d target = RandomPositionGenerator.func_75463_a(this.theEntityCreature, 5, 4);
        if (target == null) {
            return false;
        }
        this.randPosX = target.field_72450_a;
        this.randPosY = target.field_72448_b;
        this.randPosZ = target.field_72449_c;
        return true;
    }
    
    public void func_75249_e() {
        this.theEntityCreature.func_70661_as().func_75492_a(this.randPosX, this.randPosY, this.randPosZ, (double)this.speed);
    }
    
    public boolean func_75253_b() {
        return !this.theEntityCreature.func_70661_as().func_75500_f();
    }
}
