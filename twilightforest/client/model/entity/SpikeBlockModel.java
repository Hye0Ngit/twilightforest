// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.SpikeBlock;
import net.minecraft.client.model.ListModel;

public class SpikeBlockModel extends ListModel<SpikeBlock>
{
    ModelPart block;
    
    public SpikeBlockModel(final ModelPart root) {
        this.block = root.m_171324_("block");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition block = partRoot.m_171599_("block", CubeListBuilder.m_171558_().m_171514_(32, 32).m_171481_(-4.0f, -8.0f, -4.0f, 8.0f, 8.0f, 8.0f), PartPose.f_171404_);
        final float QUARTER_PI = 0.7853982f;
        final float ANGLE_MINOR = -0.61086524f;
        final float ANGLE_MAJOR = -0.9599311f;
        block.m_171599_("spikes_0", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(0.0f, -9.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        block.m_171599_("spikes_1", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(0.0f, -8.0f, 4.0f, 0.7853982f, 0.0f, 0.0f));
        block.m_171599_("spikes_2", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(4.0f, -8.0f, 4.0f, -0.9599311f, 0.7853982f, 0.0f));
        block.m_171599_("spikes_3", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(4.0f, -8.0f, 0.0f, 0.0f, 0.0f, 0.7853982f));
        block.m_171599_("spikes_4", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(4.0f, -8.0f, -4.0f, -0.61086524f, -0.7853982f, 0.0f));
        block.m_171599_("spikes_5", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(0.0f, -8.0f, -4.0f, 0.7853982f, 0.0f, 0.0f));
        block.m_171599_("spikes_6", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.0f, -8.0f, -4.0f, -0.61086524f, 0.7853982f, 0.0f));
        block.m_171599_("spikes_7", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.0f, -8.0f, 0.0f, 0.0f, 0.0f, 0.7853982f));
        block.m_171599_("spikes_8", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.0f, -8.0f, 4.0f, -0.9599311f, -0.7853982f, 0.0f));
        block.m_171599_("spikes_9", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(0.0f, -4.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        block.m_171599_("spikes_10", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(0.0f, -4.0f, 4.0f, 0.0f, 0.0f, 0.0f));
        block.m_171599_("spikes_11", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(4.0f, -4.0f, 5.0f, 0.0f, 0.7853982f, 0.0f));
        block.m_171599_("spikes_12", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(5.0f, -4.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        block.m_171599_("spikes_13", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(4.0f, -4.0f, -4.0f, 0.0f, 0.7853982f, 0.0f));
        block.m_171599_("spikes_14", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(0.0f, -4.0f, -5.0f, 0.0f, 0.0f, 0.0f));
        block.m_171599_("spikes_15", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.0f, -4.0f, -4.0f, 0.0f, 0.7853982f, 0.0f));
        block.m_171599_("spikes_16", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(-5.0f, -4.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        block.m_171599_("spikes_17", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.0f, -4.0f, 4.0f, 0.0f, 0.7853982f, 0.0f));
        block.m_171599_("spikes_18", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f));
        block.m_171599_("spikes_19", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(0.0f, 0.0f, 4.0f, 0.7853982f, 0.0f, 0.0f));
        block.m_171599_("spikes_20", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(4.0f, 0.0f, 4.0f, -0.61086524f, 0.7853982f, 0.0f));
        block.m_171599_("spikes_21", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(4.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.7853982f));
        block.m_171599_("spikes_22", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(4.0f, 0.0f, -4.0f, -0.9599311f, -0.7853982f, 0.0f));
        block.m_171599_("spikes_23", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(0.0f, 0.0f, -4.0f, 0.7853982f, 0.0f, 0.0f));
        block.m_171599_("spikes_24", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.0f, 0.0f, -4.0f, -0.9599311f, 0.7853982f, 0.0f));
        block.m_171599_("spikes_25", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.7853982f));
        block.m_171599_("spikes_26", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.m_171423_(-4.0f, 0.0f, 4.0f, -0.61086524f, -0.7853982f, 0.0f));
        return LayerDefinition.m_171565_(mesh, 64, 48);
    }
    
    public void setupAnim(final SpikeBlock entity, final float v, final float v1, final float v2, final float v3, final float v4) {
    }
    
    public Iterable<ModelPart> m_6195_() {
        return (Iterable<ModelPart>)ImmutableList.of((Object)this.block);
    }
}
