// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.lwjgl.opengl.GL11;
import twilightforest.entity.passive.EntityTFQuestRam;
import twilightforest.client.model.ModelTFQuestRam;

public class RenderTFQuestRam extends bhb
{
    private static final bjl textureLoc;
    private static final bjl textureLocLines;
    
    public RenderTFQuestRam() {
        super((bbl)new ModelTFQuestRam(), 1.0f);
        this.a((bbl)new ModelTFQuestRam());
    }
    
    protected int setQuestRamLineBrightness(final EntityTFQuestRam par1EntityQuestRam, final int par2, final float par3) {
        if (par2 != 0) {
            return -1;
        }
        this.a(RenderTFQuestRam.textureLocLines);
        final float var4 = 1.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 1);
        GL11.glScalef(1.025f, 1.025f, 1.025f);
        final char var5 = '\uf0f0';
        final int var6 = var5 % 65536;
        final int var7 = var5 / 65536;
        blx.a(blx.b, var6 / 1.0f, var7 / 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, var4);
        return 1;
    }
    
    protected int a(final oe par1EntityLiving, final int par2, final float par3) {
        return this.setQuestRamLineBrightness((EntityTFQuestRam)par1EntityLiving, par2, par3);
    }
    
    protected bjl a(final nm par1Entity) {
        return RenderTFQuestRam.textureLoc;
    }
    
    static {
        textureLoc = new bjl("twilightforest:textures/model/questram.png");
        textureLocLines = new bjl("twilightforest:textures/model/questram_lines.png");
    }
}
