// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.lwjgl.opengl.GL11;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderSpider;

public class RenderTFTowerBroodling extends RenderSpider
{
    private static final ResourceLocation textureLoc;
    
    protected ResourceLocation func_110775_a(final Entity entity) {
        return RenderTFTowerBroodling.textureLoc;
    }
    
    protected void func_77041_b(final EntityLivingBase par1EntityLivingBase, final float par2) {
        final float scale = 0.7f;
        GL11.glScalef(scale, scale, scale);
    }
    
    static {
        textureLoc = new ResourceLocation("twilightforest:textures/model/towerbroodling.png");
    }
}
