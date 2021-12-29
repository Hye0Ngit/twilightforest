// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderBiped;

public class RenderTFWraith extends RenderBiped
{
    private static final ResourceLocation textureWraith;
    private static final ResourceLocation textureCrown;
    
    public RenderTFWraith(final ModelBiped modelbiped, final float f) {
        super(modelbiped, f);
    }
    
    protected int func_77032_a(final EntityLivingBase entityliving, final int i, final float f) {
        this.func_77042_a(this.field_77045_g);
        if (i == 1) {
            this.func_110776_a(RenderTFWraith.textureWraith);
            GL11.glEnable(3042);
            GL11.glDisable(3008);
            GL11.glBlendFunc(1, 1);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.5f);
            return 1;
        }
        return 0;
    }
    
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
        return RenderTFWraith.textureCrown;
    }
    
    static {
        textureWraith = new ResourceLocation("twilightforest:textures/model/ghost.png");
        textureCrown = new ResourceLocation("twilightforest:textures/model/ghost-crown.png");
    }
}
