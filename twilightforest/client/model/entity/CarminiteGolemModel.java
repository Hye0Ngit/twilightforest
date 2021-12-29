// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import twilightforest.entity.CarminiteGolemEntity;

public class CarminiteGolemModel<T extends CarminiteGolemEntity> extends SegmentedModel<T>
{
    ModelRenderer head;
    ModelRenderer jaw;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer leftleg;
    ModelRenderer leftfoot;
    ModelRenderer ribs;
    ModelRenderer hips;
    ModelRenderer rightfoot;
    ModelRenderer rightleg;
    ModelRenderer spine;
    
    public CarminiteGolemModel() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        (this.head = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, -11.0f, -2.0f);
        this.head.func_78784_a(0, 0).func_228300_a_(-3.5f, -10.0f, -3.0f, 7.0f, 8.0f, 6.0f);
        this.head.func_78784_a(0, 14).func_228300_a_(-4.0f, -6.0f, -3.5f, 8.0f, 4.0f, 6.0f);
        (this.body = new ModelRenderer((Model)this, 0, 26)).func_228300_a_(-8.0f, 0.0f, -5.0f, 16.0f, 10.0f, 10.0f);
        this.body.func_78793_a(0.0f, -13.0f, 0.0f);
        (this.ribs = new ModelRenderer((Model)this, 0, 46)).func_228300_a_(-5.0f, 0.0f, -3.0f, 10.0f, 6.0f, 6.0f);
        this.ribs.func_78793_a(0.0f, -3.0f, 0.0f);
        (this.rightarm = new ModelRenderer((Model)this, 52, 0)).func_78793_a(-8.0f, -12.0f, 0.0f);
        this.rightarm.func_78784_a(52, 0).func_228300_a_(-5.0f, -2.0f, -1.5f, 3.0f, 14.0f, 3.0f);
        this.rightarm.func_78784_a(52, 17).func_228300_a_(-7.0f, 12.0f, -3.0f, 6.0f, 12.0f, 6.0f);
        this.rightarm.func_78784_a(52, 36).func_228300_a_(-7.0f, -3.0f, -3.5f, 7.0f, 2.0f, 7.0f);
        this.rightarm.func_78784_a(52, 45).func_228300_a_(-7.0f, -1.0f, -3.5f, 7.0f, 5.0f, 2.0f);
        this.rightarm.func_78784_a(52, 45).func_228300_a_(-7.0f, -1.0f, 1.5f, 7.0f, 5.0f, 2.0f);
        this.rightarm.func_78784_a(52, 54).func_228300_a_(-2.0f, -1.0f, -2.0f, 2.0f, 5.0f, 3.0f);
        this.leftarm = new ModelRenderer((Model)this, 52, 0);
        this.leftarm.field_78809_i = true;
        this.leftarm.func_78793_a(8.0f, -12.0f, 0.0f);
        this.leftarm.func_78784_a(52, 0).func_228300_a_(2.0f, -2.0f, -1.5f, 3.0f, 14.0f, 3.0f);
        this.leftarm.func_78784_a(52, 17).func_228300_a_(1.0f, 12.0f, -3.0f, 6.0f, 12.0f, 6.0f);
        this.leftarm.func_78784_a(52, 36).func_228300_a_(0.0f, -3.0f, -3.5f, 7.0f, 2.0f, 7.0f);
        this.leftarm.func_78784_a(52, 45).func_228300_a_(0.0f, -1.0f, -3.5f, 7.0f, 5.0f, 2.0f);
        this.leftarm.func_78784_a(52, 45).func_228300_a_(0.0f, -1.0f, 1.5f, 7.0f, 5.0f, 2.0f);
        this.leftarm.func_78784_a(52, 54).func_228300_a_(0.0f, -1.0f, -2.0f, 2.0f, 5.0f, 3.0f);
        (this.hips = new ModelRenderer((Model)this, 84, 25)).func_228300_a_(-5.0f, 0.0f, -2.0f, 10.0f, 3.0f, 4.0f);
        this.hips.func_78793_a(0.0f, 1.0f, 0.0f);
        (this.spine = new ModelRenderer((Model)this, 84, 18)).func_228300_a_(-1.5f, 0.0f, -1.5f, 3.0f, 4.0f, 3.0f);
        this.spine.func_78793_a(0.0f, -3.0f, 0.0f);
        this.leftleg = new ModelRenderer((Model)this, 84, 32);
        this.leftleg.field_78809_i = true;
        this.leftleg.func_78793_a(1.0f, 2.0f, 0.0f);
        this.leftleg.func_78784_a(84, 32).func_228300_a_(0.0f, 0.0f, -1.5f, 3.0f, 8.0f, 3.0f);
        this.leftleg.func_78784_a(84, 43).func_228300_a_(-0.5f, 8.0f, -4.0f, 6.0f, 14.0f, 7.0f);
        (this.rightleg = new ModelRenderer((Model)this, 84, 32)).func_78793_a(-1.0f, 2.0f, 0.0f);
        this.rightleg.func_78784_a(84, 32).func_228300_a_(-3.0f, 0.0f, -1.5f, 3.0f, 8.0f, 3.0f);
        this.rightleg.func_78784_a(84, 43).func_228300_a_(-5.5f, 8.0f, -4.0f, 6.0f, 14.0f, 7.0f);
    }
    
    public Iterable<ModelRenderer> func_225601_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.head, (Object)this.body, (Object)this.rightarm, (Object)this.leftarm, (Object)this.rightleg, (Object)this.leftleg, (Object)this.ribs, (Object)this.hips, (Object)this.spine);
    }
    
    public void setRotationAngles(final T entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.head.field_78796_g = netHeadYaw / 57.295776f;
        this.head.field_78795_f = headPitch / 57.295776f;
        this.leftleg.field_78795_f = -1.5f * this.func_78172_a(limbSwing, 13.0f) * limbSwingAmount;
        this.rightleg.field_78795_f = 1.5f * this.func_78172_a(limbSwing, 13.0f) * limbSwingAmount;
        this.leftleg.field_78796_g = 0.0f;
        this.rightleg.field_78796_g = 0.0f;
        this.rightarm.field_78808_h = MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
        this.leftarm.field_78808_h = -MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f - 0.05f;
    }
    
    public void setLivingAnimations(final T entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        final int var6 = entity.getAttackTimer();
        if (var6 > 0) {
            this.rightarm.field_78795_f = -2.0f + 1.5f * this.func_78172_a(var6 - partialTicks, 10.0f);
            this.leftarm.field_78795_f = -2.0f + 1.5f * this.func_78172_a(var6 - partialTicks, 10.0f);
        }
        else {
            this.rightarm.field_78795_f = (-0.2f + 1.5f * this.func_78172_a(limbSwing, 25.0f)) * limbSwingAmount;
            this.leftarm.field_78795_f = (-0.2f - 1.5f * this.func_78172_a(limbSwing, 25.0f)) * limbSwingAmount;
        }
    }
    
    private float func_78172_a(final float par1, final float par2) {
        return (Math.abs(par1 % par2 - par2 * 0.5f) - par2 * 0.25f) / (par2 * 0.25f);
    }
}
