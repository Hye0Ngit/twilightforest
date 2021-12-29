// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.entity.EntityTFGoblinKnightUpper;
import twilightforest.entity.EntityTFGoblinKnightLower;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAITFRiderSpearAttack extends EntityAIBase
{
    private EntityTFGoblinKnightLower entity;
    
    public EntityAITFRiderSpearAttack(final EntityTFGoblinKnightLower lowerKnight) {
        this.entity = lowerKnight;
        this.func_75248_a(3);
    }
    
    public boolean func_75250_a() {
        if (!this.entity.func_184188_bt().isEmpty() && this.entity.func_184188_bt().get(0) instanceof EntityTFGoblinKnightUpper) {
            final int timer = this.entity.func_184188_bt().get(0).heavySpearTimer;
            return timer > 0 && timer < 60;
        }
        return false;
    }
}
