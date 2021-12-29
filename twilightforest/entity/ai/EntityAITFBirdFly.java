// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.entity.passive.EntityTFTinyBird;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAITFBirdFly extends EntityAIBase
{
    private EntityTFTinyBird entity;
    
    public EntityAITFBirdFly(final EntityTFTinyBird bird) {
        this.entity = bird;
        this.func_75248_a(5);
    }
    
    public boolean func_75250_a() {
        return !this.entity.isBirdLanded();
    }
}
