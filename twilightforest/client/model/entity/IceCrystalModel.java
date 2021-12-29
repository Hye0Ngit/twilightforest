// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import java.util.function.Function;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.monster.IceCrystal;
import net.minecraft.client.model.HierarchicalModel;

public class IceCrystalModel extends HierarchicalModel<IceCrystal>
{
    private ModelPart root;
    private final ModelPart[] spikes;
    private boolean alive;
    
    public IceCrystalModel(final ModelPart root) {
        super((Function)RenderType::m_110473_);
        this.spikes = new ModelPart[16];
        this.root = root;
        for (int i = 0; i < this.spikes.length; ++i) {
            this.spikes[i] = root.m_171324_("spike_" + i);
        }
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        for (int i = 0; i < 16; ++i) {
            final int spikeLength = (i % 2 == 0) ? 6 : 8;
            final PartDefinition spike = partRoot.m_171599_("spike_" + i, CubeListBuilder.m_171558_().m_171514_(0, 16).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, (float)spikeLength, 2.0f), PartPose.f_171404_);
            spike.m_171599_("cube_" + i, CubeListBuilder.m_171558_().m_171514_(8, 16).m_171481_(-1.5f, -1.5f, -1.5f, 3.0f, 3.0f, 3.0f), PartPose.m_171423_(0.0f, (float)spikeLength, 0.0f, 0.0f, 0.0f, 0.7853982f));
        }
        return LayerDefinition.m_171565_(mesh, 32, 32);
    }
    
    public ModelPart m_142109_() {
        return this.root;
    }
    
    public void m_7695_(final PoseStack stack, final VertexConsumer builder, final int light, final int overlay, final float red, final float green, final float blue, final float alpha) {
        for (final ModelPart spike : this.spikes) {
            spike.m_104306_(stack, builder, light, overlay, red, green, blue, this.alive ? 0.6f : alpha);
        }
    }
    
    public void setupAnim(final IceCrystal entity, final float v, final float v1, final float v2, final float v3, final float v4) {
    }
    
    public void prepareMobModel(final IceCrystal entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        this.alive = entity.m_6084_();
        for (int i = 0; i < this.spikes.length; ++i) {
            this.spikes[i].f_104203_ = Mth.m_14031_((entity.f_19797_ + partialTicks) / 5.0f) / 4.0f;
            this.spikes[i].f_104204_ = (entity.f_19797_ + partialTicks) / 5.0f;
            this.spikes[i].f_104205_ = Mth.m_14089_((entity.f_19797_ + partialTicks) / 5.0f) / 4.0f;
            final ModelPart modelPart = this.spikes[i];
            modelPart.f_104203_ += (float)(i * 0.39269908169872414);
            if (i % 4 == 0) {
                final ModelPart modelPart2 = this.spikes[i];
                ++modelPart2.f_104204_;
            }
            else if (i % 4 == 2) {
                final ModelPart modelPart3 = this.spikes[i];
                --modelPart3.f_104204_;
            }
        }
    }
}
