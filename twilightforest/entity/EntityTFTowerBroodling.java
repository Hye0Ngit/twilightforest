// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFTowerBroodling extends EntityTFSwarmSpider
{
    public EntityTFTowerBroodling(final zv world) {
        this(world, true);
    }
    
    public EntityTFTowerBroodling(final zv world, final boolean spawnMore) {
        super(world, spawnMore);
        this.be = 3;
        this.aH = "/mods/twilightforest/textures/model/towerbroodling.png";
    }
    
    @Override
    public int aW() {
        return 7;
    }
    
    @Override
    public int c(final mp par1Entity) {
        return (!this.F && this.ab.nextInt(2) == 0) ? 4 : 2;
    }
    
    @Override
    protected boolean spawnAnother() {
        final EntityTFSwarmSpider another = new EntityTFTowerBroodling(this.q, false);
        final double sx = this.u + (this.ab.nextBoolean() ? 0.9 : -0.9);
        final double sy = this.v;
        final double sz = this.w + (this.ab.nextBoolean() ? 0.9 : -0.9);
        another.b(sx, sy, sz, this.ab.nextFloat() * 360.0f, 0.0f);
        if (!another.bv()) {
            another.w();
            return false;
        }
        this.q.d((mp)another);
        return true;
    }
}
