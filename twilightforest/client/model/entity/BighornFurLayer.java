// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.passive.Bighorn;
import net.minecraft.client.model.SheepFurModel;

public class BighornFurLayer extends SheepFurModel<Bighorn>
{
    public BighornFurLayer(final ModelPart root) {
        super(root);
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("head", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171488_(-3.0f, -4.0f, -4.0f, 6.0f, 6.0f, 6.0f, new CubeDeformation(0.6f)), PartPose.m_171419_(0.0f, 6.0f, -8.0f));
        partRoot.m_171599_("body", CubeListBuilder.m_171558_().m_171514_(28, 8).m_171488_(-4.0f, -9.0f, -7.0f, 8.0f, 15.0f, 6.0f, new CubeDeformation(0.5f)), PartPose.m_171419_(0.0f, 5.0f, 2.0f));
        final CubeListBuilder legOffset = CubeListBuilder.m_171558_().m_171514_(0, 16).m_171488_(-2.0f, 0.0f, -2.0f, 4.0f, 6.0f, 4.0f, new CubeDeformation(0.4f));
        partRoot.m_171599_("right_hind_leg", legOffset, PartPose.m_171419_(-3.0f, 12.0f, 7.0f));
        partRoot.m_171599_("left_hind_leg", legOffset, PartPose.m_171419_(3.0f, 12.0f, 7.0f));
        partRoot.m_171599_("right_front_leg", legOffset, PartPose.m_171419_(-3.0f, 12.0f, -5.0f));
        partRoot.m_171599_("left_front_leg", legOffset, PartPose.m_171419_(3.0f, 12.0f, -5.0f));
        return LayerDefinition.m_171565_(mesh, 64, 32);
    }
}
