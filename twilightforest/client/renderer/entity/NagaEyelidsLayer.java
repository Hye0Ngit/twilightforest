// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import twilightforest.entity.boss.EntityTFNaga;

@SideOnly(Side.CLIENT)
public class NagaEyelidsLayer<T extends EntityTFNaga> implements LayerRenderer<T>
{
    private static final ResourceLocation textureLocDazed;
    private final RenderTFNaga nagaRenderer;
    
    public NagaEyelidsLayer(final RenderTFNaga nagaRenderer) {
        this.nagaRenderer = nagaRenderer;
    }
    
    public void doRenderLayer(final T entitylivingbaseIn, final float limbSwing, final float limbSwingAmount, final float partialTicks, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        if (entitylivingbaseIn.isDazed()) {
            this.nagaRenderer.func_110776_a(NagaEyelidsLayer.textureLocDazed);
            this.nagaRenderer.func_177087_b().func_78088_a((Entity)entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }
    
    public boolean func_177142_b() {
        return true;
    }
    
    static {
        textureLocDazed = TwilightForestMod.getModelTexture("nagahead_dazed.png");
    }
}
