// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

public class EntityTFLichBolt extends av
{
    public EntityTFLichBolt(final xd par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }
    
    public EntityTFLichBolt(final xd par1World, final acq par2EntityLiving) {
        super(par1World, par2EntityLiving);
    }
    
    public EntityTFLichBolt(final xd par1World) {
        super(par1World);
    }
    
    protected float c() {
        return 0.5f;
    }
    
    public void J_() {
        super.J_();
        this.makeTrail();
    }
    
    public void makeTrail() {
        for (int i = 0; i < 5; ++i) {
            final double dx = this.o + 0.5 * (this.U.nextDouble() - this.U.nextDouble());
            final double dy = this.p + 0.5 * (this.U.nextDouble() - this.U.nextDouble());
            final double dz = this.q + 0.5 * (this.U.nextDouble() - this.U.nextDouble());
            final double s1 = (this.U.nextFloat() * 0.5f + 0.5f) * 0.17f;
            final double s2 = (this.U.nextFloat() * 0.5f + 0.5f) * 0.8f;
            final double s3 = (this.U.nextFloat() * 0.5f + 0.5f) * 0.69f;
            this.k.a("mobSpell", dx, dy, dz, s1, s2, s3);
        }
    }
    
    public boolean l_() {
        return true;
    }
    
    public float j_() {
        return 1.0f;
    }
    
    public boolean a(final md damagesource, final int i) {
        System.out.println("Lich bolt being attacked!");
        this.K();
        if (damagesource.a() != null) {
            final bo vec3d = damagesource.a().Q();
            if (vec3d != null) {
                this.a(vec3d.a, vec3d.b, vec3d.c, 1.5f, 0.1f);
            }
            if (damagesource.a() instanceof acq) {
                this.c = (acq)damagesource.a();
            }
            return true;
        }
        return false;
    }
    
    protected float e() {
        return 0.0f;
    }
    
    protected void a(final pl par1MovingObjectPosition) {
        boolean passThrough = false;
        if (par1MovingObjectPosition.g != null && par1MovingObjectPosition.g instanceof EntityTFLichBolt) {
            passThrough = true;
        }
        if (par1MovingObjectPosition.g != null && par1MovingObjectPosition.g instanceof acq) {
            if (par1MovingObjectPosition.g instanceof EntityTFLich) {
                final EntityTFLich lich = (EntityTFLich)par1MovingObjectPosition.g;
                if (lich.isShadowClone()) {
                    passThrough = true;
                }
            }
            if (passThrough || par1MovingObjectPosition.g.a(md.b((nn)this, (nn)this.c), 6)) {}
        }
        if (!passThrough) {
            for (int i = 0; i < 8; ++i) {
                this.k.a("iconcrack_" + yr.bn.bQ, this.o, this.p, this.q, this.U.nextGaussian() * 0.05, this.U.nextDouble() * 0.2, this.U.nextGaussian() * 0.05);
            }
            if (!this.k.F) {
                this.A();
            }
        }
    }
}
