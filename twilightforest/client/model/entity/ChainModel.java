// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.model.ListModel;

public class ChainModel extends ListModel<Entity>
{
    private final ModelPart chain;
    
    public ChainModel(final ModelPart root) {
        this.chain = root.m_171324_("chain");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("chain", CubeListBuilder.m_171558_().m_171514_(56, 36).m_171481_(-1.0f, -1.0f, -1.0f, 2.0f, 2.0f, 2.0f), PartPose.f_171404_);
        return LayerDefinition.m_171565_(mesh, 64, 64);
    }
    
    public Iterable<ModelPart> m_6195_() {
        return (Iterable<ModelPart>)ImmutableList.of((Object)this.chain);
    }
    
    public void m_6973_(final Entity entity, final float v, final float v1, final float v2, final float v3, final float v4) {
    }
}
