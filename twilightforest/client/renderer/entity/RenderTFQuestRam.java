// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.renderer.OpenGlHelper;
import org.lwjgl.opengl.GL11;
import twilightforest.entity.passive.EntityTFQuestRam;
import net.minecraft.client.model.ModelBase;
import twilightforest.client.model.ModelTFQuestRam;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFQuestRam extends RenderLiving
{
    private static final ResourceLocation textureLoc;
    private static final ResourceLocation textureLocLines;
    
    public RenderTFQuestRam() {
        super((ModelBase)new ModelTFQuestRam(), 1.0f);
        this.func_77042_a((ModelBase)new ModelTFQuestRam());
    }
    
    protected int setQuestRamLineBrightness(final EntityTFQuestRam par1EntityQuestRam, final int par2, final float par3) {
        if (par2 != 0) {
            return -1;
        }
        this.func_110776_a(RenderTFQuestRam.textureLocLines);
        final float var4 = 1.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 1);
        GL11.glScalef(1.025f, 1.025f, 1.025f);
        final char var5 = '\uf0f0';
        final int var6 = var5 % 65536;
        final int var7 = var5 / 65536;
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, var6 / 1.0f, var7 / 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, var4);
        return 1;
    }
    
    protected int func_77032_a(final EntityLivingBase par1EntityLiving, final int par2, final float par3) {
        return this.setQuestRamLineBrightness((EntityTFQuestRam)par1EntityLiving, par2, par3);
    }
    
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
        return RenderTFQuestRam.textureLoc;
    }
    
    static {
        textureLoc = new ResourceLocation("twilightforest:textures/model/questram.png");
        textureLocLines = new ResourceLocation("twilightforest:textures/model/questram_lines.png");
    }
}
