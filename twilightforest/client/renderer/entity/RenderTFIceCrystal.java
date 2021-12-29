// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.model.ModelBase;
import twilightforest.client.model.entity.ModelTFIceCrystal;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.boss.EntityTFIceCrystal;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFIceCrystal extends RenderLiving<EntityTFIceCrystal>
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFIceCrystal(final RenderManager manager) {
        super(manager, (ModelBase)new ModelTFIceCrystal(), 0.25f);
    }
    
    protected void preRenderCallback(final EntityTFIceCrystal entity, final float partialTicks) {
        final float bounce = entity.field_70173_aa + partialTicks;
        GlStateManager.func_179109_b(0.0f, MathHelper.func_76126_a(bounce * 0.2f) * 0.15f, 0.0f);
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFIceCrystal entity) {
        return RenderTFIceCrystal.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("icecrystal.png");
    }
}
