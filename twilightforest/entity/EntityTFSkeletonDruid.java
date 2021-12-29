// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.entity;

import twilightforest.TFAchievementPage;
import twilightforest.item.TFItems;

public class EntityTFSkeletonDruid extends rv implements rx
{
    public EntityTFSkeletonDruid(final zv world) {
        super(world);
        this.aH = "/mods/twilightforest/textures/model/skeletondruid.png";
        this.bI = 0.25f;
        this.bo.a(1, (og)new od((ng)this));
        this.bo.a(2, (og)new pd((nl)this));
        this.bo.a(3, (og)new oc((nl)this, this.bI));
        this.bo.a(4, (og)new pb((rx)this, this.bI, 60, 10.0f));
        this.bo.a(5, (og)new pa((nl)this, this.bI));
        this.bo.a(6, (og)new ol((ng)this, (Class)sk.class, 8.0f));
        this.bo.a(6, (og)new oz((ng)this));
        this.bp.a(1, (og)new pk((ng)this, false));
        this.bp.a(2, (og)new pl((ng)this, (Class)sk.class, 16.0f, 0, true));
        this.c(0, new wg(we.S));
    }
    
    public boolean bh() {
        return true;
    }
    
    public int aW() {
        return 20;
    }
    
    protected String bb() {
        return "mob.skeleton.say";
    }
    
    protected String bc() {
        return "mob.skeleton.hurt";
    }
    
    protected String bd() {
        return "mob.skeleton.death";
    }
    
    protected void a(final int par1, final int par2, final int par3, final int par4) {
        this.a("mob.skeleton.step", 0.15f, 1.0f);
    }
    
    protected int be() {
        return TFItems.torchberries.cp;
    }
    
    protected void a(final boolean par1, final int lootingModifier) {
        for (int numberOfItemsToDrop = this.ab.nextInt(3 + lootingModifier), i = 0; i < numberOfItemsToDrop; ++i) {
            this.b(TFItems.torchberries.cp, 1);
        }
        for (int numberOfItemsToDrop = this.ab.nextInt(3 + lootingModifier), i = 0; i < numberOfItemsToDrop; ++i) {
            this.b(we.aY.cp, 1);
        }
    }
    
    public ni bF() {
        return ni.b;
    }
    
    public void a(final mg par1DamageSource) {
        super.a(par1DamageSource);
        if (par1DamageSource.h() instanceof sk) {
            ((sk)par1DamageSource.h()).a((ka)TFAchievementPage.twilightHunter);
        }
    }
    
    public void a(final ng attackTarget, final float extraDamage) {
        final EntityTFNatureBolt natureBolt = new EntityTFNatureBolt(this.q, (ng)this);
        this.q.a((mp)this, "mob.ghast.fireball", 1.0f, 1.0f / (this.ab.nextFloat() * 0.4f + 0.8f));
        natureBolt.setTarget(attackTarget);
        final double tx = attackTarget.u - this.u;
        final double ty = attackTarget.v + attackTarget.e() - 2.699999988079071 - this.v;
        final double tz = attackTarget.w - this.w;
        final float heightOffset = kx.a(tx * tx + tz * tz) * 0.2f;
        natureBolt.c(tx, ty + heightOffset, tz, 0.6f, 6.0f);
        this.q.d((mp)natureBolt);
    }
}
