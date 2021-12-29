// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity.legacy;

import net.minecraft.world.entity.Entity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.boss.HydraNeck;
import net.minecraft.client.model.ListModel;

public class HydraNeckLegacyModel extends ListModel<HydraNeck>
{
    ModelPart neck;
    
    public HydraNeckLegacyModel(final ModelPart root) {
        this.neck = root.m_171324_("neck");
    }
    
    public static LayerDefinition create() {
        final MeshDefinition mesh = new MeshDefinition();
        final PartDefinition partRoot = mesh.m_171576_();
        partRoot.m_171599_("neck", CubeListBuilder.m_171558_().m_171514_(128, 136).m_171481_(-16.0f, -16.0f, -16.0f, 32.0f, 32.0f, 32.0f).m_171514_(128, 200).m_171481_(-2.0f, -23.0f, 0.0f, 4.0f, 24.0f, 24.0f), PartPose.f_171404_);
        return LayerDefinition.m_171565_(mesh, 512, 256);
    }
    
    public Iterable<ModelPart> m_6195_() {
        return (Iterable<ModelPart>)ImmutableList.of((Object)this.neck);
    }
    
    public void setupAnim(final HydraNeck entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch) {
        this.neck.f_104204_ = netHeadYaw / 57.29578f;
        this.neck.f_104203_ = headPitch / 57.29578f;
    }
}
