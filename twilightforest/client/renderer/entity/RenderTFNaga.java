// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.client.renderer.entity.RenderManager;
import twilightforest.entity.boss.EntityTFNaga;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFNaga extends RenderLiving
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFNaga(final ModelBase modelbase, final float f) {
        super(modelbase, f);
    }
    
    public void func_76986_a(final Entity entity, final double d, final double d1, final double d2, final float f, final float f1) {
        super.func_76986_a(entity, d, d1, d2, f, f1);
        if (entity instanceof EntityTFNaga && ((EntityTFNaga)entity).func_70021_al() != null) {
            final EntityTFNaga naga = (EntityTFNaga)entity;
            for (int i = 0; i < naga.func_70021_al().length; ++i) {
                if (!naga.func_70021_al()[i].field_70128_L) {
                    RenderManager.field_78727_a.func_147937_a(naga.func_70021_al()[i], f1);
                }
            }
            BossStatus.func_82824_a((IBossDisplayData)naga, false);
        }
    }
    
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
        return RenderTFNaga.textureLoc;
    }
    
    static {
        textureLoc = new ResourceLocation("twilightforest:textures/model/nagahead.png");
    }
}
