// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import java.util.List;

public abstract class EntityAITFRedcapBase extends nc
{
    protected EntityTFRedcap me;
    
    public boolean isTargetLookingAtMe(final md target) {
        final double dx = this.me.t - target.t;
        final double dz = this.me.v - target.v;
        final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.141592653589793) - 90.0f;
        final float difference = ke.e((target.z - angle) % 360.0f);
        return difference < 60.0f || difference > 300.0f;
    }
    
    public s findBlockTNTNearby(final int range) {
        final int entityPosX = ke.c(this.me.t);
        final int entityPosY = ke.c(this.me.u);
        final int entityPosZ = ke.c(this.me.v);
        for (int x = -range; x <= range; ++x) {
            for (int y = -range; y <= range; ++y) {
                for (int z = -range; z <= range; ++z) {
                    if (this.me.p.a(entityPosX + x, entityPosY + y, entityPosZ + z) == amj.ap.cm) {
                        return new s(entityPosX + x, entityPosY + y, entityPosZ + z);
                    }
                }
            }
        }
        return null;
    }
    
    public boolean isLitTNTNearby(final int range) {
        final anw expandedBox = this.me.D.b((double)range, (double)range, (double)range);
        final List nearbyTNT = this.me.p.a((Class)pz.class, expandedBox);
        return nearbyTNT.size() > 0;
    }
}
