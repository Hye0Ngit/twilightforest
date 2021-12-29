// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import twilightforest.entity.EntityTFTowerGolem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.model.ModelBase;

public class ModelTFTowerGolem extends ModelBase
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
    
    public ModelTFTowerGolem() {
        this.field_78090_t = 128;
        this.field_78089_u = 64;
        (this.head = new ModelRenderer((ModelBase)this, 0, 0)).func_78793_a(0.0f, -11.0f, -2.0f);
        this.head.func_78784_a(0, 0).func_78789_a(-3.5f, -10.0f, -3.0f, 7, 8, 6);
        this.head.func_78784_a(0, 14).func_78789_a(-4.0f, -6.0f, -3.5f, 8, 4, 6);
        (this.body = new ModelRenderer((ModelBase)this, 0, 26)).func_78789_a(-8.0f, 0.0f, -5.0f, 16, 10, 10);
        this.body.func_78793_a(0.0f, -13.0f, 0.0f);
        (this.ribs = new ModelRenderer((ModelBase)this, 0, 46)).func_78789_a(-5.0f, 0.0f, -3.0f, 10, 6, 6);
        this.ribs.func_78793_a(0.0f, -3.0f, 0.0f);
        (this.rightarm = new ModelRenderer((ModelBase)this, 52, 0)).func_78793_a(-8.0f, -12.0f, 0.0f);
        this.rightarm.func_78784_a(52, 0).func_78789_a(-5.0f, -2.0f, -1.5f, 3, 14, 3);
        this.rightarm.func_78784_a(52, 17).func_78789_a(-7.0f, 12.0f, -3.0f, 6, 12, 6);
        this.rightarm.func_78784_a(52, 36).func_78789_a(-7.0f, -3.0f, -3.5f, 7, 2, 7);
        this.rightarm.func_78784_a(52, 45).func_78789_a(-7.0f, -1.0f, -3.5f, 7, 5, 2);
        this.rightarm.func_78784_a(52, 45).func_78789_a(-7.0f, -1.0f, 1.5f, 7, 5, 2);
        this.rightarm.func_78784_a(52, 54).func_78789_a(-2.0f, -1.0f, -2.0f, 2, 5, 3);
        this.leftarm = new ModelRenderer((ModelBase)this, 52, 0);
        this.leftarm.field_78809_i = true;
        this.leftarm.func_78793_a(8.0f, -12.0f, 0.0f);
        this.leftarm.func_78784_a(52, 0).func_78789_a(2.0f, -2.0f, -1.5f, 3, 14, 3);
        this.leftarm.func_78784_a(52, 17).func_78789_a(1.0f, 12.0f, -3.0f, 6, 12, 6);
        this.leftarm.func_78784_a(52, 36).func_78789_a(0.0f, -3.0f, -3.5f, 7, 2, 7);
        this.leftarm.func_78784_a(52, 45).func_78789_a(0.0f, -1.0f, -3.5f, 7, 5, 2);
        this.leftarm.func_78784_a(52, 45).func_78789_a(0.0f, -1.0f, 1.5f, 7, 5, 2);
        this.leftarm.func_78784_a(52, 54).func_78789_a(0.0f, -1.0f, -2.0f, 2, 5, 3);
        (this.hips = new ModelRenderer((ModelBase)this, 84, 25)).func_78789_a(-5.0f, 0.0f, -2.0f, 10, 3, 4);
        this.hips.func_78793_a(0.0f, 1.0f, 0.0f);
        (this.spine = new ModelRenderer((ModelBase)this, 84, 18)).func_78789_a(-1.5f, 0.0f, -1.5f, 3, 4, 3);
        this.spine.func_78793_a(0.0f, -3.0f, 0.0f);
        this.leftleg = new ModelRenderer((ModelBase)this, 84, 32);
        this.leftleg.field_78809_i = true;
        this.leftleg.func_78793_a(1.0f, 2.0f, 0.0f);
        this.leftleg.func_78784_a(84, 32).func_78789_a(0.0f, 0.0f, -1.5f, 3, 8, 3);
        this.leftleg.func_78784_a(84, 43).func_78789_a(-0.5f, 8.0f, -4.0f, 6, 14, 7);
        (this.rightleg = new ModelRenderer((ModelBase)this, 84, 32)).func_78793_a(-1.0f, 2.0f, 0.0f);
        this.rightleg.func_78784_a(84, 32).func_78789_a(-3.0f, 0.0f, -1.5f, 3, 8, 3);
        this.rightleg.func_78784_a(84, 43).func_78789_a(-5.5f, 8.0f, -4.0f, 6, 14, 7);
    }
    
    public void func_78088_a(final Entity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        this.func_78087_a(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entity);
        this.head.func_78785_a(scale);
        this.body.func_78785_a(scale);
        this.rightarm.func_78785_a(scale);
        this.leftarm.func_78785_a(scale);
        this.rightleg.func_78785_a(scale);
        this.leftleg.func_78785_a(scale);
        this.ribs.func_78785_a(scale);
        this.hips.func_78785_a(scale);
        this.spine.func_78785_a(scale);
    }
    
    public void func_78087_a(final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scaleFactor, final Entity entity) {
        this.head.field_78796_g = netHeadYaw / 57.295776f;
        this.head.field_78795_f = headPitch / 57.295776f;
        this.leftleg.field_78795_f = -1.5f * this.func_78172_a(limbSwing, 13.0f) * limbSwingAmount;
        this.rightleg.field_78795_f = 1.5f * this.func_78172_a(limbSwing, 13.0f) * limbSwingAmount;
        this.leftleg.field_78796_g = 0.0f;
        this.rightleg.field_78796_g = 0.0f;
        this.rightarm.field_78808_h = MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f + 0.05f;
        this.leftarm.field_78808_h = -MathHelper.func_76134_b(ageInTicks * 0.09f) * 0.05f - 0.05f;
    }
    
    public void func_78086_a(final EntityLivingBase entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        final EntityTFTowerGolem golem = (EntityTFTowerGolem)entity;
        final int var6 = golem.getAttackTimer();
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
