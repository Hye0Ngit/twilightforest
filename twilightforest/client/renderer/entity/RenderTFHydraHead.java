// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import twilightforest.TwilightForestMod;
import net.minecraft.entity.EntityLivingBase;
import twilightforest.entity.boss.EntityTFHydra;
import twilightforest.entity.boss.EntityTFHydraPart;
import twilightforest.entity.boss.HydraHeadContainer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import twilightforest.entity.boss.EntityTFHydraHead;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFHydraHead extends RenderLiving<EntityTFHydraHead>
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFHydraHead(final RenderManager manager, final ModelBase modelbase, final float shadowSize) {
        super(manager, modelbase, shadowSize);
    }
    
    public void doRender(final EntityTFHydraHead entity, final double x, final double y, final double z, final float yaw, final float partialTicks) {
        final HydraHeadContainer headCon = this.getHeadObject((Entity)entity);
        if (headCon != null) {
            if (headCon.shouldRenderHead()) {
                super.func_76986_a((EntityLiving)entity, x, y, z, yaw, partialTicks);
            }
            if (headCon.shouldRenderNeck(0)) {
                this.field_76990_c.func_188388_a((Entity)headCon.necka, partialTicks, false);
            }
            if (headCon.shouldRenderNeck(1)) {
                this.field_76990_c.func_188388_a((Entity)headCon.neckb, partialTicks, false);
            }
            if (headCon.shouldRenderNeck(2)) {
                this.field_76990_c.func_188388_a((Entity)headCon.neckc, partialTicks, false);
            }
            if (headCon.shouldRenderNeck(3)) {
                this.field_76990_c.func_188388_a((Entity)headCon.neckd, partialTicks, false);
            }
            if (headCon.shouldRenderNeck(4)) {
                this.field_76990_c.func_188388_a((Entity)headCon.necke, partialTicks, false);
            }
        }
        else {
            super.func_76986_a((EntityLiving)entity, x, y, z, yaw, partialTicks);
        }
    }
    
    private HydraHeadContainer getHeadObject(final Entity entity) {
        final EntityTFHydra hydra = ((EntityTFHydraPart)entity).hydra;
        if (hydra != null) {
            int i = 0;
            while (true) {
                final int n = i;
                hydra.getClass();
                if (n >= 7) {
                    break;
                }
                if (hydra.hc[i].headEntity == entity) {
                    return hydra.hc[i];
                }
                ++i;
            }
        }
        return null;
    }
    
    protected ResourceLocation getEntityTexture(final EntityTFHydraHead entity) {
        return RenderTFHydraHead.textureLoc;
    }
    
    static {
        textureLoc = TwilightForestMod.getModelTexture("hydra4.png");
    }
}
