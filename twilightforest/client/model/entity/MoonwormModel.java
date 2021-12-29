// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import twilightforest.client.BugModelAnimationHelper;
import net.minecraft.util.Mth;
import javax.annotation.Nullable;
import twilightforest.block.entity.MoonwormBlockEntity;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import java.util.function.Function;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.Model;

public class MoonwormModel extends Model
{
    private final ModelPart shape1;
    private final ModelPart shape2;
    private final ModelPart shape3;
    private final ModelPart head;
    
    public MoonwormModel(final ModelPart root) {
        super((Function)RenderType::m_110458_);
        this.head = root.m_171324_("head");
        this.shape1 = root.m_171324_("shape1");
        this.shape2 = root.m_171324_("shape2");
        this.shape3 = root.m_171324_("shape3");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition meshdefinition = new MeshDefinition();
        final PartDefinition partdefinition = meshdefinition.m_171576_();
        partdefinition.m_171599_("shape1", CubeListBuilder.m_171558_().m_171514_(0, 4).m_171481_(-1.0f, -1.0f, -1.0f, 4.0f, 2.0f, 2.0f), PartPose.m_171419_(-1.0f, 7.0f, 3.0f));
        partdefinition.m_171599_("shape2", CubeListBuilder.m_171558_().m_171514_(0, 8).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 4.0f), PartPose.m_171419_(3.0f, 7.0f, 0.0f));
        partdefinition.m_171599_("shape3", CubeListBuilder.m_171558_().m_171514_(0, 14).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171419_(2.0f, 7.0f, -2.0f));
        partdefinition.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171419_(-3.0f, 7.0f, 2.0f));
        return LayerDefinition.m_171565_(meshdefinition, 32, 32);
    }
    
    public void setRotationAngles(@Nullable final MoonwormBlockEntity moonworm, final float partialTime) {
        this.head.f_104201_ = 7.0f;
        this.shape1.f_104201_ = 7.0f;
        this.shape2.f_104201_ = 7.0f;
        this.shape3.f_104201_ = 7.0f;
        if (moonworm != null && moonworm.yawDelay == 0) {
            final float time = moonworm.desiredYaw - moonworm.currentYaw - partialTime;
            final ModelPart head = this.head;
            head.f_104201_ += Math.min(0.0f, Mth.m_14031_(time / 2.0f));
            final ModelPart shape1 = this.shape1;
            shape1.f_104201_ += Math.min(0.0f, Mth.m_14031_(time / 2.0f + 1.0f));
            final ModelPart shape2 = this.shape2;
            shape2.f_104201_ += Math.min(0.0f, Mth.m_14031_(time / 2.0f + 2.0f));
            final ModelPart shape3 = this.shape3;
            shape3.f_104201_ += Math.min(0.0f, Mth.m_14031_(time / 2.0f + 3.0f));
        }
        else if (moonworm == null && BugModelAnimationHelper.yawWriggleDelay == 0) {
            final float time = BugModelAnimationHelper.desiredRotation - BugModelAnimationHelper.currentRotation - partialTime;
            final ModelPart head2 = this.head;
            head2.f_104201_ += Math.min(0.0f, Mth.m_14031_(time / 2.0f));
            final ModelPart shape4 = this.shape1;
            shape4.f_104201_ += Math.min(0.0f, Mth.m_14031_(time / 2.0f + 1.0f));
            final ModelPart shape5 = this.shape2;
            shape5.f_104201_ += Math.min(0.0f, Mth.m_14031_(time / 2.0f + 2.0f));
            final ModelPart shape6 = this.shape3;
            shape6.f_104201_ += Math.min(0.0f, Mth.m_14031_(time / 2.0f + 3.0f));
        }
    }
    
    public void m_7695_(final PoseStack ms, final VertexConsumer buffer, final int light, final int overlay, final float r, final float g, final float b, final float a) {
        this.shape1.m_104306_(ms, buffer, light, overlay, r, g, b, a);
        this.shape2.m_104306_(ms, buffer, light, overlay, r, g, b, a);
        this.shape3.m_104306_(ms, buffer, light, overlay, r, g, b, a);
        this.head.m_104306_(ms, buffer, light, overlay, r, g, b, a);
    }
}
