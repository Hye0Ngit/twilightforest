// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.lwjgl.opengl.GL11;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelBiped;

public class RenderTFYeti extends RenderTFBiped
{
    public RenderTFYeti(final ModelBiped modelBiped, final float scale, final String textureName) {
        super(modelBiped, scale, textureName);
    }
    
    protected void func_77041_b(final EntityLivingBase par1EntityLivingBase, final float par2) {
        final float scale = 1.0f;
        GL11.glScalef(scale, scale, scale);
    }
}
