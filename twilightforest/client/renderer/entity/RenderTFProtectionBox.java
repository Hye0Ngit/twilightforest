// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import twilightforest.client.model.entity.ModelTFProtectionBox;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.EntityTFProtectionBox;
import net.minecraft.client.renderer.entity.Render;

public class RenderTFProtectionBox extends Render<EntityTFProtectionBox>
{
    private static final ResourceLocation textureLoc;
    private final ModelTFProtectionBox boxModel;
    
    public RenderTFProtectionBox(final RenderManager manager) {
        super(manager);
        this.boxModel = new ModelTFProtectionBox();
        this.field_76989_e = 0.5f;
    }
    
    public void doRender(final EntityTFProtectionBox entity, final double x, final double y, final double z, final float yaw, final float partialTicks) {
        GlStateManager.func_179094_E();
        GlStateManager.func_179109_b((float)x, (float)y, (float)z);
        this.func_110776_a(RenderTFProtectionBox.textureLoc);
        final float f1 = entity.field_70173_aa + partialTicks;
        GlStateManager.func_179128_n(5890);
        GlStateManager.func_179096_D();
        final float f2 = f1 * 0.05f;
        final float f3 = f1 * 0.05f;
        GlStateManager.func_179109_b(f2, f3, 0.0f);
        GlStateManager.func_179152_a(1.0f, 1.0f, 1.0f);
        GlStateManager.func_179128_n(5888);
        GlStateManager.func_179135_a(true, true, true, true);
        GlStateManager.func_179147_l();
        GlStateManager.func_179129_p();
        GlStateManager.func_179112_b(770, 771);
        GlStateManager.func_179118_c();
        GlStateManager.func_179140_f();
        float alpha = 1.0f;
        if (entity.lifeTime < 20) {
            alpha = entity.lifeTime / 20.0f;
        }
        GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, alpha);
        this.boxModel.func_78088_a(entity, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        GlStateManager.func_179084_k();
        GlStateManager.func_179089_o();
        GlStateManager.func_179141_d();
        GlStateManager.func_179145_e();
        GlStateManager.func_179128_n(5890);
        GlStateManager.func_179096_D();
        GlStateManager.func_179128_n(5888);
        GlStateManager.func_179121_F();
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFProtectionBox entity) {
        return RenderTFProtectionBox.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("protectionbox.png");
    }
}
