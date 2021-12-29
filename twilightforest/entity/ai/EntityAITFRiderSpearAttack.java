// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.entity.EntityTFGoblinKnightUpper;
import twilightforest.entity.EntityTFGoblinKnightLower;

public class EntityAITFRiderSpearAttack extends pr
{
    private EntityTFGoblinKnightLower entity;
    
    public EntityAITFRiderSpearAttack(final EntityTFGoblinKnightLower par1EntityCreature) {
        this.entity = par1EntityCreature;
        this.a(7);
    }
    
    public boolean a() {
        return this.isRiderDoingSpearAttack();
    }
    
    public boolean isRiderDoingSpearAttack() {
        if (this.entity.n != null && this.entity.n instanceof EntityTFGoblinKnightUpper) {
            final int timer = ((EntityTFGoblinKnightUpper)this.entity.n).heavySpearTimer;
            return timer > 0 && timer < 50;
        }
        return false;
    }
    
    public boolean b() {
        return this.isRiderDoingSpearAttack();
    }
}
