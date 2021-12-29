// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.entity.passive.EntityTFTinyBird;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAITFBirdFly extends EntityAIBase
{
    private EntityTFTinyBird entity;
    
    public EntityAITFBirdFly(final EntityTFTinyBird par1EntityCreature) {
        this.entity = par1EntityCreature;
        this.func_75248_a(5);
    }
    
    public boolean func_75250_a() {
        return !this.entity.isBirdLanded();
    }
    
    public boolean func_75253_b() {
        return !this.entity.isBirdLanded();
    }
}
