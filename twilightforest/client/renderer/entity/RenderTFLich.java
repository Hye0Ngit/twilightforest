// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import org.lwjgl.opengl.GL11;
import twilightforest.client.model.ModelTFLich;
import twilightforest.entity.EntityTFLich;

public class RenderTFLich extends bgr
{
    public static EntityTFLich entityLich;
    private static final bjl textureLoc;
    
    public RenderTFLich(final bbg modelbiped, final float f) {
        super(modelbiped, f);
        this.a((bbl)new ModelTFLich(true));
    }
    
    protected int a(final oe entity, final int i, final float f) {
        final EntityTFLich lich = (EntityTFLich)entity;
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
        if (lich.ac > 0) {
            bew.a((sf)lich, false);
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        return 1;
    }
    
    protected bjl a(final nm par1Entity) {
        return RenderTFLich.textureLoc;
    }
    
    static {
        RenderTFLich.entityLich = null;
        textureLoc = new bjl("twilightforest:textures/model/twilightlich64.png");
    }
}
