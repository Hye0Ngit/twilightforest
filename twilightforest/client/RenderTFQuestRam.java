// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;
import twilightforest.entity.EntityTFQuestRam;
import twilightforest.client.model.ModelTFQuestRam;

public class RenderTFQuestRam extends bhi
{
    public RenderTFQuestRam() {
        super((bbx)new ModelTFQuestRam(), 1.0f);
        this.a((bbx)new ModelTFQuestRam());
    }
    
    protected int setQuestRamLineBrightness(final EntityTFQuestRam par1EntityQuestRam, final int par2, final float par3) {
        if (par2 != 0) {
            return -1;
        }
        this.a("/mods/twilightforest/textures/model/questram_lines.png");
        final float var4 = 1.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        GL11.glBlendFunc(770, 1);
        GL11.glScalef(1.025f, 1.025f, 1.025f);
        final char var5 = '\uf0f0';
        final int var6 = var5 % 65536;
        final int var7 = var5 / 65536;
        bkg.a(bkg.b, var6 / 1.0f, var7 / 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, var4);
        return 1;
    }
    
    protected int a(final ng par1EntityLiving, final int par2, final float par3) {
        return this.setQuestRamLineBrightness((EntityTFQuestRam)par1EntityLiving, par2, par3);
    }
}
