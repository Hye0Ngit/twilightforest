// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import twilightforest.entity.passive.EntityTFBird;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFTinyBird extends ModelBase
{
    ModelRenderer beak;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer tail;
    
    public ModelTFTinyBird() {
        this.field_78090_t = 32;
        this.field_78089_u = 32;
        (this.head = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-1.5f, -1.5f, -1.5f, 3, 3, 3);
        this.head.func_78793_a(0.0f, 20.5f, -0.5f);
        this.head.func_78787_b(32, 32);
        this.head.field_78809_i = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.beak = new ModelRenderer((ModelBase)this, 12, 0)).func_78789_a(-0.5f, -0.5f, -0.5f, 1, 1, 1);
        this.beak.func_78793_a(0.0f, 0.5f, -2.0f);
        this.head.func_78792_a(this.beak);
        (this.body = new ModelRenderer((ModelBase)this, 0, 6)).func_78789_a(-1.5f, 0.0f, -1.0f, 3, 3, 3);
        this.body.func_78793_a(0.0f, 20.0f, 0.0f);
        this.body.func_78787_b(32, 32);
        this.body.field_78809_i = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.rightarm = new ModelRenderer((ModelBase)this, 12, 2)).func_78789_a(-1.0f, 0.0f, -1.5f, 1, 2, 3);
        this.rightarm.func_78793_a(-1.5f, 20.5f, 1.0f);
        this.rightarm.func_78787_b(32, 32);
        this.rightarm.field_78809_i = true;
        this.setRotation(this.rightarm, 0.0f, 0.0f, 0.0f);
        (this.leftarm = new ModelRenderer((ModelBase)this, 12, 2)).func_78789_a(0.0f, 0.0f, -1.5f, 1, 2, 3);
        this.leftarm.func_78793_a(1.5f, 20.5f, 1.0f);
        this.leftarm.func_78787_b(32, 32);
        this.leftarm.field_78809_i = true;
        this.setRotation(this.leftarm, 0.0f, 0.0f, 0.0f);
        (this.rightleg = new ModelRenderer((ModelBase)this, 0, 12)).func_78789_a(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.rightleg.func_78793_a(-1.5f, 23.0f, 0.0f);
        this.rightleg.func_78787_b(32, 32);
        this.rightleg.field_78809_i = true;
        this.setRotation(this.rightleg, 0.0f, 0.0f, 0.0f);
        (this.leftleg = new ModelRenderer((ModelBase)this, 0, 12)).func_78789_a(0.5f, 0.0f, 0.0f, 1, 1, 1);
        this.leftleg.func_78793_a(0.0f, 23.0f, 0.0f);
        this.leftleg.func_78787_b(32, 32);
        this.leftleg.field_78809_i = true;
        this.setRotation(this.leftleg, 0.0f, 0.0f, 0.0f);
        (this.tail = new ModelRenderer((ModelBase)this, 0, 14)).func_78789_a(-1.5f, -0.5f, 0.0f, 3, 1, 2);
        this.tail.func_78793_a(0.0f, 22.0f, 2.0f);
        this.tail.func_78787_b(32, 32);
        this.tail.field_78809_i = true;
        this.setRotation(this.tail, 0.0f, 0.0f, 0.0f);
    }
    
    public void func_78088_a(final Entity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        this.func_78087_a(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        if (this.field_78091_s) {
            final float f = 2.0f;
            GlStateManager.func_179094_E();
            GlStateManager.func_179109_b(0.0f, 5.0f * scale, 0.75f * scale);
            this.head.func_78785_a(scale);
            GlStateManager.func_179121_F();
            GlStateManager.func_179094_E();
            GlStateManager.func_179152_a(1.0f / f, 1.0f / f, 1.0f / f);
            GlStateManager.func_179109_b(0.0f, 24.0f * scale, 0.0f);
            this.body.func_78785_a(scale);
            this.rightleg.func_78785_a(scale);
            this.leftleg.func_78785_a(scale);
            this.rightarm.func_78785_a(scale);
            this.leftarm.func_78785_a(scale);
            GlStateManager.func_179121_F();
        }
        else {
            this.head.func_78785_a(scale);
            this.body.func_78785_a(scale);
            this.rightleg.func_78785_a(scale);
            this.leftleg.func_78785_a(scale);
            this.rightarm.func_78785_a(scale);
            this.leftarm.func_78785_a(scale);
            this.tail.func_78785_a(scale);
        }
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.field_78795_f = x;
        model.field_78796_g = y;
        model.field_78808_h = z;
    }
    
    public void func_78087_a(final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scaleFactor, final Entity entity) {
        this.head.field_78795_f = headPitch / 57.295776f;
        this.head.field_78796_g = netHeadYaw / 57.295776f;
        this.rightleg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.leftleg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.rightarm.field_78808_h = ageInTicks;
        this.leftarm.field_78808_h = -ageInTicks;
        if (((EntityTFBird)entity).isBirdLanded()) {
            this.rightleg.field_78797_d = 23.0f;
            this.leftleg.field_78797_d = 23.0f;
        }
        else {
            this.rightleg.field_78797_d = 22.5f;
            this.leftleg.field_78797_d = 22.5f;
        }
    }
}
