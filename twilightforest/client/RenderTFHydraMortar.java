// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;
import twilightforest.entity.EntityTFHydraMortar;
import twilightforest.client.model.ModelTFHydraMortar;

public class RenderTFHydraMortar extends bgt
{
    private ModelTFHydraMortar mortarModel;
    
    public RenderTFHydraMortar() {
        this.mortarModel = new ModelTFHydraMortar();
        this.d = 0.5f;
    }
    
    public void a(final mp var1, final double x, final double y, final double z, final float var8, final float partialTick) {
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
        this.a("/mods/twilightforest/textures/model/hydramortar.png");
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
}
