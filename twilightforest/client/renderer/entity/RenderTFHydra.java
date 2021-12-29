// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.boss.BossStatus;
import twilightforest.entity.boss.EntityTFHydra;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFHydra extends RenderLiving
{
    private static final ResourceLocation textureLoc;
    
    public RenderTFHydra(final ModelBase modelbase, final float f) {
        super(modelbase, f);
    }
    
    public void func_76986_a(final Entity entity, final double d, final double d1, final double d2, final float f, final float f1) {
        super.func_76986_a(entity, d, d1, d2, f, f1);
        BossStatus.func_82824_a((IBossDisplayData)entity, false);
    }
    
    protected float func_77037_a(final EntityLivingBase par1EntityLiving) {
        return 0.0f;
    }
    
    protected ResourceLocation func_110775_a(final Entity par1Entity) {
        return RenderTFHydra.textureLoc;
    }
    
    static {
        textureLoc = new ResourceLocation("twilightforest:textures/model/hydra4.png");
    }
}
