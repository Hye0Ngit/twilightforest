// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import com.google.common.collect.ImmutableList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import twilightforest.entity.passive.BoarEntity;

@OnlyIn(Dist.CLIENT)
public class BoarModel<T extends BoarEntity> extends AgeableModel<T>
{
    public ModelRenderer part1;
    public ModelRenderer torso;
    public ModelRenderer rightFrontLeg;
    public ModelRenderer leftFrontLeg;
    public ModelRenderer rightBackLeg;
    public ModelRenderer leftBackLeg;
    
    public BoarModel() {
        this.field_78090_t = 64;
        this.field_78089_u = 64;
        (this.rightFrontLeg = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-2.9f, 18.0f, -2.0f);
        this.rightFrontLeg.func_78784_a(0, 13).func_228302_a_(-2.0f, 0.0f, -1.9f, 4.0f, 6.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        (this.leftFrontLeg = new ModelRenderer((Model)this, 0, 0)).func_78793_a(2.9f, 18.0f, -2.0f);
        this.leftFrontLeg.func_78784_a(0, 23).func_228302_a_(-2.0f, 0.0f, -1.9f, 4.0f, 6.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        (this.rightBackLeg = new ModelRenderer((Model)this, 0, 0)).func_78793_a(-3.1f, 18.0f, 9.0f);
        this.rightBackLeg.func_78784_a(0, 33).func_228302_a_(-2.0f, 0.0f, -2.0f, 4.0f, 6.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        (this.leftBackLeg = new ModelRenderer((Model)this, 0, 0)).func_78793_a(3.1f, 18.0f, 9.0f);
        this.leftBackLeg.func_78784_a(0, 43).func_228302_a_(-2.0f, 0.0f, -2.0f, 4.0f, 6.0f, 4.0f, 0.0f, 0.0f, 0.0f);
        (this.part1 = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 15.5f, -5.0f);
        this.part1.func_228302_a_(-4.0f, -4.0f, -5.0f, 8.0f, 7.0f, 6.0f, 0.0f, 0.0f, 0.0f);
        this.part1.func_78784_a(46, 22).func_228302_a_(-3.0f, -1.0f, -8.0f, 6.0f, 4.0f, 3.0f, 0.0f, 0.0f, 0.0f);
        this.part1.func_78784_a(28, 0).func_228302_a_(-4.0f, 0.0f, -8.0f, 1.0f, 2.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        this.part1.func_78784_a(28, 3).func_228302_a_(3.0f, 0.0f, -8.0f, 1.0f, 2.0f, 1.0f, 0.0f, 0.0f, 0.0f);
        (this.torso = new ModelRenderer((Model)this, 0, 0)).func_78793_a(0.0f, 19.0f, 2.0f);
        this.torso.func_78784_a(28, 0).func_228302_a_(-5.0f, -6.0f, 0.0f, 10.0f, 14.0f, 8.0f, 0.0f, 0.0f, 0.0f);
        this.setRotateAngle(this.torso, 1.6580628f, 0.0f, 0.0f);
    }
    
    public void setRotationAngles(final T entityIn, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.part1.field_78795_f = headPitch * 0.017453292f;
        this.part1.field_78796_g = netHeadYaw * 0.017453292f;
        this.torso.field_78795_f = 1.5707964f;
        this.rightBackLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
        this.leftBackLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.rightFrontLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f + 3.1415927f) * 1.4f * limbSwingAmount;
        this.leftFrontLeg.field_78795_f = MathHelper.func_76134_b(limbSwing * 0.6662f) * 1.4f * limbSwingAmount;
    }
    
    protected Iterable<ModelRenderer> func_225602_a_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.part1);
    }
    
    protected Iterable<ModelRenderer> func_225600_b_() {
        return (Iterable<ModelRenderer>)ImmutableList.of((Object)this.torso, (Object)this.leftBackLeg, (Object)this.rightBackLeg, (Object)this.leftFrontLeg, (Object)this.rightFrontLeg);
    }
    
    public void setRotateAngle(final ModelRenderer modelRenderer, final float x, final float y, final float z) {
        modelRenderer.field_78795_f = x;
        modelRenderer.field_78796_g = y;
        modelRenderer.field_78808_h = z;
    }
}
