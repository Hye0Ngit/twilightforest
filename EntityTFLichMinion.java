import java.util.Iterator;
import java.util.List;

// 
// Decompiled by Procyon v0.6-prerelease
// 

public class EntityTFLichMinion extends wl
{
    EntityTFLich master;
    
    public EntityTFLichMinion(final ge par1World) {
        super(par1World);
        this.master = null;
    }
    
    public EntityTFLichMinion(final ge world, final double x, final double y, final double z) {
        this(world);
        this.c(x, y, z);
    }
    
    public EntityTFLichMinion(final ge par1World, final EntityTFLich entityTFLich) {
        super(par1World);
        this.master = entityTFLich;
    }
    
    public boolean a(final rq par1DamageSource, final int par2) {
        final ne prevTarget = this.at();
        if (super.a(par1DamageSource, par2)) {
            if (par1DamageSource.a() instanceof EntityTFLich) {
                this.b(prevTarget);
                this.a(prevTarget);
                this.e(new zv(kf.c.H, 200, 4));
                this.e(new zv(kf.g.H, 200, 1));
            }
            return true;
        }
        return false;
    }
    
    public void e() {
        if (this.master == null) {
            this.findNewMaster();
        }
        if (this.master == null || this.master.bE) {
            this.ap = 0;
        }
        super.e();
    }
    
    private void findNewMaster() {
        final List nearbyLiches = this.bi.a((Class)EntityTFLich.class, fp.b(this.bm, this.bn, this.bo, this.bm + 1.0, this.bn + 1.0, this.bo + 1.0).b(32.0, 16.0, 32.0));
        for (final EntityTFLich nearbyLich : nearbyLiches) {
            if (!nearbyLich.isShadowClone() && nearbyLich.wantsNewMinion(this)) {
                (this.master = nearbyLich).makeBlackMagicTrail(this.bm, this.bn + this.B(), this.bo, this.master.bm, this.master.bn + this.master.B(), this.master.bo);
                this.b(this.master.at());
                break;
            }
        }
    }
    
    public void a(final rq par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.b() instanceof ih) {
            ((ih)par1DamageSource.b()).a((xo)TFAchievementPage.twilightHunter);
        }
    }
}
