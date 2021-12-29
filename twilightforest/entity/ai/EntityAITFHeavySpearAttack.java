// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.entity.EntityTFGoblinKnightUpper;

public class EntityAITFHeavySpearAttack extends pr
{
    private EntityTFGoblinKnightUpper entity;
    
    public EntityAITFHeavySpearAttack(final EntityTFGoblinKnightUpper par1EntityCreature) {
        this.entity = par1EntityCreature;
        this.a(7);
    }
    
    public boolean a() {
        return this.entity.heavySpearTimer > 0 && this.entity.heavySpearTimer < 50;
    }
    
    public boolean b() {
        return this.entity.heavySpearTimer > 0 && this.entity.heavySpearTimer < 50;
    }
}
