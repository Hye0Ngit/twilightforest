// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.LivingEntity;
import com.mojang.math.Vector3f;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelPart;
import twilightforest.entity.monster.RisingZombie;
import net.minecraft.client.model.ZombieModel;

public class RisingZombieModel extends ZombieModel<RisingZombie>
{
    private float tick;
    
    public RisingZombieModel(final ModelPart part) {
        super(part);
    }
    
    public void m_7695_(final PoseStack stack, final VertexConsumer builder, final int light, final int overlay, final float red, final float green, final float blue, final float scale) {
        stack.m_85836_();
        if (this.f_102610_) {
            stack.m_85836_();
            stack.m_85841_(0.75f, 0.75f, 0.75f);
            stack.m_85837_(0.0, (double)(16.0f * scale), 0.0);
            this.m_5607_().forEach(renderer -> renderer.m_104306_(stack, builder, light, overlay, red, green, blue, scale));
            stack.m_85849_();
            stack.m_85836_();
            stack.m_85841_(0.5f, 0.5f, 0.5f);
            stack.m_85837_(0.0, (double)(24.0f * scale), 0.0);
            this.f_102810_.m_104306_(stack, builder, light, overlay, red, green, blue, scale);
            this.f_102811_.m_104306_(stack, builder, light, overlay, red, green, blue, scale);
            this.f_102812_.m_104306_(stack, builder, light, overlay, red, green, blue, scale);
            this.f_102809_.m_104306_(stack, builder, light, overlay, red, green, blue, scale);
            stack.m_85849_();
            this.f_102813_.m_104306_(stack, builder, light, overlay, red, green, blue, scale);
            this.f_102814_.m_104306_(stack, builder, light, overlay, red, green, blue, scale);
        }
        else {
            if (this.f_102817_) {
                stack.m_85837_(0.0, 0.20000000298023224, 0.0);
            }
            stack.m_85837_(0.0, (double)((80.0f - Math.min(80.0f, this.tick)) / 80.0f), 0.0);
            stack.m_85837_(0.0, (double)((40.0f - Math.min(40.0f, Math.max(0.0f, this.tick - 80.0f))) / 40.0f), 0.0);
            stack.m_85836_();
            final float yOff = 1.0f;
            stack.m_85837_(0.0, 1.0, 0.0);
            stack.m_85845_(Vector3f.f_122223_.m_122240_(-120.0f * (80.0f - Math.min(80.0f, this.tick)) / 80.0f));
            stack.m_85845_(Vector3f.f_122223_.m_122240_(30.0f * (40.0f - Math.min(40.0f, Math.max(0.0f, this.tick - 80.0f))) / 40.0f));
            stack.m_85837_(0.0, -1.0, 0.0);
            this.m_5607_().forEach(renderer -> renderer.m_104306_(stack, builder, light, overlay, red, green, blue, scale));
            this.f_102810_.m_104306_(stack, builder, light, overlay, red, green, blue, scale);
            this.f_102811_.m_104306_(stack, builder, light, overlay, red, green, blue, scale);
            this.f_102812_.m_104306_(stack, builder, light, overlay, red, green, blue, scale);
            this.f_102809_.m_104306_(stack, builder, light, overlay, red, green, blue, scale);
            stack.m_85849_();
            this.f_102813_.m_104306_(stack, builder, light, overlay, red, green, blue, scale);
            this.f_102814_.m_104306_(stack, builder, light, overlay, red, green, blue, scale);
        }
        stack.m_85849_();
    }
    
    protected void setupAttackAnimation(final RisingZombie p_102858_, final float p_102859_) {
        super.m_7884_((LivingEntity)p_102858_, p_102859_);
        this.tick = p_102859_ + Minecraft.m_91087_().m_91297_();
    }
}
