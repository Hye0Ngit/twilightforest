// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.MathHelper;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;
import twilightforest.entity.EntityTFChainBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;

public class RenderTFChainBlock extends Render
{
    private ModelBase model;
    private static final ResourceLocation textureLoc;
    
    public RenderTFChainBlock(final ModelBase modelTFSpikeBlock, final float f) {
        this.model = modelTFSpikeBlock;
    }
    
    public void renderSpikeBlock(final EntityTFChainBlock par1Entity, final double par2, final double par4, final double par6, final float par8, final float time) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        this.func_110777_b((Entity)par1Entity);
        GL11.glScalef(-1.0f, -1.0f, 1.0f);
        GL11.glRotatef(MathHelper.func_76142_g((float)par4), 1.0f, 0.0f, 1.0f);
        GL11.glRotatef(MathHelper.func_76142_g(((float)par2 + (float)par6) * 11.0f), 0.0f, 1.0f, 0.0f);
        this.model.func_78088_a((Entity)par1Entity, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }
    
    public void func_76986_a(final Entity par1Entity, final double par2, final double par4, final double par6, final float par8, final float par9) {
        final EntityTFChainBlock chainBlock = (EntityTFChainBlock)par1Entity;
        this.renderSpikeBlock(chainBlock, par2, par4, par6, par8, par9);
        RenderManager.field_78727_a.func_147937_a((Entity)chainBlock.chain1, par9);
        RenderManager.field_78727_a.func_147937_a((Entity)chainBlock.chain2, par9);
        RenderManager.field_78727_a.func_147937_a((Entity)chainBlock.chain3, par9);
        RenderManager.field_78727_a.func_147937_a((Entity)chainBlock.chain4, par9);
        RenderManager.field_78727_a.func_147937_a((Entity)chainBlock.chain5, par9);
    }
    
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
        return RenderTFChainBlock.textureLoc;
    }
    
    static {
        textureLoc = new ResourceLocation("twilightforest:textures/model/blockgoblin.png");
    }
}
