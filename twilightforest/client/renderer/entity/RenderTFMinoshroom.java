// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.Entity;
import net.minecraft.block.Block;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderBiped;

public class RenderTFMinoshroom extends RenderBiped
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFMinoshroom(final ModelBiped par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
    }
    
    protected void renderMooshroomEquippedItems(final EntityLivingBase par1EntityLiving, final float par2) {
        super.func_77029_c(par1EntityLiving, par2);
        this.func_110776_a(TextureMap.field_110575_b);
        GL11.glEnable(2884);
        GL11.glPushMatrix();
        GL11.glScalef(1.0f, -1.0f, 1.0f);
        GL11.glTranslatef(0.2f, 0.375f, 0.5f);
        GL11.glRotatef(42.0f, 0.0f, 1.0f, 0.0f);
        this.field_76988_d.func_78600_a((Block)Block.field_72103_ag, 0, 1.0f);
        GL11.glTranslatef(0.1f, 0.0f, -0.6f);
        GL11.glRotatef(42.0f, 0.0f, 1.0f, 0.0f);
        this.field_76988_d.func_78600_a((Block)Block.field_72103_ag, 0, 1.0f);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        ((ModelBiped)this.field_77045_g).field_78116_c.func_78794_c(0.0625f);
        GL11.glScalef(1.0f, -1.0f, 1.0f);
        GL11.glTranslatef(0.0f, 1.0f, 0.0f);
        GL11.glRotatef(12.0f, 0.0f, 1.0f, 0.0f);
        this.field_76988_d.func_78600_a((Block)Block.field_72103_ag, 0, 1.0f);
        GL11.glPopMatrix();
        GL11.glDisable(2884);
    }
    
    protected void func_77029_c(final EntityLivingBase par1EntityLiving, final float par2) {
        this.renderMooshroomEquippedItems(par1EntityLiving, par2);
    }
    
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
        return RenderTFMinoshroom.textureLoc;
    }
    
    static {
        textureLoc = new ResourceLocation("twilightforest:textures/model/minoshroomtaur.png");
    }
}
