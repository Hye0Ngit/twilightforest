// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.lwjgl.opengl.GL11;
import twilightforest.entity.boss.EntityTFHydraMortar;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import twilightforest.client.model.ModelTFHydraMortar;
import net.minecraft.client.renderer.entity.Render;

public class RenderTFHydraMortar extends Render
{
    private ModelTFHydraMortar mortarModel;
    private static final ResourceLocation textureLoc;
    
    public RenderTFHydraMortar() {
        this.mortarModel = new ModelTFHydraMortar();
        this.field_76989_e = 0.5f;
    }
    
    public void func_76986_a(final Entity var1, final double x, final double y, final double z, final float var8, final float partialTick) {
        final EntityTFHydraMortar mortar = (EntityTFHydraMortar)var1;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x, (float)y, (float)z);
        if (mortar.fuse - partialTick + 1.0f < 10.0f) {
            float var9 = 1.0f - (mortar.fuse - partialTick + 1.0f) / 10.0f;
            if (var9 < 0.0f) {
                var9 = 0.0f;
            }
            if (var9 > 1.0f) {
                var9 = 1.0f;
            }
            var9 *= var9;
            var9 *= var9;
            final float var10 = 1.0f + var9 * 0.3f;
            GL11.glScalef(var10, var10, var10);
        }
        float var9 = (1.0f - (mortar.fuse - partialTick + 1.0f) / 100.0f) * 0.8f;
        this.func_110776_a(RenderTFHydraMortar.textureLoc);
        this.mortarModel.render(0.075f);
        if (mortar.fuse / 5 % 2 == 0) {
            GL11.glDisable(3553);
            GL11.glDisable(2896);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 772);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, var9);
            this.mortarModel.render(0.075f);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glDisable(3042);
            GL11.glEnable(2896);
            GL11.glEnable(3553);
        }
        GL11.glPopMatrix();
    }
    
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
        return RenderTFHydraMortar.textureLoc;
    }
    
    static {
        textureLoc = new ResourceLocation("twilightforest:textures/model/hydramortar.png");
    }
}
