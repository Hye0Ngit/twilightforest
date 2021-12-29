// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.armor;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.model.HumanoidModel;

public class TFArmorModel extends HumanoidModel<LivingEntity>
{
    public TFArmorModel(final ModelPart root) {
        super(root);
    }
    
    public void m_6973_(final LivingEntity entityIn, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        if (entityIn instanceof final ArmorStand entityarmorstand) {
            this.f_102808_.f_104203_ = 0.017453292f * entityarmorstand.m_31680_().m_123156_();
            this.f_102808_.f_104204_ = 0.017453292f * entityarmorstand.m_31680_().m_123157_();
            this.f_102808_.f_104205_ = 0.017453292f * entityarmorstand.m_31680_().m_123158_();
            this.f_102808_.m_104227_(0.0f, 1.0f, 0.0f);
            this.f_102810_.f_104203_ = 0.017453292f * entityarmorstand.m_31685_().m_123156_();
            this.f_102810_.f_104204_ = 0.017453292f * entityarmorstand.m_31685_().m_123157_();
            this.f_102810_.f_104205_ = 0.017453292f * entityarmorstand.m_31685_().m_123158_();
            this.f_102812_.f_104203_ = 0.017453292f * entityarmorstand.m_31688_().m_123156_();
            this.f_102812_.f_104204_ = 0.017453292f * entityarmorstand.m_31688_().m_123157_();
            this.f_102812_.f_104205_ = 0.017453292f * entityarmorstand.m_31688_().m_123158_();
            this.f_102811_.f_104203_ = 0.017453292f * entityarmorstand.m_31689_().m_123156_();
            this.f_102811_.f_104204_ = 0.017453292f * entityarmorstand.m_31689_().m_123157_();
            this.f_102811_.f_104205_ = 0.017453292f * entityarmorstand.m_31689_().m_123158_();
            this.f_102814_.f_104203_ = 0.017453292f * entityarmorstand.m_31691_().m_123156_();
            this.f_102814_.f_104204_ = 0.017453292f * entityarmorstand.m_31691_().m_123157_();
            this.f_102814_.f_104205_ = 0.017453292f * entityarmorstand.m_31691_().m_123158_();
            this.f_102814_.m_104227_(1.9f, 11.0f, 0.0f);
            this.f_102813_.f_104203_ = 0.017453292f * entityarmorstand.m_31694_().m_123156_();
            this.f_102813_.f_104204_ = 0.017453292f * entityarmorstand.m_31694_().m_123157_();
            this.f_102813_.f_104205_ = 0.017453292f * entityarmorstand.m_31694_().m_123158_();
            this.f_102813_.m_104227_(-1.9f, 11.0f, 0.0f);
            this.f_102809_.m_104315_(this.f_102808_);
        }
        else {
            super.m_6973_(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        }
    }
}
