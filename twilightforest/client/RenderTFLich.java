// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client;

import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.boss.BossStatus;
import org.lwjgl.opengl.GL11;
import net.minecraft.entity.EntityLiving;
import net.minecraft.client.model.ModelBase;
import twilightforest.client.model.ModelTFLich;
import net.minecraft.client.model.ModelBiped;
import twilightforest.entity.EntityTFLich;
import net.minecraft.client.renderer.entity.RenderBiped;

public class RenderTFLich extends RenderBiped
{
    public static EntityTFLich entityLich;
    
    public RenderTFLich(final ModelBiped modelbiped, final float f) {
        super(modelbiped, f);
        this.func_77042_a((ModelBase)new ModelTFLich(true));
    }
    
    protected int func_77032_a(final EntityLiving entityliving, final int i, final float f) {
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
        if (lich.field_70173_aa > 0) {
            BossStatus.func_82824_a((IBossDisplayData)lich, false);
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        return 1;
    }
    
    static {
        RenderTFLich.entityLich = null;
    }
}
