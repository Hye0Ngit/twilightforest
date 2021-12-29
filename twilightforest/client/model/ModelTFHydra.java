// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import twilightforest.entity.boss.EntityTFHydraPart;
import twilightforest.entity.boss.EntityTFHydra;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFHydra extends ModelBase
{
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer tail4;
    ModelRenderer neck1a;
    ModelRenderer neck1b;
    ModelRenderer neck1c;
    ModelRenderer neck1d;
    ModelRenderer head1;
    ModelRenderer jaw1;
    ModelRenderer frill1;
    ModelRenderer neck2a;
    ModelRenderer neck2b;
    ModelRenderer neck2c;
    ModelRenderer neck2d;
    ModelRenderer head2;
    ModelRenderer jaw2;
    ModelRenderer frill2;
    ModelRenderer neck3a;
    ModelRenderer neck3b;
    ModelRenderer neck3c;
    ModelRenderer neck3d;
    ModelRenderer head3;
    ModelRenderer jaw3;
    ModelRenderer frill3;
    
    public ModelTFHydra() {
        this.field_78090_t = 512;
        this.field_78089_u = 256;
        this.func_78085_a("body.body", 0, 0);
        this.func_78085_a("leg.main", 0, 136);
        this.func_78085_a("leg.toe", 184, 200);
        this.func_78085_a("tail.box", 128, 136);
        this.func_78085_a("tail.fin", 128, 200);
        this.func_78085_a("neck.box", 128, 136);
        this.func_78085_a("neck.fin", 128, 200);
        this.func_78085_a("head.box", 272, 0);
        this.func_78085_a("head.upperlip", 272, 56);
        this.func_78085_a("head.fin", 128, 200);
        this.func_78085_a("jaw.jaw", 272, 92);
        this.func_78085_a("frill.frill", 272, 200);
        (this.body = new ModelRenderer((ModelBase)this, "body")).func_78793_a(0.0f, -12.0f, 0.0f);
        this.body.func_78786_a("body", -48.0f, 0.0f, 0.0f, 96, 96, 40);
        this.setRotation(this.body, 1.22173f, 0.0f, 0.0f);
        (this.leg1 = new ModelRenderer((ModelBase)this, "leg")).func_78793_a(48.0f, -24.0f, 0.0f);
        this.leg1.func_78786_a("main", -16.0f, 0.0f, -16.0f, 32, 48, 32);
        this.leg1.func_78786_a("toe", -20.0f, 40.0f, -20.0f, 8, 8, 8);
        this.leg1.func_78786_a("toe", -4.0f, 40.0f, -22.0f, 8, 8, 8);
        this.leg1.func_78786_a("toe", 12.0f, 40.0f, -20.0f, 8, 8, 8);
        (this.leg2 = new ModelRenderer((ModelBase)this, "leg")).func_78793_a(-48.0f, -24.0f, 0.0f);
        this.leg2.field_78809_i = true;
        this.leg2.func_78786_a("main", -16.0f, 0.0f, -16.0f, 32, 48, 32);
        this.leg2.func_78786_a("toe", -20.0f, 40.0f, -20.0f, 8, 8, 8);
        this.leg2.func_78786_a("toe", -4.0f, 40.0f, -22.0f, 8, 8, 8);
        this.leg2.func_78786_a("toe", 12.0f, 40.0f, -20.0f, 8, 8, 8);
        (this.tail1 = new ModelRenderer((ModelBase)this, "tail")).func_78793_a(0.0f, 6.0f, 108.0f);
        this.tail1.func_78786_a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.tail1.func_78786_a("fin", -2.0f, -28.0f, -11.0f, 4, 24, 24);
        (this.tail2 = new ModelRenderer((ModelBase)this, "tail")).func_78786_a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.tail2.func_78786_a("fin", -2.0f, -28.0f, -11.0f, 4, 24, 24);
        this.tail2.func_78793_a(0.0f, 7.0f, 142.0f);
        (this.tail3 = new ModelRenderer((ModelBase)this, "tail")).func_78786_a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.tail3.func_78786_a("fin", -2.0f, -28.0f, -11.0f, 4, 24, 24);
        this.tail3.func_78793_a(0.0f, 8.0f, 176.0f);
        (this.tail4 = new ModelRenderer((ModelBase)this, "tail")).func_78786_a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.tail4.func_78786_a("fin", -2.0f, -28.0f, -11.0f, 4, 24, 24);
        this.tail4.func_78793_a(0.0f, 8.0f, 210.0f);
        (this.neck1a = new ModelRenderer((ModelBase)this, "neck")).func_78786_a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck1a.func_78786_a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck1a.func_78793_a(0.0f, -48.0f, 16.0f);
        (this.neck1b = new ModelRenderer((ModelBase)this, "neck")).func_78786_a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck1b.func_78786_a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck1b.func_78793_a(0.0f, -68.0f, 0.0f);
        (this.neck1c = new ModelRenderer((ModelBase)this, "neck")).func_78786_a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck1c.func_78786_a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck1c.func_78793_a(0.0f, -93.0f, -14.0f);
        (this.neck1d = new ModelRenderer((ModelBase)this, "neck")).func_78786_a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck1d.func_78786_a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck1d.func_78793_a(0.0f, -116.0f, -37.0f);
        (this.head1 = new ModelRenderer((ModelBase)this, "head")).func_78786_a("box", -16.0f, -14.0f, -32.0f, 32, 24, 32);
        this.head1.func_78786_a("upperlip", -15.0f, -2.0f, -56.0f, 30, 12, 24);
        this.head1.func_78786_a("fin", -2.0f, -30.0f, -12.0f, 4, 24, 24);
        this.head1.func_78793_a(0.0f, -128.0f, -53.0f);
        (this.jaw1 = new ModelRenderer((ModelBase)this, "jaw")).func_78793_a(0.0f, 10.0f, -4.0f);
        this.jaw1.func_78786_a("jaw", -15.0f, 0.0f, -48.0f, 30, 8, 48);
        this.setRotation(this.jaw1, 0.0f, 0.0f, 0.0f);
        this.head1.func_78792_a(this.jaw1);
        (this.frill1 = new ModelRenderer((ModelBase)this, "frill")).func_78793_a(0.0f, 0.0f, -10.0f);
        this.frill1.func_78786_a("frill", -24.0f, -40.0f, 0.0f, 48, 48, 4);
        this.setRotation(this.frill1, -0.5235988f, 0.0f, 0.0f);
        this.head1.func_78792_a(this.frill1);
        (this.neck2a = new ModelRenderer((ModelBase)this, "neck")).func_78786_a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck2a.func_78786_a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck2a.func_78793_a(48.0f, -48.0f, 16.0f);
        (this.neck2b = new ModelRenderer((ModelBase)this, "neck")).func_78786_a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck2b.func_78786_a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck2b.func_78793_a(71.0f, -68.0f, 0.0f);
        (this.neck2c = new ModelRenderer((ModelBase)this, "neck")).func_78786_a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck2c.func_78786_a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck2c.func_78793_a(96.0f, -93.0f, -14.0f);
        (this.neck2d = new ModelRenderer((ModelBase)this, "neck")).func_78786_a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck2d.func_78786_a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck2d.func_78793_a(108.0f, -116.0f, -37.0f);
        (this.head2 = new ModelRenderer((ModelBase)this, "head")).func_78786_a("box", -16.0f, -14.0f, -32.0f, 32, 24, 32);
        this.head2.func_78786_a("upperlip", -15.0f, -2.0f, -56.0f, 30, 12, 24);
        this.head2.func_78786_a("fin", -2.0f, -30.0f, -12.0f, 4, 24, 24);
        this.head2.func_78793_a(108.0f, -128.0f, -53.0f);
        (this.jaw2 = new ModelRenderer((ModelBase)this, "jaw")).func_78793_a(0.0f, 10.0f, -4.0f);
        this.jaw2.func_78786_a("jaw", -15.0f, 0.0f, -48.0f, 30, 8, 48);
        this.setRotation(this.jaw2, 0.0f, 0.0f, 0.0f);
        this.head2.func_78792_a(this.jaw2);
        (this.frill2 = new ModelRenderer((ModelBase)this, "frill")).func_78793_a(0.0f, 0.0f, -10.0f);
        this.frill2.func_78786_a("frill", -24.0f, -40.0f, 0.0f, 48, 48, 4);
        this.setRotation(this.frill2, -0.5235988f, 0.0f, 0.0f);
        this.head2.func_78792_a(this.frill2);
        (this.neck3a = new ModelRenderer((ModelBase)this, "neck")).func_78786_a("box", -16.0f, -16.0f, -16.0f, 32, 32, 31);
        this.neck3a.func_78786_a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck3a.func_78793_a(-48.0f, -48.0f, 16.0f);
        (this.neck3b = new ModelRenderer((ModelBase)this, "neck")).func_78786_a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck3b.func_78786_a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck3b.func_78793_a(-71.0f, -43.0f, 0.0f);
        (this.neck3c = new ModelRenderer((ModelBase)this, "neck")).func_78786_a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck3c.func_78786_a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck3c.func_78793_a(-96.0f, -33.0f, -14.0f);
        (this.neck3d = new ModelRenderer((ModelBase)this, "neck")).func_78786_a("box", -16.0f, -16.0f, -16.0f, 32, 32, 32);
        this.neck3d.func_78786_a("fin", -2.0f, -23.0f, 0.0f, 4, 24, 24);
        this.neck3d.func_78793_a(-108.0f, -24.0f, -37.0f);
        (this.head3 = new ModelRenderer((ModelBase)this, "head")).func_78786_a("box", -16.0f, -14.0f, -32.0f, 32, 24, 32);
        this.head3.func_78786_a("upperlip", -15.0f, -2.0f, -56.0f, 30, 12, 24);
        this.head3.func_78786_a("fin", -2.0f, -30.0f, -12.0f, 4, 24, 24);
        this.head3.func_78793_a(-108.0f, -24.0f, -53.0f);
        (this.jaw3 = new ModelRenderer((ModelBase)this, "jaw")).func_78793_a(0.0f, 10.0f, -4.0f);
        this.jaw3.func_78786_a("jaw", -15.0f, 0.0f, -48.0f, 30, 8, 48);
        this.setRotation(this.jaw3, 0.125f, 0.0f, 0.0f);
        this.head3.func_78792_a(this.jaw3);
        (this.frill3 = new ModelRenderer((ModelBase)this, "frill")).func_78793_a(0.0f, 0.0f, -10.0f);
        this.frill3.func_78786_a("frill", -24.0f, -40.0f, 0.0f, 48, 48, 4);
        this.setRotation(this.frill3, -0.5235988f, 0.0f, 0.0f);
        this.head3.func_78792_a(this.frill3);
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
        this.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        this.body.func_78785_a(f5);
        this.leg1.func_78785_a(f5);
        this.leg2.func_78785_a(f5);
        this.tail1.func_78785_a(f5);
        this.tail2.func_78785_a(f5);
        this.tail3.func_78785_a(f5);
        this.tail4.func_78785_a(f5);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void func_78087_a(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        super.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        this.leg1.field_78795_f = MathHelper.func_76134_b(f * 0.6662f) * 1.4f * f1;
        this.leg2.field_78795_f = MathHelper.func_76134_b(f * 0.6662f + 3.141593f) * 1.4f * f1;
        this.leg1.field_78796_g = 0.0f;
        this.leg2.field_78796_g = 0.0f;
    }
    
    public float getRotationY(final EntityTFHydra hydra, final EntityTFHydraPart whichHead, final float time) {
        final float yawOffset = hydra.field_70760_ar + (hydra.field_70761_aq - hydra.field_70760_ar) * time;
        final float yaw = whichHead.field_70126_B + (whichHead.field_70177_z - whichHead.field_70126_B) * time;
        return (yaw - yawOffset) / 57.29578f;
    }
    
    public float getRotationX(final EntityTFHydra hydra, final EntityTFHydraPart whichHead, final float time) {
        return (whichHead.field_70127_C + (whichHead.field_70125_A - whichHead.field_70127_C) * time) / 57.29578f;
    }
}
