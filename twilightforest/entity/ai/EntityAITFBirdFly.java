// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.entity.passive.EntityTFTinyBird;

public class EntityAITFBirdFly extends pr
{
    private EntityTFTinyBird entity;
    
    public EntityAITFBirdFly(final EntityTFTinyBird par1EntityCreature) {
        this.entity = par1EntityCreature;
        this.a(5);
    }
    
    public boolean a() {
        return !this.entity.isBirdLanded();
    }
    
    public boolean b() {
        return !this.entity.isBirdLanded();
    }
}
