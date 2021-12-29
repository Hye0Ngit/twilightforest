// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFUrGhastFireball extends ul
{
    public EntityTFUrGhastFireball(final abv worldObj, final EntityTFUrGhast entityTFTowerBoss, final double x, final double y, final double z) {
        super(worldObj, (oe)entityTFTowerBoss, x, y, z);
    }
    
    protected void a(final asx par1MovingObjectPosition) {
        if (!this.q.I && !(par1MovingObjectPosition.g instanceof ui)) {
            if (par1MovingObjectPosition.g != null) {
                par1MovingObjectPosition.g.a(na.a((ui)this, (nm)this.a), 16.0f);
            }
            this.q.a((nm)null, this.u, this.v, this.w, (float)this.e, true, this.q.O().b("mobGriefing"));
            this.w();
        }
    }
}
