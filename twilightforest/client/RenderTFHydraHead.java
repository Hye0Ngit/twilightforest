// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import twilightforest.entity.EntityTFHydra;
import twilightforest.entity.EntityTFHydraPart;
import twilightforest.entity.HydraHeadContainer;

public class RenderTFHydraHead extends bcj
{
    public RenderTFHydraHead(final axa modelbase, final float f) {
        super(modelbase, f);
    }
    
    public void a(final lq entity, final double d, final double d1, final double d2, final float f, final float f1) {
        final HydraHeadContainer headCon = this.getHeadObject(entity);
        if (headCon != null) {
            if (headCon.shouldRenderHead()) {
                super.a(entity, d, d1, d2, f, f1);
            }
            if (headCon.shouldRenderNeck(0)) {
                bbu.a.a((lq)headCon.necka, f1);
            }
            if (headCon.shouldRenderNeck(1)) {
                bbu.a.a((lq)headCon.neckb, f1);
            }
            if (headCon.shouldRenderNeck(2)) {
                bbu.a.a((lq)headCon.neckc, f1);
            }
            if (headCon.shouldRenderNeck(3)) {
                bbu.a.a((lq)headCon.neckd, f1);
            }
            if (headCon.shouldRenderNeck(4)) {
                bbu.a.a((lq)headCon.necke, f1);
            }
        }
        else {
            super.a(entity, d, d1, d2, f, f1);
        }
    }
    
    private HydraHeadContainer getHeadObject(final lq entity) {
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
}
