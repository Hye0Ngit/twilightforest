// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.lwjgl.opengl.GL11;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.ModelTFMoonworm;
import net.minecraft.client.renderer.entity.Render;

public class RenderTFMoonwormShot extends Render
{
    private ModelTFMoonworm wormModel;
    private static final ResourceLocation textureLoc;
    
    public RenderTFMoonwormShot() {
        this.wormModel = new ModelTFMoonworm();
        this.field_76989_e = 0.5f;
    }
    
    public void func_76986_a(final Entity var1, final double x, final double y, final double z, final float var8, final float partialTick) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y, (float)z);
        GL11.glRotatef(90.0f, 1.0f, 0.0f, 1.0f);
        this.func_110776_a(RenderTFMoonwormShot.textureLoc);
        this.wormModel.render(0.075f);
        GL11.glPopMatrix();
    }
    
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
        return RenderTFMoonwormShot.textureLoc;
    }
    
    static {
        textureLoc = new ResourceLocation("twilightforest:textures/model/moonworm.png");
    }
}
