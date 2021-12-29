// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.client.model.ModelTFSlimeBeetle;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFSlimeBeetle extends RenderLiving
{
    ModelBase renderModel;
    private static final ResourceLocation textureLoc;
    
    public RenderTFSlimeBeetle(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.renderModel = new ModelTFSlimeBeetle(true);
    }
    
    protected int func_77032_a(final EntityLivingBase par1EntityLiving, final int par2, final float par3) {
        return this.shouldSlimeRenderPass(par1EntityLiving, par2, par3);
    }
    
    protected int shouldSlimeRenderPass(final EntityLivingBase par1EntitySlime, final int par2, final float par3) {
        if (par1EntitySlime.func_82150_aj()) {
            return 0;
        }
        if (par2 == 0) {
            this.func_77042_a(this.renderModel);
            GL11.glEnable(2977);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            return 1;
        }
        if (par2 == 1) {
            GL11.glDisable(3042);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
        return -1;
    }
    
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
        return RenderTFSlimeBeetle.textureLoc;
    }
    
    static {
        textureLoc = new ResourceLocation("twilightforest:textures/model/slimebeetle.png");
    }
}
