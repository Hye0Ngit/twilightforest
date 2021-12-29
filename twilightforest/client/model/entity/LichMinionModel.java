// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.monster.LichMinion;
import net.minecraft.client.model.ZombieModel;

public class LichMinionModel extends ZombieModel<LichMinion>
{
    private boolean hasStrength;
    
    public LichMinionModel(final ModelPart root) {
        super(root);
    }
    
    public void prepareMobModel(final LichMinion entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        this.hasStrength = (entity.m_21124_(MobEffects.f_19600_) != null);
    }
    
    public void m_7695_(final PoseStack stack, final VertexConsumer builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        if (this.hasStrength) {
            super.m_7695_(stack, builder, light, overlay, red * 0.25f, green, blue * 0.25f, scale);
        }
        else {
            super.m_7695_(stack, builder, light, overlay, red * 0.5f, green, blue * 0.5f, scale);
        }
    }
}
