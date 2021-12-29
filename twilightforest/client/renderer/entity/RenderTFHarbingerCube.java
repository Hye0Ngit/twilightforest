// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.lwjgl.opengl.GL11;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFHarbingerCube extends RenderLiving
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFHarbingerCube() {
        super((ModelBase)new ModelTFApocalypseCube(), 1.0f);
    }
    
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
        return RenderTFHarbingerCube.textureLoc;
    }
    
    protected void func_77041_b(final EntityLivingBase par1EntityLivingBase, final float par2) {
        final float scale = 1.0f;
        GL11.glScalef(scale, scale, scale);
    }
    
    static {
        textureLoc = new ResourceLocation("twilightforest:textures/model/apocalypse2.png");
    }
}
