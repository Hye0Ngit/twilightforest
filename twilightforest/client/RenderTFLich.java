// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import org.lwjgl.opengl.GL11;
import twilightforest.entity.EntityTFLich;

public class RenderTFLich extends bcc
{
    public static EntityTFLich entityLich;
    
    public RenderTFLich(final aww modelbiped, final float f) {
        super(modelbiped, f);
        this.a((axa)new ModelTFLich(true));
    }
    
    protected int a(final md entityliving, final int i, final float f) {
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
        if (lich.ab > 0) {
            bai.a((pl)lich, false);
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        return 1;
    }
    
    static {
        RenderTFLich.entityLich = null;
    }
}
