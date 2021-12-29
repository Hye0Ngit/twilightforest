// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFLichBolt extends bj
{
    public EntityTFLichBolt(final ge par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityTFLichBolt(final ge par1World, final ne par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public EntityTFLichBolt(final ge par1World) {
        super(par1World);
    }
    
    protected float c() {
        return 0.5f;
    }
    
    public void F_() {
        super.F_();
        this.makeTrail();
    }
    
    public void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.bm + 0.5 * (this.bS.nextDouble() - this.bS.nextDouble());
            final double dy = this.bn + 0.5 * (this.bS.nextDouble() - this.bS.nextDouble());
            final double dz = this.bo + 0.5 * (this.bS.nextDouble() - this.bS.nextDouble());
            final double s1 = (this.bS.nextFloat() * 0.5f + 0.5f) * 0.17f;
            final double s2 = (this.bS.nextFloat() * 0.5f + 0.5f) * 0.8f;
            final double s3 = (this.bS.nextFloat() * 0.5f + 0.5f) * 0.69f;
            this.bi.a("mobSpell", dx, dy, dz, s1, s2, s3);
        }
    }
    
    public boolean o_() {
        return true;
    }
    
    public float j_() {
        return 1.0f;
    }
    
    public boolean a(final rq damagesource, final int i) {
        System.out.println("Lich bolt being attacked!");
        this.aW();
        if (damagesource.a() != null) {
            final cj vec3d = damagesource.a().aJ();
            if (vec3d != null) {
                this.a(vec3d.a, vec3d.b, vec3d.c, 1.5f, 0.1f);
            }
            if (damagesource.a() instanceof ne) {
                this.c = (ne)damagesource.a();
            }
            return true;
        }
        return false;
    }
    
    protected float e() {
        return 0.0f;
    }
    
    protected void a(final wu par1MovingObjectPosition) {
        boolean passThrough = false;
        if (par1MovingObjectPosition.g != null && par1MovingObjectPosition.g instanceof EntityTFLichBolt) {
            passThrough = true;
        }
        if (par1MovingObjectPosition.g != null && par1MovingObjectPosition.g instanceof ne) {
            if (par1MovingObjectPosition.g instanceof EntityTFLich) {
                final EntityTFLich lich = (EntityTFLich)par1MovingObjectPosition.g;
                if (lich.isShadowClone()) {
                    passThrough = true;
                }
            }
            if (passThrough || par1MovingObjectPosition.g.a(rq.b((tv)this, (tv)this.c), 6)) {}
        }
        if (!passThrough) {
            for (int i = 0; i < 8; ++i) {
                this.bi.a("iconcrack_" + id.bm.bP, this.bm, this.bn, this.bo, this.bS.nextGaussian() * 0.05, this.bS.nextDouble() * 0.2, this.bS.nextGaussian() * 0.05);
            }
            if (!this.bi.F) {
                this.X();
            }
        }
    }
}
