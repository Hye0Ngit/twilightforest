// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.boss.BossStatus;
import twilightforest.entity.EntityTFNaga;
import net.minecraft.entity.Entity;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;

public class RenderTFNaga extends RenderLiving
{
    public RenderTFNaga(final ModelBase modelbase, final float f) {
        super(modelbase, f);
    }
    
    public void func_76986_a(final Entity entity, final double d, final double d1, final double d2, final float f, final float f1) {
        super.func_76986_a(entity, d, d1, d2, f, f1);
        if (entity instanceof EntityTFNaga) {
            BossStatus.func_82824_a((IBossDisplayData)entity, false);
        }
    }
}
