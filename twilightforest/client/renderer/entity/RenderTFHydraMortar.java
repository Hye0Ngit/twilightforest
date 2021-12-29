// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import twilightforest.client.model.entity.ModelTFHydraMortar;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.boss.EntityTFHydraMortar;
import net.minecraft.client.renderer.entity.Render;

public class RenderTFHydraMortar extends Render<EntityTFHydraMortar>
{
    private static final ResourceLocation textureLoc;
    private final ModelTFHydraMortar mortarModel;
    
    public RenderTFHydraMortar(final RenderManager manager) {
        super(manager);
        this.mortarModel = new ModelTFHydraMortar();
        this.field_76989_e = 0.5f;
    }
    
    public void doRender(final EntityTFHydraMortar mortar, final double x, final double y, final double z, final float yaw, final float partialTicks) {
        GlStateManager.func_179094_E();
        GlStateManager.func_179109_b((float)x, (float)y, (float)z);
        if (mortar.fuse - partialTicks + 1.0f < 10.0f) {
            float var10 = 1.0f - (mortar.fuse - partialTicks + 1.0f) / 10.0f;
            if (var10 < 0.0f) {
                var10 = 0.0f;
            }
            if (var10 > 1.0f) {
                var10 = 1.0f;
            }
            var10 *= var10;
            var10 *= var10;
            final float var11 = 1.0f + var10 * 0.3f;
            GlStateManager.func_179152_a(var11, var11, var11);
        }
        float var10 = (1.0f - (mortar.fuse - partialTicks + 1.0f) / 100.0f) * 0.8f;
        this.func_110776_a(RenderTFHydraMortar.textureLoc);
        this.mortarModel.render(0.075f);
        if (mortar.fuse / 5 % 2 == 0) {
            GlStateManager.func_179090_x();
            GlStateManager.func_179140_f();
            GlStateManager.func_179147_l();
            GlStateManager.func_179112_b(770, 772);
            GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, var10);
            this.mortarModel.render(0.075f);
            GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, 1.0f);
            GlStateManager.func_179084_k();
            GlStateManager.func_179145_e();
            GlStateManager.func_179098_w();
        }
        GlStateManager.func_179121_F();
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFHydraMortar entity) {
        return RenderTFHydraMortar.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("hydramortar.png");
    }
}
