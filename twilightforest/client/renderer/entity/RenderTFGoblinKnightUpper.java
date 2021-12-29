// 
// Decompiled by Procyon v0.6-prerelease
// 

package twilightforest.client.renderer.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import twilightforest.entity.EntityTFGoblinKnightUpper;

public class RenderTFGoblinKnightUpper extends RenderTFBiped<EntityTFGoblinKnightUpper>
{
    public RenderTFGoblinKnightUpper(final RenderManager manager, final ModelBiped model, final float shadowSize) {
        super(manager, model, shadowSize, "doublegoblin.png");
    }
    
    protected void applyRotations(final EntityTFGoblinKnightUpper upperKnight, final float ageInTicks, final float rotationYaw, final float partialTicks) {
        super.func_77043_a((EntityLivingBase)upperKnight, ageInTicks, rotationYaw, partialTicks);
        if (upperKnight.heavySpearTimer > 0) {
            GlStateManager.func_179114_b(this.getPitchForAttack(60 - upperKnight.heavySpearTimer + partialTicks), 1.0f, 0.0f, 0.0f);
        }
    }
    
    private float getPitchForAttack(final float attackTime) {
        if (attackTime <= 10.0f) {
            return attackTime * 3.0f;
        }
        if (attackTime > 10.0f && attackTime <= 30.0f) {
            return 30.0f;
        }
        if (attackTime > 30.0f && attackTime <= 33.0f) {
            return (attackTime - 30.0f) * -25.0f + 30.0f;
        }
        if (attackTime > 33.0f && attackTime <= 50.0f) {
            return -45.0f;
        }
        if (attackTime > 50.0f && attackTime <= 60.0f) {
            return (10.0f - (attackTime - 50.0f)) * -4.5f;
        }
        return 0.0f;
    }
}
