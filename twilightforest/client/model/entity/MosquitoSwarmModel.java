// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.core.Direction;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import java.util.Random;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.monster.MosquitoSwarm;
import net.minecraft.client.model.HierarchicalModel;

public class MosquitoSwarmModel extends HierarchicalModel<MosquitoSwarm>
{
    private final ModelPart root;
    private final ModelPart core;
    private final ModelPart group1;
    private final ModelPart group2;
    private final ModelPart group3;
    private final ModelPart group4;
    private final ModelPart group5;
    private final ModelPart group6;
    private static final Random rand;
    
    public MosquitoSwarmModel(final ModelPart root) {
        this.root = root;
        this.core = this.root.m_171324_("core");
        this.group1 = this.core.m_171324_("group_1");
        this.group2 = this.core.m_171324_("group_2");
        this.group3 = this.core.m_171324_("group_3");
        this.group4 = this.core.m_171324_("group_4");
        this.group5 = this.core.m_171324_("group_5");
        this.group6 = this.core.m_171324_("group_6");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        final PartDefinition core = partRoot.m_171599_("core", CubeListBuilder.m_171558_().m_171514_(MosquitoSwarmModel.rand.nextInt(28), MosquitoSwarmModel.rand.nextInt(28)).m_171481_(-0.5f, 2.0f, -0.5f, 1.0f, 1.0f, 1.0f), PartPose.m_171419_(0.0f, -4.0f, 0.0f));
        final PartPose offset = PartPose.m_171419_(-0.5f, -2.0f, -0.5f);
        final Direction[] values = Direction.values();
        for (int length = values.length, i = 0; i < length; ++i) {
            final Direction dir = values[i];
            addBugsToGroup(dir.ordinal(), core.m_171599_("group_" + (dir.ordinal() + 1), CubeListBuilder.m_171558_().m_171514_(MosquitoSwarmModel.rand.nextInt(28), MosquitoSwarmModel.rand.nextInt(28)).m_171481_((float)(dir.m_122429_() * 11), (float)(dir.m_122430_() * 11), (float)(dir.m_122431_() * 11), 1.0f, 1.0f, 1.0f), offset));
        }
        return LayerDefinition.m_171565_(mesh, 64, 64);
    }
    
    public static void addBugsToGroup(final int iteration, final PartDefinition parent) {
        final int bugs = 16;
        for (int i = 0; i < 16; ++i) {
            final Vec3 vec = new Vec3(0.0, 0.0, 0.0);
            final float rotateY = i * 22.5f * 3.1415927f / 180.0f;
            vec.m_82496_(rotateY);
            final float bugX = (MosquitoSwarmModel.rand.nextFloat() - MosquitoSwarmModel.rand.nextFloat()) * 16.0f;
            final float bugY = (MosquitoSwarmModel.rand.nextFloat() - MosquitoSwarmModel.rand.nextFloat()) * 16.0f;
            final float bugZ = (MosquitoSwarmModel.rand.nextFloat() - MosquitoSwarmModel.rand.nextFloat()) * 16.0f;
            parent.m_171599_("bug_" + (iteration * 16 + i), CubeListBuilder.m_171558_().m_171514_(MosquitoSwarmModel.rand.nextInt(28), MosquitoSwarmModel.rand.nextInt(28)).m_171481_(bugX, bugY, bugZ, 1.0f, 1.0f, 1.0f), PartPose.m_171423_((float)vec.f_82479_, (float)vec.f_82480_, (float)vec.f_82481_, 0.0f, rotateY, 0.0f));
        }
    }
    
    public ModelPart m_142109_() {
        return this.root;
    }
    
    public void setupAnim(final MosquitoSwarm entity, final float v, final float v1, final float v2, final float v3, final float v4) {
    }
    
    public void prepareMobModel(final MosquitoSwarm entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        this.core.f_104204_ = (entity.f_19797_ + partialTicks) / 5.0f;
        this.core.f_104203_ = Mth.m_14031_((entity.f_19797_ + partialTicks) / 5.0f) / 4.0f;
        this.core.f_104205_ = Mth.m_14089_((entity.f_19797_ + partialTicks) / 5.0f) / 4.0f;
        this.group1.f_104204_ = (entity.f_19797_ + partialTicks) / 2.0f;
        this.group1.f_104203_ = Mth.m_14031_((entity.f_19797_ + partialTicks) / 6.0f) / 2.0f;
        this.group1.f_104205_ = Mth.m_14089_((entity.f_19797_ + partialTicks) / 5.0f) / 4.0f;
        this.group2.f_104204_ = Mth.m_14031_((entity.f_19797_ + partialTicks) / 2.0f) / 3.0f;
        this.group2.f_104203_ = (entity.f_19797_ + partialTicks) / 5.0f;
        this.group2.f_104205_ = Mth.m_14089_((entity.f_19797_ + partialTicks) / 5.0f) / 4.0f;
        this.group3.f_104204_ = Mth.m_14031_((entity.f_19797_ + partialTicks) / 7.0f) / 3.0f;
        this.group3.f_104203_ = Mth.m_14089_((entity.f_19797_ + partialTicks) / 4.0f) / 2.0f;
        this.group3.f_104205_ = (entity.f_19797_ + partialTicks) / 5.0f;
        this.group4.f_104203_ = (entity.f_19797_ + partialTicks) / 2.0f;
        this.group4.f_104205_ = Mth.m_14031_((entity.f_19797_ + partialTicks) / 6.0f) / 2.0f;
        this.group4.f_104204_ = Mth.m_14031_((entity.f_19797_ + partialTicks) / 5.0f) / 4.0f;
        this.group5.f_104205_ = (entity.f_19797_ + partialTicks) / 2.0f;
        this.group5.f_104204_ = Mth.m_14089_((entity.f_19797_ + partialTicks) / 5.0f) / 4.0f;
        this.group5.f_104203_ = Mth.m_14089_((entity.f_19797_ + partialTicks) / 5.0f) / 4.0f;
        this.group6.f_104205_ = Mth.m_14089_((entity.f_19797_ + partialTicks) / 7.0f) / 3.0f;
        this.group6.f_104203_ = Mth.m_14089_((entity.f_19797_ + partialTicks) / 4.0f) / 2.0f;
        this.group6.f_104204_ = (entity.f_19797_ + partialTicks) / 5.0f;
    }
    
    static {
        rand = new Random();
    }
}
