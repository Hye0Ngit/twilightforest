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
        final oe attackTarget = this.me.m();
        return attackTarget != null && this.me.getTntLeft() > 0 && this.me.e((nm)attackTarget) < 25.0 && !this.isTargetLookingAtMe(attackTarget) && !this.isLitTNTNearby(8) && this.findBlockTNTNearby(5) == null;
    }
    
    public void c() {
        final int entityPosX = lr.c(this.me.u);
        final int entityPosY = lr.c(this.me.v);
        final int entityPosZ = lr.c(this.me.w);
        this.me.c(0, EntityTFRedcap.heldTNT);
        if (this.me.q.c(entityPosX, entityPosY, entityPosZ)) {
            this.me.setTntLeft(this.me.getTntLeft() - 1);
            this.me.p();
            this.me.q.f(entityPosX, entityPosY, entityPosZ, aqw.ar.cF, 0, 3);
        }
    }
    
    public void d() {
        this.me.c(0, this.me.getPick());
    }
}
