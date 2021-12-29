// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.EntityTFTowerGolem;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFTowerGolem extends RenderLiving<EntityTFTowerGolem>
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFTowerGolem(final RenderManager manager, final ModelBase model, final float shadowSize) {
        super(manager, model, shadowSize);
    }
    
    protected void applyRotations(final EntityTFTowerGolem entity, final float ageInTicks, final float rotationYaw, final float partialTicks) {
        super.func_77043_a((EntityLivingBase)entity, ageInTicks, rotationYaw, partialTicks);
        if (entity.field_70721_aZ >= 0.01) {
            final float var5 = 13.0f;
            final float var6 = entity.field_184619_aG - entity.field_70721_aZ * (1.0f - partialTicks) + 6.0f;
            final float var7 = (Math.abs(var6 % var5 - var5 * 0.5f) - var5 * 0.25f) / (var5 * 0.25f);
            GlStateManager.func_179114_b(6.5f * var7, 0.0f, 0.0f, 1.0f);
        }
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFTowerGolem entity) {
        return RenderTFTowerGolem.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("carminitegolem.png");
    }
}
