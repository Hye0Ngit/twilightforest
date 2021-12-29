// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityAITFRedcapPlantTNT extends EntityAITFRedcapBase
{
    public EntityAITFRedcapPlantTNT(final EntityTFRedcap entityTFRedcap) {
        this.me = entityTFRedcap;
    }
    
    public boolean a() {
        final md attackTarget = this.me.aG();
        return attackTarget != null && this.me.getTntLeft() > 0 && this.me.e((lq)attackTarget) < 25.0 && !this.isTargetLookingAtMe(attackTarget) && !this.isLitTNTNearby(8) && this.findBlockTNTNearby(5) == null;
    }
    
    public boolean i() {
        return false;
    }
    
    public void c() {
        final int entityPosX = ke.c(this.me.t);
        final int entityPosY = ke.c(this.me.u);
        final int entityPosZ = ke.c(this.me.v);
        final EntityTFRedcap me = this.me;
        final int n = 0;
        final EntityTFRedcap me2 = this.me;
        me.b(n, EntityTFRedcap.heldTNT);
        if (this.me.p.c(entityPosX, entityPosY, entityPosZ)) {
            this.me.setTntLeft(this.me.getTntLeft() - 1);
            this.me.aO();
            this.me.p.e(entityPosX, entityPosY, entityPosZ, amj.ap.cm);
        }
    }
    
    public void d() {
        this.me.b(0, this.me.getPick());
    }
}
