// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model;

import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.entity.EntityLiving;
import twilightforest.entity.EntityTFLich;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFLich extends ModelBiped
{
    ModelRenderer collar;
    ModelRenderer cloak;
    ModelRenderer shieldBelt;
    boolean renderPass;
    
    public ModelTFLich() {
        this.renderPass = false;
        this.renderPass = false;
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        (this.field_78115_e = new ModelRenderer((ModelBase)this, 8, 16)).func_78789_a(-4.0f, 0.0f, -2.0f, 8, 24, 4);
        this.field_78115_e.func_78793_a(0.0f, -4.0f, 0.0f);
        this.field_78115_e.func_78787_b(64, 64);
        (this.field_78112_f = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(-2.0f, -2.0f, -1.0f, 2, 12, 2);
        this.field_78112_f.func_78787_b(64, 64);
        this.field_78112_f.func_78793_a(-5.0f, -2.0f, 0.0f);
        this.field_78113_g = new ModelRenderer((ModelBase)this, 0, 16);
        this.field_78113_g.field_78809_i = true;
        this.field_78113_g.func_78789_a(-2.0f, -2.0f, -1.0f, 2, 12, 2);
        this.field_78113_g.func_78793_a(5.0f, -2.0f, 0.0f);
        this.field_78113_g.func_78787_b(64, 64);
        (this.field_78114_d = new ModelRenderer((ModelBase)this, 32, 0)).func_78790_a(-4.0f, -12.0f, -4.0f, 8, 8, 8, 0.5f);
        this.field_78114_d.func_78793_a(0.0f, -4.0f, 0.0f);
        this.field_78114_d.func_78787_b(64, 64);
        (this.field_78116_c = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.field_78116_c.func_78793_a(0.0f, -4.0f, 0.0f);
        this.field_78116_c.func_78787_b(64, 64);
        (this.field_78123_h = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(-1.0f, 0.0f, -1.0f, 2, 12, 2);
        this.field_78123_h.func_78793_a(-2.0f, 9.5f, 0.0f);
        this.field_78123_h.func_78787_b(64, 64);
        (this.field_78124_i = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(-1.0f, 0.0f, -1.0f, 2, 12, 2);
        this.field_78124_i.func_78793_a(2.0f, 9.5f, 0.0f);
        this.field_78124_i.func_78787_b(64, 64);
        this.field_78124_i.field_78809_i = true;
        (this.collar = new ModelRenderer((ModelBase)this, 32, 16)).func_78789_a(-6.0f, 0.0f, 0.0f, 12, 12, 1);
        this.collar.func_78793_a(0.0f, -3.0f, -1.0f);
        this.collar.func_78787_b(64, 64);
        this.setRotation(this.collar, 2.164208f, 0.0f, 0.0f);
        (this.cloak = new ModelRenderer((ModelBase)this, 0, 44)).func_78789_a(-6.0f, 0.0f, 0.0f, 12, 19, 1);
        this.cloak.func_78793_a(0.0f, -4.0f, 2.5f);
        this.cloak.func_78787_b(64, 64);
        this.setRotation(this.cloak, 0.0f, 0.0f, 0.0f);
        (this.shieldBelt = new ModelRenderer((ModelBase)this)).func_78793_a(0.0f, 0.0f, 0.0f);
    }
    
    public ModelTFLich(final boolean specialRenderModel) {
        this();
        this.renderPass = specialRenderModel;
    }
    
    public void func_78088_a(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        final EntityTFLich lich = (EntityTFLich)entity;
        if (!this.renderPass) {
            if (!lich.isShadowClone()) {
                super.func_78088_a(entity, f, f1, f2, f3, f4, f5 * 1.125f);
                this.collar.func_78785_a(f5 * 1.125f);
                this.cloak.func_78785_a(f5 * 1.125f);
            }
        }
        else if (lich.isShadowClone()) {
            super.func_78088_a(entity, f, f1, f2, f3, f4, f5 * 1.125f);
        }
        else if (lich.getShieldStrength() > 0) {
            this.shieldBelt.func_78785_a(f5 * 1.125f);
        }
    }
    
    public void func_78086_a(final EntityLiving par1EntityLiving, final float par2, final float par3, final float time) {
        final EntityTFLich lich = (EntityTFLich)par1EntityLiving;
        final int shields = lich.getShieldStrength();
        if (!lich.isShadowClone() && shields > 0) {
            if (this.shieldBelt.field_78805_m == null || this.shieldBelt.field_78805_m.size() != shields) {
                if (this.shieldBelt.field_78805_m != null) {
                    this.shieldBelt.field_78805_m.clear();
                }
                for (int i = 0; i < shields; ++i) {
                    final Vec3 vec = Vec3.func_72443_a(11.0, 0.0, 0.0);
                    final float rotateY = i * (360.0f / shields) * 3.141593f / 180.0f;
                    vec.func_72442_b(rotateY);
                    final ModelRenderer shield = new ModelRenderer((ModelBase)this, 26, 40);
                    shield.func_78789_a(0.5f, -6.0f, -6.0f, 1, 12, 12);
                    shield.func_78793_a((float)vec.field_72450_a, (float)vec.field_72448_b, (float)vec.field_72449_c);
                    shield.func_78787_b(64, 64);
                    shield.field_78796_g = rotateY;
                    this.shieldBelt.func_78792_a(shield);
                }
            }
            this.shieldBelt.field_78796_g = (lich.field_70173_aa + time) / 5.0f;
            this.shieldBelt.field_78795_f = MathHelper.func_76126_a((lich.field_70173_aa + time) / 5.0f) / 4.0f;
            this.shieldBelt.field_78808_h = MathHelper.func_76134_b((lich.field_70173_aa + time) / 5.0f) / 4.0f;
        }
    }
    
    public void func_78087_a(final float f, final float f1, final float f2, final float f3, final float f4, final float f5, final Entity entity) {
        this.field_78118_o = false;
        super.func_78087_a(f, f1, f2, f3, f4, f5, entity);
        final float ogSin = MathHelper.func_76126_a(this.field_78095_p * 3.141593f);
        final float otherSin = MathHelper.func_76126_a((1.0f - (1.0f - this.field_78095_p) * (1.0f - this.field_78095_p)) * 3.141593f);
        this.field_78112_f.field_78808_h = 0.0f;
        this.field_78113_g.field_78808_h = 0.5f;
        this.field_78112_f.field_78796_g = -(0.1f - ogSin * 0.6f);
        this.field_78113_g.field_78796_g = 0.1f - ogSin * 0.6f;
        this.field_78112_f.field_78795_f = -1.570796f;
        this.field_78113_g.field_78795_f = -3.141593f;
        final ModelRenderer field_78112_f = this.field_78112_f;
        field_78112_f.field_78795_f -= ogSin * 1.2f - otherSin * 0.4f;
        final ModelRenderer field_78113_g = this.field_78113_g;
        field_78113_g.field_78795_f -= ogSin * 1.2f - otherSin * 0.4f;
        final ModelRenderer field_78112_f2 = this.field_78112_f;
        field_78112_f2.field_78808_h += MathHelper.func_76134_b(f2 * 0.26f) * 0.15f + 0.05f;
        final ModelRenderer field_78113_g2 = this.field_78113_g;
        field_78113_g2.field_78808_h -= MathHelper.func_76134_b(f2 * 0.26f) * 0.15f + 0.05f;
        final ModelRenderer field_78112_f3 = this.field_78112_f;
        field_78112_f3.field_78795_f += MathHelper.func_76126_a(f2 * 0.167f) * 0.15f;
        final ModelRenderer field_78113_g3 = this.field_78113_g;
        field_78113_g3.field_78795_f -= MathHelper.func_76126_a(f2 * 0.167f) * 0.15f;
        this.field_78116_c.field_78797_d = -4.0f;
        this.field_78114_d.field_78797_d = -4.0f;
        this.field_78123_h.field_78797_d = 9.5f;
        this.field_78124_i.field_78797_d = 9.5f;
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
}
