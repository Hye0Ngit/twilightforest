// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.model.entity;

import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import twilightforest.entity.boss.EntityTFLichMinion;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelZombie;

public class ModelTFLichMinion extends ModelZombie
{
    public void func_78086_a(final EntityLivingBase entity, final float limbSwing, final float limbSwingAmount, final float partialTicks) {
        final EntityTFLichMinion minion = (EntityTFLichMinion)entity;
        if (minion.isStrong()) {
            GlStateManager.func_179124_c(0.25f, 2.0f, 0.25f);
        }
        else {
            GlStateManager.func_179124_c(0.5f, 1.0f, 0.5f);
        }
    }
    
    public void func_78088_a(final Entity entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float netHeadYaw, final float headPitch, final float scale) {
        final EntityTFLichMinion minion = (EntityTFLichMinion)entity;
        if (minion.isStrong()) {
            super.func_78088_a(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
        else {
            super.func_78088_a(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }
}
