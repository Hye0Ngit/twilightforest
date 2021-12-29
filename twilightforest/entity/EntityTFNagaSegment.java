// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;

public class EntityTFNagaSegment extends nm
{
    EntityTFNaga naga;
    int segment;
    String texture;
    private int deathCounter;
    
    public EntityTFNagaSegment(final abv par1World) {
        super(par1World);
        this.a(1.8f, 1.8f);
        this.Y = 2.0f;
    }
    
    public EntityTFNagaSegment(final EntityTFNaga myNaga, final int segNum) {
        this(myNaga.b());
        this.naga = myNaga;
        this.segment = segNum;
    }
    
    public boolean a(final na damagesource, final float damage) {
        return !damagesource.c() && !damagesource.m() && this.naga != null && this.naga.a(damagesource, (float)Math.round(damage * 2.0f / 3.0f));
    }
    
    public void l_() {
        super.l_();
        if (this.naga == null || this.naga.M) {
            this.w();
        }
        ++this.ac;
        this.U = this.u;
        this.V = this.v;
        this.W = this.w;
        while (this.A - this.C < -180.0f) {
            this.C -= 360.0f;
        }
        while (this.A - this.C >= 180.0f) {
            this.C += 360.0f;
        }
        while (this.B - this.D < -180.0f) {
            this.D -= 360.0f;
        }
        while (this.B - this.D >= 180.0f) {
            this.D += 360.0f;
        }
        if (!this.F) {
            this.y -= 0.08;
        }
        else {
            this.x *= 0.800000011920929;
            this.z *= 0.800000011920929;
        }
        this.d(this.x, this.y, this.z);
        this.collideWithOthers();
        if (this.deathCounter > 0) {
            --this.deathCounter;
            if (this.deathCounter == 0) {
                for (int k = 0; k < 20; ++k) {
                    final double d = this.ab.nextGaussian() * 0.02;
                    final double d2 = this.ab.nextGaussian() * 0.02;
                    final double d3 = this.ab.nextGaussian() * 0.02;
                    final String explosionType = this.ab.nextBoolean() ? "largeexplode" : "explode";
                    this.q.a(explosionType, this.u + this.ab.nextFloat() * this.O * 2.0f - this.O, this.v + this.ab.nextFloat() * this.P, this.w + this.ab.nextFloat() * this.O * 2.0f - this.O, d, d2, d3);
                }
                this.w();
                this.q.e((nm)this);
            }
        }
    }
    
    protected void collideWithOthers() {
        final List list = this.q.b((nm)this, this.E.b(0.20000000298023224, 0.0, 0.20000000298023224));
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); ++i) {
                final nm entity = list.get(i);
                if (entity.L()) {
                    this.collideWithEntity(entity);
                }
            }
        }
    }
    
    private void collideWithEntity(final nm entity) {
        entity.f((nm)this);
        if (entity instanceof oe && !(entity instanceof EntityTFNaga) && !(entity instanceof EntityTFNagaSegment)) {
            this.naga.aC = 10;
            int attackStrength = 2;
            if (entity instanceof ro) {
                attackStrength *= 3;
            }
            entity.a(na.a((oe)this.naga), (float)attackStrength);
        }
    }
    
    public void b(final float par1, final float par2) {
        this.A = lr.g(par1 % 360.0f);
        this.B = par2 % 360.0f;
    }
    
    public boolean K() {
        return true;
    }
    
    public boolean L() {
        return false;
    }
    
    public boolean h(final nm entity) {
        return this == entity || this.naga == entity;
    }
    
    protected void a() {
    }
    
    protected void a(final bx nbttagcompound) {
    }
    
    protected void b(final bx nbttagcompound) {
    }
    
    protected void a(final int par1, final int par2, final int par3, final int par4) {
    }
    
    @SideOnly(Side.CLIENT)
    public String getTexture() {
        return this.texture;
    }
    
    public void selfDestruct() {
        this.deathCounter = 30;
    }
}
