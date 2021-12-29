// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import twilightforest.entity.EntityTFRedcap;

public class EntityAITFRedcapPlantTNT extends EntityAITFRedcapBase
{
    public EntityAITFRedcapPlantTNT(final EntityTFRedcap entityTFRedcap) {
        this.me = entityTFRedcap;
    }
    
    public boolean a() {
        final ng attackTarget = this.me.aJ();
        return attackTarget != null && this.me.getTntLeft() > 0 && this.me.e((mp)attackTarget) < 25.0 && !this.isTargetLookingAtMe(attackTarget) && !this.isLitTNTNearby(8) && this.findBlockTNTNearby(5) == null;
    }
    
    public void c() {
        final int entityPosX = kx.c(this.me.u);
        final int entityPosY = kx.c(this.me.v);
        final int entityPosZ = kx.c(this.me.w);
        this.me.c(0, EntityTFRedcap.heldTNT);
        if (this.me.q.c(entityPosX, entityPosY, entityPosZ)) {
            this.me.setTntLeft(this.me.getTntLeft() - 1);
            this.me.aR();
            this.me.q.f(entityPosX, entityPosY, entityPosZ, aou.aq.cz, 0, 3);
        }
    }
    
    public void d() {
        this.me.c(0, this.me.getPick());
    }
}
