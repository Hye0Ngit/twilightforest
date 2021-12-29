// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.entity.EntityTFHydra;
import twilightforest.entity.EntityTFHydraPart;
import twilightforest.entity.HydraHeadContainer;

public class RenderTFHydraHead extends bhb
{
    private static final bjl textureLoc;
    
    public RenderTFHydraHead(final bbl modelbase, final float f) {
        super(modelbase, f);
    }
    
    public void a(final nm entity, final double d, final double d1, final double d2, final float f, final float f1) {
        final HydraHeadContainer headCon = this.getHeadObject(entity);
        if (headCon != null) {
            if (headCon.shouldRenderHead()) {
                super.a(entity, d, d1, d2, f, f1);
            }
            if (headCon.shouldRenderNeck(0)) {
                bgi.a.a((nm)headCon.necka, f1);
            }
            if (headCon.shouldRenderNeck(1)) {
                bgi.a.a((nm)headCon.neckb, f1);
            }
            if (headCon.shouldRenderNeck(2)) {
                bgi.a.a((nm)headCon.neckc, f1);
            }
            if (headCon.shouldRenderNeck(3)) {
                bgi.a.a((nm)headCon.neckd, f1);
            }
            if (headCon.shouldRenderNeck(4)) {
                bgi.a.a((nm)headCon.necke, f1);
            }
        }
        else {
            super.a(entity, d, d1, d2, f, f1);
        }
    }
    
    private HydraHeadContainer getHeadObject(final nm entity) {
        final EntityTFHydra hydra = ((EntityTFHydraPart)entity).hydraObj;
        if (hydra != null) {
            for (int i = 0; i < hydra.numHeads; ++i) {
                if (hydra.hc[i].headEntity == entity) {
                    return hydra.hc[i];
                }
            }
        }
        return null;
    }
    
    protected bjl a(final nm par1Entity) {
        return RenderTFHydraHead.textureLoc;
    }
    
    static {
        textureLoc = new bjl("twilightforest:textures/model/hydra4.png");
    }
}
