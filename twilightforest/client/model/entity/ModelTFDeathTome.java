// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBook;

public class ModelTFDeathTome extends ModelBook
{
    private ModelRenderer everything;
    private ModelRenderer book;
    private ModelRenderer loosePage1;
    private ModelRenderer loosePage2;
    private ModelRenderer loosePage3;
    private ModelRenderer loosePage4;
    
    public ModelTFDeathTome() {
        this.everything = new ModelRenderer((ModelBase)this).func_78784_a(0, 0).func_78789_a(0.0f, 0.0f, 0.0f, 0, 0, 0);
        (this.book = new ModelRenderer((ModelBase)this).func_78784_a(0, 0).func_78789_a(0.0f, 0.0f, 0.0f, 0, 0, 0)).func_78792_a(this.field_78102_a);
        this.book.func_78792_a(this.field_78100_b);
        this.book.func_78792_a(this.field_78097_g);
        this.book.func_78792_a(this.field_78101_c);
        this.book.func_78792_a(this.field_78098_d);
        this.book.func_78792_a(this.field_78099_e);
        this.book.func_78792_a(this.field_78096_f);
        this.loosePage1 = new ModelRenderer((ModelBase)this).func_78784_a(24, 10).func_78789_a(0.0f, -4.0f, -8.0f, 5, 8, 0);
        this.loosePage2 = new ModelRenderer((ModelBase)this).func_78784_a(24, 10).func_78789_a(0.0f, -4.0f, 9.0f, 5, 8, 0);
        this.loosePage3 = new ModelRenderer((ModelBase)this).func_78784_a(24, 10).func_78789_a(0.0f, -4.0f, 11.0f, 5, 8, 0);
        this.loosePage4 = new ModelRenderer((ModelBase)this).func_78784_a(24, 10).func_78789_a(0.0f, -4.0f, 7.0f, 5, 8, 0);
        this.everything.func_78792_a(this.book);
        this.everything.func_78792_a(this.loosePage1);
        this.everything.func_78792_a(this.loosePage2);
        this.everything.func_78792_a(this.loosePage3);
        this.everything.func_78792_a(this.loosePage4);
    }
    
    public void func_78088_a(final Entity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        GlStateManager.func_179089_o();
        this.func_78087_a((float)entity.field_70173_aa, 0.4f, 0.6f, 0.9f, headPitch, 0.0625f, entity);
        this.everything.func_78785_a(scale);
        GlStateManager.func_179129_p();
    }
    
    public void func_78087_a(final float bounce, final float flipRight, final float flipLeft, final float open, final float rotate, final float scale, final Entity entity) {
        this.book.field_78808_h = -0.87266463f;
        this.everything.field_78796_g = rotate / 57.295776f + 1.5707964f;
    }
    
    public void func_78086_a(final EntityLivingBase entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        final float bounce = entity.field_70173_aa + partialTicks;
        final float open = 0.9f;
        final float flipRight = 0.4f;
        final float flipLeft = 0.6f;
        this.book.func_78793_a(0.0f, 4.0f + MathHelper.func_76126_a(bounce * 0.3f) * 2.0f, 0.0f);
        final float openAngle = (MathHelper.func_76126_a(bounce * 0.4f) * 0.3f + 1.25f) * open;
        this.field_78102_a.field_78796_g = 3.1415927f + openAngle;
        this.field_78100_b.field_78796_g = -openAngle;
        this.field_78101_c.field_78796_g = openAngle;
        this.field_78098_d.field_78796_g = -openAngle;
        this.field_78099_e.field_78796_g = openAngle - openAngle * 2.0f * flipRight;
        this.field_78096_f.field_78796_g = openAngle - openAngle * 2.0f * flipLeft;
        this.field_78101_c.field_78800_c = MathHelper.func_76126_a(openAngle);
        this.field_78098_d.field_78800_c = MathHelper.func_76126_a(openAngle);
        this.field_78099_e.field_78800_c = MathHelper.func_76126_a(openAngle);
        this.field_78096_f.field_78800_c = MathHelper.func_76126_a(openAngle);
        this.loosePage1.field_78796_g = bounce / 4.0f;
        this.loosePage1.field_78795_f = MathHelper.func_76126_a(bounce / 5.0f) / 3.0f;
        this.loosePage1.field_78808_h = MathHelper.func_76134_b(bounce / 5.0f) / 5.0f;
        this.loosePage2.field_78796_g = bounce / 3.0f;
        this.loosePage2.field_78795_f = MathHelper.func_76126_a(bounce / 5.0f) / 3.0f;
        this.loosePage2.field_78808_h = MathHelper.func_76134_b(bounce / 5.0f) / 4.0f + 2.0f;
        this.loosePage3.field_78796_g = bounce / 4.0f;
        this.loosePage3.field_78795_f = -MathHelper.func_76126_a(bounce / 5.0f) / 3.0f;
        this.loosePage3.field_78808_h = MathHelper.func_76134_b(bounce / 5.0f) / 5.0f - 1.0f;
        this.loosePage4.field_78796_g = bounce / 4.0f;
        this.loosePage4.field_78795_f = -MathHelper.func_76126_a(bounce / 2.0f) / 4.0f;
        this.loosePage4.field_78808_h = MathHelper.func_76134_b(bounce / 7.0f) / 5.0f;
    }
}
