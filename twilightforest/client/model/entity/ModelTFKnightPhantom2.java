// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.util.math.MathHelper;
import twilightforest.entity.boss.EntityTFKnightPhantom;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBiped;

public class ModelTFKnightPhantom2 extends ModelBiped
{
    public ModelTFKnightPhantom2() {
        this(0.0f);
    }
    
    public ModelTFKnightPhantom2(final float scale) {
        super(scale, 0.0f, 64, 32);
        (this.field_178723_h = new ModelRenderer((ModelBase)this, 40, 16)).func_78790_a(-1.0f, -2.0f, -1.0f, 2, 12, 2, scale);
        this.field_178723_h.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.field_178724_i = new ModelRenderer((ModelBase)this, 40, 16);
        this.field_178724_i.field_78809_i = true;
        this.field_178724_i.func_78790_a(-1.0f, -2.0f, -1.0f, 2, 12, 2, scale);
        this.field_178724_i.func_78793_a(5.0f, 2.0f, 0.0f);
        (this.field_178721_j = new ModelRenderer((ModelBase)this, 0, 16)).func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, scale);
        this.field_178721_j.func_78793_a(-2.0f, 12.0f, 0.0f);
        this.field_178722_k = new ModelRenderer((ModelBase)this, 0, 16);
        this.field_178722_k.field_78809_i = true;
        this.field_178722_k.func_78790_a(-1.0f, 0.0f, -1.0f, 2, 12, 2, scale);
        this.field_178722_k.func_78793_a(2.0f, 12.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        this.func_78087_a(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        if (((EntityTFKnightPhantom)entity).isChargingAtPlayer()) {
            super.func_78088_a(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }
    
    public void func_78087_a(final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scaleFactor, final Entity entity) {
        super.func_78087_a(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entity);
        this.field_178722_k.field_78795_f = 0.0f;
        this.field_178722_k.field_78796_g = 0.0f;
        this.field_178722_k.field_78808_h = 0.0f;
        this.field_178721_j.field_78795_f = 0.0f;
        this.field_178721_j.field_78796_g = 0.0f;
        this.field_178721_j.field_78808_h = 0.0f;
        this.field_178721_j.field_78795_f = 0.2f * MathHelper.func_76126_a(ageInTicks * 0.3f) + 0.4f;
        this.field_178722_k.field_78795_f = 0.2f * MathHelper.func_76126_a(ageInTicks * 0.3f) + 0.4f;
    }
}
