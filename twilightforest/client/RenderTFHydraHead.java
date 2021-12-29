// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import twilightforest.entity.EntityTFHydra;
import twilightforest.entity.EntityTFHydraPart;
import twilightforest.entity.HydraHeadContainer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFHydraHead extends RenderLiving
{
    public RenderTFHydraHead(final ModelBase modelbase, final float f) {
        super(modelbase, f);
    }
    
    public void func_76986_a(final Entity entity, final double d, final double d1, final double d2, final float f, final float f1) {
        final HydraHeadContainer headCon = this.getHeadObject(entity);
        if (headCon != null) {
            if (headCon.shouldRenderHead()) {
                super.func_76986_a(entity, d, d1, d2, f, f1);
            }
            if (headCon.shouldRenderNeck(0)) {
                RenderManager.field_78727_a.func_78720_a((Entity)headCon.necka, f1);
            }
            if (headCon.shouldRenderNeck(1)) {
                RenderManager.field_78727_a.func_78720_a((Entity)headCon.neckb, f1);
            }
            if (headCon.shouldRenderNeck(2)) {
                RenderManager.field_78727_a.func_78720_a((Entity)headCon.neckc, f1);
            }
            if (headCon.shouldRenderNeck(3)) {
                RenderManager.field_78727_a.func_78720_a((Entity)headCon.neckd, f1);
            }
            if (headCon.shouldRenderNeck(4)) {
                RenderManager.field_78727_a.func_78720_a((Entity)headCon.necke, f1);
            }
        }
        else {
            super.func_76986_a(entity, d, d1, d2, f, f1);
        }
    }
    
    private HydraHeadContainer getHeadObject(final Entity entity) {
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
