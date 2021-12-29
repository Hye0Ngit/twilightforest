// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFPenguin extends ModelBase
{
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer head;
    ModelRenderer beak;
    
    public ModelTFPenguin() {
        this.field_78090_t = 64;
        this.field_78089_u = 32;
        (this.body = new ModelRenderer((ModelBase)this, 32, 0)).func_78789_a(-4.0f, 0.0f, -4.0f, 8, 9, 8);
        this.body.func_78793_a(0.0f, 14.0f, 0.0f);
        (this.rightarm = new ModelRenderer((ModelBase)this, 34, 18)).func_78789_a(-1.0f, -1.0f, -2.0f, 1, 8, 4);
        this.rightarm.func_78793_a(-4.0f, 15.0f, 0.0f);
        (this.leftarm = new ModelRenderer((ModelBase)this, 24, 18)).func_78789_a(0.0f, -1.0f, -2.0f, 1, 8, 4);
        this.leftarm.func_78793_a(4.0f, 15.0f, 0.0f);
        this.leftarm.field_78809_i = true;
        (this.rightleg = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(-2.0f, 0.0f, -5.0f, 4, 1, 8);
        this.rightleg.func_78793_a(-2.0f, 23.0f, 0.0f);
        this.rightleg.func_78787_b(64, 32);
        (this.leftleg = new ModelRenderer((ModelBase)this, 0, 16)).func_78789_a(-2.0f, 0.0f, -5.0f, 4, 1, 8);
        this.leftleg.func_78793_a(2.0f, 23.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase)this, 0, 0)).func_78789_a(-3.5f, -4.0f, -3.5f, 7, 5, 7);
        this.head.func_78793_a(0.0f, 13.0f, 0.0f);
        (this.beak = new ModelRenderer((ModelBase)this, 0, 13)).func_78789_a(-1.0f, 0.0f, -1.0f, 2, 1, 2);
        this.beak.func_78793_a(0.0f, -1.0f, -4.0f);
        this.head.func_78792_a(this.beak);
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
        }
    }
    
    public void func_78087_a(final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scaleFactor, final Entity entity) {
        this.head.field_78795_f = headPitch / 57.295776f;
        this.head.field_78796_g = netHeadYaw / 57.295776f;
        this.rightleg.field_78795_f = MathHelper.func_76134_b(limbSwing) * 0.7f * limbSwingAmount;
        this.leftleg.field_78795_f = MathHelper.func_76134_b(limbSwing + 3.1415927f) * 0.7f * limbSwingAmount;
        this.rightarm.field_78808_h = ageInTicks;
        this.leftarm.field_78808_h = -ageInTicks;
    }
}
