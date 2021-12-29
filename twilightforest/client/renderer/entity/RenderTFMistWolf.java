// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderWolf;

public class RenderTFMistWolf extends RenderWolf
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFMistWolf(final ModelBase par1ModelBase, final ModelBase par2ModelBase, final float par3) {
        super(par1ModelBase, par2ModelBase, par3);
    }
    
    protected void func_77041_b(final EntityLivingBase par1EntityLiving, final float par2) {
        final float wolfScale = 1.9f;
        GL11.glScalef(wolfScale, wolfScale, wolfScale);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 771);
        float misty = par1EntityLiving.func_70013_c(0.0f) * 3.0f + 0.25f;
        misty = Math.min(1.0f, misty);
        final float smoky = par1EntityLiving.func_70013_c(0.0f) * 2.0f + 0.6f;
        GL11.glColor4f(misty, misty, misty, smoky);
    }
    
    protected int func_77032_a(final EntityLivingBase par1EntityLiving, final int par2, final float par3) {
        return -1;
    }
    
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
        return RenderTFMistWolf.textureLoc;
    }
    
    static {
        textureLoc = new ResourceLocation("twilightforest:textures/model/mistwolf.png");
    }
}
