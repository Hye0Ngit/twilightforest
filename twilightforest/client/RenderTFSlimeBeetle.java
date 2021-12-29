// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;

public class RenderTFSlimeBeetle extends bcj
{
    axa renderModel;
    
    public RenderTFSlimeBeetle(final axa par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.renderModel = new ModelTFSlimeBeetle(true);
    }
    
    protected int a(final md par1EntityLiving, final int par2, final float par3) {
        return this.shouldSlimeRenderPass(par1EntityLiving, par2, par3);
    }
    
    protected int shouldSlimeRenderPass(final md par1EntitySlime, final int par2, final float par3) {
        if (par1EntitySlime.aj()) {
            return 0;
        }
        if (par2 == 0) {
            this.a(this.renderModel);
            GL11.glEnable(2977);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            return 1;
        }
        if (par2 == 1) {
            GL11.glDisable(3042);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
        return -1;
    }
}
