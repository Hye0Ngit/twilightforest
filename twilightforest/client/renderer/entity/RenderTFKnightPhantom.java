// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.lwjgl.opengl.GL11;
import twilightforest.entity.EntityTFKnightPhantom;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBiped;
import twilightforest.client.model.ModelTFKnightPhantom2;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderBiped;

public class RenderTFKnightPhantom extends RenderBiped
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFKnightPhantom(final ModelTFKnightPhantom2 modelTFKnightPhantom2, final float f) {
        super((ModelBiped)modelTFKnightPhantom2, f);
    }
    
    protected ResourceLocation func_110775_a(final Entity entity) {
        return RenderTFKnightPhantom.textureLoc;
    }
    
    protected void func_77041_b(final EntityLivingBase par1EntityLivingBase, final float par2) {
        final float scale = ((EntityTFKnightPhantom)par1EntityLivingBase).isChargingAtPlayer() ? 1.8f : 1.2f;
        GL11.glScalef(scale, scale, scale);
    }
    
    static {
        textureLoc = new ResourceLocation("twilightforest:textures/model/phantomskeleton.png");
    }
}
