// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import twilightforest.entity.monster.BaseIceMob;
import net.minecraft.util.Mth;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.monster.StableIceCore;

public class StableIceCoreModel extends UnstableIceCoreModel<StableIceCore>
{
    public StableIceCoreModel(final ModelPart root) {
        super(root);
    }
    
    @Override
    public void prepareMobModel(final StableIceCore entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        this.alive = entity.m_6084_();
        for (int i = 0; i < this.spikes.length; ++i) {
            this.spikes[i].f_104204_ = 1.570795f + Mth.m_14031_((entity.f_19797_ + partialTicks) / 5.0f) * 0.5f;
            this.spikes[i].f_104203_ = (entity.f_19797_ + partialTicks) / 5.0f;
            this.spikes[i].f_104205_ = Mth.m_14089_(i / 5.0f) / 4.0f;
            final ModelPart modelPart = this.spikes[i];
            modelPart.f_104203_ += (float)(i * 0.39269908169872414);
            this.cubes[i].f_104201_ = 9.5f + Mth.m_14031_((i + entity.f_19797_ + partialTicks) / 3.0f) * 3.0f;
        }
    }
}
