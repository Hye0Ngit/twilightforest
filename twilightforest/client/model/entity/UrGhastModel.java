// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import twilightforest.entity.CarminiteGhastguardEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.model.Model;
import java.util.Random;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import twilightforest.entity.boss.UrGhastEntity;

@OnlyIn(Dist.CLIENT)
public class UrGhastModel extends TFGhastModel<UrGhastEntity>
{
    protected ModelRenderer[][] subTentacles;
    protected ModelRenderer[][] smallTentacles;
    
    public UrGhastModel() {
        this.smallTentacles = new ModelRenderer[2][3];
        for (int i = 0; i < this.smallTentacles.length; ++i) {
            this.makeSmallTentacle(i);
        }
    }
    
    @Override
    protected void makeTentacle(final byte yOffset, final Random random, final int num) {
        this.tentacles[num] = new ModelRenderer((Model)this, 0, 0);
        float length = 5.333f;
        this.tentacles[num].func_228300_a_(-1.5f, 0.0f, -1.5f, 3.333f, length, 3.333f);
        if (num == 0) {
            this.tentacles[num].field_78800_c = 4.5f;
            this.tentacles[num].field_78798_e = 4.5f;
            this.tentacles[num].field_78797_d = (float)(23 + yOffset);
        }
        if (num == 1) {
            this.tentacles[num].field_78800_c = -4.5f;
            this.tentacles[num].field_78798_e = 4.5f;
            this.tentacles[num].field_78797_d = (float)(23 + yOffset);
        }
        if (num == 2) {
            this.tentacles[num].field_78800_c = 0.0f;
            this.tentacles[num].field_78798_e = 0.0f;
            this.tentacles[num].field_78797_d = (float)(23 + yOffset);
        }
        if (num == 3) {
            this.tentacles[num].field_78800_c = 5.5f;
            this.tentacles[num].field_78798_e = -4.5f;
            this.tentacles[num].field_78797_d = (float)(23 + yOffset);
        }
        if (num == 4) {
            this.tentacles[num].field_78800_c = -5.5f;
            this.tentacles[num].field_78798_e = -4.5f;
            this.tentacles[num].field_78797_d = (float)(23 + yOffset);
        }
        else if (num == 5) {
            this.tentacles[num].field_78800_c = -7.5f;
            this.tentacles[num].field_78797_d = 3.5f;
            this.tentacles[num].field_78798_e = -1.0f;
            this.tentacles[num].field_78808_h = 0.7853982f;
        }
        else if (num == 6) {
            this.tentacles[num].field_78800_c = -7.5f;
            this.tentacles[num].field_78797_d = -1.5f;
            this.tentacles[num].field_78798_e = 3.5f;
            this.tentacles[num].field_78808_h = 1.0471976f;
        }
        else if (num == 7) {
            this.tentacles[num].field_78800_c = 7.5f;
            this.tentacles[num].field_78797_d = 3.5f;
            this.tentacles[num].field_78798_e = -1.0f;
            this.tentacles[num].field_78808_h = -0.7853982f;
        }
        else if (num == 8) {
            this.tentacles[num].field_78800_c = 7.5f;
            this.tentacles[num].field_78797_d = -1.5f;
            this.tentacles[num].field_78798_e = 3.5f;
            this.tentacles[num].field_78808_h = -1.0471976f;
        }
        if (this.subTentacles == null) {
            this.subTentacles = new ModelRenderer[this.tentacles.length][2];
        }
        length = 6.66f;
        (this.subTentacles[num][0] = new ModelRenderer((Model)this, 0, 3)).func_228300_a_(-1.5f, -1.35f, -1.5f, 3.333f, length, 3.333f);
        this.subTentacles[num][0].field_78800_c = 0.0f;
        this.subTentacles[num][0].field_78798_e = 0.0f;
        this.subTentacles[num][0].field_78797_d = length;
        this.tentacles[num].func_78792_a(this.subTentacles[num][0]);
        length = 4.0f;
        (this.subTentacles[num][1] = new ModelRenderer((Model)this, 0, 9)).func_228300_a_(-1.5f, 1.3f, -1.5f, 3.333f, length, 3.333f);
        this.subTentacles[num][1].field_78800_c = 0.0f;
        this.subTentacles[num][1].field_78798_e = 0.0f;
        this.subTentacles[num][1].field_78797_d = length;
        this.subTentacles[num][0].func_78792_a(this.subTentacles[num][1]);
        this.body.func_78792_a(this.tentacles[num]);
    }
    
    protected void makeSmallTentacle(final int num) {
    }
    
    @Override
    public void setRotationAngles(final UrGhastEntity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        super.setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        for (int i = 0; i < this.subTentacles.length; ++i) {
            final float wiggle = Math.min(limbSwingAmount, 0.6f);
            final float time = (ageInTicks + i * 9) / 2.0f;
            this.subTentacles[i][0].field_78795_f = (MathHelper.func_76134_b(time * 0.6662f) - 1.0471976f) * wiggle;
            this.subTentacles[i][1].field_78795_f = MathHelper.func_76134_b(time * 0.7774f) * 1.2f * wiggle;
            this.subTentacles[i][0].field_78795_f = 0.1f + MathHelper.func_76134_b(time * 0.3335f) * 0.15f;
            this.subTentacles[i][1].field_78795_f = 0.1f + MathHelper.func_76134_b(time * 0.4445f) * 0.2f;
            final float yTwist = 0.4f;
            this.tentacles[i].field_78796_g = yTwist * MathHelper.func_76126_a(time * 0.3f);
        }
    }
}
