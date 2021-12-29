// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.monster.LoyalZombie;
import net.minecraft.client.model.HumanoidModel;

public class LoyalZombieModel extends HumanoidModel<LoyalZombie>
{
    public LoyalZombieModel(final ModelPart part) {
        super(part);
    }
    
    public void setupAnim(final LoyalZombie e, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        super.m_6973_((LivingEntity)e, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        final boolean flag = e.m_5912_();
        final float f = Mth.m_14031_(this.f_102608_ * 3.1415927f);
        final float f2 = Mth.m_14031_((1.0f - (1.0f - this.f_102608_) * (1.0f - this.f_102608_)) * 3.1415927f);
        this.f_102811_.f_104205_ = 0.0f;
        this.f_102812_.f_104205_ = 0.0f;
        this.f_102811_.f_104204_ = -(0.1f - f * 0.6f);
        this.f_102812_.f_104204_ = 0.1f - f * 0.6f;
        final float f3 = -3.1415927f / (flag ? 1.5f : 2.25f);
        this.f_102811_.f_104203_ = f3;
        this.f_102812_.f_104203_ = f3;
        final ModelPart f_102811_ = this.f_102811_;
        f_102811_.f_104203_ += f * 1.2f - f2 * 0.4f;
        final ModelPart f_102812_ = this.f_102812_;
        f_102812_.f_104203_ += f * 1.2f - f2 * 0.4f;
        final ModelPart f_102811_2 = this.f_102811_;
        f_102811_2.f_104205_ += Mth.m_14089_(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelPart f_102812_2 = this.f_102812_;
        f_102812_2.f_104205_ -= Mth.m_14089_(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelPart f_102811_3 = this.f_102811_;
        f_102811_3.f_104203_ += Mth.m_14031_(ageInTicks * 0.067f) * 0.05f;
        final ModelPart f_102812_3 = this.f_102812_;
        f_102812_3.f_104203_ -= Mth.m_14031_(ageInTicks * 0.067f) * 0.05f;
    }
    
    public void m_7695_(final PoseStack stack, final VertexConsumer builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        super.m_7695_(stack, builder, light, overlay, red * 0.25f, green, blue * 0.25f, scale);
    }
}
