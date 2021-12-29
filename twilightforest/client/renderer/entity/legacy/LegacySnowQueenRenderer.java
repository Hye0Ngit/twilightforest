// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity.legacy;

import twilightforest.TwilightForestMod;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.client.renderer.MultiBufferSource;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import twilightforest.client.model.entity.legacy.SnowQueenLegacyModel;
import twilightforest.entity.boss.SnowQueen;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;

public class LegacySnowQueenRenderer extends HumanoidMobRenderer<SnowQueen, SnowQueenLegacyModel>
{
    private static final ResourceLocation textureLoc;
    
    public LegacySnowQueenRenderer(final EntityRendererProvider.Context manager, final SnowQueenLegacyModel model) {
        super(manager, (HumanoidModel)model, 0.625f);
    }
    
    public ResourceLocation getTextureLocation(final SnowQueen entity) {
        return LegacySnowQueenRenderer.textureLoc;
    }
    
    protected void scale(final SnowQueen queen, final PoseStack stack, final float partialTicks) {
        final float scale = 1.2f;
        stack.m_85841_(scale, scale, scale);
    }
    
    public void render(final SnowQueen queen, final float yaw, final float partialTicks, final PoseStack stack, final MultiBufferSource buffer, final int light) {
        super.m_7392_((Mob)queen, yaw, partialTicks, stack, buffer, light);
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("snowqueen.png");
    }
}
