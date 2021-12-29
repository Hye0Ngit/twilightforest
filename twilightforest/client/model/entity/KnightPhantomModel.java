// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.LivingEntity;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import twilightforest.entity.boss.KnightPhantomEntity;
import net.minecraft.client.renderer.entity.model.BipedModel;

public class KnightPhantomModel extends BipedModel<KnightPhantomEntity>
{
    private KnightPhantomEntity knight;
    
    public KnightPhantomModel() {
        this(0.0f);
    }
    
    public KnightPhantomModel(final float scale) {
        super(scale);
        (this.field_178723_h = new ModelRenderer((Model)this, 40, 16)).func_228301_a_(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f, scale);
        this.field_178723_h.func_78793_a(-5.0f, 2.0f, 0.0f);
        this.field_178724_i = new ModelRenderer((Model)this, 40, 16);
        this.field_178724_i.field_78809_i = true;
        this.field_178724_i.func_228301_a_(-1.0f, -2.0f, -1.0f, 2.0f, 12.0f, 2.0f, scale);
        this.field_178724_i.func_78793_a(5.0f, 2.0f, 0.0f);
        (this.field_178721_j = new ModelRenderer((Model)this, 0, 16)).func_228301_a_(-1.0f, 0.0f, -1.0f, 2.0f, 12.0f, 2.0f, scale);
        this.field_178721_j.func_78793_a(-2.0f, 12.0f, 0.0f);
        this.field_178722_k = new ModelRenderer((Model)this, 0, 16);
        this.field_178722_k.field_78809_i = true;
        this.field_178722_k.func_228301_a_(-1.0f, 0.0f, -1.0f, 2.0f, 12.0f, 2.0f, scale);
        this.field_178722_k.func_78793_a(2.0f, 12.0f, 0.0f);
    }
    
    public void func_225598_a_(final MatrixStack stack, final IVertexBuilder builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        if (this.knight != null && this.knight.isChargingAtPlayer()) {
            super.func_225598_a_(stack, builder, light, overlay, red, green, blue, scale);
        }
    }
    
    public void setRotationAngles(final KnightPhantomEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        super.func_225597_a_((LivingEntity)(this.knight = entity), limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
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
