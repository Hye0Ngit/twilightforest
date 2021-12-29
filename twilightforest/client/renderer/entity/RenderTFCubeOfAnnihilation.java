// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import twilightforest.client.model.entity.ModelTFCubeOfAnnihilation;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.EntityTFCubeOfAnnihilation;
import net.minecraft.client.renderer.entity.Render;

public class RenderTFCubeOfAnnihilation extends Render<EntityTFCubeOfAnnihilation>
{
    private static final ResourceLocation textureLoc;
    private final ModelBase model;
    
    public RenderTFCubeOfAnnihilation(final RenderManager manager) {
        super(manager);
        this.model = new ModelTFCubeOfAnnihilation();
    }
    
    public void doRender(final EntityTFCubeOfAnnihilation entity, final double x, final double y, final double z, final float yaw, final float partialTicks) {
        super.func_76986_a((Entity)entity, x, y, z, yaw, partialTicks);
        GlStateManager.func_179094_E();
        GlStateManager.func_179109_b((float)x, (float)y, (float)z);
        this.func_180548_c((Entity)entity);
        GlStateManager.func_179152_a(-1.0f, -1.0f, 1.0f);
        GlStateManager.func_179114_b(MathHelper.func_76142_g(((float)x + (float)z + entity.field_70173_aa + partialTicks) * 11.0f), 0.0f, 1.0f, 0.0f);
        GlStateManager.func_179140_f();
        GlStateManager.func_179147_l();
        GlStateManager.func_179112_b(770, 771);
        GlStateManager.func_179109_b(0.0f, -0.5f, 0.0f);
        this.model.func_78088_a((Entity)entity, 0.0f, 0.0f, 0.0f, 0.0f, partialTicks, 0.03125f);
        GlStateManager.func_179145_e();
        GlStateManager.func_179084_k();
        GlStateManager.func_179121_F();
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFCubeOfAnnihilation entity) {
        return RenderTFCubeOfAnnihilation.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("cubeofannihilation.png");
    }
}
