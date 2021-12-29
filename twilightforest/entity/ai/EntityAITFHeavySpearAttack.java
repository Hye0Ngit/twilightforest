// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.entity.EntityTFGoblinKnightUpper;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAITFHeavySpearAttack extends EntityAIBase
{
    private EntityTFGoblinKnightUpper entity;
    
    public EntityAITFHeavySpearAttack(final EntityTFGoblinKnightUpper upperKnight) {
        this.entity = upperKnight;
        this.func_75248_a(3);
    }
    
    public void func_75246_d() {
        if (this.entity.heavySpearTimer == 25) {
            this.entity.landHeavySpearAttack();
        }
    }
    
    public boolean func_75250_a() {
        return this.entity.heavySpearTimer > 0 && this.entity.heavySpearTimer < 60;
    }
}
