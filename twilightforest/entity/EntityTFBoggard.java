// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFFeature;
import twilightforest.TFAchievementPage;
import twilightforest.item.TFItems;
import twilightforest.entity.ai.EntityAITFChargeAttack;

public class EntityTFBoggard extends rv
{
    private boolean shy;
    
    public EntityTFBoggard(final zv world) {
        super(world);
        this.aH = "/mob/pigzombie.png";
        this.bI = 0.28f;
        this.a(0.8f, 1.1f);
        this.shy = true;
        this.bo.a(0, (og)new od((ng)this));
        this.bo.a(2, (og)new EntityAITFChargeAttack((ng)this, 0.55f));
        this.bo.a(3, (og)new oo((ng)this, (Class)sk.class, this.bI, false));
        this.bo.a(6, (og)new pa((nl)this, this.bI));
        this.bo.a(7, (og)new ol((ng)this, (Class)sk.class, 8.0f));
        this.bo.a(7, (og)new oz((ng)this));
        this.bp.a(1, (og)new pk((ng)this, false));
        this.bp.a(2, (og)new pl((ng)this, (Class)sk.class, 16.0f, 0, false));
    }
    
    public EntityTFBoggard(final zv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected boolean bh() {
        return true;
    }
    
    public int aW() {
        return 14;
    }
    
    protected String bb() {
        return "mob.tf.redcap.redcap";
    }
    
    protected String bc() {
        return "mob.tf.redcap.hurt";
    }
    
    protected String bd() {
        return "mob.tf.redcap.die";
    }
    
    protected int be() {
        return we.ah.cp;
    }
    
    protected void a(final boolean flag, final int i) {
        if (this.ab.nextInt(5) == 0) {
            this.b(TFItems.mazeMapFocus.cp, 1 + i);
        }
        if (this.ab.nextInt(6) == 0) {
            this.b(we.ah.cp, 1 + i);
        }
        if (this.ab.nextInt(9) == 0) {
            this.b(we.h.cp, 1 + i);
        }
    }
    
    public boolean isShy() {
        return this.shy && this.bl <= 0;
    }
    
    public boolean isTargetLookingAtMe() {
        final double dx = this.u - this.a_.u;
        final double dz = this.w - this.a_.w;
        final float angle = (float)(Math.atan2(dz, dx) * 180.0 / 3.1415927410125732) - 90.0f;
        final float difference = kx.e((this.a_.A - angle) % 360.0f);
        return difference < 60.0f || difference > 300.0f;
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
            final int chunkX = kx.c(this.u) >> 4;
            final int chunkZ = kx.c(this.w) >> 4;
            if (TFFeature.getNearestFeature(chunkX, chunkZ, this.q) == TFFeature.hill1) {
                ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHill1);
            }
        }
    }
    
    public void e(final float par1, final float par2) {
        super.e(par1, par2);
    }
}
