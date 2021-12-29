// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.lwjgl.opengl.GL11;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderBiped;

public class RenderTFGiant extends RenderBiped
{
    private ResourceLocation textureLoc;
    
    public RenderTFGiant() {
        super(new ModelBiped(), 0.625f);
        this.textureLoc = new ResourceLocation("textures/entity/steve.png");
    }
    
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
        if (Minecraft.func_71410_x().field_71439_g.func_110306_p() != null) {
            return Minecraft.func_71410_x().field_71439_g.func_110306_p();
        }
        return this.textureLoc;
    }
    
    protected void func_77041_b(final EntityLivingBase par1EntityLivingBase, final float par2) {
        final float scale = 4.0f;
        GL11.glScalef(scale, scale, scale);
    }
}
