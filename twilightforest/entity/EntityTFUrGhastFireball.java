// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFUrGhastFireball extends sr
{
    public EntityTFUrGhastFireball(final zv worldObj, final EntityTFUrGhast entityTFTowerBoss, final double x, final double y, final double z) {
        super(worldObj, (ng)entityTFTowerBoss, x, y, z);
    }
    
    protected void a(final aqu par1MovingObjectPosition) {
        if (!this.q.I && !(par1MovingObjectPosition.g instanceof so)) {
            if (par1MovingObjectPosition.g != null) {
                par1MovingObjectPosition.g.a(mg.a((so)this, (mp)this.a), 16);
            }
            this.q.a((mp)null, this.u, this.v, this.w, (float)this.e, true, this.q.M().b("mobGriefing"));
            this.w();
        }
    }
}
