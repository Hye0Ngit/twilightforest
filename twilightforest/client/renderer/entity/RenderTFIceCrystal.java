// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelBase;
import twilightforest.client.model.ModelTFIceCrystal;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFIceCrystal extends RenderLiving
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFIceCrystal() {
        super((ModelBase)new ModelTFIceCrystal(), 1.0f);
    }
    
    protected void func_77041_b(final EntityLivingBase par1EntityLivingBase, final float partialTick) {
        final float bounce = par1EntityLivingBase.field_70173_aa + partialTick;
        GL11.glTranslatef(0.0f, MathHelper.func_76126_a(bounce * 0.2f) * 0.15f, 0.0f);
    }
    
    protected ResourceLocation func_110775_a(final Entity var1) {
        return RenderTFIceCrystal.textureLoc;
    }
    
    static {
        textureLoc = new ResourceLocation("twilightforest:textures/model/icecrystal.png");
    }
}
