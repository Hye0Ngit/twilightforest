// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import net.minecraft.util.Vec3;
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
    
    public EntityAITFKidnapRider(final EntityCreature par1EntityCreature, final float par2) {
        this.theEntityCreature = par1EntityCreature;
        this.speed = par2;
        this.func_75248_a(1);
    }
    
    public boolean func_75250_a() {
        if (this.theEntityCreature.field_70153_n == null || this.theEntityCreature.func_70681_au().nextInt(5) > 0) {
            return false;
        }
        final Vec3 var1 = RandomPositionGenerator.func_75463_a(this.theEntityCreature, 5, 4);
        if (var1 == null) {
            return false;
        }
        this.randPosX = var1.field_72450_a;
        this.randPosY = var1.field_72448_b;
        this.randPosZ = var1.field_72449_c;
        return true;
    }
    
    public void func_75249_e() {
        this.theEntityCreature.func_70661_as().func_75492_a(this.randPosX, this.randPosY, this.randPosZ, (double)this.speed);
    }
    
    public boolean func_75253_b() {
        return !this.theEntityCreature.func_70661_as().func_75500_f();
    }
}
