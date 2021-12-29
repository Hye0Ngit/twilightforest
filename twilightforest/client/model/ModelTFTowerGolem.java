// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import twilightforest.entity.EntityTFTowerGolem;

public class ModelTFTowerGolem extends bbx
{
    bdc head;
    bdc jaw;
    bdc body;
    bdc rightarm;
    bdc leftarm;
    bdc leftleg;
    bdc leftfoot;
    bdc ribs;
    bdc hips;
    bdc rightfoot;
    bdc rightleg;
    bdc spine;
    
    public ModelTFTowerGolem() {
        this.t = 128;
        this.u = 64;
        (this.head = new bdc((bbx)this, 0, 0)).a(0.0f, -11.0f, -2.0f);
        this.head.a(0, 0).a(-3.5f, -10.0f, -3.0f, 7, 8, 6);
        this.head.a(0, 14).a(-4.0f, -6.0f, -3.5f, 8, 4, 6);
        (this.body = new bdc((bbx)this, 0, 26)).a(-8.0f, 0.0f, -5.0f, 16, 10, 10);
        this.body.a(0.0f, -13.0f, 0.0f);
        (this.ribs = new bdc((bbx)this, 0, 46)).a(-5.0f, 0.0f, -3.0f, 10, 6, 6);
        this.ribs.a(0.0f, -3.0f, 0.0f);
        (this.rightarm = new bdc((bbx)this, 52, 0)).a(-8.0f, -12.0f, 0.0f);
        this.rightarm.a(52, 0).a(-5.0f, -2.0f, -1.5f, 3, 14, 3);
        this.rightarm.a(52, 17).a(-7.0f, 12.0f, -3.0f, 6, 12, 6);
        this.rightarm.a(52, 36).a(-7.0f, -3.0f, -3.5f, 7, 2, 7);
        this.rightarm.a(52, 45).a(-7.0f, -1.0f, -3.5f, 7, 5, 2);
        this.rightarm.a(52, 45).a(-7.0f, -1.0f, 1.5f, 7, 5, 2);
        this.rightarm.a(52, 54).a(-2.0f, -1.0f, -2.0f, 2, 5, 3);
        this.leftarm = new bdc((bbx)this, 52, 0);
        this.leftarm.i = true;
        this.leftarm.a(8.0f, -12.0f, 0.0f);
        this.leftarm.a(52, 0).a(2.0f, -2.0f, -1.5f, 3, 14, 3);
        this.leftarm.a(52, 17).a(1.0f, 12.0f, -3.0f, 6, 12, 6);
        this.leftarm.a(52, 36).a(0.0f, -3.0f, -3.5f, 7, 2, 7);
        this.leftarm.a(52, 45).a(0.0f, -1.0f, -3.5f, 7, 5, 2);
        this.leftarm.a(52, 45).a(0.0f, -1.0f, 1.5f, 7, 5, 2);
        this.leftarm.a(52, 54).a(0.0f, -1.0f, -2.0f, 2, 5, 3);
        (this.hips = new bdc((bbx)this, 84, 25)).a(-5.0f, 0.0f, -2.0f, 10, 3, 4);
        this.hips.a(0.0f, 1.0f, 0.0f);
        (this.spine = new bdc((bbx)this, 84, 18)).a(-1.5f, 0.0f, -1.5f, 3, 4, 3);
        this.spine.a(0.0f, -3.0f, 0.0f);
        this.leftleg = new bdc((bbx)this, 84, 32);
        this.leftleg.i = true;
        this.leftleg.a(1.0f, 2.0f, 0.0f);
        this.leftleg.a(84, 32).a(0.0f, 0.0f, -1.5f, 3, 8, 3);
        this.leftleg.a(84, 43).a(-0.5f, 8.0f, -4.0f, 6, 14, 7);
        (this.rightleg = new bdc((bbx)this, 84, 32)).a(-1.0f, 2.0f, 0.0f);
        this.rightleg.a(84, 32).a(-3.0f, 0.0f, -1.5f, 3, 8, 3);
        this.rightleg.a(84, 43).a(-5.5f, 8.0f, -4.0f, 6, 14, 7);
    }
    
    public void a(final mp entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        this.a(f, f1, f2, f3, f4, f5, entity);
        this.head.a(f5);
        this.body.a(f5);
        this.rightarm.a(f5);
        this.leftarm.a(f5);
        this.rightleg.a(f5);
        this.leftleg.a(f5);
        this.ribs.a(f5);
        this.hips.a(f5);
        this.spine.a(f5);
    }
    
    private void setRotation(final bdc model, final float x, final float y, final float z) {
        model.f = x;
        model.g = y;
        model.h = z;
    }
    
    public void a(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6, final mp par7Entity) {
        this.head.g = par4 / 57.295776f;
        this.head.f = par5 / 57.295776f;
        this.leftleg.f = -1.5f * this.func_78172_a(par1, 13.0f) * par2;
        this.rightleg.f = 1.5f * this.func_78172_a(par1, 13.0f) * par2;
        this.leftleg.g = 0.0f;
        this.rightleg.g = 0.0f;
        this.rightarm.h = kx.b(par3 * 0.09f) * 0.05f + 0.05f;
        this.leftarm.h = -kx.b(par3 * 0.09f) * 0.05f - 0.05f;
    }
    
    public void a(final ng par1EntityLiving, final float par2, final float par3, final float par4) {
        final EntityTFTowerGolem var5 = (EntityTFTowerGolem)par1EntityLiving;
        final int var6 = var5.getAttackTimer();
        if (var6 > 0) {
            this.rightarm.f = -2.0f + 1.5f * this.func_78172_a(var6 - par4, 10.0f);
            this.leftarm.f = -2.0f + 1.5f * this.func_78172_a(var6 - par4, 10.0f);
        }
        else {
            this.rightarm.f = (-0.2f + 1.5f * this.func_78172_a(par2, 25.0f)) * par3;
            this.leftarm.f = (-0.2f - 1.5f * this.func_78172_a(par2, 25.0f)) * par3;
        }
    }
    
    private float func_78172_a(final float par1, final float par2) {
        return (Math.abs(par1 % par2 - par2 * 0.5f) - par2 * 0.25f) / (par2 * 0.25f);
    }
}
