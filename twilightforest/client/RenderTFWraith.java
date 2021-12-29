// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;
import net.minecraft.entity.EntityLiving;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;

public class RenderTFWraith extends RenderBiped
{
    public RenderTFWraith(final ModelBiped modelbiped, final float f) {
        super(modelbiped, f);
    }
    
    protected int func_77032_a(final EntityLiving entityliving, final int i, final float f) {
        this.func_77042_a(this.field_77045_g);
        if (i == 1) {
            this.func_76985_a("/mods/twilightforest/textures/model/ghost.png");
            GL11.glEnable(3042);
            GL11.glDisable(3008);
            GL11.glBlendFunc(1, 1);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 0.5f);
            return 1;
        }
        return 0;
    }
}
