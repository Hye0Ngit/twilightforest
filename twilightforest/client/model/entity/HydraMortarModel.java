// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.boss.HydraMortarHead;
import net.minecraft.client.model.HierarchicalModel;

public class HydraMortarModel extends HierarchicalModel<HydraMortarHead>
{
    public ModelPart root;
    
    public HydraMortarModel(final ModelPart root) {
        this.root = root;
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("mortar", CubeListBuilder.m_171558_().m_171514_(0, 0).m_171481_(-4.0f, 0.0f, -4.0f, 8.0f, 8.0f, 8.0f), PartPose.f_171404_);
        return LayerDefinition.m_171565_(mesh, 32, 32);
    }
    
    public ModelPart m_142109_() {
        return this.root;
    }
    
    public void setupAnim(final HydraMortarHead entity, final float v, final float v1, final float v2, final float v3, final float v4) {
    }
}
