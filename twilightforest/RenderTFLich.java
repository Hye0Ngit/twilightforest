// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest;

import org.lwjgl.opengl.GL11;

public class RenderTFLich extends tg
{
    public RenderTFLich(final xg modelbiped, final float f) {
        super(modelbiped, f);
        this.a((ho)new ModelTFLich(true));
    }
    
    protected int b(final acq entityliving, final int i, final float f) {
        final EntityTFLich lich = (EntityTFLich)entityliving;
        if (i != 2) {
            return 0;
        }
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        if (lich.isShadowClone()) {
            final float shadow = 0.33f;
            GL11.glColor4f(shadow, shadow, shadow, 0.8f);
            return 2;
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        return 1;
    }
}
