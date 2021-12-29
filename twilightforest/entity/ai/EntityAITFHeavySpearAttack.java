// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.entity.EntityTFGoblinKnightUpper;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAITFHeavySpearAttack extends EntityAIBase
{
    private EntityTFGoblinKnightUpper entity;
    
    public EntityAITFHeavySpearAttack(final EntityTFGoblinKnightUpper par1EntityCreature) {
        this.entity = par1EntityCreature;
        this.func_75248_a(7);
    }
    
    public boolean func_75250_a() {
        return this.entity.heavySpearTimer > 0 && this.entity.heavySpearTimer < 50;
    }
    
    public boolean func_75253_b() {
        return this.entity.heavySpearTimer > 0 && this.entity.heavySpearTimer < 50;
    }
}
