// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.lwjgl.opengl.GL11;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelBiped;
import twilightforest.client.model.ModelTFIceShooter;

public class RenderTFIceShooter extends RenderTFBiped
{
    public RenderTFIceShooter() {
        super(new ModelTFIceShooter(), 1.0f, "iceshooter.png");
    }
    
    protected void func_77041_b(final EntityLivingBase par1EntityLivingBase, final float partialTick) {
        final float bounce = par1EntityLivingBase.field_70173_aa + partialTick;
        GL11.glTranslatef(0.0f, MathHelper.func_76126_a(bounce * 0.2f) * 0.15f, 0.0f);
    }
}
