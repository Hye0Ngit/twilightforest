// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import java.util.function.Function;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.monster.Wraith;
import net.minecraft.client.model.HumanoidModel;

public class WraithModel extends HumanoidModel<Wraith>
{
    private final ModelPart dress;
    
    public WraithModel(final ModelPart root) {
        super(root, (Function)RenderType::m_110473_);
        this.dress = root.m_171324_("dress");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = HumanoidModel.m_170681_(CubeDeformation.f_171458_, 0.0f);
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("dress", CubeListBuilder.m_171558_().m_171514_(40, 16).m_171481_(-4.0f, 12.0f, -2.0f, 8.0f, 12.0f, 4.0f), PartPose.f_171404_);
        return LayerDefinition.m_171565_(mesh, 64, 32);
    }
    
    protected Iterable<ModelPart> m_5607_() {
        return (Iterable<ModelPart>)ImmutableList.of((Object)this.f_102808_, (Object)this.f_102809_);
    }
    
    protected Iterable<ModelPart> m_5608_() {
        return (Iterable<ModelPart>)ImmutableList.of((Object)this.f_102810_, (Object)this.f_102811_, (Object)this.f_102812_, (Object)this.dress);
    }
    
    public void m_7695_(final PoseStack p_102034_, final VertexConsumer p_102035_, final int p_102036_, final int p_102037_, final float p_102038_, final float p_102039_, final float p_102040_, final float p_102041_) {
        super.m_7695_(p_102034_, p_102035_, p_102036_, p_102037_, p_102038_, p_102039_, p_102040_, 0.6f);
    }
    
    public void setupAnim(final Wraith entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        super.m_6973_((LivingEntity)entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        final float var8 = Mth.m_14031_(this.f_102608_ * 3.1415927f);
        final float var9 = Mth.m_14031_((1.0f - (1.0f - this.f_102608_) * (1.0f - this.f_102608_)) * 3.1415927f);
        this.f_102811_.f_104205_ = 0.0f;
        this.f_102812_.f_104205_ = 0.0f;
        this.f_102811_.f_104204_ = -(0.1f - var8 * 0.6f);
        this.f_102812_.f_104204_ = 0.1f - var8 * 0.6f;
        this.f_102811_.f_104203_ = -1.5707964f;
        this.f_102812_.f_104203_ = -1.5707964f;
        final ModelPart f_102811_ = this.f_102811_;
        f_102811_.f_104203_ -= var8 * 1.2f - var9 * 0.4f;
        final ModelPart f_102812_ = this.f_102812_;
        f_102812_.f_104203_ -= var8 * 1.2f - var9 * 0.4f;
        final ModelPart f_102811_2 = this.f_102811_;
        f_102811_2.f_104205_ += Mth.m_14089_(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelPart f_102812_2 = this.f_102812_;
        f_102812_2.f_104205_ -= Mth.m_14089_(ageInTicks * 0.09f) * 0.05f + 0.05f;
        final ModelPart f_102811_3 = this.f_102811_;
        f_102811_3.f_104203_ += Mth.m_14031_(ageInTicks * 0.067f) * 0.05f;
        final ModelPart f_102812_3 = this.f_102812_;
        f_102812_3.f_104203_ -= Mth.m_14031_(ageInTicks * 0.067f) * 0.05f;
    }
}
