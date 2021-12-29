// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.client.renderer.GlStateManager;
import twilightforest.client.model.entity.ModelTFSlimeBeetle;
import twilightforest.TwilightForestMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.EntityTFSlimeBeetle;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFSlimeBeetle extends RenderLiving<EntityTFSlimeBeetle>
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFSlimeBeetle(final RenderManager manager, final ModelBase par1ModelBase, final float shadowSize) {
        super(manager, par1ModelBase, shadowSize);
        this.func_177094_a((LayerRenderer)new LayerInner());
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFSlimeBeetle entity) {
        return RenderTFSlimeBeetle.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("slimebeetle.png");
    }
    
    class LayerInner implements LayerRenderer<EntityTFSlimeBeetle>
    {
        private final ModelBase innerModel;
        
        LayerInner() {
            this.innerModel = new ModelTFSlimeBeetle(true);
        }
        
        public void doRenderLayer(final EntityTFSlimeBeetle entity, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
            if (!entity.func_82150_aj()) {
                GlStateManager.func_179131_c(1.0f, 1.0f, 1.0f, 1.0f);
                GlStateManager.func_179108_z();
                GlStateManager.func_179147_l();
                GlStateManager.func_187401_a(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
                this.innerModel.func_178686_a(RenderTFSlimeBeetle.this.func_177087_b());
                this.innerModel.func_78088_a((Entity)entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
                GlStateManager.func_179084_k();
                GlStateManager.func_179133_A();
            }
        }
        
        public boolean func_177142_b() {
            return true;
        }
    }
}
