// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.entity.ai.EntityAITFFlockToSameKind;
import twilightforest.entity.ai.EntityAITFPanicOnFlockDeath;

public class EntityTFKobold extends rv
{
    private boolean shy;
    
    public EntityTFKobold(final zv world) {
        super(world);
        this.aH = "/mods/twilightforest/textures/model/kobold.png";
        this.bI = 0.28f;
        this.a(0.8f, 1.1f);
        this.shy = true;
        this.bo.a(0, (og)new od((ng)this));
        this.bo.a(1, (og)new EntityAITFPanicOnFlockDeath((nl)this, 0.38f));
        this.bo.a(2, (og)new ok((ng)this, 0.28f));
        this.bo.a(3, (og)new oo((ng)this, (Class)sk.class, this.bI, false));
        this.bo.a(4, (og)new EntityAITFFlockToSameKind((ng)this, this.bI));
        this.bo.a(6, (og)new pa((nl)this, this.bI));
        this.bo.a(7, (og)new ol((ng)this, (Class)sk.class, 8.0f));
        this.bo.a(7, (og)new oz((ng)this));
        this.bp.a(1, (og)new pk((ng)this, true));
        this.bp.a(2, (og)new pl((ng)this, (Class)sk.class, 16.0f, 0, true));
    }
    
    public EntityTFKobold(final zv world, final double x, final double y, final double z) {
        this(world);
        this.b(x, y, z);
    }
    
    protected void a() {
        super.a();
        this.ah.a(17, (Object)0);
    }
    
    protected boolean bh() {
        return true;
    }
    
    public int aW() {
        return 13;
    }
    
    protected String bb() {
        return "mob.tf.kobold.kobold";
    }
    
    protected String bc() {
        return "mob.tf.kobold.hurt";
    }
    
    protected String bd() {
        return "mob.tf.kobold.die";
    }
    
    protected int be() {
        return we.U.cp;
    }
    
    protected void a(final boolean flag, final int i) {
        super.a(flag, i);
        if (this.ab.nextInt(2) == 0) {
            this.b(we.br.cp, 1 + i);
        }
    }
    
    public boolean isShy() {
        return this.shy && this.bl <= 0;
    }
    
    public boolean isPanicked() {
        return this.ah.a(17) != 0;
    }
    
    public void setPanicked(final boolean flag) {
        if (flag) {
            this.ah.b(17, (Object)127);
        }
        else {
            this.ah.b(17, (Object)0);
        }
    }
    
    public void c() {
        super.c();
        if (this.isPanicked()) {
            for (int i = 0; i < 2; ++i) {
                this.q.a("splash", this.u + (this.ab.nextDouble() - 0.5) * this.O * 0.5, this.v + this.e(), this.w + (this.ab.nextDouble() - 0.5) * this.O * 0.5, 0.0, 0.0, 0.0);
            }
        }
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
        }
    }
    
    public int by() {
        return 8;
    }
    
    public int c(final mp par1Entity) {
        return 3;
    }
}
