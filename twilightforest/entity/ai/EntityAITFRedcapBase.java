// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity.ai;

import java.util.List;
import twilightforest.entity.EntityTFRedcap;

public abstract class EntityAITFRedcapBase extends pr
{
    protected EntityTFRedcap me;
    
    public boolean isTargetLookingAtMe(final oe attackTarget) {
        final double dx = this.me.u - attackTarget.u;
        final double dz = this.me.w - attackTarget.w;
        final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.141592653589793) - 90.0f;
        final float difference = lr.e((attackTarget.A - angle) % 360.0f);
        return difference < 60.0f || difference > 300.0f;
    }
    
    public t findBlockTNTNearby(final int range) {
        final int entityPosX = lr.c(this.me.u);
        final int entityPosY = lr.c(this.me.v);
        final int entityPosZ = lr.c(this.me.w);
        for (int x = -range; x <= range; ++x) {
            for (int y = -range; y <= range; ++y) {
                for (int z = -range; z <= range; ++z) {
                    if (this.me.q.a(entityPosX + x, entityPosY + y, entityPosZ + z) == aqw.ar.cF) {
                        return new t(entityPosX + x, entityPosY + y, entityPosZ + z);
                    }
                }
            }
        }
        return null;
    }
    
    public boolean isLitTNTNearby(final int range) {
        final asu expandedBox = this.me.E.b((double)range, (double)range, (double)range);
        final List nearbyTNT = this.me.q.a((Class)tb.class, expandedBox);
        return nearbyTNT.size() > 0;
    }
}
