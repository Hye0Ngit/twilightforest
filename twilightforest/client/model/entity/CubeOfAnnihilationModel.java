// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.CubeOfAnnihilation;
import net.minecraft.client.model.ListModel;

public class CubeOfAnnihilationModel extends ListModel<CubeOfAnnihilation>
{
    private final ModelPart box;
    private final ModelPart boxX;
    private final ModelPart boxY;
    private final ModelPart boxZ;
    
    public CubeOfAnnihilationModel(final ModelPart root) {
        this.box = root.m_171324_("box");
        this.boxX = root.m_171324_("box_x");
        this.boxY = root.m_171324_("box_y");
        this.boxZ = root.m_171324_("box_z");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("box", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f), PartPose.f_171404_);
        partRoot.m_171599_("box_x", CubeListBuilder.m_171558_().m_171514_(0, 32).m_171481_(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f), PartPose.f_171404_);
        partRoot.m_171599_("box_y", CubeListBuilder.m_171558_().m_171514_(0, 32).m_171481_(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f), PartPose.f_171404_);
        partRoot.m_171599_("box_z", CubeListBuilder.m_171558_().m_171514_(0, 32).m_171481_(-8.0f, -8.0f, -8.0f, 16.0f, 16.0f, 16.0f), PartPose.f_171404_);
        return LayerDefinition.m_171565_(mesh, 64, 64);
    }
    
    public Iterable<ModelPart> m_6195_() {
        return (Iterable<ModelPart>)ImmutableList.of((Object)this.box, (Object)this.boxX, (Object)this.boxY, (Object)this.boxZ);
    }
    
    public void setupAnim(final CubeOfAnnihilation entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.boxX.f_104203_ = Mth.m_14031_(entity.f_19797_ + headPitch) / 5.0f;
        this.boxY.f_104204_ = Mth.m_14031_(entity.f_19797_ + headPitch) / 5.0f;
        this.boxZ.f_104205_ = Mth.m_14031_(entity.f_19797_ + headPitch) / 5.0f;
    }
}
