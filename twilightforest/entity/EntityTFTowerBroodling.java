// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

public class EntityTFTowerBroodling extends EntityTFSwarmSpider
{
    public EntityTFTowerBroodling(final abv world) {
        this(world, true);
    }
    
    public EntityTFTowerBroodling(final abv world, final boolean spawnMore) {
        super(world, spawnMore);
        this.b = 3;
    }
    
    @Override
    protected void ay() {
        super.ay();
        this.a(to.a).a(7.0);
        this.a(to.e).a(4.0);
    }
    
    @Override
    protected boolean spawnAnother() {
        final EntityTFSwarmSpider another = new EntityTFTowerBroodling(this.q, false);
        final double sx = this.u + (this.ab.nextBoolean() ? 0.9 : -0.9);
        final double sy = this.v;
        final double sz = this.w + (this.ab.nextBoolean() ? 0.9 : -0.9);
        another.b(sx, sy, sz, this.ab.nextFloat() * 360.0f, 0.0f);
        if (!another.bs()) {
            another.w();
            return false;
        }
        this.q.d((nm)another);
        return true;
    }
}
