// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.particle;

public class EntityTFLeafRuneFX extends bdq
{
    public EntityTFLeafRuneFX(final abv world, final double x, final double y, final double z, final double velX, final double velY, final double velZ) {
        super(world, x, y, z, velX, velY, velZ);
        this.h = this.ab.nextFloat() + 1.0f;
        this.g += 10;
        this.i = 0.003f + this.ab.nextFloat() * 0.006f;
        this.Z = false;
    }
    
    public void l_() {
        this.r = this.u;
        this.s = this.v;
        this.t = this.w;
        this.d(this.x, this.y, this.z);
        this.y -= this.i;
        if (this.f++ >= this.g) {
            this.w();
        }
    }
}
