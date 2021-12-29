// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityLiving;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.model.ModelBiped;
import twilightforest.client.model.entity.ModelTFSnowQueen;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.boss.EntityTFSnowQueen;
import net.minecraft.client.renderer.entity.RenderBiped;

public class RenderTFSnowQueen extends RenderBiped<EntityTFSnowQueen>
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFSnowQueen(final RenderManager manager) {
        super(manager, (ModelBiped)new ModelTFSnowQueen(), 0.625f);
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFSnowQueen entity) {
        return RenderTFSnowQueen.textureLoc;
    }
    
    protected void preRenderCallback(final EntityTFSnowQueen queen, final float partialTicks) {
        final float scale = 1.2f;
        GlStateManager.func_179152_a(scale, scale, scale);
    }
    
    public void doRender(final EntityTFSnowQueen queen, final double x, final double y, final double z, final float yaw, final float partialTicks) {
        super.func_76986_a((EntityLiving)queen, x, y, z, yaw, partialTicks);
        for (int i = 0; i < queen.iceArray.length; ++i) {
            this.field_76990_c.func_188388_a(queen.iceArray[i], partialTicks, false);
        }
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("snowqueen.png");
    }
}
